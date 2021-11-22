package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Oferta extends Actividad implements Serializable {

    public Oferta(){   
    }
    
    @Override
    public String toString(){
        return super.toString() + " }";
    }

}
