
package edu.eci.cvds.managedBean;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@SuppressWarnings("deprecation")
@ManagedBean(name = "necesidadListener")
@SessionScoped
public class NecesidadBean {
    @Inject 
    ServiciosEscuela serviciosEscuela;
    
    private String categoriaNecesidad;
    private String nombreNecesidad;
    private String descripcionNecesidad;
    private int urgenciaNecesidad;
    private String UsuarioNecesidad; //--> No sabria en que espacio ponerlo...
    private String mensaje;
    private FacesMessage.Severity estadoSolicitud;
    
    
    /**
     * Se encarga de crear la necesidad del estudiante en la base de datos
     * Solo se pide estos parametros, pues los demás se crean de manera automatica 
     * mediante disparadores SQL.
     */
    public void agregarNecesidad(){
        try{
            serviciosEscuela.expresarNecesidad(categoriaNecesidad, nombreNecesidad, descripcionNecesidad, urgenciaNecesidad,UsuarioNecesidad);
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
    
    public void setNombreCategoria(){
        
    }
    
}
