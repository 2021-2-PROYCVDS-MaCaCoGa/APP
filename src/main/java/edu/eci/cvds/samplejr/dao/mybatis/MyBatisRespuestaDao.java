package edu.eci.cvds.samplejr.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.samplejr.dao.PersistenceException;
import edu.eci.cvds.samplejr.dao.RespuestaDao;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.RespuestaMapper;
import edu.eci.cvds.samples.entities.Respuesta;

public class MyBatisRespuestaDao implements RespuestaDao{
	
	@Inject
	private RespuestaMapper respuestaMapper;

	@Override
	public void agregarRespuesta(String nombre, String comentario, String nombreComentario, String actividad, String usuario) throws PersistenceException {
		try {
			respuestaMapper.addRespuesta(nombre, comentario, nombreComentario,actividad,usuario);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al agregar Respuesta: "+nombre, e);
		}
		
	}
        
        @Override
        public void agregarComentario(String comentario, String usuario, String respuesta,String nombre) throws PersistenceException {
                try{
                    respuestaMapper.addComentario(comentario, usuario, respuesta, nombre);
                }catch(org.apache.ibatis.exceptions.PersistenceException e){
                        throw new PersistenceException("Error al agregar Comentario: "+nombre,e);
                }
        }

	@Override
	public List<Respuesta> consultarRespuestas() throws PersistenceException {
		try {
			return respuestaMapper.consultarRespuestas();
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar las respuestas ", e);
		}
	}

	@Override
	public List<Respuesta> consultarrespuesta(String respuesta)throws PersistenceException {
		try {
			return respuestaMapper.consultarRespuesta(respuesta);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar respuesta: "+respuesta, e);
		}
	}
        
        @Override
        public void eliminarComentario(String comentario) throws PersistenceException{
                try{
                    respuestaMapper.deleteComentario(comentario);
                }catch(org.apache.ibatis.exceptions.PersistenceException e){
                    throw new PersistenceException("Error al eliminar comentario"+comentario,e);
                }
        }
        
        @Override
        public void eliminarRespuesta(String respuesta) throws PersistenceException{
                try{
                    respuestaMapper.deleteRespuesta(respuesta);
                }catch(org.apache.ibatis.exceptions.PersistenceException e){
                    throw new PersistenceException("Error al eliminar respuesta "+respuesta,e);
                }
        }

}
