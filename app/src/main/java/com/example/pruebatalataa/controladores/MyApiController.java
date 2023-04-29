package com.example.pruebatalataa.controladores;

import com.example.pruebatalataa.interfaces.MiApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApiController {
    private final static String  url_base = "http://15.228.232.99:3000/";
    private static MyApiController clienteObject;
    private static Retrofit retrofit;

    MyApiController(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(url_base)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized MyApiController getInstance(){
        if(clienteObject==null)
            clienteObject = new MyApiController();
        return  clienteObject;
    }

    public MiApi getApi(){
        return this.retrofit.create(MiApi.class);
    }

}
