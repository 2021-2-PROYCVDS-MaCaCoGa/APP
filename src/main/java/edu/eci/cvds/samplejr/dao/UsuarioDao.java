package edu.eci.cvds.samplejr.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Perfil;
import edu.eci.cvds.samples.entities.Usuario;

public interface UsuarioDao {
    /**
     * Busca el nombre de usuario, y si la contraseña coincide con la registrada, devuelve el usuario
     * @param login Nombre de usuario de el usuario
     * @param contraseña Contraseña del usuario
     * @return Usuario ha buscar
     * @throws PersistenceException 
     */
    public Usuario iniciarSesion(String login, String contraseña) throws PersistenceException;

    public boolean ExistenciaUsuario(String login, String contra) throws PersistenceException;
    
    /**
     * Retorna el usuario dado el nombre de usuario
     * @param log Nombre de usuario de la persona
     * @return Usuario consultado
     * @throws PersistenceException 
     */
    public Usuario consultarUsuaro(String log) throws PersistenceException;
    
    /**
     * Retorna los usuarios en el registro
     * @return Usuarios en el registro
     * @throws PersistenceException 
     */
    public List<Usuario> consultarUsuarios()throws PersistenceException;
    
    /**
     * Ingresa a la base de datos el usuario dado
     * @param nombre Nombre del usuario a ingresar
     * @param log Nombre de usuario de la persona a ingresar
     * @param contraseña Contraseña del usuario
     * @param correo Correo del usuario
     * @param perfil Perfil del usuario, este puede ser 'ESTUDIANTE','ADMINISTRATIVO','PROFESOR','EGRESADO','ADMINISTRADOR'
     * @throws PersistenceException 
     */
    public void ingresarUsuario(String nombre, String log, String contraseña, String correo , String perfil)throws PersistenceException;
    
    public int existenciaUsuario(String nombre, String contraseña)throws PersistenceException;
    
    /** 
     * Elimina el usuario, siempre y cuando se de la contraseña correcta del usuario
     * @param login Nombre de usuario del usuario a eliminar
     * @param password Contraseña del usuario
     * @throws PersistenceException 
     */
    public void deleteUsuario(String login, String password) throws PersistenceException;
    
    /**
     * Consulta el número de solicitudes de un usuario
     * @param usuario Usuario al que se busca saber el numero de necesidades registradas
     * @return
     * @throws PersistenceException 
     */
    public int consultarNumeroSolicitadas(String usuario) throws PersistenceException;
    
    
    /**
     * Consulta el numero de ofertas de un usuario
     * @param usuario Usuario al que se busca saber el numero de ofertas registradas
     * @return
     * @throws PersistenceException 
     */
    public int consultarNumeroOfrecidas(String usuario) throws PersistenceException;
}
