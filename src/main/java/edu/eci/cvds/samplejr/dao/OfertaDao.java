package edu.eci.cvds.samplejr.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Oferta;

public interface OfertaDao {
	
	public void agregarOferta(String categoria, String descripcion, String nombre, String usuario) throws PersistenceException;
	
	public void actualizarEstado(String oferta, String estado) throws PersistenceException;
	
	public Oferta consultaroferta(String oferta) throws PersistenceException;
	
	public List<Oferta> consultarOfertas(String categoria) throws PersistenceException;
	
    public List<Oferta> consultarOfertas() throws PersistenceException;
}
