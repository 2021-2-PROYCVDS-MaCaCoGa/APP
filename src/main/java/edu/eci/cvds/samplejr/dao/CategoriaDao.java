package edu.eci.cvds.samplejr.dao;
import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Categoria;

public interface CategoriaDao {
       
    /**
     * Se agrega una categoria de acuerdo al nombre y la descripcion dada por el usuario
     * @param nombre Nombre a dar a la categoria
     * @param descripcion Descripcion de la categoria
     * @throws PersistenceException 
     */
    public void agregarCategoria(String nombre, String descripcion) throws PersistenceException;
    
    /**
     * Modifica la categoria dada
     * @param categoria Nombre de la categoria a modificar
     * @param nombre Nombre nuevbo de la categoria
     * @param descripcion Descripcion nueva de la categoria
     * @param estado Estado nuevo de la categoria
     * @throws PersistenceException 
     */
    public void modificarCategoria(String categoria, String nombre, String descripcion, String estado)throws PersistenceException;
    
    /**
     * Borra la categoria dada por el nombre
     * @param categoria Nombre de la categoria a borrar
     * @throws PersistenceException 
     */
    public void borrarCategoria(String categoria) throws PersistenceException;
    
    /**
     * Consulta la categoria dada por su id
     * @param id Identificador de la categoria
     * @return
     * @throws PersistenceException 
     */
    public Categoria consultarcategoria(int id)throws PersistenceException;
    /**
     * COnsulta la categoria dado por su nombre
     * @param nombre Nombre de la categoria a consultar
     * @return
     * @throws PersistenceException 
     */
    public Categoria consultarcategoria(String nombre)throws PersistenceException;
    
    /**
     * Consulta todas las categorias que hayan en la base de datos
     * @return
     * @throws PersistenceException 
     */
    public List<Categoria> consultarcategorias()throws PersistenceException;

}


