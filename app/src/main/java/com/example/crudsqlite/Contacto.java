package com.example.crudsqlite;

public class Contacto {
    /*ATRIBUTOS DE MI CLASE*/
    int id;
    String nombre;
    String telefono;
    String email;
    int edad;

    /*Constructor*/
    public Contacto() {
    }

    /*Sobrecarga del constructor*/
    public Contacto(int id, String nombre, String telefono, String email, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.edad = edad;
    }

    /*MÉTODOS GETTERS Y SETTERS*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
