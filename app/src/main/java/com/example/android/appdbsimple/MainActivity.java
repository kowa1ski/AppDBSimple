package com.example.android.appdbsimple;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {


    /*
    Sacamos la declaración de DataBaseManager aquí, fuera del Override
     */
    private DataBaseManager manager;
    // También declaramos un cursor para el cursor que carga los contactos
    // y un listView que exponga la información que se obtenga.
    private Cursor cursor;
    private ListView listView;
    SimpleCursorAdapter adapter;

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
        /*
        Ahora sacamos la declaración fuera
         */
        manager = new DataBaseManager(this);

        // Aparte del cursor hay que terminar de crear la lista
        listView = (ListView) findViewById(R.id.listView);

        // Insertamos un par de nombres
        manager.insertar("Pablo", "666 666 666");
        manager.insertar("Juan", "666 99 99 99");
        manager.insertar("Liberty", "222 666 666");
        manager.insertar("Toñi", "333 99 99 99");

        /*
         Dejamos comentados algunas acciones
          */
        // manager.eliminar("Juan");
        // manager.modificarTelefono("Toñi", "444 44 44 44");

        // El cursor este, que se acaba de declarar arriba está llamando al
        // cursor que carga los contactos en el manager.
        cursor = manager.cargarCursorContactos();
        // Y también su adaptador
        // recordamos que el ,two_line_list_item, es un layout por defecto
        // Tenemos que definir from y to
        String[]from = new String[]{DataBaseManager.CN_NAME, DataBaseManager.CN_PHONE};
        int[] to = new int[]{android.R.id.text1, android.R.id.text2};
        adapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item, cursor, from, to, 0);

        // Por fin montamos el adaptador en su lista
        listView.setAdapter(adapter);



    }
}
