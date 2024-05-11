package com.NetChat.server;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberAuthService implements AuthService{
    SessionFactory sessionFactory;

    @Override
    public void start() {
         sessionFactory = new Configuration()
                 .addAnnotatedClass(User.class)
                 .buildSessionFactory();

    }

    @Override
    public String getNickByLoginPass(String login, String pass) {

        Session session= null;
        session=sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user=session.get(User.class,pass);
        User user1=session.createQuery("SELECT i FROM User i WHERE i.login=:login AND i.pass=:login",User.class)
                .setParameter(login,pass)
                .getSingleResult();
        session.getTransaction().commit();
        return user1.getName();
    }

    @Override
    public boolean chNikc(ClientHandler c, String newNick) {

        Session session= null;
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();



        User user=session.get(User.class,c.getName());
        if (user.getName().equals(newNick)) {
            return false;
        }

           if (user.getName().equals(c.getName())){user.setName(newNick);
               session.getTransaction().commit();

               return true;
           }
        return false;


    }

    @Override
    public void stop() {
        sessionFactory.close();

    }
}
