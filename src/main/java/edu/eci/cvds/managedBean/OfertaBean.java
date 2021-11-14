/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.cvds.managedBean;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@SuppressWarnings("deprecation")
@ManagedBean(name = "ofertaListener")
@SessionScoped
public class OfertaBean {
    @Inject
    ServiciosEscuela serviciosEscuela;
    
    private String categoriaOferta;
    private String nombreOferta;
    private String descripcionOferta;
    private String mensaje;
    private FacesMessage.Severity estadoSolicitud;
    
    /**
     * Se encarga de crear la oferta del estudiante en la base de datos
     * Solo se pide estos parametros, pues los demás se crean de manera automatica 
     * mediante disparadores SQL.
     */
    public void registrarOferta(){
        try{
            serviciosEscuela.registrarOferta(categoriaOferta, nombreOferta, descripcionOferta);
            mensajeSinErrores();
        }
        catch(Exception exception){
            mensajeConErrores(exception.getMessage());
        }
    }
    
    /**
     * Se encarga de decirle al usuario que su solicitud de categoria
     * ha pasado sin problemas.
     */
    public void mensajeSinErrores(){
        this.mensaje = "Se pudo crear la oferta";
        this.estadoSolicitud = FacesMessage.SEVERITY_INFO;
    }
    
    /**
     * Se encarga de decirle al usuario que hubo un problema
     * con la solicitud requerida en la categoria
     * @param mensajeError --> Mensaje enviado por la excepcion
     */
    public void mensajeConErrores(String mensajeError){
        this.mensaje = mensajeError;
        this.estadoSolicitud = FacesMessage.SEVERITY_WARN;  
    }
    
}
