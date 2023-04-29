package com.example.pruebatalataa.interfaces;

import com.example.pruebatalataa.modelos.Categoria;
import com.example.pruebatalataa.modelos.ErrorData;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MiApi {

    @GET("categorias")
    Call<List<Categoria>> getAllCaterogias();

    @GET("categorias/{id}")
    Call<Categoria> getCategoryById(@Path("id") int id);

    @POST("categorias")
    Call<Categoria> createCategoria(@Body Map<String,String> data);

    @PATCH("categorias/{id}")
    Call<Categoria> UpdateCategoryById(@Path("id") int id, @Body Map<String,String> data);

}
