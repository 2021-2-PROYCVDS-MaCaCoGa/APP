package edu.eci.cvds.samplejr.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.samplejr.dao.OfertaDao;
import edu.eci.cvds.samplejr.dao.PersistenceException;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.OfertaMapper;
import edu.eci.cvds.samples.entities.Oferta;

public class MyBatisOfertaDao implements OfertaDao{
	
	@Inject
	private OfertaMapper ofertaMapper;

	@Override
	public void agregarOferta(int id, String categoria, String descripcion, String nombre) throws PersistenceException {
		try {
			ofertaMapper.addOferta(id, categoria, descripcion, nombre);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al agregar oferta: "+id, e);
		}
		
	}

	@Override
	public void actualizarEstado(int id, String estado) throws PersistenceException {
		try {
			ofertaMapper.actualizarEstado(id, estado);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al actualizar estado: "+id, e);
		}
		
	}

	@Override
	public Oferta consultaroferta(int id) throws PersistenceException {
		try {
			return ofertaMapper.consultarOferta(id);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar oferta: "+id, e);
		}
		
	}

	@Override
	public List<Oferta> consultarOfertas(int categoria) throws PersistenceException {
		try {
			return ofertaMapper.consultarOfertas(categoria);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar ofertas: "+categoria, e);
		}
	}

	@Override
	public List<Oferta> consultarOfertas() throws PersistenceException {
		try {
			return ofertaMapper.consultarOfertas();
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar ofertas", e);
		}
	}

}
