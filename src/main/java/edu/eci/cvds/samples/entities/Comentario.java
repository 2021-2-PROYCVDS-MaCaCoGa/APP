/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.cvds.samples.entities;

/**
 *
 * @author crisa
 */
public class Comentario {
    
    private int id;
    private String comentario;
    private String usuario;
    
    public Comentario(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    
    @Override
    public String toString(){
        return "Comentario{id="+getId()+", comentario= "+getComentario()+", usuario= "+getUsuario()+"}";
    }
}
