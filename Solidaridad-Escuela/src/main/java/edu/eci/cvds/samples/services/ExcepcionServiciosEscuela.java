package edu.eci.cvds.samples.services;

public class ExcepcionServiciosEscuela extends Exception {
    
    public ExcepcionServiciosEscuela(String mensaje, Exception e){
        super(mensaje,e);
    }

    public ExcepcionServiciosEscuela(String mensaje){
        super(mensaje);
    }
}
