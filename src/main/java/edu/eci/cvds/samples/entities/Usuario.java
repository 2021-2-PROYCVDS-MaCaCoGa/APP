package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



/* Clase que contiene la informacion de los usuarios que utilizan la aplicación
**/
public class Usuario implements Serializable{
    private int id;
    private String nombre;
    private String rol;
    private String correo;
    private String password;
    private String login;
    private List<Actividad> actividades;
    
    private int ofrecidas;
    private int solicitadas;


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
        this.rol = rol;
        this.correo = correo;
        this.password = contraseña;
        this.login = login;       
        this.actividades = new ArrayList<Actividad>();
    }
    
    public Usuario(){}

    public void setNombre(String nombre){this.nombre = nombre;}
    public String getNombre(){return this.nombre;}

    public void setPerfil(String rol){this.rol = rol;}
    public String getPerfil(){return this.rol;}

    public void setCorreo(String correo){this.correo = correo;}
    public String getCorreo(){return this.correo;}

    public void setContraseña(String contraseña){this.password = contraseña;}
    public String getContraseña(){return this.password;}

    public void setLogin(String login){this.login = login;}
    public String getLogin(){return this.login;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }

    public int getOfrecidas() {
        return ofrecidas;
    }

    public void setOfrecidas(int ofrecidas) {
        this.ofrecidas = ofrecidas;
    }

    public int getSolicitadas() {
        return solicitadas;
    }

    public void setSolicitadas(int solicitadas) {
        this.solicitadas = solicitadas;
    }
    
    
    
    @Override
    public String toString(){
        return "Usuario{"+"nombre="+getNombre()+", rol="+rol+", correo="+correo+", contraseña= "+getContraseña()+", login="+login+"}\n";
    }


}
