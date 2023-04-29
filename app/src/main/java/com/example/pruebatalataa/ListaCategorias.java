package com.example.pruebatalataa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pruebatalataa.adaptadores.CategoriasAdapter;
import com.example.pruebatalataa.controladores.MyApiController;
import com.example.pruebatalataa.modelos.Categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaCategorias extends AppCompatActivity {
    TextView txtListaCategoria;
    RecyclerView listaCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_categorias);
        listaCategoria = findViewById(R.id.rv_categorias_lista);
        listaCategoria.setLayoutManager(new LinearLayoutManager(this));
        txtListaCategoria = findViewById(R.id.viewListaCategoria);
        getAllcategories();
    }

    public void showCrearCategoriasss(View v){
        startActivity(new Intent(this,CategoriaCrear.class));
    }

    public void getAllcategories(){
        Call<List<Categoria>> call = MyApiController.getInstance().getApi().getAllCaterogias();
        call.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                List<Categoria> categorias = response.body();
                CategoriasAdapter adapter = new CategoriasAdapter(response.body());
                listaCategoria.setAdapter(adapter);

                /*for (int i = 0; i < categorias.size(); i++) {
                        txtListaCategoria.setText(txtListaCategoria.getText().toString()+"Nombre : "+categorias.get(i).getNombre()+ " id:  "+categorias.get(i).getId()+"\n");
                }*/
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
            txtListaCategoria.setText(t.toString());
            }
        });
    }


}