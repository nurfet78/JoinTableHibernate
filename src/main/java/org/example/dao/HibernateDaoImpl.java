package org.example.dao;

import org.example.model.Auto;
import org.example.model.User;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.security.cert.Extension;
import java.util.ArrayList;
import java.util.List;

public class HibernateDaoImpl implements HibernateDao{
    private final SessionFactory sessionFactory = Util.getSessionFactory();

    @Override
    public User findById(int id) {
        User user = null;
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            user = session.createSelectionQuery("from User s where s.id=:id", User.class)
                    .setParameter("id", id)
                    .getSingleResultOrNull();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return user;
    }

    @Override
    public void save(User user) {
        sessionFactory.inTransaction(session -> {
            session.persist(user);
        });
    }

    @Override
    public void update(User user) {
        sessionFactory.inTransaction(session -> {
            session.merge(user);
        });
    }

    @Override
    public void delete(User user) {
        sessionFactory.inTransaction(session -> {
            long id = user.getId();
            session.createMutationQuery("delete from User s where s.id=:id")
                    .setParameter("id", id)
                    .executeUpdate();
        });
    }

    @Override
    public Auto findAutoById(int id) {
        Auto auto = null;
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            auto = session.createSelectionQuery("from Auto s where s.id=:id", Auto.class)
                    .setParameter("id", id)
                    .getSingleResultOrNull();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return auto;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            users = session.createSelectionQuery("from User", User.class)
                    .getResultList();

            transaction.commit();
        } catch (Throwable e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return users;
    }

    @Override
    public void findAllJoin() {
        sessionFactory.inTransaction(session -> {
            session.createSelectionQuery("from User as user inner join user.autos as auto", User.class)
                    .getResultList()
                    .forEach(s -> {
                        System.out.println(s.getName() + " " + s.getAge() + " " + s.getAutos());
                    });
        });
    }
}



































