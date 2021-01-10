package com.example.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    daoContacto dao;
    Adaptador adapter;
    ArrayList<Contacto> lista;
    Contacto c;

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
        if(lista!=null && lista.size() > 0 )
        {
            list.setAdapter(adapter);
        }
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
                Dialog dialogoAñadir = new Dialog(MainActivity.this);
                dialogoAñadir.setTitle("Nuevo Contacto");
                dialogoAñadir.setCancelable(true);
                dialogoAñadir.setContentView(R.layout.activity_formulario);
                dialogoAñadir.show();

                //Asociamos los campos
                EditText nombre = (EditText) dialogoAñadir.findViewById(R.id.EditTextNombre);
                EditText mail = (EditText) dialogoAñadir.findViewById(R.id.editTextEmail);
                EditText phone = (EditText) dialogoAñadir.findViewById(R.id.editTextPhone);
                EditText edad = (EditText) dialogoAñadir.findViewById(R.id.editTextEdad);

                Button guardar = (Button) dialogoAñadir.findViewById(R.id.btnGuardar);
                Button cancelar = (Button) dialogoAñadir.findViewById(R.id.btnCancelar);

                //Eventos para estos Botones
                guardar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            //Creamos el objeto con los datos del formulario
                            c =  new Contacto(nombre.getText().toString(),
                                    phone.getText().toString(), mail.getText().toString(),
                                    Integer.parseInt(edad.getText().toString()));

                            //Se lo pasamos al objeto dao para invocar al método insertar
                            dao.Insertar(c);

                            //Actualizamos el adaptador
                            adapter.notifyDataSetChanged();
                            dialogoAñadir.dismiss();

                        }catch (Exception e){
                            Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                cancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogoAñadir.dismiss();

                    }
                });
            }
        });
    }
}