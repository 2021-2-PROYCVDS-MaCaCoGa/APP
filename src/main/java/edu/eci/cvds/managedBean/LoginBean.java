package edu.eci.cvds.managedBean;


import com.google.inject.Inject;
import edu.eci.cvds.security.login;
import javax.faces.application.FacesMessage;
import org.apache.shiro.subject.Subject;

import javax.faces.bean.ManagedBean;
import org.apache.shiro.SecurityUtils;

@ManagedBean(name = "loginListener")
public class LoginBean {
    @Inject
    private login logger;
    private String correo;
    private String contraseña;
    private Subject actual;
    private String message;
    private FacesMessage.Severity estado;


    /**
     * Metodo encargado de loguear al usuario de acuerdo a su correo y contraseña
     */
    public void Loguear(){
        try{
            limpio();
            actual =  SecurityUtils.getSubject();
            if(logger.Logueado()){
                System.out.println("Usuario logueado con exito");
            }
            else{
                logger.log(correo, contraseña);
            }
        } catch(Exception exception){
            
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
            if(rolEstudiante()){
            }
           
        } catch(Exception exception){
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

}
