package com.cakeservice.db;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.Properties;

public class Database {

    public static Connection getConnection() throws Exception {
        Properties properties = new Properties();

        try (InputStream in = Database.class.getClassLoader().getResourceAsStream("db,properties")) {
            properties.load(in);
        }

        return DriverManager.getConnection(
                properties.getProperty("db.url"),
                properties.getProperty("db.user"),
                properties.getProperty("db.password")
        );
    }
}

//This Database class will allow me to easily make connections to my database