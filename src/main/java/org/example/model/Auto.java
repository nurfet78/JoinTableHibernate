package org.example.model;


import jakarta.persistence.*;

@Entity
@Table(name = "autos")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String model;
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Auto() {

    }

    public Auto(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{" +
                "id = " + id +
                ", model = '" + model + '\'' +
                ", color = '" + color + '\'' +
                '}';
    }
}





















































