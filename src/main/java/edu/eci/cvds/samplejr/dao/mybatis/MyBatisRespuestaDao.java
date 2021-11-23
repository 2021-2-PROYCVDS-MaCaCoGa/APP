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
			throw new PersistenceException("Error al agregar Respuesta: ", e);
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

}
