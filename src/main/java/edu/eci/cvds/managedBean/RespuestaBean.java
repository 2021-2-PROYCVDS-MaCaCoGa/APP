package edu.eci.cvds.managedBean;

import edu.eci.cvds.samples.entities.Respuesta;
import edu.eci.cvds.samples.services.ExcepcionServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuelaFactory;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author crisa
 */

@SuppressWarnings("deprecation")
@ManagedBean(name = "respuestaListener")
@SessionScoped
public class RespuestaBean {
    ServiciosEscuela serviciosEscuela = ServiciosEscuelaFactory.getInstance().getServiciosEscuela();
    
    private String nombreRespuesta;
    private String comentarioRespuesta;
    private String nombreComentarioRespuesta;
    private String actividadRespuesta;
    private String usuarioRespuesta;

    public void registrarRespuesta() {
        try{
            serviciosEscuela.registrarRespuesta(nombreRespuesta, comentarioRespuesta, nombreComentarioRespuesta, actividadRespuesta, usuarioRespuesta);
        }catch(ExcepcionServiciosEscuela e){
            e.printStackTrace();
        }
    }
    
    public List<Respuesta> tablaRespuestas() throws ExcepcionServiciosEscuela{
        return serviciosEscuela.consultarRespuestas();
    }

    public ServiciosEscuela getServiciosEscuela() {
        return serviciosEscuela;
    }

    public void setServiciosEscuela(ServiciosEscuela serviciosEscuela) {
        this.serviciosEscuela = serviciosEscuela;
    }

    public String getNombreRespuesta() {
        return nombreRespuesta;
    }

    public void setNombreRespuesta(String nombreRespuesta) {
        this.nombreRespuesta = nombreRespuesta;
    }

    public String getComentarioRespuesta() {
        return comentarioRespuesta;
    }

    public void setComentarioRespuesta(String comentarioRespuesta) {
        this.comentarioRespuesta = comentarioRespuesta;
    }

    public String getNombreComentarioRespuesta() {
        return nombreComentarioRespuesta;
    }

    public void setNombreComentarioRespuesta(String nombreComentarioRespuesta) {
        this.nombreComentarioRespuesta = nombreComentarioRespuesta;
    }

    public String getActividadRespuesta() {
        return actividadRespuesta;
    }

    public void setActividadRespuesta(String actividadRespuesta) {
        this.actividadRespuesta = actividadRespuesta;
    }

    public String getUsuarioRespuesta() {
        return usuarioRespuesta;
    }

    public void setUsuarioRespuesta(String usuarioRespuesta) {
        this.usuarioRespuesta = usuarioRespuesta;
    }
    
    
    
}
