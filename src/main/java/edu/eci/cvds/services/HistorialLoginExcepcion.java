package edu.eci.cvds.services;

public class HistorialLoginExcepcion extends Exception{

    public static final String CLIENTE_INEXISTENTE = "Cliente no existente en la base de datos";

    public HistorialLoginExcepcion(String message){
        super(message);
    }
    
}