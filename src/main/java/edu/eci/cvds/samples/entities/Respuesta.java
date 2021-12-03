package edu.eci.cvds.samples.entities;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author 2167892
 */
public class Respuesta {
    
    private int id;
    private String nombre;
    private Comentario comentario;
    private Date fechaCreacion;
    private String actividad;
    private String tActividad;
    
    public Respuesta(){

    }
        
    public int getId() {
        return this.id;
    
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public String gettActividad() {
        return tActividad;
    }

    public void settActividad(String tActividad) {
        this.tActividad = tActividad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    
    
    
    @Override
    public String toString(){
        return "Respuesta{ id="+getId()+", nombre= "+getNombre()+", comentarios = ["+ getComentario()+ "], fechaCreacion= "+getFechaCreacion()+",actividad"+getActividad()+", tipoActividad= "+gettActividad()+"}";
    }
    
    
        
    
    
}
