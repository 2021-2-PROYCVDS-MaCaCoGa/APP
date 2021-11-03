package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class Necesidad extends Actividad implements Serializable {
    
    private int urgencia;    

    public Necesidad(int id, Categoria categoria, String nombre, String descripcion, int urgencia, String estado){
        super(id, categoria, nombre, descripcion, estado);
        this.urgencia = urgencia;
    }

    public int getUrgencia(){return this.urgencia;}
    public void setUrgencia(int urgencia){this.urgencia = urgencia;}


}
