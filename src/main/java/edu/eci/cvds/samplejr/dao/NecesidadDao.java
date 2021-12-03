package edu.eci.cvds.samplejr.dao;

import edu.eci.cvds.samples.entities.Actividad;
import java.util.List;

import edu.eci.cvds.samples.entities.Necesidad;

public interface NecesidadDao {
	
        /**
         * Ingresa a la base de datos la necesidad registrada por el usuario
         * @param categoria Categoria a la que pertenece la necesidad
         * @param nombre Nombre de la necesidad expuesta por el usuario
         * @param descripcion Descripcion de la necesidad del usuario
         * @param usuario Usuario que expone su necesidad
         * @param urgencia Urgencia de la necesidad
         * @throws PersistenceException 
         */
	public void agregarNecesidad (String categoria, String nombre, String descripcion,String usuario, int urgencia) throws PersistenceException;
	
        /**
         * Retorna las necesidades de la base de datos, segun la categoria
         * @param categoria Nombre de la categoria
         * @return
         * @throws PersistenceException 
         */
	public List<Necesidad> consultarNecesidades(int categoria)throws PersistenceException;
	
        /**
         * Retorna las necesidades de la base de datos
         * @return
         * @throws PersistenceException 
         */
	public List<Actividad> consultarNecesidades()throws PersistenceException;
	
        /**
         * Retorna una necesidad dada su nombre
         * @param necesidad Nombre de la necesidad a consultar
         * @return
         * @throws PersistenceException 
         */
	public Necesidad consultarNecesidad(String necesidad) throws PersistenceException;
	
        /**
         * Actualiza el estado de la necesidad dado su nombre
         * @param necesidad Nombre de la necesidad a actualizar
         * @param estado Estado nuevo de la necesidad
         * @throws PersistenceException 
         */
	public void actualizarEstado(String necesidad, String estado) throws PersistenceException;

        /**
         * Elimina la necesidad dada su nombre
         * @param necesidad Nombre de eliminar la necesidad a eliminar
         * @throws PersistenceException 
         */
        public void eliminarNecesidad(String necesidad) throws PersistenceException;
        
        /**
         * Revisa la cantidad de necesidades que ha publicado un usuario
         * @param nombreUsuario
         * @return
         * @throws PersistenceException 
         */
        public Number consultarCantidadNecesidades(String nombreUsuario) throws PersistenceException;
	
}
