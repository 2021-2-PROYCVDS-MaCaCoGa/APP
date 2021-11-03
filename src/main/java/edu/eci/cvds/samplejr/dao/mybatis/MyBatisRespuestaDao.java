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
	public void agregarRespuesta(int id, String nombre, List<String> comentarios) throws PersistenceException {
		try {
			respuestaMapper.addRespuesta(id, nombre, comentarios);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al agregar Respuesta: "+id, e);
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
	public Respuesta consultarrespuesta(int id) throws PersistenceException {
		try {
			return respuestaMapper.consultarRespuesta(id);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar respuesta: "+id, e);
		}
	}

}
