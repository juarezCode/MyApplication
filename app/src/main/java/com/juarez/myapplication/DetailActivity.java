package com.juarez.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.juarez.myapplication.fragments.SerieActorFragment;
import com.juarez.myapplication.fragments.SerieDetailFragment;
import com.juarez.myapplication.fragments.SerieEpisodeFragment;

public class DetailActivity extends AppCompatActivity {
    private TextView detailSeriesName;
    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detailSeriesName = findViewById(R.id.detailSeriesName);

        //recibir  datos
        String dataSeriesName = getIntent().getStringExtra("seriesName");

        //Mostrar valores a la pantalla
        detailSeriesName.setText(dataSeriesName);
        Log.e(TAG,"datos mostrados correctamente");

        //BottomNavigationView onclick
        bottomNavigation = findViewById(R.id.bottomnavigationview);
        fragmentManager = getSupportFragmentManager();
        firstFragment();
        Log.e(TAG,"fragment mostrado correctamente");
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                switch (id){
                    case R.id.seriesDetailItem:
                        fragment = new SerieDetailFragment();
                        break;
                    case R.id.seriesEpisodeItem:
                        fragment = new SerieEpisodeFragment();
                        break;
                    case R.id.seriesActorItem:
                        fragment = new SerieActorFragment();
                        break;
                }
                final FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.container, fragment).commit();
                return true;
            }
        });
    }
    private void firstFragment(){
        fragment = new SerieDetailFragment();//default
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.container, fragment).commit();
    }
}
