package lt.codeacademy.provider;

import lt.codeacademy.entity.Exam;
import lt.codeacademy.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

public class SessionFactoryProvider {

    private static SessionFactoryProvider instance;
    private SessionFactory sessionFactory;

    private SessionFactoryProvider() {
        Configuration configuration = new Configuration();
        configuration.setProperties(getProperties()); //sudedam properties

        configuration.addAnnotatedClass(User.class);    //rysys, kur enticiai yra sumepinam
        configuration.addAnnotatedClass(Exam.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactoryProvider getInstance() {            //grazina objekta sukurta
        if (instance == null) {                                     //kai instance = o, kuriam nauja objekta
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
        p.put(URL, "jdbc:postgresql://localhost/exams");
        p.put(USER, "postgres");
        p.put(PASS, "123");
        p.put(SHOW_SQL, "true");
        p.put(HBM2DDL_AUTO, "update");   //"create-drop"

        return p;
    }
}
