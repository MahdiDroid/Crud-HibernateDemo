package com.company;

import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        //create  session factory
        SessionFactory  factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try {

            System.out.println(" getting ");

            session.beginTransaction();
            Student stu = session.get(Student.class,4);

            System.out.println("id : " + stu.getId() + "\nemail :"+stu.getEmail() + "\nfirstName: " + stu.getFirstName() + "\nlast name : " + stu.getLastName());


            session.getTransaction().commit();
            System.out.println("done");

        }
        finally {
            factory.close();
        }

    }
}
