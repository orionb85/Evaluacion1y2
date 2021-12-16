package com.example.evaluacion1y2;

import java.io.Serializable;

public class Contacto implements Serializable {

    private String nombre;
    private String password;

    public Contacto() {
        this.nombre ="";
        this.password="";
    }
    public Contacto(String nombre, String password){
        this.nombre = nombre;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
