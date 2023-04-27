package com.example.pruebatalataa;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebatalataa.adaptadores.ListaAsteroidesAdapter;
import com.example.pruebatalataa.db.dbAsteroides;
import com.example.pruebatalataa.db.dbUsuarios;
import com.example.pruebatalataa.interfaces.AsteroidesAPI;
import com.example.pruebatalataa.modelos.Asteroide;
import com.example.pruebatalataa.modelos.Data;
import com.example.pruebatalataa.modelos.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaAsteroides extends AppCompatActivity {

    TextView txtCantidadObjetos, teUsuario ;
    String usuario_id;

    RecyclerView listaAsteroides;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_asteroides);
        this.txtCantidadObjetos = findViewById(R.id.txtCantidad);
        this.teUsuario = findViewById(R.id.txtUsuario_id);
        this.listaAsteroides = findViewById(R.id.listaAsteroides);
        this.listaAsteroides.setLayoutManager(new LinearLayoutManager(this));
        usuario_id = getIntent().getStringExtra("usuario_id");
        String countLoggedIn = getIntent().getStringExtra("usuario_count_logged");

        teUsuario.setText("usuario_id : "+usuario_id + " countLogged : "+countLoggedIn);
        if(Integer.parseInt(countLoggedIn)==0){
            onGetAsteroides();
        }else{
            onListarAsteroides();
        }

        Toast.makeText(ListaAsteroides.this, "usuario_id !"+usuario_id , Toast.LENGTH_SHORT).show();

    }



    public void onGetAsteroides(){

            dbAsteroides dbAte = new dbAsteroides(this);
            dbUsuarios dbUsuario = new dbUsuarios(this);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.nasa.gov/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            AsteroidesAPI as = retrofit.create(AsteroidesAPI.class);

            Call<Data> call = as.getAsteroides();
            call.enqueue(new Callback<Data>() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onResponse(Call<Data> call, Response<Data> response) {
                    try {
                        Data a = response.body();
                        for (Map.Entry<String, List<Asteroide>> entry : a.getNear_earth_objects().entrySet()) {
                            for (int i = 0 ; i <  entry.getValue().size() ; i++){
                                Asteroide aTemp = entry.getValue().get(i);
                                aTemp.setUsuario_id(Integer.parseInt(usuario_id));
                                if ( dbAte.InsertAsteroides(aTemp)> 0)  Toast.makeText(ListaAsteroides.this, "HECHO : ", Toast.LENGTH_SHORT).show();
                            }
                        }
                        dbUsuario.incrementCountLoggedIn(Integer.parseInt(usuario_id));
                        onListarAsteroides();
                        //a.getNear_earth_objects().forEach((k,v) ->  teUsuario.setText(teUsuario.getText().toString()+"Key: " + k + ": Value: " + v.size()+"\n"));
                        txtCantidadObjetos.setText("Cantidad : " +a.getElement_count()+"\n"
                        );
                    }catch (Exception e){
                        Toast.makeText(ListaAsteroides.this, "error!!"+e.toString() , Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<Data> call, Throwable t) {
                    txtCantidadObjetos.setText("ERORR"+t.toString());
                    Toast.makeText(ListaAsteroides.this, "ERORR : "+t.toString(), Toast.LENGTH_SHORT).show();
                }
            });
    }

    public void onListarAsteroides(){
        try {
            dbAsteroides dbAte = new dbAsteroides(this);
            ArrayList<Asteroide> asteroidesAll = dbAte.getAllAsteroidesByUser(Integer.parseInt(usuario_id));
            ListaAsteroidesAdapter adapter = new ListaAsteroidesAdapter(asteroidesAll);
            listaAsteroides.setAdapter(adapter);
            Toast.makeText(ListaAsteroides.this, "SIZE : "+asteroidesAll.size(), Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            Toast.makeText(ListaAsteroides.this, "ERORR : "+e.toString(), Toast.LENGTH_SHORT).show();

        }

    }

    public void onGetUsuario(View v){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AsteroidesAPI as = retrofit.create(AsteroidesAPI.class);
        Call<Usuario> call = as.getusuarioById();

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {

                try {
                Usuario u = response.body();
                teUsuario.setText("id"+u.getId()+"\n" +
                        "nombre: Estefsnao" );
                Toast.makeText(ListaAsteroides.this, "user id!!"+u.getId() , Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(ListaAsteroides.this, "error!!"+e.toString() , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(ListaAsteroides.this, "ERORR :!!", Toast.LENGTH_SHORT).show();

            }
        });


    }
}