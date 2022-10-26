package com.portofio.GMsasiuk.Security.Controller;

//Clase que será usada para mostrar mensajes de distintos mét. de otras clases
public class Mensaje {

    private String mensaje;

    //Mét. constructores
    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    //Mét. getters y setters
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}