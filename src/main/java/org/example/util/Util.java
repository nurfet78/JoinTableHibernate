package org.example.util;

import org.example.model.Auto;
import org.example.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Util {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder().build();

        try {
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(User.class)
                    .addAnnotatedClass(Auto.class)
                    .buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Exception " + e);
            StandardServiceRegistryBuilder.destroy(registry);
        }

        return sessionFactory;
    }

    public static void destroy() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
