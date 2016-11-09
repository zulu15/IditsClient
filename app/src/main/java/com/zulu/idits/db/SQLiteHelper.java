package com.zulu.idits.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String TAG = SQLiteHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "idits_inscripciones_usuario.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "usuarios";

    //Declaracion de los campos de la tabla con sus indices
    public static final String C_DNI = "_id";
    public static final  int C_DNI_INDEX = 0;
    public static final String C_NOMBRE = "nombre";
    public static final  int C_ID_NOMBRE_INDEX = 1;
    public static final String C_APELLIDO= "apellido";
    public static final  int C_APELLIDO_INDEX = 2;
    public static final String C_FECHA_NACIMIENTO = "fecha_nacimiento";
    public static final  int C_FECHA_INDEX = 3;
    public static final String C_CUIL= "cuil";
    public static final  int C_CUIL_INDEX = 4;
    public static final String C_EMAIL = "email";
    public static final  int C_EMAIL_INDEX = 5;
    public static final String C_TELEFONO = "telefono";
    public static final  int C_TELEFONO_INDEX = 6;
    public static final String C_PROVINCIA = "provincia";
    public static final  int C_PROVINCIA_INDEX = 7;
    public static final String C_CODIGO_POSTAL = "codigo_postal";
    public static final  int C_CODIGO_POSTAL_INDEX = 8;
    public static final String C_APORTES = "aportes";
    public static final  int C_APORTES_INDEX = 9;


    public SQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        final String creationTableQuery =
                "CREATE TABLE "+TABLE_NAME+" ( "
                +C_DNI +" integer primary key, "
                +C_NOMBRE+" text NOT NULL, "
                +C_APELLIDO+" text, "
                +C_FECHA_NACIMIENTO+" text, "
                +C_CUIL+" text, "
                +C_EMAIL+" text, "
                +C_TELEFONO+" integer, "
                +C_PROVINCIA+" text, "
                +C_CODIGO_POSTAL+" integer, "
                +C_APORTES+" integer )";

        Log.i(TAG,"Executed query: "+creationTableQuery);
        db.execSQL(creationTableQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Typically do ALTER TABLE statements, but... we're just in
        // development, so:
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
