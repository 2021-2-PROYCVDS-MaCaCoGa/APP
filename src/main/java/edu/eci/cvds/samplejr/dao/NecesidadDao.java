package edu.eci.cvds.samplejr.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Necesidad;

public interface NecesidadDao {
	
	public void agregarNecesidad (String categoria, String nombre, String descripcion,String usuario, int urgencia) throws PersistenceException;
	
	public List<Necesidad> consultarNecesidades(int categoria)throws PersistenceException;
	
	public List<Necesidad> consultarNecesidades()throws PersistenceException;
	
	public Necesidad consultarNecesidad(String necesidad) throws PersistenceException;
	
	public void actualizarEstado(String necesidad, String estado) throws PersistenceException;
	
}
