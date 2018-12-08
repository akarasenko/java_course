package ru.stqa.ptf.mantisbt.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.ptf.mantisbt.models.User;

import java.util.List;

public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public List<User> getUsers() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> result = session.createQuery( "from User where enabled = true" ).list();
        for ( User user : result ) {
            System.out.println(user);
        }
        session.getTransaction().commit();
        session.close();
        return result;
    }
}
