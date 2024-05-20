package com.NetChat.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
@Component
@Scope("prototype")
public class ClientHandler implements Runnable {


    private MyServer myServer;
    //@Autowired
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;

    public String getName() {
        return name;
    }

    public ClientHandler(MyServer myServer,Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";
        } catch (IOException e) {
            throw new RuntimeException("Проблемы при создании обработчика клиента");
        }
    }



    @Override
    public void run() {
        try {
            while (true) {
                String str = in.readUTF();
                if (str.startsWith("/auth")) {
                    String[] parts = str.split("\\s");
                    String nick = myServer.getAuthService().getNickByLoginPass(parts[1], parts[2]);
                    if (nick != null) {
                        if (!myServer.isNickBusy(nick)) {
                            sendMsg("/authok " + nick);
                            name = nick;
                            myServer.broadcastMsg(name + " зашел в чат");
                            myServer.subscribe(this);
                            break;
                        } else sendMsg("Учетная запись уже используется");
                    } else {
                        sendMsg("Неверные логин/пароль");
                    }
                }
            }

            while (true) {
                String str = in.readUTF();

                System.out.println("from " + name + ": " + str);
                myServer.history(name+": "+ str);
                if (str.startsWith("/w")) {

                    String[] parts = str.split(" ",3);
                    myServer.PMsg(this,parts[1],parts[2]);


                }
                if (str.startsWith("/chnick")) {
                    String newNick =str.split(" ")[1];
                    if (myServer.getAuthService().chNikc(this,newNick));
                    chNick(newNick);

                }else {sendMsg("Ник занят");}


                if (str.equals("/end")) break;

                myServer.broadcastMsg(name + ": " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            myServer.unsubscribe(this);
            myServer.broadcastMsg(name + " вышел из чата");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }

    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void chNick (String newnick) {
        myServer.broadcastMsg(name+" теперь "+newnick);
        name=newnick;

        sendMsg("/chnick " +newnick);
         myServer.broadcastclientslist();


    }
}
