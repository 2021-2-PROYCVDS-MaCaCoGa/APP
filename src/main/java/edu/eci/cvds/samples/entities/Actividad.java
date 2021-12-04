
package edu.eci.cvds.samples.entities;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author crisa
 */
public abstract class Actividad {
    
    protected int id;
    protected String categoria;
    protected String nombre;
    protected String descripcion;
    protected LocalDate fechaCreacion;
    protected String estado;
    protected LocalDate fechaModificacion;
    protected String usuario;
    protected String actividad;
    public static Number nSolicitudes = 10;

    public final static String ACTIVA = "Activa";
    public final static String ENPROCESO = "En Proceso";
    public final static String RESUELTA = "Resuelta";
    public final static String CERRADA = "Cerrada";
    
    public Actividad(){
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

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }
    
    public String getUsuario(){
        return this.usuario;
    }

    public Number getnSolicitudes() {
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

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
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
