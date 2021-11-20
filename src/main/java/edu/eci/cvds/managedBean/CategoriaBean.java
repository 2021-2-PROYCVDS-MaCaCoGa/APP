package edu.eci.cvds.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "listenerCategoria")
@SessionScoped
public class CategoriaBean{
    private String nombreCategoria;
}
