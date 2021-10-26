package edu.eci.cvds.samplejr.dao;

public class PersistenceException extends Exception{
    
    public PersistenceException(String mensaje, Exception e){
        super(mensaje,e);
    }

    public PersistenceException(String mensaje){
        super(mensaje);
    }
}
