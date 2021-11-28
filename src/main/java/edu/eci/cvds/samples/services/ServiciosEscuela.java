package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Actividad;
import edu.eci.cvds.samples.entities.Categoria;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.services.HistorialLoginExcepcion;

import java.util.List;
import org.apache.ibatis.session.SqlSessionFactory;

public interface ServiciosEscuela {
    
  
    public abstract void crearCategoria(String nombre, String descripcion) throws ExcepcionServiciosEscuela;   
    
    public abstract void actualizarCategoria(String categoria, String nuevoNombre, String nuevaDescripcion, String nuevoEstado) throws ExcepcionServiciosEscuela;
    
    public abstract void eliminarCategoria(String nombre) throws ExcepcionServiciosEscuela;
    
    public abstract void expresarNecesidad(String categoria, String nombre, String descripcion, int urgencia, String usuario)throws ExcepcionServiciosEscuela;
    
    public abstract void registrarOferta(String categoria, String nombre, String descripcion, String usuario)throws ExcepcionServiciosEscuela;
    
    public abstract void registrarRespuesta(String nombre, String comentario, String nombreComentario, String actividad, String usuario) throws ExcepcionServiciosEscuela;
    
    public abstract void actualizarEstadoNecesidad(String necesidad, String nuevoEstado) throws ExcepcionServiciosEscuela;
    
    public abstract void actualizarEstadoOferta(String oferta, String nuevoEstado) throws ExcepcionServiciosEscuela;
    
    public abstract List<Categoria> consultarCategorias() throws ExcepcionServiciosEscuela;
    
    public abstract List<Actividad> consultarNecesidades() throws ExcepcionServiciosEscuela;
    
    public abstract void loggear(String correo, String contra) throws  ExcepcionServiciosEscuela;
    
    public abstract void cerrarSesion() throws  ExcepcionServiciosEscuela;
          
}
