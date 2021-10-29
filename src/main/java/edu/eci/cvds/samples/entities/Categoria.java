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

    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    public String getNombre(){return this.nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public String getDescripcion(){return this.descripcion;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}

    public Date getFechaCreacion(){return this.fechaCreacion;}
    public void setFechaCreacion(Date fecahCreacion){this.fechaCreacion = fechaCreacion;}

    public boolean getEstado(){return this.estado;}
    public void setEstado(){this.estado = estado;}

    public Date getFechaModificacion(){return this.fechaModificacion;}
    public void setFechaModificacion(Date fechaModificacion){this.fechaModificacion = fechaModificacion;}
    


    
}
