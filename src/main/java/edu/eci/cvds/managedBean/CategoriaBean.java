
package edu.eci.cvds.managedBean;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.ExcepcionServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 *
 * @author diego
 */
@SuppressWarnings("deprecation")
@ManagedBean(name = "categoriaListener")
@SessionScoped
public class CategoriaBean{
    @Inject 
    ServiciosEscuela serviciosEscuela;
    
    private String nombreCategoria;
    private String descripcionCategoria;
    private String mensaje;
    private FacesMessage.Severity estadoSolicitud;

    public void prueba(){
        System.out.println(nombreCategoria);
        System.out.println(descripcionCategoria);
    }

  

    
    /**
     * Se encarga de llamar al metodo crearCategoria de los servicios de la escuela
     * Este metodo va ligado con el boton de "CREAR CATEGORIA" del xhtml
     */
    public void registrarCategoria(){
        try{
            serviciosEscuela.crearCategoria(nombreCategoria, descripcionCategoria);
            mensajeSinErrores();
        }
        catch(Exception exception){
            mensajeConErrores(exception.getMessage());
        }
    }
    
    /**
     * Se encarga de decirle al usuario que su solicitud de categoria
     * ha pasado sin problemas.
     */
    public void mensajeSinErrores(){
        this.mensaje = "Se pudo crear la categoria";
        this.estadoSolicitud = FacesMessage.SEVERITY_INFO;
    }
    
    /**
     * Se encarga de decirle al usuario que hubo un problema
     * con la solicitud requerida en la categoria
     * @param mensajeError --> Mensaje enviado por la excepcion
     */
    public void mensajeConErrores(String mensajeError){
        this.mensaje = mensajeError;
        this.estadoSolicitud = FacesMessage.SEVERITY_WARN;
        
       
    }
    
}
