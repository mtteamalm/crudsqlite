package com.example.crudsqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    //ATRIBUTOS DE MI CLASE
    ArrayList<Contacto> lista;
    daoContacto dao;
    Contacto c;
    Activity a;

    //CONSTRUCTOR
    public Adaptador( Activity a, ArrayList<Contacto> lista, daoContacto dao){
        this.lista = lista;
        this.a = a;
        this.dao = dao;
    }
    //FIN CONSTRUCTOR

    @Override
    public int getCount() {
        return lista.size(); //Devolvemos el tamaño de la lista
    }


    @Override
    public Contacto getItem(int position) {
        c= lista.get(position); //Obtenemos un contacto de la lista
        return c;
    }

    @Override
    //Este método es para devlver el id del elemento que se está seleccionando
    public long getItemId(int position) {
        c=lista.get(position);
        return c.getId();
    }

    @Override
    //Lo usaremos para devolver la vista activity_detalle en la que tenemos los botones
    //editar y eliminar registros.
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v!=null){
            LayoutInflater li = (LayoutInflater) a.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=li.inflate(R.layout.activity_detalle,null);
        }

        //Aqui hacemos la asociación de los valores del Contacto que mostramos
        c = lista.get(position);

        //Enlazamos los valores con los elementos de nuestra interfaz activity_detalle
        TextView nombre = (TextView) v.findViewById(R.id.TextViewNombre);
        TextView email = (TextView) v.findViewById(R.id.TextViewEmail);
        TextView telefono = (TextView) v.findViewById(R.id.TextViewTelefono);
        TextView edad = (TextView) v.findViewById(R.id.TextViewEdad);
        ImageButton editar = (ImageButton) v.findViewById(R.id.btnEditar);
        ImageButton eliminar = (ImageButton) v.findViewById(R.id.btnEliminar);

        nombre.setText(c.getNombre());
        email.setText(c.getEmail());
        telefono.setText(c.getTelefono());
        edad.setText(c.getEdad());

        //A los botones les vamos a asignar una etiqueta con el fin de controlar
        // a cual de ellos les estamos haciendo clic y le pasamos la posición
        editar.setTag(position);
        eliminar.setTag(position);

        //Eventos para los botones
        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Vista de Formulario para editar (es la misma pantalla que para añadir)
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vista para confirmar eliminación SI/NO
            }
        });
        //Fin Eventos para los botones
        return v;
    }
}
