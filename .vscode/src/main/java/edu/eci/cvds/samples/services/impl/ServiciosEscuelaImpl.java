package edu.eci.cvds.samples.services.impl;

import javax.inject.Inject;
import edu.eci.cvds.samplejr.dao.PersistenceException;
import edu.eci.cvds.samplejr.dao.UsuarioDao;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ExcepcionServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuela;

public class ServiciosEscuelaImpl implements ServiciosEscuela {

    @Inject
    private UsuarioDao usuario;

    @Override
    public Usuario iniciarSesion(String login, String contraseña) throws ExcepcionServiciosEscuela {
 
        return null;
    }

	@Override
	public boolean verificarUsuario(String login, String contraseña) throws ExcepcionServiciosEscuela {
		// TODO Auto-generated method stub
		return false;
	}
        
    
}


