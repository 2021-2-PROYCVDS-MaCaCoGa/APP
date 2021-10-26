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

    /**
     * Se encarga de revisar si el usuario está en la base de datos, en caso que no, retorna false
     * Lo mismo pasa con la contraseña. SI no es la correcta, retorna false
     */
    @Override
    public boolean verificarUsuario(String login, String contraseña) throws ExcepcionServiciosEscuela {
        try{
            return usuario.ExistenciaUsuario(login, contraseña);
         } catch(PersistenceException persistenceException){
         throw new ExcepcionServiciosEscuela("Usuario inexistente o contraseña incorrecta");
     }
    }    
    
}


