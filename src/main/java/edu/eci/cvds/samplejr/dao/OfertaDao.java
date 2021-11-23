package edu.eci.cvds.samplejr.dao;

import java.util.List;

import edu.eci.cvds.samples.entities.Oferta;

public interface OfertaDao {
    /**
     * Inserta en la base de datos una nueva oferta
     * @param categoria Categoria a la que pertenece la oferta
     * @param descripcion Descripcion de la oferta 
     * @param nombre Nombre de la oferta 
     * @param usuario Usuario que radica la oferta
     * @throws PersistenceException 
     */
    public void agregarOferta(String categoria, String descripcion, String nombre, String usuario) throws PersistenceException;

    /** 
     * Actualiza el estado de la oferta
     * @param oferta Nombre de la oferta a actualizar
     * @param estado Estado de la oferta a actualizar
     * @throws PersistenceException 
     */
    public void actualizarEstado(String oferta, String estado) throws PersistenceException;

    /**
     * Retorna una oferta dado el nombre
     * @param oferta Nombre de la oferta 
     * @return
     * @throws PersistenceException 
     */
    public Oferta consultaroferta(String oferta) throws PersistenceException;

    /**
     * Retorna las ofertas de la base de datos segun la categoria
     * @param categoria Nombre de la categoria 
     * @return
     * @throws PersistenceException 
     */
    public List<Oferta> consultarOfertas(String categoria) throws PersistenceException;

    /**
     * Retorna las ofertas de la base de datos
     * @return
     * @throws PersistenceException 
     */
    public List<Oferta> consultarOfertas() throws PersistenceException;
    
    /**
     * Elimina la oferta dado el nombre
     * @param oferta Nombre de la oferta a eliminar
     * @throws PersistenceException 
     */
    public void eliminarOferta(String oferta) throws PersistenceException; 
    
        
}

