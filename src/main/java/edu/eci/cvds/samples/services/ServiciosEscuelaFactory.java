package edu.eci.cvds.samples.services;

import com.google.inject.Injector;

import edu.eci.cvds.samplejr.dao.mybatis.MyBatisUsuario;
import edu.eci.cvds.samplejr.dao.UsuarioDao;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.XMLMyBatisModule;
import edu.eci.cvds.samples.services.impl.ServiciosEscuelaImpl;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosEscuelaFactory {

   private static ServiciosEscuelaFactory instance = new ServiciosEscuelaFactory();

   private static Injector Injector;

   private Injector myBatisInjector(String env, String pathResource) {
       return createInjector(new XMLMyBatisModule() {
           @Override
           protected void initialize() {
               install(JdbcHelper.PostgreSQL);
			   setClassPathResource("mybatis-config.xml")
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

   public static void main(String[] args) throws ExcepcionServiciosEscuela {
        instance.getServiciosEscuela();
        /*System.out.println(instance.getServiciosEscuela().consultarClientes().toString());

        System.out.println(instance.getServiciosEscuela().consultarCliente(-706).toString());*/
}

}