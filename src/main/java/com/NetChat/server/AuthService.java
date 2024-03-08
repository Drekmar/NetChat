package com.NetChat.server;

import org.springframework.stereotype.Component;


public interface AuthService {
    void start();
    String getNickByLoginPass(String login, String pass);
    boolean chNikc(ClientHandler c, String newNick);
    void stop();
}
