package edu.eci.cvds.samplejr.dao;
import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Categoria;

public interface CategoriaDao {
    
    public void agregarCategoria(int id, String nombre, String descripcion, boolean estado) throws PersistenceException;
    public void agregarCategoria(Categoria cat) throws PersistenceException;

    public void borrarCategoria(int id) throws PersistenceException;

    public void modificarCategoria(int id, String nombre, boolean estado)throws PersistenceException;
    public Categoria consultarcategoria(int id)throws PersistenceException;
    public Categoria consultarcategoria(String nombre)throws PersistenceException;
    public List<Categoria> consultarcategorias()throws PersistenceException;

}


