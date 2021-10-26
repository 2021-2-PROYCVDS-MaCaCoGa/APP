package edu.eci.cvds.samplejr.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.samplejr.dao.PersistenceException;
import edu.eci.cvds.samplejr.dao.UsuarioDao;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.Usuario;

public class MyBatisUsuario implements UsuarioDao {
    
    @Inject
    UsuarioMapper usuarioMapper;

    @Override
    public Usuario iniciarSesion(String login, String contraseña) throws PersistenceException{
        try{
            return null;
        }catch(Exception e){
            throw new PersistenceException("El usuario o contraseña estan mal escritos o son invalidos: ", e);
        }
    }
}

