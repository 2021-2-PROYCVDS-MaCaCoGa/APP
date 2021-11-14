package edu.eci.cvds.samplejr.dao;
import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Categoria;

public interface CategoriaDao {
       
    public void agregarCategoria(String nombre, String descripcion) throws PersistenceException;

    public void modificarCategoria(String nombre, String descripcion, String estado)throws PersistenceException;
    
    public void borrarCategoria(int id) throws PersistenceException;
    public Categoria consultarcategoria(int id)throws PersistenceException;
    public Categoria consultarcategoria(String nombre)throws PersistenceException;
    public List<Categoria> consultarcategorias()throws PersistenceException;

}


