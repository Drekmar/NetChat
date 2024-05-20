package com.NetChat.server;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Scope("prototype")
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
private long id;
    @Column(name = "nick")
private String nick;
    @Column(name="login")
private  String login;
    @Column(name = "password")
private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }



    public void setName(String nick) {
        this.nick = nick;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return nick;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User(){}
}
