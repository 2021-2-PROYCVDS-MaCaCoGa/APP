package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.samplejr.dao.CategoriaDao;
import edu.eci.cvds.samplejr.dao.NecesidadDao;
import edu.eci.cvds.samplejr.dao.OfertaDao;
import javax.inject.Inject;
import edu.eci.cvds.samplejr.dao.PersistenceException;
import edu.eci.cvds.samples.services.ExcepcionServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuela;

public class ServiciosEscuelaImpl implements ServiciosEscuela {

    @Inject
    CategoriaDao categoriaDao;
    
    @Inject
    NecesidadDao necesidadDao;
    
    @Inject 
    OfertaDao ofertaDao;
    
    /**
     * Se encarga de crear la categoria y meterla a la base de datos
     * @param nombre
     * @param descripcion
     * @throws ExcepcionServiciosEscuela 
     */
    @Override
    public void crearCategoria(String nombre, String descripcion) throws ExcepcionServiciosEscuela {
        try{
            categoriaDao.agregarCategoria(nombre, descripcion);
        }
        catch(PersistenceException persistenceException){
            throw new ExcepcionServiciosEscuela("No se pudo crear la categoria");
        }
    }  

    /**
     * Se encarga de actualizar la categoria que requiera el administrador
     * Solo se puede modificar el nombre, descripcion y estado
     * @param nuevoNombre
     * @param nuevaDescripcion
     * @param nuevoEstado
     * @throws ExcepcionServiciosEscuela 
     */
    @Override
    public void actualizarCategoria(String categoria, String nuevoNombre, String nuevaDescripcion, String nuevoEstado) throws ExcepcionServiciosEscuela{
        try{
            categoriaDao.modificarCategoria(categoria, nuevoNombre, nuevaDescripcion, nuevoEstado);
        }
        catch(PersistenceException persistenceException){
            throw new ExcepcionServiciosEscuela("No se pudo actualizar la categoria");
        }
    }

    /**
     * Se encarga de crear la necesidad solicitada por el estudiante.
     * Los niveles de urgencia van desde 1 hasta 5, siendo este de extrema importancia
     * @param categoria
     * @param nombre
     * @param descripcion
     * @param urgencia
     * @throws ExcepcionServiciosEscuela 
     */
    @Override
    public void expresarNecesidad(String categoria, String nombre, String descripcion, int urgencia) throws ExcepcionServiciosEscuela {
        try{
            necesidadDao.agregarNecesidad(categoria, nombre, descripcion, urgencia);
        }
        catch(PersistenceException persistenceException){
            throw new ExcepcionServiciosEscuela("No se pudo crear la necesidad");
        }
    }

    /**
     * Se encarga de crear la oferta del estudiante
     * @param categoria
     * @param nombre
     * @param descripcion
     * @throws ExcepcionServiciosEscuela 
     */
    @Override
    public void registrarOferta(String categoria, String nombre, String descripcion) throws ExcepcionServiciosEscuela {
        try{
            ofertaDao.agregarOferta(categoria, descripcion, nombre);
        }
        catch(PersistenceException persistenceException){
            throw new ExcepcionServiciosEscuela("No se pudo registrar la oferta del estudiante");
        }
    }

    
}


