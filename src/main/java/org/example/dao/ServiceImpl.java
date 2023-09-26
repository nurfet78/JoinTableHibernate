package org.example.dao;

import org.example.model.Auto;
import org.example.model.User;

import java.util.List;

public class ServiceImpl implements Service{
    private final HibernateDao service = new HibernateDaoImpl();

    @Override
    public User findById(int id) {
        return service.findById(id);
    }

    @Override
    public void save(User user) {
        service.save(user);
    }

    @Override
    public void update(User user) {
        service.update(user);
    }

    @Override
    public void delete(User user) {
        service.delete(user);
    }

    @Override
    public Auto findAutoById(int id) {
        return service.findAutoById(id);
    }

    @Override
    public List<User> findAll() {
        return service.findAll();
    }

    @Override
    public void findAllJoin() {
        service.findAllJoin();
    }
}
