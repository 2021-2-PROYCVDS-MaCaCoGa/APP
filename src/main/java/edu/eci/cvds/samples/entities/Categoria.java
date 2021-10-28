package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;


public class Categoria implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private boolean estado;
    private Date fechaModificacion;

    public Categoria(){
        this.estado = true;
    }
    public Categoria(int id, String nombre, String descripcion, Date fechaCreacion){
        this();
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = new Date(Calendar.getInstance().getTime().getTime());
    }

    
}
