package edu.eci.cvds.samplejr.dao.mybatis.mappers;

import java.sql.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Categoria;

public interface CategoriaMapper {
    
    public void agregarCategoria(@Param("categoria") Categoria cat);

    public void borrarCategoria(@Param("id") int id);

    public void modificarCategoria(@Param("id") int id,
                                   @Param("nombre") String nombre,
                                   @Param("estado") boolean estado);

    public Categoria consultarCategorias();
}
