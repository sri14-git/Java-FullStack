package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student.class);
        // Loads hibernate.cfg.xml
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Student s1 = new Student();
        s1.setsName("Sri");
        s1.setsAge(22);

        Student s2=new Student();
        s2.setsAge(23);
        s2.setsName("Prakask");
        s2.setRollNo(191);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(s2);
        transaction.commit();
        session.close();
        sessionFactory.close();
        System.out.println(s1);




    }
    }
