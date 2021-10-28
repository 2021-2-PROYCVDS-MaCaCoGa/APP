package edu.eci.cvds.samplejr.dao;
import java.sql.Date;

public interface CategoriaDao {
    
    public void agregarCategoria(int id, String nombre, String descripcion) throws PersistenceException;

    public void borrarCategoria(int id);

    public void modificarCategoria(int id, String nombre, boolean estado);

}


