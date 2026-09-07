package com.atm.main;

import java.sql.Connection;

import com.atm.util.Dbconnet;

public class Dbatmtest {

    public static void main(String[] args) {

        try {

            Connection connection =
                    Dbconnet.getConnection();

            System.out.println("Database connected successfully!");

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}