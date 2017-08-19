package com.example.android.appdbsimple;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
         Hemos cortado las dos líneas que iniciaban la base en este
          mismo contexto y las hemos pasado a DataBaseManager. Así que,
          ahora instanciamos a DataBaseManager para la creación de esa base
          llamando al constructor que hemos creado para eso con esas líneas
          anteriores que cortamos y pegamos desde aquí a DataBaseManager
          */
        DataBaseManager manager = new DataBaseManager(this);









    }
}
