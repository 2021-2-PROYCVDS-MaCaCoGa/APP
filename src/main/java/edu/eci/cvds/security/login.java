package edu.eci.cvds.security;

import edu.eci.cvds.services.HistorialLoginExcepcion;

public interface login {

    public void log(String usuario, String contraseña) throws HistorialLoginExcepcion;

    public void cerrarSesion() throws HistorialLoginExcepcion;

    public boolean Logueado();
    
    public void redireccion();
    
    public void redireccionEstudiante();
    
    public void redireccionAdmin();
    
}
