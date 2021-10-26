package edu.eci.cvds.samples.services.impl;

import javax.inject.Inject;

import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ExcepcionServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuela;

public class ServiciosEscuelaImpl implements ServiciosEscuela {
    @Inject
    private LoginDao login;

    @Override
    public boolean iniciarSesion(String login, String contraseña) throws ExcepcionServiciosEscuela {
        try{
            Usuario user = login.consultarUsuario(login);

        }
    }
    
}
