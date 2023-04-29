package com.example.pruebatalataa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebatalataa.controladores.MyApiController;
import com.example.pruebatalataa.modelos.Categoria;
import com.example.pruebatalataa.modelos.ErrorData;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoriaCrear extends AppCompatActivity {


    EditText txtNombre;
    TextView txterr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_crear);
        txtNombre = findViewById(R.id.txtNombreCategoriaReg);
        txterr= findViewById(R.id.viewRaro);



    }



    public void onCrearCategoria(View v){


        if(!txtNombre.getText().toString().isEmpty()) {


            Categoria c = new Categoria();
            c.setNombre(txtNombre.getText().toString());
            c.setId(0);
            Map<String, String> mm = new HashMap<>();
            mm.put("nombre", txtNombre.getText().toString());
            Call<Categoria> call = MyApiController.getInstance().getApi().createCategoria(mm);
            call.enqueue(new Callback<Categoria>() {
                @Override
                public void onResponse(Call<Categoria> call, Response<Categoria> response) {
                    Toast.makeText(CategoriaCrear.this, "CATEGORIA CREADA", Toast.LENGTH_SHORT).show();
                    txtNombre.setText("");
                    startActivity(new Intent(v.getContext(), ListaCategorias.class));
                }

                @Override
                public void onFailure(Call<Categoria> call, Throwable t) {
                    Toast.makeText(CategoriaCrear.this, t.toString(), Toast.LENGTH_SHORT).show();
                }
            });

        }else{
            Toast.makeText(CategoriaCrear.this, "DEBE INGRESAR UN NOMBRE", Toast.LENGTH_SHORT).show();
        }

    }
}