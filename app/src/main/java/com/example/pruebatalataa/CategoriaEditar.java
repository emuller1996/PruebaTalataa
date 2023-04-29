package com.example.pruebatalataa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pruebatalataa.controladores.MyApiController;
import com.example.pruebatalataa.modelos.Categoria;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriaEditar extends AppCompatActivity {

    EditText nombre,TxtId;

    String idString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_editar);
        nombre = findViewById(R.id.txtCategoriaNombreEditar);
        TxtId = findViewById(R.id.txtCategoriaIdEditar);
        TxtId.setEnabled(false);
        try {
            idString= getIntent().getStringExtra("id");
            getCategory(Integer.parseInt(idString));
        }catch (Exception e){
            Toast.makeText(CategoriaEditar.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void getCategory(int id){
        Call<Categoria> call = MyApiController.getInstance().getApi().getCategoryById(id);

        call.enqueue(new Callback<Categoria>() {
            @Override
            public void onResponse(Call<Categoria> call, Response<Categoria> response) {
                nombre.setText(response.body().getNombre());
                TxtId.setText(String.valueOf(response.body().getId()));
            }
            @Override
            public void onFailure(Call<Categoria> call, Throwable t) {
                Toast.makeText(CategoriaEditar.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    public void onUpdateCategory(View v){
        Map<String, String> mm = new HashMap<>();
        mm.put("nombre", nombre.getText().toString());
        Call<Categoria> call = MyApiController.getInstance().getApi().UpdateCategoryById(Integer.parseInt(idString),mm);
        call.enqueue(new Callback<Categoria>() {
            @Override
            public void onResponse(Call<Categoria> call, Response<Categoria> response) {
                if(response.isSuccessful()) Toast.makeText(CategoriaEditar.this, "CATEGORIA ACTUALIZADA", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Categoria> call, Throwable t) {
                Toast.makeText(CategoriaEditar.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}