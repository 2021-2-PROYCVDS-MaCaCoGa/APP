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
    public boolean ExistenciaUsuario(String login, String contraseña) throws PersistenceException{
        try{
            int verificador = usuarioMapper.ExistenciaUsuario(login, contraseña);
            if(verificador == 1){
                return true;
            }
            return false;
        }catch(Exception e){
            throw new PersistenceException("El usuario no existe o la contraseña es incorrecta: ", e);
        }
    }

    @Override
    public Usuario iniciarSesion(String login, String contraseña) throws PersistenceException {
        return null;
    }
}

