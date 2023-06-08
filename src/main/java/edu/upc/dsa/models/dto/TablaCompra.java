package edu.upc.dsa.models.dto;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import io.swagger.models.auth.In;

public class TablaCompra {

    String correo;

    String nombreObjeto;

    public TablaCompra(){}

    public TablaCompra(String correo, String nombreObjeto){
        this.setCorreo(correo);
        this.setNombreObjeto(nombreObjeto);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }
}
