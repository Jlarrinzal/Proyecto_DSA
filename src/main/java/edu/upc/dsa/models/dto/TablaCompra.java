package edu.upc.dsa.models.dto;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import io.swagger.models.auth.In;

public class TablaCompra {

    Integer usuario1;

    Integer objeto1;

    public TablaCompra(){}

    public TablaCompra(Integer usuario1, Integer objeto1){
        this.setUsuario1(usuario1);
        this.setObjeto1(objeto1);
    }

    public Integer getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Integer usuario1) {
        this.usuario1 = usuario1;
    }

    public Integer getObjeto1() {
        return objeto1;
    }

    public void setObjeto1(Integer objeto1) {
        this.objeto1 = objeto1;
    }

}
