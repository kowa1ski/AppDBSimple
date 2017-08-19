package com.example.android.appdbsimple;

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

}
