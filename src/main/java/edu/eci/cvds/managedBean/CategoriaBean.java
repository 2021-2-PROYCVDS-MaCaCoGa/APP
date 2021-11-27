package edu.eci.cvds.managedBean;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.services.ExcepcionServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuelaFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


@ManagedBean(name = "listenerCategoria")
@ApplicationScoped
public class CategoriaBean{
    //@Inject
    ServiciosEscuela serviciosEscuela = ServiciosEscuelaFactory.getInstance().getServiciosEscuela();
    
    private String nombreCategoria;
    private String descripcionCategoria;
    private List<Categoria> categorias;
    private List<String> nombres;
    private String nombreActualizar;
    private String descripcionActualizar;
    private String estadoActualizar;
    
    @PostConstruct
    public void init(){
        nombres = new ArrayList<>();
        try {
            this.categorias = serviciosEscuela.consultarCategorias();
            for(Categoria categoria : categorias){
                this.nombres.add(categoria.getNombre());
            }
        } catch (ExcepcionServiciosEscuela ex){
        }
    }
    
    public void getDatosActualizar(){
        for(Categoria categoria : categorias){
            if(categoria.getNombre().equals(nombreCategoria)){
                this.descripcionActualizar = categoria.getDescripcion();
                this.nombreActualizar = categoria.getNombre();
                this.estadoActualizar = categoria.getEstado();
            }
        }
    }
    
    public void prueba(){
        System.out.println(nombreCategoria);
        System.out.println(nombreActualizar);
        System.out.println(descripcionActualizar);
        System.out.println(estadoActualizar);
        
    }
    
    /**
     * Se encarga de conectar el boton de "CREAR CATEGORIA" del frontend con el método crear categoria
     * implementado en los servicios de la escuela
     */
    public void agregarCategoria(){
        try{
            System.out.println(nombreCategoria.getClass());
            System.out.println(descripcionCategoria.getClass());
            serviciosEscuela.crearCategoria(nombreCategoria, descripcionCategoria);
          
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
    
    /**
     * Metodo que se encarga de modificar la categoria de acuerdo a los nuevos parametros
     * dados por el usuario
     */
    public void actualizarCategoria(){
        try{
            serviciosEscuela.actualizarCategoria(nombreCategoria, nombreActualizar, descripcionActualizar, estadoActualizar);
        }
        catch(Exception exception){
        }
    }
    
    /**
     * Metodo que se encarga de eliminar la categoria que el cliente desee.
     * Este proceso se logra gracias al nombre de la categoria a eliminar
     */
    public void eliminarCategoria(){
        try{
            serviciosEscuela.eliminarCategoria(nombreCategoria);
        }
        catch(Exception exception){}
        
    }
    
    public void redireccionarActualizacion(){
        getDatosActualizar();
        try{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().redirect("../admin/modificacionFinal.xhtml");
        }
        catch(Exception exception){
        }
    }
    
    public void redireccionarEliminacion(){
        getDatosActualizar();
        try{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().redirect("../admin/eliminacionFinal.xhtml");
        }
        catch(Exception exception){}
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
    

    public List<String> getNombres() {
        return nombres;
    }

    public void setNombres(List<String> nombres) {
        this.nombres = nombres;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    public String getNombreActualizar() {
        return nombreActualizar;
    }

    public void setNombreActualizar(String nombreActualizar) {
        this.nombreActualizar = nombreActualizar;
    }

    public String getDescripcionActualizar() {
        return descripcionActualizar;
    }

    public void setDescripcionActualizar(String descripcionActualizar) {
        this.descripcionActualizar = descripcionActualizar;
    }

    public String getEstadoActualizar() {
        return estadoActualizar;
    }

    public void setEstadoActualizar(String estadoActualizar) {
        this.estadoActualizar = estadoActualizar;
    }
    
    

    

    
    
}
