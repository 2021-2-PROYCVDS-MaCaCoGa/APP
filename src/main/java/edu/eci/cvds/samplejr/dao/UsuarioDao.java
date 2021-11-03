package edu.eci.cvds.samplejr.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Perfil;
import edu.eci.cvds.samples.entities.Usuario;

public interface UsuarioDao {
    
    public Usuario iniciarSesion(String login, String contraseña) throws PersistenceException;

    public boolean ExistenciaUsuario(String login, String contra) throws PersistenceException;
    
    public Usuario consultarUsuaro(String log) throws PersistenceException;
    
    public List<Usuario> consultarUsuarios()throws PersistenceException;
    
    public void ingresarUsuario(String nombre, String log, String contraseña, String correo , Perfil perfil)throws PersistenceException;
    
    public int existenciaSusuario(String nombre, String contraseña)throws PersistenceException;
}
