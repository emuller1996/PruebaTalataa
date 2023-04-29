package com.example.pruebatalataa.interfaces;


import com.example.pruebatalataa.modelos.Asteroide;
import com.example.pruebatalataa.modelos.Data;
import com.example.pruebatalataa.modelos.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AsteroidesAPI  {


    @GET("neo/rest/v1/feed?api_key=DEMO_KEY")
    Call<Data> getAsteroides();


    @GET("users/1")
    Call<Usuario> getusuarioById();


}





