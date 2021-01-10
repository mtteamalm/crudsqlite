package com.example.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    daoContacto dao;
    Adaptador adapter;
    ArrayList<Contacto> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos el adaptador y llamamos al método Index para traer todos los contactos
        dao = new daoContacto(this);
        lista = dao.Index();
        adapter = new Adaptador(this, lista, dao);

        ImageButton add = (ImageButton) findViewById(R.id.ImageButtonAdd);

        //Ahora enlazamos con el Listview el resultado obtenido.
        ListView list = (ListView) findViewById(R.id.ListViewListado);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() { //Con esto haremos alguna funcionalidad al hacer clic sobre alguno de los items
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Vista previa de Detalle del contacto
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Vista de Formulario para añadir
            }
        });
    }
}