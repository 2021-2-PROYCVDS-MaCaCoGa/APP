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

        /**
         * Encargado de la implementacion del metodo para agregar 
         * una categoria a la tabla CATEGORIA
         * Solo se deja dos parametros, pues los demas se hacen por triggers
         * @param nombre
         * @param descripcion
         * @throws PersistenceException 
         */
         @Override
    public void agregarCategoria(String nombre, String descripcion) throws PersistenceException {
        try{
            categoriaMapper.agregarCategoria(nombre, descripcion);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException exception){
            throw new PersistenceException("Error al agregar la categoria: "+nombre, exception);
        }
    }
	

	@Override
	public void borrarCategoria(int id) throws PersistenceException {
		try {
			categoriaMapper.borrarCategoria(id);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al borrar categoria: "+id, e);
		}
		
	}

	@Override
	public void modificarCategoria(String nombre,String descripcion, String estado) throws PersistenceException  {
		try {
			categoriaMapper.modificarCategoria(nombre,descripcion, estado);
		}catch(org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al modificar categoria: "+nombre, e);
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
			return categoriaMapper.consultarCategoriaNombre(nombre);
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
