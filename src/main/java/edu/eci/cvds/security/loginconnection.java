package edu.eci.cvds.security;

import com.google.inject.Inject;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.Usuario;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.session.UnknownSessionException;
import java.io.IOException;


import edu.eci.cvds.services.HistorialLoginExcepcion;
import javax.faces.context.FacesContext;
import org.apache.shiro.crypto.hash.Sha256Hash;

import sun.security.provider.SHA;

public class loginconnection implements login{
    @Inject
    private UsuarioMapper mapperUsuario;
    
    private Usuario usuarioRevisar;
    
    private String rolUsuario;

    /**
     * Funcion utilizada para loguear al usuario de acuerdo al id y contraseña proporcionada
     * en el recuadro de la pagina para entrar
     */
    @Override
    public void log(String usuario, String contra) throws HistorialLoginExcepcion {
        System.out.println("ENTRA AL METODO DE LOG DE LOGINCONNECTION");
        try{
            usuarioRevisar = mapperUsuario.consultarUsuario(usuario);
            if(usuarioRevisar.getContraseña().equals(contra)){
                this.rolUsuario = usuarioRevisar.getPerfil();
                redireccion();
            }
        }
        catch(Exception exception){
            exception.printStackTrace();
            throw new HistorialLoginExcepcion("No se pudo revisar los datos del usuario");
        }
    }

    /**
     * Funcion utlizada para cerrar la sesion del usuario actual
     * @throws HistorialLoginExcepcion 
     */
    @Override
    public void cerrarSesion() throws HistorialLoginExcepcion {
        SecurityUtils.getSubject().logout();
        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect("../login.xhtml");
        }catch(IOException ioexception){
            ioexception.printStackTrace();
            throw new HistorialLoginExcepcion("Ocurrio un error inesperado al intentar cerrar la sesion");
        }
    }

    /**
     * Funcion que se encarga de revisar si el usuario está logueado en la pagina 
     * @return 
     */
    @Override
    public boolean Logueado() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

    @Override
    public void redireccion() {
        System.out.println("SE REDIRECCIONA HACIA "+this.usuarioRevisar.getPerfil());
        if(this.rolUsuario.equals("Estudiante")){
            redireccionEstudiante();
        }
        else if(this.rolUsuario.equals("Administrador")){
            redireccionAdmin();
        }
    }

    @Override
    public void redireccionEstudiante() {
        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/roles/estudiante.xhtml");
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }

    @Override
    public void redireccionAdmin() {
        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/roles/administrador.xhtml");
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }
    
    
}
