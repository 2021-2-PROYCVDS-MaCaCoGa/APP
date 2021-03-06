package edu.eci.cvds.samplejr.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;
import edu.eci.cvds.samplejr.dao.PersistenceException;
import edu.eci.cvds.samplejr.dao.UsuarioDao;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.Perfil;
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
    	try {
    		return usuarioMapper.iniciarSesion(login, contraseña);
    	}catch(org.apache.ibatis.exceptions.PersistenceException e) {
    		throw new PersistenceException("Error al iniciar sesion");
    	}
    }

	@Override
	public Usuario consultarUsuaro(String log) throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuario(log);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar usuario: "+log, e);
		}
		
	}

	@Override
	public List<Usuario> consultarUsuarios() throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuarios();
		}catch(org.apache.ibatis.exceptions.PersistenceException e){
			throw new PersistenceException("Error al consultar usuarios");
		}
	}

	@Override
	public void ingresarUsuario(String nombre, String log, String contraseña, String correo, String perfil)
			throws PersistenceException {
		try {
			usuarioMapper.ingresarUsuario(nombre, log, contraseña, correo, perfil);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al ingresar usuario: "+nombre, e);
		}
		
	}

	@Override
	public int existenciaUsuario(String nombre, String contraseña) throws PersistenceException {
		try {
			return usuarioMapper.ExistenciaUsuario(nombre, contraseña);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar la existencia del usuario: "+nombre, e);
		}
	}
        
        @Override
        public void deleteUsuario(String login, String contraseña) throws PersistenceException{
            try{
                usuarioMapper.deleteUsuario(login, contraseña);
            }catch(org.apache.ibatis.exceptions.PersistenceException e){
                throw new PersistenceException("Error al eliminar el usuario "+login,e);
            }
        }

        @Override
        public int consultarNumeroSolicitadas(String usuario) throws PersistenceException {
            int solicitadas = 0;
            try{
                solicitadas = usuarioMapper.consultarCantidadNecesidades(usuario).getSolicitadas();
            }catch(org.apache.ibatis.exceptions.PersistenceException e){
                throw new PersistenceException("No fue posible obtener el numero de necesidades del usuario "+usuario,e);
            }
            return solicitadas;
        }
        
        @Override
        public int consultarNumeroOfrecidas(String usuario) throws PersistenceException{
            int ofrecidas = 0;
            try{
                ofrecidas = usuarioMapper.consultarCantidadOfertas(usuario).getOfrecidas();
            }catch(org.apache.ibatis.exceptions.PersistenceException e){
                throw new PersistenceException("No fue posible obtener el numero de ofertas del usuario "+usuario,e);
            }
            return ofrecidas;
        }
        
        
}

