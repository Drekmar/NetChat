package com.NetChat.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@Component
public class MyServer {
    private ServerSocket server;
    @Autowired
    private ClientHandler ch;

    private Vector<ClientHandler> clients;

    @Autowired
    @Qualifier("BaseAuthService")
    private AuthService authService;
    private PrintWriter out;



    private final int PORT = 8189;

    public MyServer(AuthService authService) {

        this.authService=authService;


        try {

            out=new PrintWriter("chatHistory.txt");
            server = new ServerSocket(PORT);
            Socket socket = null;
            //authService = new BaseAuthService();
            authService.start();
            clients = new Vector<>();
            ExecutorService executorService = Executors.newCachedThreadPool();

            while (true) {
                System.out.println("Сервер ожидает подключения");

                socket = server.accept();
                System.out.println("Клиент подключился");
                //переделать порт в проперти ,
                // наследный клас и компонетн на него  или отдельный бин

                ClientHandler ch = new ClientHandler(this, socket);
                 //ch=ctx.getBean("clientHandler",ClientHandler.class);

                executorService.submit(ch);

                //Class<ClientHandler> cc = ClientHandler.class;

            }

        } catch (IOException e) {
            System.out.println("Ошибка при работе сервера");
        } finally {
            try {
                server.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            authService.stop();
        }
    }

    public ServerSocket getServer() {

        return server;
    }

    public AuthService getAuthService() {
        return authService;
    }

    public void history(String msg){
        out.println(Calendar.getInstance().getTime().toString()+" "+msg);
        out.flush();
        //буфер и счётчик запилить
    }

    public synchronized boolean isNickBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getName().equals(nick)) return true;
        }
        return false;
    }

    public synchronized void broadcastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    public synchronized void PMsg(ClientHandler from, String nick,String msg) {
        for (ClientHandler o : clients) {
            if ( o.getName().equals(nick) ) {

                o.sendMsg("from:"+ from.getName() +msg);
                break;
            }
            else {  from.sendMsg("нет его");};

       }
    }


    public synchronized void unsubscribe(ClientHandler o) {
        clients.remove(o);
        broadcastclientslist ();

    }

    public synchronized void subscribe(ClientHandler o) {
        clients.add(o);
        broadcastclientslist ();
    }


    public synchronized void broadcastclientslist () {
        //ннадо через бд
        StringBuilder sb= new StringBuilder("/clients ");
        for (ClientHandler o : clients) {
            sb.append(o.getName()+" ");


        }
        broadcastMsg(sb.toString());
    }
}
