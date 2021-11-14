package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosEscuela {
    
  
    public abstract void crearCategoria(String nombre, String descripcion) throws ExcepcionServiciosEscuela;   
    
    public abstract void actualizarCategoria(String nuevoNombre, String nuevaDescripcion, String nuevoEstado) throws ExcepcionServiciosEscuela;
    
    public abstract void expresarNecesidad(String categoria, String nombre, String descripcion, int urgencia)throws ExcepcionServiciosEscuela;
}
