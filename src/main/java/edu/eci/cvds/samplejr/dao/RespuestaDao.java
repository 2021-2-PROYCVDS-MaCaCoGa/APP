package edu.eci.cvds.samplejr.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Respuesta;

public interface RespuestaDao {
	public void agregarRespuesta(int id, String nombre, List<String> comentarios) throws PersistenceException;
	
	public List<Respuesta> consultarRespuestas() throws PersistenceException;
	
	public Respuesta consultarrespuesta(int id) throws PersistenceException;
	
	
}
