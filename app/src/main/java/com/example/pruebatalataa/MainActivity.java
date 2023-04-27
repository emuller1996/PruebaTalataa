package com.example.pruebatalataa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pruebatalataa.db.DBHelper;
import com.example.pruebatalataa.db.dbUsuarios;
import com.example.pruebatalataa.modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail, txtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.txtEmail = findViewById(R.id.txtEmailLogin);
        this.txtPassword = findViewById(R.id.txtPasswordLogin);

    }



    public void showRegister(View v){
        startActivity(new Intent(this,registrame.class));
    }

    public void authUser(View v){
        dbUsuarios dbUsuario = new dbUsuarios(MainActivity.this);
        if (txtPassword.getText().toString().isEmpty() || txtEmail.getText().toString().isEmpty()){
            Toast.makeText(this, "ERROR: USUARIO Y CONTRASEÑA SON REQUERIDOS ", Toast.LENGTH_SHORT).show();
        }else{

            try {

                        Usuario u = dbUsuario.validarUsuario(txtEmail.getText().toString(),txtPassword.getText().toString()) ;
                    if (u !=null){
                        Intent i = new Intent(this,ListaAsteroides.class);
                        i.putExtra("usuario_id",String.valueOf(u.getId()));
                        i.putExtra("usuario_count_logged",String.valueOf(u.getCount_logged_in()));

                        startActivity(i);
                    }else{
                        Toast.makeText(this, "ERROR: USUARIO Y CONTRASEÑA SON INCORRECTOS ", Toast.LENGTH_SHORT).show();
                    }


            }catch (Exception e){
                Toast.makeText(this, "ERROR: "+e.toString(), Toast.LENGTH_SHORT).show();
            }


        }
    }
}