package edu.eci.cvds.samplejr.dao.mybatis;

import java.util.List;

import com.google.inject.Inject;

import edu.eci.cvds.samplejr.dao.CategoriaDao;
import edu.eci.cvds.samplejr.dao.PersistenceException;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.CategoriaMapper;
import edu.eci.cvds.samples.entities.Categoria;

public class MyBatisCategoriaDao implements CategoriaDao{
	@Inject
	private CategoriaMapper categoriaMapper;

	

	@Override
	public void borrarCategoria(int id) throws PersistenceException {
		try {
			categoriaMapper.borrarCategoria(id);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al borrar categoria: "+id, e);
		}
		
	}

	@Override
	public void modificarCategoria(int id, String nombre, boolean estado) throws PersistenceException  {
		try {
			categoriaMapper.modificarCategoria(id, nombre, estado);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al modificar categoria: "+nombre, e);
		}
		
	}

	@Override
	public void agregarCategoria(int id, String nombre, String descripcion, boolean estado)
			throws PersistenceException {
		try {
			categoriaMapper.agregarCategoria(id, nombre, descripcion, estado);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al agregar categoria: "+nombre, e);
		}
		
	}
	
	@Override
	public void agregarCategoria(Categoria cat) throws PersistenceException {
		try {
			categoriaMapper.agregarCategoria(cat);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al agregar categoria: "+cat.getNombre(), e);
		}
		
	}

	@Override
	public Categoria consultarcategoria(int id) throws PersistenceException {
		try {
			return categoriaMapper.consultarCategoria(id);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar categoria: "+id, e);
		}
		
	}

	@Override
	public Categoria consultarcategoria(String nombre) throws PersistenceException {
		try {
			return categoriaMapper.consultarCategoria(nombre);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar categoria: "+nombre, e);
		}
		
	}

	@Override
	public List<Categoria> consultarcategorias() throws PersistenceException {
		try {
			return categoriaMapper.consultarCategorias();
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar las categorias ", e);
		}
		
	}

	

}
