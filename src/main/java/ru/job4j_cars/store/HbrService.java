package ru.job4j_cars.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;
import java.util.function.Function;

public class HbrService implements AutoCloseable {

    private static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private static final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();


    private HbrService () {}

    public <T> T tx(Function<Session, T> command) {
        Transaction transaction = null;
        try (Session session = sf.openSession()) {
            transaction = session.beginTransaction();
            T rsl = command.apply(session);
            transaction.commit();
            return rsl;
        } catch (Exception e) {
           /* if (transaction != null) {
                transaction.rollback();
            }*/
            e.printStackTrace();
            throw e;
        }
    }

    public <T> void add(T input) {
        tx(session -> session.save(input));
    }

    public SessionFactory getSF() {
        return sf;
    }

    private static final class LAZY {
        private static final HbrService INST = new HbrService();
    }

    public static HbrService instOf() {
        return LAZY.INST;
    }

    @Override
    public void close() throws Exception {
        sf.close();
    }
}
