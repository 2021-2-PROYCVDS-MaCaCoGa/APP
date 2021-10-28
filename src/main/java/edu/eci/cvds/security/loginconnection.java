package edu.eci.cvds.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;

import edu.eci.cvds.services.HistorialLoginExcepcion;

public class loginconnection implements login{

    /**
     * Funcion utilizada para loguear al usuario de acuerdo al id y contraseña proporcionada
     * en el recuadro de la pagina para entrar
     */
    @Override
    public void log(String usuario, String contraseña) throws HistorialLoginExcepcion {
        try{
            Subject currentUser = SecurityUtils.getSubject();
            //MD5HASH es un metodo de criptografia de shiro
            UsernamePasswordToken token = new UsernamePasswordToken(usuario, new Md5Hash(contraseña).toHex());
            currentUser.getSession().setAttribute("usuario",usuario);
            currentUser.login(token);
        } catch(AuthenticationException authenticationException){
            throw new HistorialLoginExcepcion();
        }

    }

    @Override
    public void cerrarSesion() throws HistorialLoginExcepcion {
       
        
    }

    @Override
    public boolean Logueado() {
        
        return false;
    }
    
}
