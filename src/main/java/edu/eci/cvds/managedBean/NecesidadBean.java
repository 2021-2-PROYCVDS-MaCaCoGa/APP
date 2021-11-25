
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
  
    
    
    /**
     * Se encarga de crear la necesidad del estudiante en la base de datos
     * Solo se pide estos parametros, pues los demás se crean de manera automatica 
     * mediante disparadores SQL.
     */
    public void agregarNecesidad(){
        try{
            serviciosEscuela.expresarNecesidad(categoriaNecesidad, nombreNecesidad, descripcionNecesidad, urgenciaNecesidad,UsuarioNecesidad);
        
        }
        catch(Exception exception){
        }
    }
    

    
}
