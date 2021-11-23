package edu.eci.cvds.samplejr.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Respuesta;

public interface RespuestaDao {
	public void agregarRespuesta(String nombre, String comentario, String nombreComentario,String actividad, String usuario) throws PersistenceException;
	
	public List<Respuesta> consultarRespuestas() throws PersistenceException;
	
	public List<Respuesta> consultarrespuesta(String respuesta) throws PersistenceException;
	
	
}
