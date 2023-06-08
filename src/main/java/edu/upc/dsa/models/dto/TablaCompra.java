package edu.upc.dsa.models.dto;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import io.swagger.models.auth.In;

public class TablaCompra {

    Integer idUsuario;

    Integer idObjeto;

    public TablaCompra(){}

    public TablaCompra(Integer idUsuario, Integer idObjeto){
        this.setIdUsuario(idUsuario);
        this.setIdObjeto(idObjeto);
    }
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Integer idObjeto) {
        this.idObjeto = idObjeto;
    }
}
