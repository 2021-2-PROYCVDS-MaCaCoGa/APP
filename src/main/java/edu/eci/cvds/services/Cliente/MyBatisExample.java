

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
        sessionfact.getConfiguration().addMapper(UsuarioMapper.class);
        sessionfact.getConfiguration().addMapper(UsuarioMapper.class);
        sessionfact.getConfiguration().addMapper(CategoriaMapper.class);
        SqlSession sqlss = sessionfact.openSession();
        
        UsuarioMapper usuarioM = (UsuarioMapper)sqlss.getMapper(UsuarioMapper.class);
        CategoriaMapper categoriaM = (CategoriaMapper)sqlss.getMapper(CategoriaMapper.class);
        //NecesidadMapper necesidadM = (NecesidadMapper)sqlss.getMapper(NecesidadMapper.class);
        
        
        categoriaM.agregarCategoria(3, "LENGUAS", "Se expresan dudas de cualquier materia de lenguas extranjeras", true);
        System.out.println("--------------------Consultar Categoria LENGUAS-------------");
 
        sqlss.commit();
        sqlss.close();
    }


}