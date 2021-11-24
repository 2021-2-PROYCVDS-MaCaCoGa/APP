package edu.eci.cvds.managedBean;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuelaFactory;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "listenerCategoria")
@ApplicationScoped
public class CategoriaBean{
    //@Inject
    ServiciosEscuela serviciosEscuela = ServiciosEscuelaFactory.getInstance().getServiciosEscuela();
   
    
    private String nombreCategoria;
    private String descripcionCategoria;
    private String nuevoNombre;
    private String nuevaCategoria;
    private String nuevoEstado;
    private List<Categoria> categorias;
    


    /**
     * Se encarga de conectar el boton de "CREAR CATEGORIA" del frontend con el método crear categoria
     * implementado en los servicios de la escuela
     */
    public void agregarCategoria(){
        try{
            System.out.println("ENTRA AL METODO DE AGREGAR CATEGORIA DE CATEGORIABEAN");
            System.out.println(nombreCategoria.getClass());
            System.out.println(descripcionCategoria.getClass());
            serviciosEscuela.crearCategoria(nombreCategoria, descripcionCategoria);
          
        }
        catch(Exception exception){
            System.out.println("HAY UN ERROR");
            exception.printStackTrace();
            //ACA SE DEBE MANDAR UN ERROR DONDE SE DIGA QUE NO SE PUDO -> REVISAR HTTPCONTEXT Y ESAS VAINAS
        }
    }
    
    /**
     * Metodo que se encarga de modificar la categoria de acuerdo a los nuevos parametros
     * dados por el usuario
     */
    public void actualizarCategoria(){
        try{
            serviciosEscuela.actualizarCategoria(nombreCategoria, nuevoNombre, nuevaCategoria, nuevoEstado);
        }
        catch(Exception exception){
            
        }
    }
    
    
    public void eliminarCategoria(){
        
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }
    

    
    
}
