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
    //servicio obtener token
    //https://{{endpoint}}/login
    @POST("login")
    Call<Key> getToken(@Body Key key);

    //servicio buscar series, por nombre
    //https://api.thetvdb.com/search/series?name=x
    @GET("search/series")
    Call<Data> getSeries(@Query("name") String CharName, @Header("Authorization") String authToken);

    //servicio obtener una serie, por su id
    //https://api.thetvdb.com/series/121361
    @GET("series/{id}")
    Call<DataDetail> getDetailSerie(@Path("id") int idSerie, @Header("Authorization") String authToken);

    //servicio obtener una serie, por su imdbID
    //https://omdbapi.com/?i=tt0944947&apikey=2f1f55d7&plot=full
    @GET("/")
    Call<SerieDetalle> getDetailSerie2(@Query("i") String id,@Query("apikey") String apiKey,@Query("plot") String plot,@Header("Authorization") String authToken);

    //servicio que obtiene los actores por serie
    //https://{{endpoint}}/series/:id/actors
    @GET("series/{id}/actors")
    Call<DataActor> getActors(@Path("id") int idSerie, @Header("Authorization") String authToken);


}
