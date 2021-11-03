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
    private List<String> comentarios;
    private Date fechaCreacion;
    private Actividad actividad;
    
    public Respuesta(int id, String nombre, List<String> comentarios, Date fechaCreacion, Actividad actividad){
        this.id = id;
        this.nombre = nombre;
        this.comentarios = comentarios;
        this.fechaCreacion = new Date(Calendar.getInstance().getTime().getTime());
        this.actividad = actividad;
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

    public List<String> getComentarios() {
        return comentarios;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
    
    
}
