package com.juarez.myapplication.fragments;


import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.juarez.myapplication.DetailActivity;
import com.juarez.myapplication.R;
import com.juarez.myapplication.adapters.ChapterAdapter;
import com.juarez.myapplication.model.Chapter;
import com.juarez.myapplication.model.DataSeason;
import com.juarez.myapplication.model.IServices;
import com.juarez.myapplication.pagination.AdapterTemporada;
import com.juarez.myapplication.pagination.RecyclerViewItemClickListener;
import com.juarez.myapplication.pagination.Temporada;

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
public class SerieEpisodeFragment extends Fragment {
    private String token;
    public static final String endpointSeason = "api.thetvdb.com";
    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String TOKEN = "token";
    private String TAG = "SerieEpisodeFragment";
    private RecyclerView recyclerChapter;
    private RecyclerView recyclerTemporada;
    private ChapterAdapter mAdapter;
    private AdapterTemporada adapterTemporada;
    private ArrayList<Chapter> myDataSet;
    private ArrayList<Temporada> listaTemporada;
    private ProgressBar progressBar;
    private int serieId;
    private int totalSeasons;
    TextView numberTemporada;


    public SerieEpisodeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_serie_episode, container, false);
        //datos necesarios id de la serie y total de temporadas
        serieId = DetailActivity.idSerie;
        totalSeasons = SerieDetailFragment.totalSeasons;
        Log.e(TAG, "id que necesito: " + serieId);
        Log.e(TAG, "total de temporadas: " + totalSeasons);
        progressBar = view.findViewById(R.id.progressBar);
        numberTemporada = view.findViewById(R.id.txtNumerSeason);

        //recycler Episodes
        recyclerChapter = view.findViewById(R.id.recyclerChapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerChapter.setLayoutManager(linearLayoutManager);

        //recycler temporada
        recyclerTemporada = view.findViewById(R.id.recyclerTemporada);
        LinearLayoutManager temporada = new LinearLayoutManager(getContext());
        temporada.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerTemporada.setLayoutManager(temporada);

        //crea arreglo de temporadas
        listaTemporada = new ArrayList<Temporada>();

        for (int i = 1; i <= totalSeasons; i++) {
            Log.e(TAG, "episodio: " + i);
            listaTemporada.add(new Temporada(i));
        }
        adapterTemporada = new AdapterTemporada(getContext(), listaTemporada);
        recyclerTemporada.setAdapter(adapterTemporada);

        adapterTemporada.setOnItemClickListener( new RecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                getSearchEpisodeRequest(position+1);

            }
        });


        if (totalSeasons <= 0){
            myDataSet = new ArrayList<Chapter>();//crear ArrayList Vacio
            myDataSet.clear();
            Toast.makeText(getContext(),"No se encontraron temporadas",Toast.LENGTH_SHORT).show();
        }else{
            loadToken();
            getSearchEpisodeRequest(1);
        }

        return view;
    }


    public void loadToken() {
        SharedPreferences sharedPreferences = this.getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        token = sharedPreferences.getString(TOKEN, "");
        Log.e(TAG, "loadtoken: " + token);

    }

    private void refreshDataSet() {

        if (recyclerChapter == null) {
            return;
        }
        mAdapter = null;// cuando es nulo recarga la vista, la actualiza
        if (mAdapter == null) {
            mAdapter = new ChapterAdapter(getContext(), myDataSet);
            recyclerChapter.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();

        }

    }

    private void getSearchEpisodeRequest(final int numeroTemporada) {
        progressBar.setVisibility(View.VISIBLE);
        //comfig Retrofit
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://" + endpointSeason + "/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        IServices services = retrofit.create(IServices.class);
        Call<DataSeason> call = services.getSeason(serieId, String.valueOf(numeroTemporada), "Bearer " + token);

        call.enqueue(new Callback<DataSeason>() {
            @Override
            public void onResponse(Call<DataSeason> call, Response<DataSeason> response) {
                if (response.isSuccessful()) {
                    final AtomicInteger count = new AtomicInteger(0);//permite incrementar cada vez que es llamado, me sirve para el id
                    myDataSet = new ArrayList<Chapter>();//crear ArrayList Vacio
                    myDataSet.clear();//limpio el Arralist

                    Log.e(TAG, String.valueOf(response.body().getData()));
                    Log.e(TAG, "Temporada: " + numeroTemporada);
                    for (Chapter chapters : response.body().getData()) {
                        chapters.setIdMyControl(count.incrementAndGet());

                        Log.e(TAG, chapters.getAiredEpisodeNumber() + " nombre " + chapters.getEpisodeName());

                        myDataSet.add(chapters);
                    }
                    refreshDataSet();

                } else {
                    Toast.makeText(getContext(), "Error de autenticacion", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Error de autenticacion");
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<DataSeason> call, Throwable t) {
                Log.e(TAG, t.toString());
                progressBar.setVisibility(View.GONE);

            }
        });
        Log.e(TAG, "useTokenAuth: " + token);
    }


}
