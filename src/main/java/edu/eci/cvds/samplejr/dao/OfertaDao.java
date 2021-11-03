package edu.eci.cvds.samplejr.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Oferta;

public interface OfertaDao {
	
	public void agregarOferta(int id, String categoria, String descripcion, String nombre) throws PersistenceException;
	
	public void actualizarEstado(int id, String estado) throws PersistenceException;
	
	public Oferta consultaroferta(int id) throws PersistenceException;
	
	public List<Oferta> consultarOfertas( int categoria) throws PersistenceException;
	
    public List<Oferta> consultarOfertas() throws PersistenceException;
}
