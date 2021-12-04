
package edu.eci.cvds.managedBean;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Actividad;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.services.ExcepcionServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuelaFactory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.PrimeFacesContext;


@SuppressWarnings("deprecation")
@ManagedBean(name = "necesidadListener")
@SessionScoped
public class NecesidadBean {
    //@Inject 
    ServiciosEscuela serviciosEscuela = ServiciosEscuelaFactory.getInstance().getServiciosEscuela();
    
    private String categoriaNecesidad;
    private String nombreNecesidad;
    private String descripcionNecesidad;
    private int urgenciaNecesidad;
    private String usuarioNecesidad; 
    private List<String> nombresNecesidades;
    private List<Actividad> necesidades;
    private String estadoNecesidad;
    private String estadoActualizar;
    
    @PostConstruct
    public void init(){
        nombresNecesidades = new ArrayList<>();
        try {
            this.necesidades = serviciosEscuela.consultarNecesidades();
            for(Actividad necesidad: this.necesidades){
                this.nombresNecesidades.add(necesidad.getNombre());
            }
        } catch (ExcepcionServiciosEscuela ex){
        }
    }
    
    public void getDatosActualizar(){
        for(Actividad necesidad : this.necesidades){
            if(necesidad.getNombre().equals(this.nombreNecesidad)){
                this.nombreNecesidad = necesidad.getNombre();
                this.descripcionNecesidad = necesidad.getDescripcion();
                this.estadoNecesidad = necesidad.getEstado();
            }
        }
    }
    
    public void redireccionActualizar(){
        getDatosActualizar();
        try{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().redirect("../Funciones Generales/actualizarFinal.xhtml");
        }
        catch(Exception exception){
        }
    }
    
    public void redireccionPrincipal(){
        try{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().redirect("../roles/administrador.xhtml");
        }
        catch(Exception exception){
        }
    }
    
    /**
     * Se encarga de crear la necesidad del estudiante en la base de datos
     * Solo se pide estos parametros, pues los demás se crean de manera automatica 
     * mediante disparadores SQL.
     */
    public void agregarNecesidad(){
        try{
            serviciosEscuela.expresarNecesidad(categoriaNecesidad, nombreNecesidad, descripcionNecesidad, urgenciaNecesidad,usuarioNecesidad);       
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
    
    /**
     * Metodo encargado de actualizar el estado de la necesidad de acuerdo al nombre que
     * le demos al mapper para que la busque y la actualice
     */
    public void actualizarEstadoNecesidad(){
        try{
            serviciosEscuela.actualizarEstadoNecesidad(nombreNecesidad, estadoActualizar);
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
    
    
    public List<Actividad> tablaNecesidades() throws ExcepcionServiciosEscuela{
        return serviciosEscuela.consultarNecesidades();
    }
    

    public String getCategoriaNecesidad() {
        return categoriaNecesidad;
    }

    public void setCategoriaNecesidad(String categoriaNecesidad) {
        this.categoriaNecesidad = categoriaNecesidad;
    }

    public String getNombreNecesidad() {
        return nombreNecesidad;
    }

    public void setNombreNecesidad(String nombreNecesidad) {
        this.nombreNecesidad = nombreNecesidad;
    }

    public String getDescripcionNecesidad() {
        return descripcionNecesidad;
    }

    public void setDescripcionNecesidad(String descripcionNecesidad) {
        this.descripcionNecesidad = descripcionNecesidad;
    }

    public int getUrgenciaNecesidad() {
        return urgenciaNecesidad;
    }

    public void setUrgenciaNecesidad(int urgenciaNecesidad) {
        this.urgenciaNecesidad = urgenciaNecesidad;
    }

    public String getUsuarioNecesidad() {
        return usuarioNecesidad;
    }

    public void setUsuarioNecesidad(String usuarioNecesidad) {
        this.usuarioNecesidad = usuarioNecesidad;
    }

    public List<String> getNombresNecesidades() {
        return nombresNecesidades;
    }

    public void setNombresNecesidades(List<String> nombresNecesidades) {
        this.nombresNecesidades = nombresNecesidades;
    }

    public List<Actividad> getNecesidades() {
        return necesidades;
    }

    public void setNecesidades(List<Actividad> necesidades) {
        this.necesidades = necesidades;
    }

    public String getEstadoNecesidad() {
        return estadoNecesidad;
    }

    public void setEstadoNecesidad(String estadoNecesidad) {
        this.estadoNecesidad = estadoNecesidad;
    }

    public String getEstadoActualizar() {
        return estadoActualizar;
    }

    public void setEstadoActualizar(String estadoActualizar) {
        this.estadoActualizar = estadoActualizar;
    }

    
   
    

    
}
