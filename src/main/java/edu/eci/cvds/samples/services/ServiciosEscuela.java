package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosEscuela {
    
    public abstract boolean iniciarSesion(String login, String contraseña) throws ExcepcionServiciosEscuela;

}
