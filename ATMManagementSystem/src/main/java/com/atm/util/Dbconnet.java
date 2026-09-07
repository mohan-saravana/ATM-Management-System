package com.atm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnet {

    private static final String URL =
            "jdbc:mysql://localhost:3306/atmdb";

    private static final String USER =
            "root";

    private static final String PASSWORD =
            "200610";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}