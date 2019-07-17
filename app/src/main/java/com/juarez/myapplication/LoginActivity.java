package com.juarez.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.session.MediaSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.juarez.myapplication.model.IServices;
import com.juarez.myapplication.model.Key;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private Button btnLogin;
    private String TAG = "LoginActivity";
    private String apikey = "PPDZ39EGKOEHNR3R";
    private String userkey = "JOEZYXMFGR0RDBXA";
    private String username = "tavromero2yu";
    public static final String endpoint = "api.thetvdb.com";
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TOKEN = "token";
    private String token;
    public String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        progressBar = findViewById(R.id.progressBar);

        //comportamiento boton obtenerToken (Login)
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLogin.setEnabled(false);
            //crea instancia y envia a peticion
            Key key = new Key(apikey, userkey, username);
            sendNetworkRequest(key);
            }
        });

    }

    //peticion POST obtener token
    private void sendNetworkRequest(Key key) {
        progressBar.setVisibility(View.VISIBLE);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://" + endpoint + "/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        IServices services = retrofit.create(IServices.class);
        Call<Key> call = services.getToken(key);

        call.enqueue(new Callback<Key>() {
            @Override
            public void onResponse(Call<Key> call, Response<Key> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "token: " + response.body().getToken().substring(0,10)+"...", Toast.LENGTH_LONG).show();
                    Log.e(TAG, "getToken: " + response.body().getToken());
                    token = response.body().getToken();
                    saveToken(token);
                    Intent intent = new Intent(getApplicationContext(),SeriesActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Error de autenticacion", Toast.LENGTH_SHORT).show();
                    Log.e(TAG,"Error de credenciales");
                }
                progressBar.setVisibility(View.GONE);
                btnLogin.setEnabled(true);
            }

            @Override
            public void onFailure(Call<Key> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "something went wrong :(", Toast.LENGTH_SHORT).show();
                Log.e("Error", t.toString());
                btnLogin.setEnabled(true);
            }
        });

    }

    //guardar token en SharedPreferences
    public void saveToken(String token) {
        Log.e(TAG, "savetoken: " + token);
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN, token).commit();
    }

}
