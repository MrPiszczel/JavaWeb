package com.mateusz.model;



import org.hibernate.annotations.ColumnDefault;


import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;


@Entity
@Table(name="users")
public class User {

    @Id
    private String username;

    private String password;

    private int points;

    public User() {

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
