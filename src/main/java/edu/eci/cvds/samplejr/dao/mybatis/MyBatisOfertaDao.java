package edu.eci.cvds.samplejr.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.samplejr.dao.OfertaDao;
import edu.eci.cvds.samplejr.dao.PersistenceException;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.OfertaMapper;
import edu.eci.cvds.samples.entities.Actividad;
import edu.eci.cvds.samples.entities.Oferta;

public class MyBatisOfertaDao implements OfertaDao{
	
	@Inject
	private OfertaMapper ofertaMapper;

	@Override
	public void agregarOferta(String categoria, String descripcion, String nombre, String usuario) throws PersistenceException {
		try {
			ofertaMapper.addOferta(categoria, descripcion, nombre, usuario);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al agregar oferta: "+nombre, e);
		}
		
	}

	@Override
	public void actualizarEstado(String oferta, String estado) throws PersistenceException {
		try {
			ofertaMapper.actualizarEstado(oferta, estado);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al actualizar estado: "+oferta, e);
		}
		
	}

	@Override
	public Oferta consultaroferta(String oferta) throws PersistenceException {
		try {
			return ofertaMapper.consultarOferta(oferta);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar oferta: "+oferta, e);
		}
		
	}

	@Override
	public List<Oferta> consultarOfertas(String categoria) throws PersistenceException {
		try {
			return ofertaMapper.consultarOfertasXcategoria(categoria);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar ofertas: "+categoria, e);
		}
	}

	@Override
	public List<Actividad> consultarOfertas() throws PersistenceException {
		try {
			return ofertaMapper.consultarOfertas();
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar ofertas", e);
		}
	}
        
        @Override
        public void eliminarOferta(String oferta) throws PersistenceException{
                try{
                    ofertaMapper.deleteOferta(oferta);
                }catch(org.apache.ibatis.exceptions.PersistenceException e){
                    throw new PersistenceException("Error al eliminar la oferta "+oferta,e);
                }
        }

}
