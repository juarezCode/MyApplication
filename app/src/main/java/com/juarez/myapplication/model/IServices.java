package com.juarez.myapplication.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IServices {

    @POST("login")
    Call<Key> getToken(@Body Key key);

    @GET("search/series")
    Call<Data> getSeries(@Query("name") String CharName, @Header("Authorization") String authToken);

    @GET("series/{id}")
    Call<DataDetail> getDetailSerie(@Path("id") int idSerie, @Header("Authorization") String authToken);
}
