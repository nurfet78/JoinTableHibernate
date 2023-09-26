package org.example;

import org.example.dao.Service;
import org.example.dao.ServiceImpl;
import org.example.model.Auto;
import org.example.model.User;

public class Main {
    public static void main(String[] args) {
        Service service = new ServiceImpl();

        User Masha = new User("Маша", 26);
        service.save(new User("Маша", 26));


        Masha.addAuto(new Auto("Ferrari", "red"));
        Masha.addAuto(new Auto("Ford", "black"));

        service.update(Masha);


        User marina = new User("Марина", 18);
        service.save(marina);


        marina.addAuto(new Auto("Porshe", "metallic"));
        marina.addAuto(new Auto("Mercedes", "black"));
        marina.addAuto(new Auto("Rolls-Royce", "violet"));

        service.update(marina);

        service.findAllJoin();
    }
}