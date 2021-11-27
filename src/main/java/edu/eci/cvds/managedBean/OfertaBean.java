/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.cvds.managedBean;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuelaFactory;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@SuppressWarnings("deprecation")
@ManagedBean(name = "ofertaListener")
@SessionScoped
public class OfertaBean {
    ServiciosEscuela serviciosEscuela = ServiciosEscuelaFactory.getInstance().getServiciosEscuela();

    
    private String categoriaOferta;
    private String nombreOferta;
    private String descripcionOferta;
    private String usuarioOferta; 
    /**
     * Se encarga de crear la oferta del estudiante en la base de datos
     * Solo se pide estos parametros, pues los demás se crean de manera automatica 
     * mediante disparadores SQL.
     */
    public void registrarOferta(){
        try{
            serviciosEscuela.registrarOferta(categoriaOferta, nombreOferta, descripcionOferta, usuarioOferta);
         
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }  

    public String getCategoriaOferta() {
        return categoriaOferta;
    }

    public void setCategoriaOferta(String categoriaOferta) {
        this.categoriaOferta = categoriaOferta;
    }

    public String getNombreOferta() {
        return nombreOferta;
    }

    public void setNombreOferta(String nombreOferta) {
        this.nombreOferta = nombreOferta;
    }

    public String getDescripcionOferta() {
        return descripcionOferta;
    }

    public void setDescripcionOferta(String descripcionOferta) {
        this.descripcionOferta = descripcionOferta;
    }

    public String getUsuarioOferta() {
        return usuarioOferta;
    }

    public void setUsuarioOferta(String usuarioOferta) {
        this.usuarioOferta = usuarioOferta;
    }
    
}
