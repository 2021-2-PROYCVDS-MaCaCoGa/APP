/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.cvds.samples.entities;

import java.sql.Date;

/**
 *
 * @author crisa
 */
public abstract class Actividad {
    
    protected int id;
    protected Categoria categoria;
    protected String nombre;
    protected String descripcion;
    protected Date fechaCreacion;
    protected String estado;
    protected Date fechaModificacion;
    protected Usuario usuario;
    public static  int nSolicitudes;
    public final static String ACTIVA = "Activa";
    public final static String ENPROCESO = "En Proceso";
    public final static String RESUELTA = "Resuelta";
    public final static String CERRADA = "Cerrada";
    
    public Actividad(int id, Categoria categoria, String nombre, String descripcion,String estado ){
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }
        

    public int getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public static int getnSolicitudes() {
        return nSolicitudes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public static void setnSolicitudes(int nSolicitudes) {
        Actividad.nSolicitudes = nSolicitudes;
    }
    
    
}
