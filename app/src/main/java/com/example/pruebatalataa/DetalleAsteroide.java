package com.example.pruebatalataa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pruebatalataa.db.dbAsteroides;
import com.example.pruebatalataa.modelos.Asteroide;

public class DetalleAsteroide extends AppCompatActivity {


    TextView tvName,id,magnitud,isDanger,isObjetc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_asteroide);

        this.tvName = findViewById(R.id.viewNombreDetail);
        this.id = findViewById(R.id.viewIdDetail);
        this.magnitud = findViewById(R.id.viewMagnitudDetail);
        this.isDanger = findViewById(R.id.viewIsPeligroso);
        this.isObjetc = findViewById(R.id.viewIsObjecDetail);

        String id = getIntent().getStringExtra("id");

        try {
            dbAsteroides dbAsteroides = new dbAsteroides(this);
            Asteroide a = dbAsteroides.getAstedoriedById(id);
            if(a==null){
                Toast.makeText(this, "ERROR : ", Toast.LENGTH_SHORT).show();
            }else{
                tvName.setText("Nombre : "+a.getName());
                this.id.setText("Id :"+ a.getId());
                magnitud.setText("Magnitud :"+Double.toString(a.getAbsolute_magnitude_h()));
                isDanger.setText("es Peligroso "+(a.isIs_potentially_hazardous_asteroid() ? " : SI"  : " : NO"));
                isObjetc.setText("es Objeto Centinela " + (a.isIs_sentry_object() ? " : SI" : " : NO"));
            }

        }catch (Exception e){
            Toast.makeText(this, "ERROR : "+e.toString(), Toast.LENGTH_SHORT).show();

        }

    }
}