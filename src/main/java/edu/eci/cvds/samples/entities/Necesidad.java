package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class Necesidad implements Serializable {
    private int id;
    private int categoria;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private int urgencia;
    private boolean estado;
    private Date fechaModificacion;

    public Necesidad(int id, int categoria, String nombre, String descripcion, int urgencia, boolean estado){
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urgencia = urgencia;
        this.estado = estado;
    }

    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    public int getCategoria(){return this.categoria;}
    public void setCategoria(int categoria){this.categoria = categoria;}

    public String getNombre(){return this.nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public String getDescripcion(){return this.descripcion;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}

    public Date getFechaCreacion(){return this.fechaCreacion;}
    public void setFechaCreacion(Date fechaCreacion){this.fechaCreacion = fechaCreacion;}

    public int getUrgencia(){return this.urgencia;}
    public void setUrgencia(int urgencia){this.urgencia = urgencia;}

    public boolean getEstado(){return this.estado;}
    public void getEstado(boolean estado){this.estado = estado;}

    public Date getFechaModificacion(){return this.fechaModificacion;}
    public void setFechaModificacion(Date fechaModificacion){this.fechaModificacion = fechaModificacion;}
}
