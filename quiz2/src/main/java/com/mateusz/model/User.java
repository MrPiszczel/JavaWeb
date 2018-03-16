package com.mateusz.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String password;
    private String password2;

    public User() {

    }

    public User(String login, String password, String password2) {
        this.login = login;
        this.password = password;
        this.password2 = password2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
