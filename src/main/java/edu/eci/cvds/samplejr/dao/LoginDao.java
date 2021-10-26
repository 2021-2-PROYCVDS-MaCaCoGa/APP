package edu.eci.cvds.samplejr.dao;

import edu.eci.cvds.samples.entities.Usuario;

public interface LoginDao {
    public Usuario consultarUsuario() throws PersistenceException;
}
