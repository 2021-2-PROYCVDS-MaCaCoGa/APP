

package edu.eci.cvds.services.Cliente;


import com.mysql.jdbc.Connection;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.CategoriaMapper;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.NecesidadMapper;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.UsuarioMapper;
import edu.eci.cvds.samples.entities.Perfil;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;


import java.sql.SQLException;
import java.sql.Statement;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 *
 * @author hcadavid
 */
public class MyBatisExample {
    
    static final String JDBC_DRIVER = "org.h2.Driver";   
    static final String DB_URL = "jdbc:h2:~/test";  
    static final String USER = "sa"; 
   static final String PASS = "sa"; 

   /**
     * Método que construye una fábrica de sesiones de MyBatis a partir del
     * archivo de configuración ubicado en src/main/resources
     *
     * @return instancia de SQLSessionFactory
     */
     public static SqlSessionFactory getSqlSessionFactory() {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream("mybatis-config.xml");
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e.getCause());
            }
        }
        return sqlSessionFactory;
    }

    /**
     * Programa principal de ejempo de uso de MyBATIS
     * @param args
     * @throws SQLException
     */
    public static void main(String args[]) throws SQLException {
        SqlSessionFactory sessionfact = getSqlSessionFactory();
        //sessionfact.getConfiguration().addMapper(UsuarioMapper.class);
        //sessionfact.getConfiguration().addMapper(CategoriaMapper.class);
        SqlSession sqlss = sessionfact.openSession();
        
        UsuarioMapper usuarioM = (UsuarioMapper)sqlss.getMapper(UsuarioMapper.class);
        CategoriaMapper categoriaM = (CategoriaMapper)sqlss.getMapper(CategoriaMapper.class);
        NecesidadMapper necesidadM = (NecesidadMapper)sqlss.getMapper(NecesidadMapper.class);
        System.out.println("-----------------------Consultar Clientes-------------------");
        System.out.println(usuarioM.consultarUsuarios());
        System.out.println("------------------------Consultar Cliente-------------------");
        System.out.println(usuarioM.consultarUsuario("CristianC"));
        System.out.println("---------------------Ingresando usuario michael_mni------------------------");
        usuarioM.ingresarUsuario("Michael", "michael_mni", "14325mc", "michaelmni@gmail.com.co", Perfil.valueOf("ESTUDIANTE").toString());
        System.out.println("--------------------------Consultar Cliente michael_mni------------");
        System.out.println(usuarioM.consultarUsuario("michael_mni"));
        usuarioM.deleteUsuario("michael_mni","14325mc");
        System.out.println("-----------------------Consultar Clientes-------------------");
        System.out.println(usuarioM.consultarUsuarios());     
        System.out.println("--------------------Consultar Categorias-------------------");
        System.out.println(categoriaM.consultarCategorias());
        categoriaM.agregarCategoria("LENGUAS", "Se expresan dudas de cualquier materia de lenguas extranjeras");
        System.out.println("--------------------Consultar Categoria LENGUAS-------------");
        System.out.println(categoriaM.consultarCategoriaNombre("LENGUAS"));
        categoriaM.modificarCategoria("LENGUAS","LENGUAJE", "Se expresan dudas de cualquier tema", "ACTIVO");
        System.out.println("--------------------Consultar Categoria LENGUAJE-------------");
        System.out.println(categoriaM.consultarCategoriaNombre("LENGUAJE"));
        categoriaM.borrarCategoria("LENGUAJE");
        System.out.println("---------------------Consultar Necesidades---------------------");
        System.out.println(necesidadM.consultarNecesidades());
        System.out.println("----------------------Agregando Necesidad Advertencia-------------------");
        necesidadM.addNecesidad("SISTEMAS", "Advertencia", "Se hallo un problema en el dominio de la pagina", 5,"CristianC");
        System.out.println("---------------------Consultar Advertencia-----------");
        System.out.println(necesidadM.consultarNecesidad("Advertencia"));
        System.out.println("--------------Necesidad en no Activo ---------------------");
        necesidadM.actualizarEstado("Advertencia", "NO ACTIVO");
        System.out.println(necesidadM.consultarNecesidad("Advertencia"));
        System.out.println("--------------Necesidad advertencia eliminada-------------------");
        necesidadM.eliminarNecesidad("Advertencia");
        System.out.println("---------------------Consultar Advertencia-----------");
        System.out.println(necesidadM.consultarNecesidad("Advertencia"));

        
 
        sqlss.commit();
        sqlss.close();
    }


}