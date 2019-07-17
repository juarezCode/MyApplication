package com.juarez.myapplication.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
import com.juarez.myapplication.LoginActivity;
import com.juarez.myapplication.R;
import com.juarez.myapplication.adapters.ActorAdapter;
import com.juarez.myapplication.adapters.SeriesAdapter;
import com.juarez.myapplication.model.Actor;
import com.juarez.myapplication.model.Data;
import com.juarez.myapplication.model.DataActor;
import com.juarez.myapplication.model.IServices;
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
public class SerieActorFragment extends Fragment {
    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String TOKEN = "token";
    private static final String endpointActor = "api.thetvdb.com";
    public static String TAG = "SerieActorFragment";
    private String token;
    private RecyclerView recyclerActor;
    private ProgressBar progressBar;
    private TextView txtActorsNotFound;
    private ActorAdapter mAdapter;
    private ArrayList<Actor> myDataSet;
    private int serieId;

    public SerieActorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_serie_actor, container, false);
        recyclerActor = view.findViewById(R.id.recyclerActor);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        recyclerActor.setLayoutManager(gridLayoutManager);
        progressBar = view.findViewById(R.id.progressBar4);
        txtActorsNotFound = view.findViewById(R.id.txtActorsNotFound);

        serieId = DetailActivity.idSerie;
        Log.e(TAG,"id que necesito:"+serieId);
        loadToken();
        getActorshRequest();

        return  view;
    }
    public void loadToken() {
        SharedPreferences sharedPreferences = this.getContext().getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        token = sharedPreferences.getString(TOKEN, "");
        Log.e(TAG, "loadtoken: " + token);

    }

    //
    private void refreshDataSet() {
        if (recyclerActor == null) {
            return;
        }
        mAdapter = null;// cuando es nulo recarga la vista, la actualiza
        if (mAdapter == null) {
            mAdapter = new ActorAdapter(getContext(), myDataSet);
            recyclerActor.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private void getActorshRequest() {
        progressBar.setVisibility(View.VISIBLE);
        //comfig Retrofit
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://" + endpointActor + "/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        IServices services = retrofit.create(IServices.class);
        Call<DataActor> call = services.getActors(serieId, "Bearer " + token);

        call.enqueue(new Callback<DataActor>() {
            @Override
            public void onResponse(Call<DataActor> call, Response<DataActor> response) {
                if(response.isSuccessful()){
                    final AtomicInteger count = new AtomicInteger(0);//permite incrementar cada vez que es llamado, me sirve para el id
                    myDataSet = new ArrayList<Actor>();//crear ArrayList Vacio
                    myDataSet.clear();//limpio el Arralist

                    Log.e(TAG,String.valueOf(response.body().getActors()));
                    for (Actor actors : response.body().getActors()) {
                        actors.setIdActorControl(count.incrementAndGet());
                        Log.e(TAG, actors.getIdActorControl() + " actor: " + actors.getName());

                        myDataSet.add(actors);
                    }
                    refreshDataSet();

                }else{
                    //Toast.makeText(getContext(), "Error de autenticacion", Toast.LENGTH_SHORT).show();
                    Log.e(TAG,"Error de autenticacion");
                    Log.e(TAG,"no existen actores");
                    txtActorsNotFound.setVisibility(View.VISIBLE);
                }
                progressBar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<DataActor> call, Throwable t) {
                Log.e(TAG,t.toString());
                progressBar.setVisibility(View.GONE);
            }
        });
        Log.e(TAG, "useTokenAuth: " + token);



    }

}
