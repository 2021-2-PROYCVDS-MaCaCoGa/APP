package edu.eci.cvds.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.google.inject.Inject;

import edu.eci.cvds.samples.services.ExcepcionServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuela;

import java.io.Serializable;

@ManagedBean(name = "controladorLogin")
@RequestScoped

public class controladorLogin{
    @Inject
    private ServiciosEscuela servicios;

    public boolean revisionUsuario(String nombre, String contraseña){
       try{
           servicios.verificarUsuario(nombre, contraseña);
       } catch(ExcepcionServiciosEscuela ex){
       }
       return false;
    
}
}
