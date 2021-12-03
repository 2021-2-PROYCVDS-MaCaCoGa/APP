package edu.eci.cvds.managedBean;



import edu.eci.cvds.samples.services.ExcepcionServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuelaFactory;

import javax.faces.application.FacesMessage;
import org.apache.shiro.subject.Subject;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.shiro.authz.annotation.RequiresGuest;




@ManagedBean(name = "loginListener")
@ApplicationScoped
public class LoginBean{
    //@Inject
    ServiciosEscuela serviciosEscuela  = ServiciosEscuelaFactory.getInstance().getServiciosEscuela();
    
    private String correo;
    private String contra;
    private String rol;
    
    
    public void loguear(){
        try{
            serviciosEscuela.loggear(correo, contra);
        }
        catch(ExcepcionServiciosEscuela excepcionServiciosEscuela){
            predeterminados();
            excepcionServiciosEscuela.printStackTrace();
        }
    }
    
    public void predeterminados(){
        this.correo = "";
        this.contra = "";
        this.rol = "";
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    

}
