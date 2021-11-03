package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class Oferta implements Serializable {
    private int id;
    private Categoria categoria;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private boolean estado;
    private Date fechaModificacion;
    public static  int nSolicitudes;

    public Oferta(int id, Categoria categoria, String nombre, String descripcion, int urgencia, boolean estado){
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId(){return this.id;}
    public void setId(int id){this.id = id;}

    public Categoria getCategoria(){return this.categoria;}
    public void setCategoria(Categoria categoria){this.categoria = categoria;}

    public String getNombre(){return this.nombre;}
    public void setNombre(String nombre){this.nombre = nombre;}

    public String getDescripcion(){return this.descripcion;}
    public void setDescripcion(String descripcion){this.descripcion = descripcion;}

    public Date getFechaCreacion(){return this.fechaCreacion;}
    public void setFechaCreacion(Date fechaCreacion){this.fechaCreacion = fechaCreacion;}

    public boolean getEstado(){return this.estado;}
    public void getEstado(boolean estado){this.estado = estado;}

    public Date getFechaModificacion(){return this.fechaModificacion;}
    public void setFechaModificacion(Date fechaModificacion){this.fechaModificacion = fechaModificacion;}

    public void setnSolicitudes(int n){Oferta.nSolicitudes = n;}

}
