package com.company;

import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {

    public static void main(String[] args) {

        //create  session factory
        SessionFactory  factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session

        Session session = factory.getCurrentSession();

        try {

            System.out.println("crat ing new 3 students object ");
            Student  student = new Student ("ehsan", "mhmvd", "pp@gmail.com");
            Student  student1 = new Student ("lala", "mahoo", "ee@gmail.com");
            Student  student2= new Student ("emir", "shafig", "maz@gmail.com");

            session.beginTransaction();
            System.out.println("saving the stu");
            session.save(student);
            System.out.println("saving the stu1");
            session.save(student1);
            System.out.println("saving the stu2");
            session.save(student2);

            session.getTransaction().commit();
            System.out.println("done");

        }
        finally {
            factory.close();
        }

    }
}
