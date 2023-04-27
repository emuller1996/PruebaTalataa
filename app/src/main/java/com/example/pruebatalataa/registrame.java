package com.example.pruebatalataa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pruebatalataa.db.dbUsuarios;
import com.example.pruebatalataa.modelos.Usuario;
import com.example.pruebatalataa.utils.MyEncriptador;

public class registrame extends AppCompatActivity {

    EditText txtEmail,txtFistName,txtLastName, txtIdentification,txtPassword;
    Button btn_Registarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrame);
        this.txtEmail = findViewById(R.id.txtEmail);
        this.txtFistName = findViewById(R.id.txtNombre);
        this.txtLastName = findViewById(R.id.txtApellido);
        this.txtIdentification = findViewById(R.id.txtIdentificacion);
        this.txtPassword = findViewById(R.id.txtPassword);
        this.btn_Registarme  = findViewById(R.id.button2);
    }

    public void onCreateUser(View v) throws Exception {
        Toast.makeText(this, "onCreateUser", Toast.LENGTH_SHORT).show();
        MyEncriptador e = new MyEncriptador();

        dbUsuarios dbUsuario = new dbUsuarios(registrame.this);

        Usuario u = new Usuario();
        u.setEmail(txtEmail.getText().toString());
        u.setFist_name(txtFistName.getText().toString());
        u.setLast_name(txtLastName.getText().toString());
        u.setIndentification(Integer.parseInt(txtIdentification.getText().toString()));
        u.setPassword(e.encriptar(txtPassword.getText().toString()));

        if( txtFistName.getText().toString().isEmpty() ||
            txtEmail.getText().toString().isEmpty() ||
            txtLastName.getText().toString().isEmpty() ||
            txtIdentification.getText().toString().isEmpty() ||
            txtPassword.getText().toString().isEmpty()
        ){
            Toast.makeText(this, "ERROR! CAMPOS FALTANTES", Toast.LENGTH_SHORT).show();
        }else{
            if (dbUsuario.InsertUsuario(u)>0){
                Toast.makeText(this, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show();
                limpiar();
            }else{
                Toast.makeText(this, "ERROR : NO SE GUARDO EL USUARIO !", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void limpiar(){
        txtEmail.setText("");
        txtLastName.setText("");
        txtFistName.setText("");
        txtPassword.setText("");
        txtIdentification.setText("");
    }
}