package edu.upc.dsa.models;

public class Mensaje {

    int id;
    String mensaje;

    public Mensaje(){

    }

    public Mensaje(String mensaje){
        this.setMensaje(mensaje);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
