package edu.eci.cvds.samplejr.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Usuario;

public interface UsuarioMapper {

    public Usuario consultarUsuario();

    public void ingresarUsuario();
    
}
