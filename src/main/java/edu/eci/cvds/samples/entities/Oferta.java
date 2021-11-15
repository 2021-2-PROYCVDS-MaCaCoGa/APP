package edu.eci.cvds.samples.entities;

import java.io.Serializable;

public class Oferta extends Actividad implements Serializable {


    public Oferta(int id, String categoria, String nombre, String descripcion, int urgencia, String estado){
        super(id, categoria, nombre, descripcion, estado);
        
    }
    
    @Override
    public String toString(){
        return super.toString() + " }";
    }

}
