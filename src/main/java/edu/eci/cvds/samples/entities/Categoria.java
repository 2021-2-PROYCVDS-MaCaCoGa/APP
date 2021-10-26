package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.sql.Date;

public class Categoria implements Serializable {
    private int id;
    private String nombre;
    private String descripcion;
    private Date fechaCreacion;
    private boolean estado;
    private Date fechaModificacion;

    public Categoria(){
        
    }
}
