package com.example.pruebatalataa.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.pruebatalataa.modelos.Usuario;
import com.example.pruebatalataa.utils.MyEncriptador;

import java.util.Date;

public class dbUsuarios extends DBHelper{
    Context context;

    public dbUsuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long InsertUsuario(Usuario u){
        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("email",u.getEmail());
            values.put("encrypted_password",u.getPassword());
            values.put("first_name",u.getFist_name());
            values.put("last_name",u.getLast_name());
            values.put("identification",u.getIndentification());
            values.put("count_logged_in",0);
            values.put("created_at",new Date().toString());
            values.put("updated_at",new Date().toString());
            return db.insert("t_user",null,values);

        }catch (Exception e){
            Toast.makeText(null, "ERROR : ", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }

    public Usuario validarUsuario(String email, String password){

        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        MyEncriptador e = new MyEncriptador();
        String ePassword = null;
        Usuario u = null;

        try {
            ePassword = e.encriptar(password);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Cursor cursorUsuario;
        cursorUsuario = db.rawQuery("SELECT * FROM " + DB_TABLE_USER + " WHERE email = '" + email + "' AND  encrypted_password  =  '"+ePassword+"';", null);
        if (cursorUsuario.moveToFirst()) {
            u = new Usuario();
            u.setId(cursorUsuario.getInt(0));
            u.setEmail(cursorUsuario.getString(1));
            u.setCount_logged_in(cursorUsuario.getInt(6));
            return u;
        }
        return  u;
    }

    public boolean incrementCountLoggedIn(int id){
        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            Cursor cursorUsuario;
            cursorUsuario = db.rawQuery("UPDATE " + DB_TABLE_USER + " SET count_logged_in = count_logged_in+1 WHERE id = "+id+";", null);
            if (cursorUsuario.moveToFirst()) return true;
        }catch(Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
            return false;
        }finally {
            return false;
        }
    }

    public Usuario getUsuarioById(int id){
        DBHelper dbHelper = new DBHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Usuario u = null;

        try {
            Cursor cursorUsuario;
            cursorUsuario = db.rawQuery("SELECT * FROM " + DB_TABLE_USER + " WHERE id = " + id + " ;", null);
            if (cursorUsuario.moveToFirst()) {
                u = new Usuario();
                u.setId(cursorUsuario.getInt(0));
                u.setEmail(cursorUsuario.getString(1));
                u.setCount_logged_in(cursorUsuario.getInt(6));
                u.setFist_name(cursorUsuario.getString(3));
                return u;
            }

        }catch (Exception e){
            Log.println(Log.ERROR,"ERROR : >",e.toString());
        }
        return u;
    }

}
