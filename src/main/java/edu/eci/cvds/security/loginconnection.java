package edu.eci.cvds.security;

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

    /**
     * Funcion utilizada para loguear al usuario de acuerdo al id y contraseña proporcionada
     * en el recuadro de la pagina para entrar
     */
    @Override
    public void log(String usuario, String contra) throws HistorialLoginExcepcion {
        System.out.println("Se intenta el log, entra al metodo");
        try{
            System.out.println("PRIMERA PRUEBA PARA VER SI ESTAN LOS VALORES");
            System.out.println(usuario);
            System.out.println(contra);
            //Subject currentUser = SecurityUtils.setSecurityManager(SecurityManager.);
            //System.out.println(//currentUser.toString());
            //MD5HASH es un metodo de criptografia de shiro
            UsernamePasswordToken token = new UsernamePasswordToken(usuario, new Sha256Hash(contra).toHex());
            //currentUser.getSession().setAttribute("usuario",usuario);
            //currentUser.login(token);
            System.out.print("log exitoso");
        } catch(UnknownSessionException unknownSessionException){
            System.out.print("pailas1");
            throw new HistorialLoginExcepcion("El usuario no se encuentra registrado");
        } catch(IncorrectCredentialsException incorrectCredentialsException){
            System.out.print("pailas2");
            throw new HistorialLoginExcepcion("Contraseña del usuario incorrecta, pruebe de nuevo");
        } catch(LockedAccountException lockedAccountException){
            System.out.print("pailas3");
            throw new HistorialLoginExcepcion("El usuario se encuentra actualmente bloqueado");
        } catch(Exception exception){
            System.out.println("pailas4");
            exception.printStackTrace();
            throw new HistorialLoginExcepcion("Ocurrio un error inesperado");
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
    
}
