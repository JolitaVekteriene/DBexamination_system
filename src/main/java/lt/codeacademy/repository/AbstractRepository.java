package lt.codeacademy.repository;

import lt.codeacademy.provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.function.Consumer;
import java.util.function.Function;

abstract class AbstractRepository {
    private final SessionFactory sessionFactory;

    AbstractRepository() {
        sessionFactory = SessionFactoryProvider.getInstance().getSessionFactory();
    }

    void modifyEntity(Consumer<Session> consumer) {
        Transaction transaction = null;     //SUKURIAM OBJEKTA, KAD GALETUM GRAZINTI
        try (Session session = sessionFactory.openSession()) { //atnaujinti irasyti irasa i DB
            transaction = session.beginTransaction(); //TRANS.- PRISKIRIAM KINTAMAJI

            consumer.accept(session);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Can not modify entity");
        }
    }

    <V> V getValue (Function<Session, V> function) {
        try (Session session = sessionFactory.openSession()) {
            return function.apply(session);
        } catch (Exception e) {
            System.out.println("Can not get entities data");
        }
        return null;
    }
}
