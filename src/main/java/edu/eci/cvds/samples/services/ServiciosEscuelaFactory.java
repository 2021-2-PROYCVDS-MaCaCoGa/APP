package edu.eci.cvds.samples.services;

import com.google.inject.Injector;

import edu.eci.cvds.samplejr.dao.mybatis.MyBatisUsuario;
import edu.eci.cvds.samplejr.dao.UsuarioDao;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import edu.eci.cvds.samples.services.impl.ServiciosEscuelaImpl;
import edu.eci.cvds.samples.services.ServiciosEscuela;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;
import edu.eci.cvds.samplejr.dao.CategoriaDao;
import edu.eci.cvds.samplejr.dao.NecesidadDao;
import edu.eci.cvds.samplejr.dao.OfertaDao;
import edu.eci.cvds.samplejr.dao.RespuestaDao;
import edu.eci.cvds.samplejr.dao.mybatis.MyBatisCategoriaDao;
import edu.eci.cvds.samplejr.dao.mybatis.MyBatisNecesidadDao;
import edu.eci.cvds.samplejr.dao.mybatis.MyBatisOfertaDao;
import edu.eci.cvds.samplejr.dao.mybatis.MyBatisRespuestaDao;
import edu.eci.cvds.samplejr.dao.mybatis.mappers.CategoriaMapper;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ServiciosEscuelaFactory {

   private static ServiciosEscuelaFactory instance = new ServiciosEscuelaFactory();

   private static Injector Injector;

   private Optional<Injector> optInjector;
   
   private CategoriaMapper categoriaM;

   private Injector myBatisInjector(String env, String pathResource) {
       return createInjector(new XMLMyBatisModule() {
           @Override
           protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config.xml");
                bind(CategoriaDao.class).to(MyBatisCategoriaDao.class);
                bind(ServiciosEscuela.class).to(ServiciosEscuelaImpl.class);
           }
       });
   }

   private ServiciosEscuelaFactory(){
        optInjector = Optional.empty();
   }

   public ServiciosEscuela getServiciosEscuela(){
       if (!optInjector.isPresent()) {
           optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
       }

       return optInjector.get().getInstance(ServiciosEscuela.class);
   }


   public ServiciosEscuela getServiciosEscuelaTesting(){
       if (!optInjector.isPresent()) {
           optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
       }

       return optInjector.get().getInstance(ServiciosEscuela.class);
   }


   public static ServiciosEscuelaFactory getInstance(){
       return instance;
   }
   
   public static SqlSessionFactory getSqlSessionFactory(){
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
    * PRUEBA PARA REVISAR SI PODEMOS CONECTAR LA BASE A PARTIR DE ESTOS METODOS
    * @return 
    */
   @PostConstruct
   public  void iniciarSesionCategoria(){
       SqlSessionFactory sessionfact = getSqlSessionFactory();
       SqlSession sqlss = sessionfact.openSession();
   }

   public static void main(String[] args) throws ExcepcionServiciosEscuela {
        instance.getServiciosEscuela();
        /*System.out.println(instance.getServiciosEscuela().consultarClientes().toString());

        System.out.println(instance.getServiciosEscuela().consultarCliente(-706).toString());*/
}

}