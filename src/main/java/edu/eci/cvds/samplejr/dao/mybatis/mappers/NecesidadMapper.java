package edu.eci.cvds.samplejr.dao.mybatis.mappers;

import java.sql.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Necesidad;

import java.util.List;

public interface NecesidadMapper {
    
    public void addNecesidad(@Param("categoria") int categoria,
                            @Param("nombre") String nombre,
                            @Param("descripcion")String descripcion,
                            @Param("urgencia") int urgencia,
                            @Param("estado") boolean estado);

    public List<Necesidad> consultarNecesidades();
    public Necesidad consultarNecesidad(@Param("id") int id);
    public Necesidad consultarCategoria(@Param("nombre") String nombre);

    
}
