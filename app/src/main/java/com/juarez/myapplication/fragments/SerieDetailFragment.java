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
import android.widget.TextView;
import android.widget.Toast;

import com.juarez.myapplication.DetailActivity;
import com.juarez.myapplication.LoginActivity;
import com.juarez.myapplication.R;
import com.juarez.myapplication.model.Data;
import com.juarez.myapplication.model.DataDetail;
import com.juarez.myapplication.model.IServices;
import com.juarez.myapplication.model.Serie;
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
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TOKEN = "token";
    private ImageView btnImage;
    private TextView txtGenre;
    private TextView txtFisrtAired;
    private TextView txtDateHour;
    private TextView txtRating;
    private TextView txtOverview;
    public static String TAG = "SerieDetailFragment";
    private  String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NjMzMjQ3NzcsImlkIjoiRGVtbyBQcm9qZWN0Iiwib3JpZ19pYXQiOjE1NjMyMzgzNzcsInVzZXJpZCI6NTIwMjgwLCJ1c2VybmFtZSI6InRhdnJvbWVybzJ5dSJ9.DYiriXKvl30ir1VVPU-2gW5X2nmMlKMZjmq6gUYxjiNmxn3aVYHo7C5cWXWVYeKeMu6s8xmcTdKYoWenFpcCvuF989xThTpL1d9qrOF7RlZPWBb9POZMW2yyEVG6KaQax2gjHbbeIVxNUtSH3RUTWxl_nquoBW4ps4Ccs4x3K-3TP-d6EOWYF-dkFi9DDXAKVsaGH3cdJygiDl0Bwo6xqMTBwovR6-EiVcNea5XyGKfNCQmi6-qmi2WYjsE2gp925k6QK4KVj-qw7Uaa6MlxTaXfjgc9c_RNLT3kJ88H-I2a98KNzelBxwpIKaqlRhL2oqm99LuQbwEysislMsN9dg";
    private int idSerieDetail;
    private DataDetail myDataSet;

    public SerieDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_serie_detail, container, false);

        btnImage = view.findViewById(R.id.imgFragDetail);
        txtGenre = view.findViewById(R.id.txtFragDetailGenre);
        txtFisrtAired = view.findViewById(R.id.txtFragDetailFirstAired);
        txtDateHour = view.findViewById(R.id.txtFragDetailDateHour);
        txtRating = view.findViewById(R.id.txtFragDetailRating);
        txtOverview = view.findViewById(R.id.txtFragDetailOverview);

        DetailActivity detailActivity = new DetailActivity();
        idSerieDetail = detailActivity.serie.getId();
        Log.e(TAG,"id:"+idSerieDetail);


        getSearchRequest();
        return view;
    }
    /*public void loadToken() {
        SharedPreferences sharedPreferences =  getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        token = sharedPreferences.getString(TOKEN, "");
        Log.e(TAG, "loadtoken: " + token);

    }*/
    private void getSearchRequest() {
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
                if(response.isSuccessful()){

                    Log.e(TAG,String.valueOf(response.body().getSerie()));
                    Log.e(TAG,String.valueOf(response.body().getSerie().getAirsDayOfWeek()));
                    Log.e(TAG,String.valueOf(response.body().getSerie().getOverview()));
                    Log.e(TAG,String.valueOf(response.body().getSerie().getAirsTime()));
                    Log.e(TAG,String.valueOf(response.body().getSerie().getFirstAired()));


                    txtOverview.setText(""+response.body().getSerie().getOverview());
                    if(response.body().getSerie().getAirsTime().length()==0 && response.body().getSerie().getAirsTime().length()==0){
                        txtDateHour.setText("no disponible");}else {
                        txtDateHour.setText(response.body().getSerie().getAirsTime() + " " + response.body().getSerie().getAirsDayOfWeek());
                    }
                    txtFisrtAired.setText(""+response.body().getSerie().getFirstAired());
                }else{
                    Log.e(TAG,"no autorizado");
                }
            }

            @Override
            public void onFailure(Call<DataDetail> call, Throwable t) {
            Log.e(TAG,t.toString());
            }
        });
    }
}
