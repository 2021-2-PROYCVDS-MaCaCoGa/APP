    package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Necesidad extends Actividad implements Serializable {
    
    private Integer urgencia;
    //private String actividad;

    public Necesidad(){
    }

    public Integer getUrgencia(){return this.urgencia;}
    public void setUrgencia(Integer urgencia){this.urgencia = urgencia;}
    
    @Override
    public String toString(){
        return super.toString() + ", urgencia="+getUrgencia()+" }";
    }

}
