package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosEscuela {
    
    public abstract void crearCategoria1(int id, String nombre, String descripcion, boolean estado) throws ExcepcionServiciosEscuela;
  
    public abstract void crearCategoria2(String nombre, String descripcion) throws ExcepcionServiciosEscuela;

    
}
