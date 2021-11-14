package edu.eci.cvds.managedBean;



import com.google.inject.Inject;
import edu.eci.cvds.security.login;
import edu.eci.cvds.security.loginconnection;

import javax.faces.application.FacesMessage;
import org.apache.shiro.subject.Subject;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.annotation.PostConstruct;
import org.apache.shiro.SecurityUtils;
import java.sql.Connection;
import java.sql.DriverManager;


@SuppressWarnings("deprecation")
@ManagedBean(name = "loginListener")
@SessionScoped
public class LoginBean {
    @Inject
    private loginconnection logger ;
    
    private String correo;
    private String contra;
    private Subject actual;
    private String message;
    private FacesMessage.Severity estado;
   

    public void prueba(){
        System.out.println(correo);
        System.out.println(contra);
    }

    /**
     * Metodo encargado de loguear al usuario de acuerdo a su correo y contraseña
     */
    public void loguear(){
        System.out.println("Entra al metodo loguear");
        try{
            
            
            System.out.println("SE INTENTA DE MANERA BRUSCA");
            System.out.println(correo);
            System.out.println(contra);
            System.out.println("SIN ERRORES EN EL CORREO Y PASSWORD");
            this.logger.log(correo, contra);
            System.out.println("PROBLEMAS CON EL LOG DE LOGGINCONNECTION");
            
            
        } catch(Exception exception){
            message = exception.getMessage();
            //estado = FacesMessage.SEVERITY_WARN;
            valoresPredeterminados();
            System.out.println("Problemas con el log");
            exception.printStackTrace();
            
        }
    }
    
    /**
     * Se encarga de mandar el mensaje satisfactorio al servidor Faces
     */
    public void limpio(){
        message = "Login exitoso";
        estado = FacesMessage.SEVERITY_INFO;
    }
    
    public void redireccionInicial(){
        try{
            System.out.println("entra a la redireccion");
            FacesContext facesContext = FacesContext.getCurrentInstance();
            /**if(rolEstudiante()){
                //En esta parte decimos que el estudiante se pudo loguear, y se redirije a la pagina estudiante.xhtml
                HttpSession sesion = (HttpSession)facesContext.getExternalContext().getSession(true);
                sesion.setAttribute("correo", correo);
                facesContext.getExternalContext().redirect("../roles/estudiante.xhtml");
            }
            else if(rolAdministrador()){
                //En esta parte decimos que el administrador se pudo loguear y se redirije a la pagina administrador.xhtml
                HttpSession sesion = (HttpSession)facesContext.getExternalContext().getSession(true);
                sesion.setAttribute("correo", correo);
                facesContext.getExternalContext().redirect("../roles/administrador.xhtml");
            }*/
           
        } catch(Exception exception){
            System.out.print("Problemas en el login,");
            cerrar();
            valoresPredeterminados();
            
        }
    }
    
    /**
     * Retorna true en caos de que el usuario actual tenga el rol de administrador
     * @return --> boolean 
     */
    public boolean rolAdministrador(){
        return actual.hasRole("Administrador");
    }
    
    /**
     * Retorna true en caso de que el usuario actual tenga el rol de estudiante
     * @return --> boolean
     */
    public boolean rolEstudiante(){
        return actual.hasRole("Estudiante");
    }
    
    /**
     * Metodo encargado de cerrar sesion 
     */
    public void cerrar(){
        try{
            logger.cerrarSesion();
        } catch(Exception exception){
            
        }
    }
        
    /**
     * Metodo encargado de volver los valores de correo y contraseña a ""
     */
    public void valoresPredeterminados(){
        this.correo = "";
        this.contra = "";
    }
    
    /**
     * Cambia el valor del correo al que ingrese el usuario
     * @param nuevoCorreo 
     */
    public void setCorreo(String nuevoCorreo){
        this.correo = nuevoCorreo;
    }
    
    /**
     * Cambia el valor de la contraseña a la que ingresa el usuario
     * @param nuevaContra 
     */
    public void setContra(String nuevaContra){
        this.contra = nuevaContra;
    }
    
    /**
     * Retorna el valor de correo del usuario
     * @return 
     */
    public String getCorreo(){
        return this.correo;
    }
    
    /**
     * Retorna el valor de contraseña del usuario
     * @return 
     */
    public String getContra(){
        return this.contra;
    }

    public void estadoLogin() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(estado, "LogIn", message));
    }

}
