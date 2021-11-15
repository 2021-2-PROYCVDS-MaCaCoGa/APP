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
            public void agregarNecesidad(String categoria, String nombre, String descripcion,String usuario, int urgencia) throws PersistenceException {
		try {
			necesidadMapper.addNecesidad(categoria, nombre, descripcion,urgencia,usuario);
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
	public Necesidad consultarNecesidad(String necesidad) throws PersistenceException {
		try {
			return necesidadMapper.consultarNecesidad(necesidad);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar necesidad"+necesidad, e);
		}
	}

	@Override
	public void actualizarEstado(String necesidad, String estado) throws PersistenceException {
		try {
			necesidadMapper.actualizarEstado(necesidad, estado);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al actualizar estado: "+necesidad, e);
		}
		
	}

}
