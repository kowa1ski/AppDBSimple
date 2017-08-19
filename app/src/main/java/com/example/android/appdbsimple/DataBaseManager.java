package com.example.android.appdbsimple;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

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
    Creamos este método para ser llamado desde otros.
     */
    public ContentValues generarContentValues(String nombre, String telefono){

        // Este bloque de código se utiliza mucho
        ContentValues values = new ContentValues();
        // Valores.put(COLUMNA, valor)
        values.put(CN_NAME, nombre);
        values.put(CN_PHONE, telefono);

        return values;

    }

    /*
    1. Estamos creando un método insertar. Si vamos al MainActivity y ponemos
    ,
    manager.
    ,
    ya nos sadría el método insertar como disponible con los parámetros
    que le hemos exigido.

    2. Hemos creado un ContentValues y lo sacamos a una función en otro método.

     */

    public void insertar (String nombre, String telefono){

        // el NullColumHack se usa porque hace falta que haya un campo null para compatibilidad
        // con otras versiones. En SQLite sirve para ponerlo en null, siempre siempre.

        // db.insert(TABLA, NullColumHack, ContentValues)
        db.insert(TABLE_NAME, null, generarContentValues(nombre, telefono));

    }


    // Creamos la función eliminar
    public void eliminar(String nombre){

        //db.delete(TABLA, Clausula WHERE, Argumentos WHERE)
        db.delete(TABLE_NAME, CN_NAME+"=?", new String[]{nombre});

    }

    public void eliminarMultiple(String nombre1, String nombre2) {

        db.delete(TABLE_NAME, CN_NAME+"IN (?,?)", new String[]{nombre1, nombre2});

    }

    public void modificarTelefono(String nombre, String nuevoTelefono){

        // db.update(TABLA, ContentValues, Clausula WHERE, Argumentos WHERE)
        db.update(TABLE_NAME, generarContentValues(nombre, nuevoTelefono), CN_NAME+"=?", new String[]{nombre, nuevoTelefono});

    }


}













