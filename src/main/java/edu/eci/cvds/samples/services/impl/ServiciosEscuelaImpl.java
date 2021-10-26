package edu.eci.cvds.samples.services.impl;

import javax.inject.Inject;

import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;

import edu.eci.cvds.samplejr.dao.LoginDao;
import edu.eci.cvds.samplejr.dao.PersistenceException;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ExcepcionServiciosEscuela;
import edu.eci.cvds.samples.services.ServiciosEscuela;

public class ServiciosEscuelaImpl implements ServiciosEscuela {
    @Inject
    private LoginDao login;

    @Override
    public boolean iniciarSesion(String login, String contraseña) throws ExcepcionServiciosEscuela {
        return false;
     }
    
}
