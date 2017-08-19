package com.example.android.appdbsimple;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Usuario on 19/08/2017.
 */

public class DataBaseManager {

    public static final String TABLE_NAME = "contactos";

    public static final String CN_ID = "_id";
    public static final String CN_NAME = "nombre";
    public static final String CN_PHONE = "telefono";

    // create table contactos (
    //                          _id integer primary key autoincrement,
    //                          nombre text not null,
    //                          telefono text);

    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + CN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CN_NAME + " TEXT NOT NULL, "
            + CN_PHONE + " TEXT);";

    /*
    Creamos el constructor y le cortapegamos los iniciadores del anterior comit.
    También, dado que necesitamos un contexto, recuerda esto:
    ,
    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
        ,
        hacemos necesario que se pase el contexto al constructor con los de Context context y
        cambiando el contexto ,this, a context como variable

     */
    public DataBaseManager(Context context) {

        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();

    }
}
