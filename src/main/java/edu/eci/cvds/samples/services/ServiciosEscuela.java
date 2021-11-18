package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Usuario;
import java.util.List;

public interface ServiciosEscuela {
    
  
    public abstract void crearCategoria(String nombre, String descripcion) throws ExcepcionServiciosEscuela;   
    
    public abstract void actualizarCategoria(String categoria, String nuevoNombre, String nuevaDescripcion, String nuevoEstado) throws ExcepcionServiciosEscuela;
    
    public abstract void expresarNecesidad(String categoria, String nombre, String descripcion, int urgencia, String usuario)throws ExcepcionServiciosEscuela;
    
<<<<<<< HEAD
    public abstract void registrarOferta(String categoria, String nombre, String descripcion)throws ExcepcionServiciosEscuela;
    
    public abstract void registrarRespuesta(String nombre, List<String> comentarios, String oferta_respondida) throws ExcepcionServiciosEscuela;
=======
    public abstract void registrarOferta(String categoria, String nombre, String descripcion, String usuario)throws ExcepcionServiciosEscuela;
>>>>>>> 9774820b9bec3426f10f63357fed496ccbac9e73
}
