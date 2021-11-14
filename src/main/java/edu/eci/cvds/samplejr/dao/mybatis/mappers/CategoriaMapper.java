package edu.eci.cvds.samplejr.dao.mybatis.mappers;

import java.sql.Date;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Categoria;

import java.util.List;

public interface CategoriaMapper {
    
    /**
     * Encargado de la conexion a la base para crear una categoria
     * @param nombre
     * @param descripcion 
     */
    public void agregarCategoria(@Param("nombre") String nombre, @Param("descripcion")String descripcion);


    public void modificarCategoria(@Param("id") int id,
                                   @Param("nombre") String nombre,
                                   @Param("descripcion") String descripcion,
                                   @Param("estado") boolean estado);
    public void borrarCategoria(@Param("id")int id);

    public List<Categoria> consultarCategorias();

    public Categoria consultarCategoria(@Param("id") int di);
    public Categoria consultarCategoriaNombre(@Param("nombre") String nombre);
}
