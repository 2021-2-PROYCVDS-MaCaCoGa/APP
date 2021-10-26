package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Usuario;

public interface ServiciosEscuela {
    
    public abstract Usuario iniciarSesion(String login, String contraseña) throws ExcepcionServiciosEscuela;
<<<<<<< HEAD

    public abstract boolean verificarUsuario(String login, String contraseña) throws ExcepcionServiciosEscuela;
=======
>>>>>>> 189c31559b61f677490c9651e57230f4ef3bdd0e

}
