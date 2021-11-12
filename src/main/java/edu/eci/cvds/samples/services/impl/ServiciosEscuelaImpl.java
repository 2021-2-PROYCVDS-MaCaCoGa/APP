package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.samplejr.dao.CategoriaDao;
import javax.inject.Inject;
import edu.eci.cvds.samplejr.dao.PersistenceException;
import edu.eci.cvds.samplejr.dao.UsuarioDao;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ExcepcionServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuela;

public class ServiciosEscuelaImpl implements ServiciosEscuela {

    @Inject
    CategoriaDao categoriaDao;
    
    /**
     * Se encarga de crear la categoria y meterla a la base de datos
     * @param nombre
     * @param descripcion
     * @throws ExcepcionServiciosEscuela 
     */
    @Override
    public void crearCategoria2(String nombre, String descripcion) throws ExcepcionServiciosEscuela {
        try{
            categoriaDao.agregarCategoria(nombre, descripcion);
        }
        catch(PersistenceException persistenceException){
            throw new ExcepcionServiciosEscuela("No se pudo crear la categoria");
        }
    }

    /**
     * Esta es una prueba para revisar triggers y de que todo se esté metiendo en la base
     * @param id
     * @param nombre
     * @param descripcion
     * @param estado
     * @throws ExcepcionServiciosEscuela 
     */
    @Override
    public void crearCategoria1(int id, String nombre, String descripcion, boolean estado) throws ExcepcionServiciosEscuela {
        try{
            categoriaDao.agregarCategoria(id, nombre, descripcion, estado);
        }
        catch(PersistenceException persistenceException){
            throw new ExcepcionServiciosEscuela("PRUEBA DE CREACION DE CATEGORIA NO PASADA");
        }
    }
        
    
}


