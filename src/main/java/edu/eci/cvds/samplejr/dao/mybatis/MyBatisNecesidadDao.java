package edu.eci.cvds.samplejr.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.samplejr.dao.NecesidadDao;
import edu.eci.cvds.samplejr.dao.PersistenceException;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.NecesidadMapper;
import edu.eci.cvds.samples.entities.Necesidad;

public class MyBatisNecesidadDao implements NecesidadDao{
	
	@Inject
	private NecesidadMapper necesidadMapper;

	@Override
	public void agregarNecesidad(int categoria, String nombre, String descripcion, int urgencia, String estado)
			throws PersistenceException {
		try {
			necesidadMapper.addNecesidad(categoria, nombre, descripcion, urgencia, estado);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al agregar necesidad "+nombre, e);
		}
		
	}

	@Override
	public List<Necesidad> consultarNecesidades(int categoria) throws PersistenceException {
		try {
			return necesidadMapper.consultarNecesidadesCategoria(categoria);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar necesidades: "+ categoria, e);
		}
	}

	@Override
	public List<Necesidad> consultarNecesidades() throws PersistenceException {
		try {
			return necesidadMapper.consultarNecesidades();
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar necesidades", e);
		}
	}

	@Override
	public Necesidad consultarNecesidad(int id) throws PersistenceException {
		try {
			return necesidadMapper.consultarNecesidad(id);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar necesidad"+id, e);
		}
	}

	@Override
	public void actualizarEstado(int id, String estado) throws PersistenceException {
		try {
			necesidadMapper.actualizarEstado(id, estado);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al actualizar estado: "+id, e);
		}
		
	}

}
