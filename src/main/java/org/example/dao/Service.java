package org.example.dao;

import org.example.model.Auto;
import org.example.model.User;

import java.util.List;

public interface Service {
    User findById(int id);
    void save(User user);
    void update(User user);
    void delete(User user);
    Auto findAutoById(int id);
    List<User> findAll();
    void findAllJoin();
}
