package com.juarez.myapplication.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.juarez.myapplication.DetailActivity;
import com.juarez.myapplication.LoginActivity;
import com.juarez.myapplication.R;
import com.juarez.myapplication.model.Data;
import com.juarez.myapplication.model.DataDetail;
import com.juarez.myapplication.model.IServices;
import com.juarez.myapplication.model.Serie;
import com.juarez.myapplication.model.SerieDetalle;
import com.juarez.myapplication.model.Series;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class SerieDetailFragment extends Fragment {
    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String TOKEN = "token";
    private static final String PLOT = "full";
    private final String omdbEndpoint = "omdbapi.com";
    private final String apikey = "2f1f55d7";
    private String imdbId;
    private ImageView imageSerie;
    private TextView txtGenre;
    private TextView txtFisrtAired;
    private TextView txtDateHour;
    private TextView txtRating;
    private TextView txtOverview;
    private TextView txtSeason;
    private ProgressBar progressBar;
    public static String TAG = "SerieDetailFragment";
    private int idSerieDetail;
    private String token;

    public SerieDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_serie_detail, container, false);

        progressBar = view.findViewById(R.id.progressBar3);
        //primer servicio detalles
        txtFisrtAired = view.findViewById(R.id.txtFragDetailFirstAired);
        txtDateHour = view.findViewById(R.id.txtFragDetailDateHour);
        txtOverview = view.findViewById(R.id.txtFragDetailOverview);
        //segundo servicio detalles
        imageSerie = view.findViewById(R.id.imgFragDetail);
        txtGenre = view.findViewById(R.id.txtFragDetailGenre);
        txtRating = view.findViewById(R.id.txtFragDetailRating);
        txtSeason = view.findViewById(R.id.txtFragDetailSeason);


        DetailActivity detailActivity = new DetailActivity();
        idSerieDetail = detailActivity.serie.getId();
        Log.e(TAG, "id:" + idSerieDetail);

        loadToken();
        getSearchIdRequest();
        return view;
    }

    private void loadToken() {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        token = sharedPreferences.getString(TOKEN, "");
        Log.e(TAG, "loadtoken: " + token);

    }

    //servicio 1
    private void getSearchIdRequest() {
        progressBar.setVisibility(View.VISIBLE);
        //comfig Retrofit
        DataDetail data = new DataDetail();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://" + LoginActivity.endpoint + "/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        IServices services = retrofit.create(IServices.class);
        Call<DataDetail> call = services.getDetailSerie(idSerieDetail, "Bearer " + token);
        call.enqueue(new Callback<DataDetail>() {
            @Override
            public void onResponse(Call<DataDetail> call, Response<DataDetail> response) {
                if (response.isSuccessful()) {
                    //mostrar propiedades a usar
                    Log.e(TAG, String.valueOf(response.body().getSerie()));
                    Log.e(TAG, String.valueOf(response.body().getSerie().getAirsDayOfWeek()));
                    Log.e(TAG, String.valueOf(response.body().getSerie().getOverview()));
                    Log.e(TAG, String.valueOf(response.body().getSerie().getAirsTime()));
                    Log.e(TAG, String.valueOf(response.body().getSerie().getFirstAired()));
                    Log.e(TAG, String.valueOf(response.body().getSerie().getImdbId()));
                    imdbId = String.valueOf(response.body().getSerie().getImdbId());

                    //asignar propiedades a las vistas
                    txtOverview.setText("" + response.body().getSerie().getOverview());
                    if (response.body().getSerie().getAirsTime().length() == 0 && response.body().getSerie().getAirsTime().length() == 0) {
                        txtDateHour.setText("no disponible");
                    } else {
                        txtDateHour.setText(response.body().getSerie().getAirsTime() + " " + response.body().getSerie().getAirsDayOfWeek());
                    }
                    txtFisrtAired.setText("" + response.body().getSerie().getFirstAired());

                    Log.e(TAG, "Servicio 1 correcto");

                    //comprobar que la propiedad imdbId no venga vacia
                    if(imdbId.length() != 0){
                        getSearchImdbIDRequest();
                    }else{
                        Toast.makeText(getContext(),"algunos datos no fueron encontrados en el servidor",Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                } else {
                    Toast.makeText(getContext(), "Error de autenticacion", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "error de autenticacion");
                }
            }

            @Override
            public void onFailure(Call<DataDetail> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    //servicio 2
    private void getSearchImdbIDRequest() {
        //comfig Retrofit
        DataDetail data = new DataDetail();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://" + omdbEndpoint)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        IServices services = retrofit.create(IServices.class);
        Call<SerieDetalle> call = services.getDetailSerie2(imdbId, apikey, PLOT, "Bearer " + token);
        call.enqueue(new Callback<SerieDetalle>() {
            @Override
            public void onResponse(Call<SerieDetalle> call, Response<SerieDetalle> response) {
                if (response.isSuccessful()) {

                    //mostrar propiedades a usar
                    Log.e(TAG, String.valueOf(response.body()));
                    Log.e(TAG, "" + response.body().getGenre());
                    Log.e(TAG, "" + response.body().getTotalSeasons());
                    Log.e(TAG, "" + response.body().getImdbRating());
                    Log.e(TAG, "" + response.body().getPoster());

                    txtGenre.setText("" + response.body().getGenre());
                    txtSeason.setText("" + response.body().getTotalSeasons());
                    txtRating.setText(response.body().getImdbRating()+"/10");
                    Glide.with(getContext())
                            .load(response.body().getPoster())
                            .placeholder(R.drawable.toolbarmediomelon)
                            .into(imageSerie);
                    Log.e(TAG, "servicio detalles 2 correcto");
                } else {
                    Log.e(TAG, "error de autenticacion");
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<SerieDetalle> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

}
