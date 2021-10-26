package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosEscuela {
    
    public abstract Usuario iniciarSesion(String login, String contraseña) throws ExcepcionServiciosEscuela;

    public abstract boolean verificarUsuario(String login, String contraseña) throws ExcepcionServiciosEscuela;

}
