package edu.upc.dsa;

import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.dto.TablaCompra;
import edu.upc.dsa.models.dto.UsuarioTO;
import edu.upc.eetac.dsa.FactorySession;
import edu.upc.eetac.dsa.Session;
import edu.upc.eetac.dsa.IUserDAO;
import edu.upc.eetac.dsa.UserDAOImpl;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameManagerImpl implements GameManager {

    HashMap<String, Usuario> Usuarios;
    protected List<Usuario> listaUsuarios;
    HashMap<String, Objeto> Objetos;
    protected List<Objeto> listaObjetos;
    private static GameManager instance;
    final static Logger logger = Logger.getLogger(GameManagerImpl.class);

    public GameManagerImpl(){
        this.listaUsuarios = new ArrayList<>();
        this.Usuarios = new HashMap<>();
        this.listaObjetos = new ArrayList<>();
        this.Objetos = new HashMap<>();
    }

    public static GameManager getInstance() {
        if (instance==null) instance = new GameManagerImpl();
        return instance;
    }

    @Override
    public void registrarUsuario(String nombre, String correo, String password) {

        if (Usuarios.get(correo) == null){

            this.listaUsuarios.add(new Usuario(nombre, correo, password));

            logger.info("Se ha realizado correctamente");
        }
        else
            logger.info("El correo ya existe con un usuario");
    }

    @Override
    public int addUsuarioORM(String nombre, String correo, String password) {
        Session session = null;
        int userID = 0;
        try {
            session = FactorySession.openSession();
            UsuarioTO u = new UsuarioTO(nombre, correo, password);
            session.save(u);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return userID;

    }

    @Override
    public Usuario addUsuario2(Usuario u) {
        Session session = null;
        try{
            session = FactorySession.openSession();
            List<Usuario> listaUsuarios = session.findAll(Usuario.class);
            for (Usuario us : listaUsuarios) {
                if (us.getNombre().equals(u.getNombre()) || us.getCorreo().equals(u.getCorreo())) {
                    return null;
                }
            }
            session.save(u);
            return u;
        }
        catch (Exception e){
                // LOG
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public void addObjeto(String nombre, String descripcion, double precio, String fotoImagen) {
        this.listaObjetos.add(new Objeto(nombre, descripcion, precio, fotoImagen));
        logger.info("Se ha añadido correctamente");
    }

    @Override
    public Objeto addObjetoORM(String nombre, String descripcion, double precio, String fotoImagen) {
        Session session = null;
        try{
            session = FactorySession.openSession();
            Objeto o = new Objeto(nombre, descripcion, precio, fotoImagen);
            session.save(o);
            return o;

        }
        catch (Exception e){
            // LOG
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public void login(String correo, String password) {

        Usuario usuario = null;
        for (Usuario u : listaUsuarios) {
            if (u.getCorreo().equals(correo)) {
                usuario = u;
                break;
            }
        }
        if (usuario != null && usuario.getPassword().equals(password)) {
            logger.info("Login con éxito");
        } else {
            logger.info("Contraseña incorrecta");
        }
    }

    @Override
    public boolean loginORM(String correo, String password) {
        Session session = null;
        Usuario usuario = null;
        try {
            session = FactorySession.openSession();
            usuario= getUserByEmailORM(correo);
            if (usuario.getCorreo().equals(correo)&(usuario.getPassword().equals(password))){
                logger.info("usuario loggeado");
                return true;

            }
            logger.info("usuario NO loggeado");
            return false;
            /*User u = new User(email, password);
            session.save(u);*/
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return false;
        }


/*    @Override
    public Objeto hacerCompra(String Usuario, String nombreObjeto) {

        Usuario usuario = getUsuarioPorNombre(Usuario);
        if (usuario == null) {
            logger.info("Usuario " + Usuario + " no existe");
        }
        else {
            Objeto objeto = getObjetoPorNombre(nombreObjeto);
            if (usuario.getDsaCoins() < objeto.getPrecio()) {
                logger.info("No tienes money");
            }
            else{
                usuario.getListaObjetosComprados().add(objeto);
                double saldo = usuario.getDsaCoins() - objeto.getPrecio();
                usuario.setDsaCoins(saldo);
                logger.info("Objeto " + nombreObjeto + " comprado");
                logger.info(Usuario + " ahora tienes: " + saldo + " dsaCoins");
                return objeto;
            }
        }
        return null;
    }*/

    @Override
    public TablaCompra hacerCompraORM(Integer usuario1, Integer objeto1) {
        Session session = null;
        try {
            session = FactorySession.openSession();
            Usuario usuario = getUsuarioORM(usuario1);
            Objeto objeto = getObjetoORM(objeto1);

            if(usuario.getDsacoins() < objeto.getPrecio()){
                return null;
            }
            else {
                double dinero = usuario.getDsacoins()-objeto.getPrecio();
                usuario.setDsacoins(dinero);
                session.update(usuario);
                TablaCompra tablacompra = new TablaCompra(usuario1, objeto1);
                session.save(tablacompra);
                return tablacompra;
            }
        }
        catch (Exception e){

        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Objeto> listadeObjetos() {
        logger.info("Lista de objetos: " + listaObjetos.toString());
        return this.listaObjetos;
    }

/*    @Override
    public List<Objeto> listadeObjetosOrdenadosPorPrecio() {
        this.listaObjetos.sort(new Comparator<Objeto>() {
            public int compare(Objeto o1, Objeto o2) {
                return Double.compare(o2.getPrecio(), o1.getPrecio());
            }
        });
        logger.info("Lista ordenada por precio ascendente: " + listaObjetos.toString());
        return listaObjetos;

    } */


    //extras

    public Usuario getUsuarioPorNombre(String nombre){
        for (Usuario u: this.listaUsuarios) {
            if(u.getNombre().equals(nombre)){
                return u;
            }
        }
        return null;
    }

    public Objeto getObjetoPorNombre(String nombre){
        for (Objeto o: this.listaObjetos) {
            if(o.getNombre().equals(nombre)){
                return o;
            }
        }
        return null;
    }

    public Usuario getUsuarioPorCorreo(String correo){
        for (Usuario u: this.listaUsuarios) {
            if(u.getCorreo().equals(correo)){
                return u;
            }
        }
        return null;
    }

    @Override
    public Usuario getUserByEmailORM(String correo) {
        Session session = null;
        Usuario usuario = null;
        try {
            session = FactorySession.openSession();
            usuario = (Usuario) session.get(Usuario.class, "correo", correo);
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return usuario;
    }

    @Override
    public Usuario getUsuarioORM(Integer idUsuario) {
        Session session = null;
        try {
            session = FactorySession.openSession();
            List<Usuario> listaUsuarios = session.findAll(new Usuario().getClass());
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getId() == idUsuario) {
                    return usuario;
                }
            }
            return null;
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return null;
    }

    @Override
    public Objeto getObjetoORM(Integer idObjeto){
        Session session = null;
        try {
            session = FactorySession.openSession();
            List<Objeto> listaObjetos = session.findAll(new Objeto().getClass());
            for (Objeto objeto : listaObjetos) {
                if (objeto.getId() == idObjeto) {
                    return objeto;
                }
            }
            return null;
        }
        catch (Exception e) {
            // LOG
        }
        finally {
            session.close();
        }

        return null;
    }

    @Override
    public void clear() {
        this.listaObjetos.clear();
    }

    @Override
    public int size() {
        return this.listaObjetos.size();
    }


    // public int size() {
    //   int ret = this.tracks.size();
    // logger.info("size " + ret);

    //return ret;
    //}

}