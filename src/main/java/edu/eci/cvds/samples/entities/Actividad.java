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
public class Actividad {
    
    protected int id;
    protected String categoria;
    protected String nombre;
    protected String descripcion;
    protected Date fechaCreacion;
    protected String estado;
    protected Date fechaModificacion;
    protected String usuario;
    public static  int nSolicitudes;
    public final static String ACTIVA = "Activa";
    public final static String ENPROCESO = "En Proceso";
    public final static String RESUELTA = "Resuelta";
    public final static String CERRADA = "Cerrada";
    
    public Actividad(int id, String categoria, String nombre, String descripcion,String estado ){
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }
        

    public int getId() {
        return id;
    }

    public String getCategoria() {
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
    
    public String getUsuario(){
        return this.usuario;
    }

    public static int getnSolicitudes() {
        return nSolicitudes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoria(String categoria) {
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

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public static void setnSolicitudes(int nSolicitudes) {
        Actividad.nSolicitudes = nSolicitudes;
    }
    
    
    
    @Override
    public String toString(){
        return "Necesidad{ id="+getId()+", nombre="+getNombre()+", categoria= "+getCategoria()+", descripcion= "+getDescripcion()+", fechacreacion="+getFechaCreacion()+", estado="+getEstado()+", fechaModificacion="+getFechaModificacion()+", usuario="+getUsuario();
    }
    
    
}
