package edu.eci.cvds.samplejr.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Respuesta;

public interface RespuestaDao {
    
        /**
         * Insertar en la base de datos una respuesta a una actividad
         * @param nombre Nombre de la respuesta
         * @param comentario Comentario de la respuesta
         * @param nombreComentario Nombre del comentario de la respuesta
         * @param actividad Actividad a la que se responde
         * @param usuario Usuario que realiza la respuesta
         * @throws PersistenceException 
         */
	public void agregarRespuesta(String nombre, String comentario, String nombreComentario,String actividad, String usuario) throws PersistenceException;
	
        /**
         * Inserta en la base de datos un nuevo comentario a una respuesta
         * @param comentario Comentario de la respuesta
         * @param usuario Usuario que realiza el comentario
         * @param respuesta Respuesta a la que se comenta
         * @param nombre  Nombre del comentario
         */
        public void agregarComentario(String comentario, String usuario, String respuesta, String nombre) throws PersistenceException;
        
        /**
         * Retorna las respuestas de la base de datos
         * @return
         * @throws PersistenceException 
         */
	public List<Respuesta> consultarRespuestas() throws PersistenceException;
	
        /**
         * Retorna la respuesta segun su nombre
         * @param respuesta Nombre de la respuesta
         * @return
         * @throws PersistenceException 
         */
	public List<Respuesta> consultarrespuesta(String respuesta) throws PersistenceException;
        
        /**
         * Elimina de la base de datos un comentario dado su nombre
         * @param comentario Nombre del comentario
         * @throws PersistenceException 
         */
        public void eliminarComentario(String comentario) throws PersistenceException;
        
        /**
         * Elimina de la base de datos una respuesta dada su nombre
         * @param respuesta
         * @throws PersistenceException 
         */
        public void eliminarRespuesta(String respuesta) throws PersistenceException;
	
	
}
