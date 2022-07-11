package lt.codeacademy.provider;

import lt.codeacademy.entity.Question;
import lt.codeacademy.entity.ExamProgram;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

public class SessionFactoryProvider {

    private static SessionFactoryProvider instance;
    private SessionFactory sessionFactory;

    private SessionFactoryProvider() {
        Configuration configuration = new Configuration();
        configuration.setProperties(getProperties());

        configuration.addAnnotatedClass(ExamProgram.class);
        configuration.addAnnotatedClass(Question.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactoryProvider getInstance() {
        if (instance == null) {
            instance = new SessionFactoryProvider();
        }

        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Properties getProperties() {
        Properties p = new Properties();

        p.put(DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        p.put(DRIVER, "org.postgresql.Driver");
        p.put(URL, "jdbc:postgresql://localhost/questions");
        p.put(USER, "postgres");
        p.put(PASS, "123");
        p.put(SHOW_SQL, "true");
        p.put(HBM2DDL_AUTO, "update");

        return p;
    }
}
