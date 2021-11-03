package edu.eci.cvds.samplejr.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Necesidad;

public interface NecesidadDao {
	
	public void agregarNecesidad (int categoria, String nombre, String descripcion, int urgencia, boolean estado) throws PersistenceException;
	
	public List<Necesidad> consultarNecesidades(int categoria)throws PersistenceException;
	
	public List<Necesidad> consultarNecesidades()throws PersistenceException;
	
	public Necesidad consultarNecesidad(int id) throws PersistenceException;
	
	public void actualizarEstado(int id, String estado) throws PersistenceException;
	
}
