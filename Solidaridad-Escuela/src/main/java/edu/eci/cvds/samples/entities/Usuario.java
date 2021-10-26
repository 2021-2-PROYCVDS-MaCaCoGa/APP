package edu.eci.cvds.samples.entities;

import java.io.Console;
import java.io.Serializable;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* Clase que contiene la informacion de los usuarios que utilizan la aplicación
**/
public class Usuario implements Serializable{
    private String nombre;
    private Perfil perfil;
    private String correo;
    private String contraseña;
    private String login;

    private static final transient Logger log = LoggerFactory.getLogger(Usuario.class);

    /**
     * Crea un usuario dados los distintos parametros
     * @param nombre
     * @param Perfil
     * @param correo
     * @param contraseña
     * @param login - Nombre de usuario del usuario
     */
    public Usuario(String nombre, String Perfil, String correo, String contraseña, String login){
        this.nombre = nombre;
        this.perfil = perfil;
        this.correo = correo;
        this.contraseña = contraseña;
        this.login = login;        
    }

    public Usuario(){}

    public void setNombre(String nombre){this.nombre = nombre;}
    public String getNombre(){return this.nombre;}

    public void setPerfil(Perfil perfil){this.perfil = perfil;}
    public Perfil getPerfil(){return this.perfil;}

    public void setCorreo(String correo){this.correo = correo;}
    public String getCorreo(){return this.correo;}

    public void setContraseña(String contraseña){this.contraseña = contraseña;}
    public String getContraseña(){return this.contraseña;}

    public void setLogin(String login){this.login = login;}
    public String getLogin(){return this.login;}

    public void seguridadLogin(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
    }
}
