package com.NetChat.server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import com.NetChat.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
public class MainClass {
    public static void main(String[] args) {
        Integer a = 23;
        Integer b = 23;
        int c = a + b;
        System.out.println(c);
        ApplicationContext ctx = new
                AnnotationConfigApplicationContext(SpringConfig.class);
        //new MyServer();
        // переделать какнить

        MyServer myServer=ctx.getBean("myServer",MyServer.class);


    }


    public static void PMsg (  String nik,String from,String msg) {


        String ss=("from "+from+" "+"to "+nik+": "+msg);
        System.out.println(ss);

        }
}






