
package edu.eci.cvds.managedBean;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuelaFactory;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


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
  
    
    
    /**
     * Se encarga de crear la necesidad del estudiante en la base de datos
     * Solo se pide estos parametros, pues los demás se crean de manera automatica 
     * mediante disparadores SQL.
     */
    public void agregarNecesidad(){
        try{
            System.out.println("ENTRA AL METODO DE AGREGAR NECESIDAD DE NECESIDAD BEAN");
            System.out.println(categoriaNecesidad);
            System.out.println(nombreNecesidad);
            System.out.println(descripcionNecesidad);
            System.out.println(urgenciaNecesidad);
            System.out.println(usuarioNecesidad);
            serviciosEscuela.expresarNecesidad(categoriaNecesidad, nombreNecesidad, descripcionNecesidad, urgenciaNecesidad,usuarioNecesidad);
        
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
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

   
    

    
}
