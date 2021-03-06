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


    public void modificarCategoria(@Param("categoria") String categoria,
                                   @Param("nombre") String nombre,
                                   @Param("descripcion") String descripcion,
                                   @Param("estado") String estado);
    
    public void borrarCategoria(@Param("NOMBRE")String nombre);

    public List<Categoria> consultarCategorias();
    public List<Categoria> consultarCategoriasMasBuscadas();

    public Categoria consultarCategoria(@Param("id") int di);
    public Categoria consultarCategoriaNombre(@Param("nombre") String nombre);
    
}
