package edu.eci.cvds.samplejr.dao;
import java.sql.Date;

public interface CategoriaDao {
    
    public void crearCategoria(int id, String nombre, String descripcion, Date fechaCreacion) throws PersistenceException;

    public void borrarCategoria(int id);

    public void insertarfechaModificacion(int id, Date fechaModificacion);

}


