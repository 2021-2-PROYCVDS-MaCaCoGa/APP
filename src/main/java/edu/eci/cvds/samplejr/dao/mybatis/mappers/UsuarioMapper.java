package edu.eci.cvds.samplejr.dao.mybatis.mappers;

import edu.eci.cvds.samples.entities.Perfil;
import edu.eci.cvds.samples.entities.Usuario;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UsuarioMapper {

    public Usuario consultarUsuario(@Param("LOGIN") String login);

    public Usuario iniciarSesion(@Param("LOGIN") String login,
                                 @Param("PASSWORD") String contraseña);

    public List<Usuario> consultarUsuarios();

    public void ingresarUsuario(@Param("NOMBRE") String nombre,
                                @Param("LOGIN") String login,
                                @Param("PASSWORD") String contraseña,
                                @Param("CORREO") String correo,
                                @Param("ROL") String rol);

    public int ExistenciaUsuario(@Param("USUARIO") String nombre,
                                 @Param("CONTRA") String contraseña);
    
    public void deleteUsuario(@Param("LOGIN") String login,@Param("PASSWORD") String password);
    
    public Usuario consultarCantidadNecesidades(@Param("nombreUsuario") String usuario);
    
    public Usuario consultarCantidadOfertas(@Param("nombreUsuario") String usuario);
        
}
