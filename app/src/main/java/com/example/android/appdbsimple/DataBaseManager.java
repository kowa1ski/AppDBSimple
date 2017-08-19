package com.example.android.appdbsimple;

import android.content.ContentValues;
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
    /*
    declaramos fuera del método DataBaseMAnagger(...) las variables que vamos a usar
    para poder llamarlas también desde los demás métodos como el de insertar(...)
     */

    DbHelper helper;
    SQLiteDatabase db;


    public DataBaseManager(Context context) {

        helper = new DbHelper(context);
        db = helper.getWritableDatabase();



    }

    /*
    1. Estamos creando un método insertar. Si vamos al MainActivity y ponemos
    ,
    manager.
    ,
    ya nos sadría el método insertar como disponible con los parámetros
    que le hemos exigido.

     */

    public void insertar (String nombre, String telefono){


        // Este bloque de código se utiliza mucho
        ContentValues values = new ContentValues();
        // Valores.put(COLUMNA, valor)
        values.put(CN_NAME, nombre);
        values.put(CN_PHONE, telefono);



        // el NullColumHack se usa porque hace falta que haya un campo null para compatibilidad
        // con otras versiones. En SQLite sirve para ponerlo en null, siempre siempre.

        // db.insert(TABLA, NullColumHack, ContentValues)
        db.insert(TABLE_NAME, null, values);


    }


}













