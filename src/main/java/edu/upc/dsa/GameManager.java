package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface GameManager {

    //Añadir Usuario
    public void registrarUsuario(String nombre, String correo, String password);
    //Añadir Objeto/Producto
    public void addObjeto(String nombre, String descripcion, double precio);
    //Login Usuario
    public void login(String correo, String password);
    // Metodo hacer una compra
    public Objeto hacerCompra(String Usuario, String nombreObjeto);
    //lista de objetos
    public List<Objeto> listadeObjetos();
    //Lista de objetos ordenados precio ascendente
 //   List<Objeto> listadeObjetosOrdenadosPorPrecio();

    //auxiliares
    Usuario getUsuarioPorCorreo(String correo);

    Usuario getUsuarioPorNombre(String nombreObjeto);

    Objeto getObjetoPorNombre(String nombreObjeto);

    public void clear();

    public int size();
}
