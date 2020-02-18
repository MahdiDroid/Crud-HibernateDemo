package com.company;

import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        //create  session factory
        SessionFactory  factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session




        try {
//            Session session = factory.getCurrentSession();
//            System.out.println(" updating  ");
//            session.beginTransaction();
//            var student = session.get(Student.class,1);
//            student.setFirstName("BOBBBBB");
//            session.getTransaction().commit();
//            System.out.println("done");


            Session session = factory.getCurrentSession();

            System.out.println(" updating  ");

            session.beginTransaction();
                       session.createQuery("update  Student set email='foo@gmail.com'")
                               .executeUpdate();
                       var students = session.createQuery("from Student").list();
            for (var student: students
                 ) {
                System.out.println(student);
            }




            session.getTransaction().commit();
            System.out.println("done");

        }
        finally {
            factory.close();
        }


    }
}
