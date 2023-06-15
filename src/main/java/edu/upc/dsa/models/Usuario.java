package edu.upc.dsa.models;

import edu.upc.dsa.models.dto.UsuarioTO;

public class Usuario {

    int id;
    String nombre;
    private String correo;
    private String password;
    //private List<Objeto> listaObjetosComprados = null;
    double dsacoins = 500;

    private String language= "es";

    public Usuario() {

    }

    public Usuario (UsuarioTO usuarioTO){
        this.setId(id);
        this.setNombre(usuarioTO.getNombre());
        this.setCorreo(usuarioTO.getCorreo());
        this.setPassword(usuarioTO.getPassword());
        this.setDsacoins(500);
        this.setLanguage(language);
    }
    public Usuario(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

/*    public Usuario(String nombre, String correo, String password, double dsacoins, String language) {
        this.nombre= nombre;
        this.correo = correo;
        this.password=password;
        this.dsacoins=dsacoins;
        this.language = language;
    }*/


  /*  public Usuario(String nombre, String apellido, String apellido2, String fecha, String correo, String password) {
        setNombre(nombre);
        setApellido(apellido);
        setApellido2(apellido2);
        setFecha(fecha);
        setCorreo(correo);
        setPassword(password);
        this.listaObjetosComprados = new ArrayList<>();
   }*/

    public Usuario(String nombre, String correo, String password) {
        setNombre(nombre);
        setCorreo(correo);
        setPassword(password);
    }

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
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

/*    public List<Objeto> getListaObjetosComprados() {
        return listaObjetosComprados;
    }

    public void setListaObjetosComprados(List<Objeto> listaObjetosComprados) {
        this.listaObjetosComprados = listaObjetosComprados;
    }*/

    public double getDsacoins() {
        return dsacoins;
    }

    public void setDsacoins(double dsacoins) {
        this.dsacoins = dsacoins;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
