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
    private List<Comentario> comentarios;
    private Date fechaCreacion;
    private String actividad;
    
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

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
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
        return "Respuesta{ id="+getId()+", nombre= "+getNombre()+", comentarios = ["+ getComentarios()+ "], fechaCreacion= "+getFechaCreacion()+",actividad"+getActividad()+"}";
    }
    
    
    
}
