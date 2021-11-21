package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Oferta extends Actividad implements Serializable {


    public Oferta(int id, String categoria, String nombre, String descripcion,String estado, LocalDate fechaCreacion, String usuario){
        super(id, categoria, nombre, descripcion, fechaCreacion, estado, usuario);
        
    }
    
    @Override
    public String toString(){
        return super.toString() + " }";
    }

}
