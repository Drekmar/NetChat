package com.NetChat.server;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
@Qualifier("bas")
public class BaseAuthService implements AuthService {
    private static class Entry {
        private String login;
        protected String pass;
        private String nick;

        public Entry(String login, String pass, String nick) {
            this.login = login;
            this.pass = pass;
            this.nick = nick;
        }
    }

    private ArrayList<Entry> entries;

    @Override
    public void start() { }

    @Override
    public void stop() { }

    public BaseAuthService() {
        entries = new ArrayList<>();
        entries.add(new Entry("login1", "pass1", "nick1"));
        entries.add(new Entry("login2", "pass2", "nick2"));
        entries.add(new Entry("login3", "pass3", "nick3"));
    }

    @Override
    public String getNickByLoginPass(String login, String pass) {


        for (Entry o : entries) {
            if (o.login.equals(login) && o.pass.equals(pass)) return o.nick;
        }
        return null;
    }

    @Override
    public boolean chNikc(ClientHandler c, String newNick) {
        for (Entry o:entries ) {
            if (o.nick.equals(newNick) ) {
                return false;

            }

        }
        Class<String> objectClass = String.class;

        for (Entry o:entries ) {
            if (o.nick.equals(c.getName()) ) {
                o.nick=newNick;
                return true;

            }

        }
        return false;
        }
}
