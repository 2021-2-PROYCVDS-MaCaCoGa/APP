package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class Necesidad extends Actividad implements Serializable {
    
    private Integer urgencia;
    //private int actividad;

    public Necesidad(int id, String categoria, String nombre, String descripcion, Integer urgencia, String estado){
        super(id, categoria, nombre, descripcion, estado);
        this.urgencia = urgencia;
    }

    public Integer getUrgencia(){return this.urgencia;}
    public void setUrgencia(Integer urgencia){this.urgencia = urgencia;}
    
    @Override
    public String toString(){
        return super.toString() + ", urgencia="+getUrgencia()+" }";
    }

}
