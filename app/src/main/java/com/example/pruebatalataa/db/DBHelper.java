package com.example.pruebatalataa.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    private static final String DB_NAME = "db_prueba";
    public  static final String DB_TABLE_USER = "t_user";
    public static final String DB_TABLE_ASTEROIDS = "t_asteroids";


    public DBHelper(@Nullable Context context) {
        super(context,
                DB_NAME,
                null,
                1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+DB_TABLE_USER+" ( " +
                "id INTEGER  PRIMARY KEY AUTOINCREMENT ," +
                "email TEXT NOT NULL," +
                "encrypted_password TEXT NOT NULL," +
                "first_name TEXT NOT NULL," +
                "last_name TEXT NOT NULL," +
                "identification TEXT NOT NULL," +
                "count_logged_in INTEGER NOT NULL," +
                "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ," +
                "updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP );");

        sqLiteDatabase.execSQL("CREATE TABLE "+DB_TABLE_ASTEROIDS+" ( " +
                "id TEXT NOT NULL, " +
                "name TEXT NOT NULL," +
                "absolute_magnitude_h REAL NOT NULL," +
                "is_potentially_hazardous_asteroid INTEGER," +
                "is_sentry_object INTEGER," +
                "usuario_id INTEGER NOT NULL," +
                " FOREIGN KEY (usuario_id) " +
                "REFERENCES t_user (id)" +
                " );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
