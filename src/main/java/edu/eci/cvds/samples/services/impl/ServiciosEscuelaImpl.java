package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.samplejr.dao.CategoriaDao;
import edu.eci.cvds.samplejr.dao.NecesidadDao;
import edu.eci.cvds.samplejr.dao.OfertaDao;
import javax.inject.Inject;
import edu.eci.cvds.samplejr.dao.PersistenceException;
import edu.eci.cvds.samplejr.dao.RespuestaDao;
import edu.eci.cvds.samples.entities.Actividad;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.services.ExcepcionServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuelaFactory;
import edu.eci.cvds.security.login;
import edu.eci.cvds.services.HistorialLoginExcepcion;

import java.sql.SQLException;
import java.util.List;

public class ServiciosEscuelaImpl implements ServiciosEscuela {

    
    CategoriaDao categoriaDao = ServiciosEscuelaFactory.getInstance().getCategoria();
    
    login loginConcection = ServiciosEscuelaFactory.getInstance().getLogin();
    
    @Inject
    NecesidadDao necesidadDao;
    
    @Inject 
    OfertaDao ofertaDao;
    
    @Inject
    RespuestaDao respuestaDao;
    
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
            persistenceException.printStackTrace();
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
     * Función encargada de llamar al metodo eliminar categoria conectado a la base de datos
     * Se elimina de acuerdo al nombre de la categoria que se quiera borrar
     * @param nombre
     * @throws ExcepcionServiciosEscuela 
     */
    @Override
    public void eliminarCategoria(String nombre) throws ExcepcionServiciosEscuela{
        try{
            categoriaDao.borrarCategoria(nombre);
        }
        catch(PersistenceException persistenceException){
            throw new ExcepcionServiciosEscuela("No se pudo eliminar la categoria "+nombre);
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
    public void expresarNecesidad(String categoria, String nombre, String descripcion, int urgencia, String usuario) throws ExcepcionServiciosEscuela {
        try{
            necesidadDao.agregarNecesidad(categoria, nombre, descripcion,usuario, urgencia);
        }
        catch(PersistenceException persistenceException){
            persistenceException.printStackTrace();
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
    public void registrarOferta(String categoria, String nombre, String descripcion, String usuario) throws ExcepcionServiciosEscuela {
        try{
            ofertaDao.agregarOferta(categoria, descripcion, nombre, usuario);
        }
        catch(PersistenceException persistenceException){
            throw new ExcepcionServiciosEscuela("No se pudo registrar la oferta del estudiante");
        }
    }

    /**
     * Se encarga de actualizar el estado de la necesidad. Se pide el nombre de la necesidad para revisar
     * en la base si existe. En caso de encontrarla, se genera el nuevo estado
     * Recordar que solo hay 4 estados disponibles 
     * @param necesidad
     * @param nuevoEstado
     * @throws ExcepcionServiciosEscuela 
     */
    @Override
    public void actualizarEstadoNecesidad(String necesidad, String nuevoEstado) throws ExcepcionServiciosEscuela{
        try{
            necesidadDao.actualizarEstado(necesidad, nuevoEstado);
            System.out.println("TODO CORRECTO ACTUALIZANDO");
        }
        catch(PersistenceException persistenceException){
            persistenceException.printStackTrace();
            throw new ExcepcionServiciosEscuela("No se pudo actualizar la necesidad "+necesidad);
        }
    }

    /**
     * Se encarga de registrar una respuesta que de un usuario registrado en la base de datos de la escuela
     * @param nombre
     * @param comentarios
     * @param nombreComentario
     * @param actividad
     * @param usuario
     * @throws ExcepcionServiciosEscuela 
     */
    @Override
    public void registrarRespuesta(String nombre, String comentario, String nombreComentario, String actividad, String usuario) throws ExcepcionServiciosEscuela {
        try{
            respuestaDao.agregarRespuesta(nombre, comentario, nombreComentario, actividad, usuario);
        }
        catch(PersistenceException persistenceException){
            throw new ExcepcionServiciosEscuela("No se pudo crear la respuesta");
        }
    }

    /**
     * Metodo encargado de actualizar el estado de la oferta. Se pide el nombre de la oferta para revisar si
     * esta se encuentra en la base, en caso que si, se actualiza el estado.
     * Recordar que solo hay 4 estados posibles.
     * @param oferta
     * @param nuevoEstado
     * @throws ExcepcionServiciosEscuela 
     */
    @Override
    public void actualizarEstadoOferta(String oferta, String nuevoEstado) throws ExcepcionServiciosEscuela {
        try{
            ofertaDao.actualizarEstado(oferta, nuevoEstado);
        }
        catch(PersistenceException persistenceException){
            throw new ExcepcionServiciosEscuela("No se pudo actualizar el estado de la oferta "+oferta);
        }
    }

    /**
     * Se encarga de consultar las categorias que se encuentren en la base de datos
     * @return
     * @throws ExcepcionServiciosEscuela 
     */
    @Override
    public List<Categoria> consultarCategorias() throws ExcepcionServiciosEscuela {
        try{
            
            return categoriaDao.consultarcategorias();
        }
        catch(PersistenceException persistenceException){
            throw new ExcepcionServiciosEscuela("No se pudo consultar las categorias");
        }
    }
    
    /**
     * Metodo encargado de dar todas las necesidades. Se revisan actividades de acuerdo  
     * @return
     * @throws ExcepcionServiciosEscuela 
     */
    @Override
    public List<Actividad> consultarNecesidades() throws ExcepcionServiciosEscuela {
        try{
            return necesidadDao.consultarNecesidades();
        }
        catch(PersistenceException persistenceException){
            throw new ExcepcionServiciosEscuela("No se pudo consultar las necesidades");
        }
    }
    
    @Override
    public List<Actividad> consultarOfertas() throws ExcepcionServiciosEscuela {
        try{
            return ofertaDao.consultarOfertas();
        }
        catch(PersistenceException persistenceException){
            throw new ExcepcionServiciosEscuela("No se pudo consultar las ofertas");
        }
    }

	@Override
	public void loggear(String correo, String contra) throws  ExcepcionServiciosEscuela {
		try {
			loginConcection.log(correo, contra);
		}catch(HistorialLoginExcepcion persistenceException){
                    persistenceException.printStackTrace();
			throw new ExcepcionServiciosEscuela("No se pudo loggear");
		}
		
	}

	@Override
	public void cerrarSesion() throws ExcepcionServiciosEscuela {
		try {
			loginConcection.cerrarSesion();
		}catch(HistorialLoginExcepcion persistenceException){
			throw new ExcepcionServiciosEscuela("No se pudo cerrar la sesion");
		}
		
        }

  
    
}


