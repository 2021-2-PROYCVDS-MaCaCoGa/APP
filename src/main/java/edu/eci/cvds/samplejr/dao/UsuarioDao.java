package edu.eci.cvds.samplejr.dao;

import edu.eci.cvds.samples.entities.Usuario;

public interface UsuarioDao {
    
    public Usuario iniciarSesion(String login, String contraseña) throws PersistenceException;

    public boolean ExistenciaUsuario(String login, String contra) throws PersistenceException;
}
