package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Necesidad extends Actividad implements Serializable {
    
    private Integer urgencia;
    //private int actividad;

    public Necesidad(int id, String categoria, String nombre, String descripcion, Integer urgencia, String estado, LocalDate fechaCreacion, String usuario){
        super(id, categoria, nombre, descripcion, fechaCreacion,estado,usuario);
        this.urgencia = urgencia;
    }

    public Integer getUrgencia(){return this.urgencia;}
    public void setUrgencia(Integer urgencia){this.urgencia = urgencia;}
    
    @Override
    public String toString(){
        return super.toString() + ", urgencia="+getUrgencia()+" }";
    }

}
