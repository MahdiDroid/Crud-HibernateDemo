package com.company;

import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueringStudentDemo {

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
            List<Student> students = session.createQuery("from Student").list();
            shoStudents(students);
            System.out.println("*******************************************************************");
            List<Student> stus = session.createQuery("from Student s where s.firstName='lala'").list();
            shoStudents(stus);

            session.getTransaction().commit();
            System.out.println("done");

        }
        finally {
            factory.close();
        }

    }

    private static void shoStudents(List<Student> stus) {
        for (var student : stus) {
            System.out.println(student);
        }
    }
}
