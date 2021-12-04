package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.samplejr.dao.CategoriaDao;
import edu.eci.cvds.samplejr.dao.NecesidadDao;
import edu.eci.cvds.samplejr.dao.OfertaDao;
import edu.eci.cvds.samplejr.dao.RespuestaDao;
import edu.eci.cvds.samplejr.dao.UsuarioDao;
import edu.eci.cvds.samplejr.dao.mybatis.MyBatisCategoriaDao;
import edu.eci.cvds.samplejr.dao.mybatis.MyBatisNecesidadDao;
import edu.eci.cvds.samplejr.dao.mybatis.MyBatisOfertaDao;
import edu.eci.cvds.samplejr.dao.mybatis.MyBatisRespuestaDao;
import edu.eci.cvds.samplejr.dao.mybatis.MyBatisUsuario;
import edu.eci.cvds.samples.services.ServiciosEscuela;
import edu.eci.cvds.samples.services.impl.ServiciosEscuelaImpl;
import edu.eci.cvds.security.*;

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                bind(CategoriaDao.class).to(MyBatisCategoriaDao.class);
                bind(NecesidadDao.class).to(MyBatisNecesidadDao.class);
                bind(ServiciosEscuela.class).to(ServiciosEscuelaImpl.class);  
                bind(OfertaDao.class).to(MyBatisOfertaDao.class);
                bind(RespuestaDao.class).to(MyBatisRespuestaDao.class);
                bind(login.class).to(loginconnection.class);
                bind(UsuarioDao.class).to(MyBatisUsuario.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}
