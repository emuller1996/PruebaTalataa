package com.example.pruebatalataa.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.pruebatalataa.modelos.Asteroide;
import com.example.pruebatalataa.modelos.Usuario;

import java.util.ArrayList;
import java.util.Date;

import kotlin.contracts.ReturnsNotNull;

public class dbAsteroides extends  DBHelper{
    Context context;

    public dbAsteroides(@Nullable Context context) {
        super(context);
        this.context = context;

    }

    public long InsertAsteroides(Asteroide a){
        try {
            DBHelper dbHelper = new DBHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put("id",a.getId());
            values.put("name",a.getName());
            values.put("absolute_magnitude_h",a.getAbsolute_magnitude_h());
            values.put("is_potentially_hazardous_asteroid",a.isIs_potentially_hazardous_asteroid() ? 1 : 0);
            values.put("is_sentry_object",a.isIs_potentially_hazardous_asteroid() ? 1 : 0);
            values.put("usuario_id",a.getUsuario_id());

            return db.insert("t_asteroids",null,values);

        }catch (Exception e){
            Toast.makeText(null, "ERROR : ", Toast.LENGTH_SHORT).show();
        }
        return 0;
    }

    public ArrayList<Asteroide> getAllAsteroidesByUser (int id){
        ArrayList<Asteroide> listAsteroides = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM "+DB_TABLE_ASTEROIDS + " WHERE usuario_id = "+id+";",null);
        if (c.moveToFirst()){
            do{
                Asteroide a = new Asteroide();
                a.setId(c.getString(0));
                a.setName(c.getString(1));
                a.setAbsolute_magnitude_h(c.getDouble(2));
                a.setIs_potentially_hazardous_asteroid( c.getInt(3) != 0 ? true : false );
                a.setIs_sentry_object(c.getInt(4) != 0 ? true : false);
                a.setUsuario_id(c.getInt(5));
                listAsteroides.add(a);
            }while (c.moveToNext());

        }
        c.close();
        return listAsteroides;
    }

    public Asteroide getAstedoriedById(String id){
        Asteroide a = null;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+DB_TABLE_ASTEROIDS + " WHERE id = "+id+" LIMIT 1;",null);
        if (c.moveToFirst()){
                a = new Asteroide();
                a.setId(c.getString(0));
                a.setName(c.getString(1));
                a.setAbsolute_magnitude_h(c.getDouble(2));
                a.setIs_potentially_hazardous_asteroid( c.getInt(3) != 0 ? true : false );
                a.setIs_sentry_object(c.getInt(4) != 0 ? true : false);
                a.setUsuario_id(c.getInt(5));
        }
        return a;
    }
}
