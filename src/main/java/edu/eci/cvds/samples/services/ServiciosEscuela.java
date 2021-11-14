package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosEscuela {
    
  
    public abstract void crearCategoria(String nombre, String descripcion) throws ExcepcionServiciosEscuela;

    
}
