package com.example.crudsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoContacto {
    /*Conexión a nuestra BBDD SQLite*/
    SQLiteDatabase cx;

    /*ArrayList de tipo Contacto, que llamaremos lista*/
    ArrayList<Contacto> lista;

    /*Variable de tipo Contacto*/
    Contacto miContacto;

    /*Contexto que usaremos en el método constructor*/
    Context miContexto;

    //Nombre de la BBDD
    String nombreBBDD = "DBContactos";

    //Tabla sobre la que operamos dentro de nuestra BBDD
    String nombreTabla = "CREATE TABLE IF NOT EXISTS " +
            "Contacto(id integer primary key autoincrement, nombre text, telefono text, email text, edad integer)";

    /*CONSTRUCTOR*/
    public daoContacto(Context c){
        this.miContexto = c;

        /*Definimos la conexión a la base de datos*/
        cx = c.openOrCreateDatabase(nombreBBDD, miContexto.MODE_WORLD_WRITEABLE,null);

        //Creación de la tabla
        cx.execSQL(nombreTabla);
    }
    /*FIN MÉTODO CONSTRUCTOR*/

    /*RESTO DE MÉTODOS PARA ESTA CLASE INSERTAR, ELIMINAR, EDITAR, LISTADO*/
    /*INSERTAR*/
    public boolean Insertar(Contacto c){
        return  true;
    }

    /*ELIMINAR*/
    public boolean Eliminar(int id){
        return true;
    }

    /*EDITAR*/
    public boolean Editar(Contacto c){
        return true;
    }

    /*LISTAR TODOS LOS CONTACTOS*/
    public ArrayList<Contacto> Index(){
        return lista;
    }

    /*DETALLE DE UN CONTACTO*/
    public Contacto Detalle(int id){
        return miContacto;
    }


}
