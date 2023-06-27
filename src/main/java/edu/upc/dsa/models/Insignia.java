package edu.upc.dsa.models;

public class Insignia {

    int id;
    String correo;

    String nombreinsignia;

    String avatar;

    public Insignia(){

    }

    public Insignia(String correo, String nombreinsignia, String avatar){
        this.correo=correo;
        this.nombreinsignia=nombreinsignia;
        this.avatar=avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreinsignia() {
        return nombreinsignia;
    }

    public void setNombreinsignia(String nombreinsignia) {
        this.nombreinsignia = nombreinsignia;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
