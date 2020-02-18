package com.company;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcurl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";

        try{
            System.out.println("Conection to db ");
            Connection conn = DriverManager.getConnection(jdbcurl,user,pass);
            System.out.println("successful connection");

        }
        catch (Exception e){
            System.out.println(e);


        }
    }
}
