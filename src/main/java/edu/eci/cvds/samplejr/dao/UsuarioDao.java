package edu.eci.cvds.samplejr.dao;

import edu.eci.cvds.samples.entities.Usuario;

public interface UsuarioDao {
    
    public boolean iniciarSesion(String login, String contraseña) throws PersistenceException;
}
