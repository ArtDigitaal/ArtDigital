package utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import entity.Categoria;
import entity.Produto;
import entity.Usuario;

public class HibernateUtil {
	
    private static SessionFactory sessionFactory;
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                var configuration = new Configuration();
                
                var settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:42109/ARTDIGITAL");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "my-secret-pw");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS, true);
                //settings.put(Environment.HBM2DDL_AUTO, "create");
                
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Usuario.class);
                configuration.addAnnotatedClass(Produto.class);
                configuration.addAnnotatedClass(Categoria.class);

                var serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
