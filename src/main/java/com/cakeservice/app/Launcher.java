
package com.cakeservice.app;

import javafx.application.Application;

import java.sql.*;

public class Launcher {
    public static void main(String[] args) {

        try {
            String sql = "select name from product where id=8";
            String url = "jdbc:mysql://localhost:3306/cake_service_db";
              String username = "javaprojectuser";
            String password = "0000";
            Connection con = DriverManager.getConnection(url, username, password);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        Application.launch(HelloApplication.class, args);


    }
}
