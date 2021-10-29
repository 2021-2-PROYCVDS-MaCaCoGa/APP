package edu.eci.cvds.samples.entities;

import java.io.Serializable;



/* Clase que contiene la informacion de los usuarios que utilizan la aplicación
**/
public class Usuario implements Serializable{
    private String nombre;
    private int perfil;
    private String correo;
    private String contraseña;
    private String login;


    /**
     * Crea un usuario dados los distintos parametros
     * @param nombre
     * @param Perfil
     * @param correo
     * @param contraseña
     * @param login - Nombre de usuario del usuario
     */
    public Usuario(String nombre, int Perfil, String correo, String contraseña, String login){
        this.nombre = nombre;
        this.perfil = perfil;
        this.correo = correo;
        this.contraseña = contraseña;
        this.login = login;        
    }

    public Usuario(){}

    public void setNombre(String nombre){this.nombre = nombre;}
    public String getNombre(){return this.nombre;}

    public void setPerfil(int perfil){this.perfil = perfil;}
    public int getPerfil(){return this.perfil;}

    public void setCorreo(String correo){this.correo = correo;}
    public String getCorreo(){return this.correo;}

    public void setContraseña(String contraseña){this.contraseña = contraseña;}
    public String getContraseña(){return this.contraseña;}

    public void setLogin(String login){this.login = login;}
    public String getLogin(){return this.login;}


}
