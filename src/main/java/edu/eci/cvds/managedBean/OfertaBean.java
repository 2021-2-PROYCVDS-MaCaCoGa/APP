
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
import org.primefaces.PrimeFaces;


@SuppressWarnings("deprecation")
@ManagedBean(name = "ofertaListener")
@SessionScoped
public class OfertaBean {
    ServiciosEscuela serviciosEscuela = ServiciosEscuelaFactory.getInstance().getServiciosEscuela();

    
    private String categoriaOferta;
    private String nombreOferta;
    private String estadoOferta;
    private String estadoActualizar;
    private String descripcionOferta;
    private String usuarioOferta; 
    private List<String> nombresOfertas;
    private List<Actividad> ofertas;
    
    
    @PostConstruct
    public void init(){
        nombresOfertas = new ArrayList<>();
        try {
            this.ofertas = serviciosEscuela.consultarOfertas();
            for(Actividad oferta: this.ofertas){
                this.nombresOfertas.add(oferta.getNombre());
            }
        } catch (ExcepcionServiciosEscuela ex){
        }
    }
    
    public void getDatosActualizar(){
        for(Actividad oferta : this.ofertas){
            if(oferta.getNombre().equals(nombreOferta)){
                this.descripcionOferta = oferta.getDescripcion();
                this.nombreOferta = oferta.getNombre();
                this.estadoOferta = oferta.getEstado();
            }
        }
    }
    
    public void redireccionActualizar(){
        getDatosActualizar();
        try{
            FacesContext facesContext = FacesContext.getCurrentInstance();
            facesContext.getExternalContext().redirect("../Funciones Generales/actualizarOfertaFinal.xhtml");
        }
        catch(Exception exception){
        }
    }
    /**
     * Se encarga de crear la oferta del estudiante en la base de datos
     * Solo se pide estos parametros, pues los demás se crean de manera automatica 
     * mediante disparadores SQL.
     */
    public void registrarOferta(){
        try{
            serviciosEscuela.registrarOferta(categoriaOferta, nombreOferta, descripcionOferta, usuarioOferta);
         
        }
        catch(Exception exception){
            FacesMessage mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",exception.getMessage());
            PrimeFaces.current().dialog().showMessageDynamic(mensaje);
        }
    }  
    
    public void actualizarEstadoOferta(){
        try{
            serviciosEscuela.actualizarEstadoOferta(nombreOferta,estadoActualizar);
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
    
    public List<Actividad> tablaOfertas() throws ExcepcionServiciosEscuela{
        return serviciosEscuela.consultarOfertas();
    }

    public String getCategoriaOferta() {
        return categoriaOferta;
    }

    public void setCategoriaOferta(String categoriaOferta) {
        this.categoriaOferta = categoriaOferta;
    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }

    public String getDescripcionOferta() {
        return descripcionOferta;
    }

    public void setDescripcionOferta(String descripcionOferta) {
        this.descripcionOferta = descripcionOferta;
    }

    public String getUsuarioOferta() {
        return usuarioOferta;
    }

    public void setUsuarioOferta(String usuarioOferta) {
        this.usuarioOferta = usuarioOferta;
    }


    public String getEstadoOferta() {
        return estadoOferta;
    }

    public void setEstadoOferta(String estadoOferta) {
        this.estadoOferta = estadoOferta;
    }

    public String getEstadoActualizar() {
        return estadoActualizar;
    }

    public void setEstadoActualizar(String estadoActualizar) {
        this.estadoActualizar = estadoActualizar;
    }

    public List<String> getNombresOfertas() {
        return nombresOfertas;
    }

    public void setNombresOfertas(List<String> nombresOfertas) {
        this.nombresOfertas = nombresOfertas;
    }

    public List<Actividad> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Actividad> ofertas) {
        this.ofertas = ofertas;
    }
    
    
    
    
}
