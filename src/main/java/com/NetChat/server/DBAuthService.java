package com.NetChat.server;

import org.springframework.stereotype.Component;

import java.sql.*;


public class DBAuthService implements AuthService {
    private Connection connection;
    private PreparedStatement ps;
    private PreparedStatement psChNick;
    public void start() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:chat.db");
           psChNick=connection.prepareStatement("SELECT Nick FROM Users WHERE Login = ? AND Pass = ?;");
            ps = connection.prepareStatement("UPDATE Users SET Nick = ? WHERE Nick = ? ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getNickByLoginPass(String login, String pass) {
        try {
            ps.setString(1, login);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean chNikc(ClientHandler c, String newNick) {
        try {
            psChNick.setString(2,c.getName());
            psChNick.setString(1,newNick);
            psChNick.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }


    }

    public void stop() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
