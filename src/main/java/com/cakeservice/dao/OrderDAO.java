package com.cakeservice.dao;

import com.cakeservice.db.Database;
import com.cakeservice.model.Cake;
import com.cakeservice.model.Order;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAO {
    public Order getOrderFromId(int orderID) throws SQLException, IOException {
        String sql = "SELECT * FROM orders WHERE order_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, orderID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                RecipeDAO rd = new RecipeDAO();

                return new Order(
                        //The first attribute of an Order object is a Cake object. A RecipeDAO was created so its
                        //getRecipeByNAme() method could be called to create a Cake from the cake_name column of the
                        //orders table.
                        rd.getRecipeByName(rs.getString("cake_name")),
                        rs.getDate("creation_date").toLocalDate(),
                        rs.getDate("delivery_date").toLocalDate(),
                        rs.getString("delivery_location"),
                        rs.getString("message"),
                        rs.getDouble("final_cost")
                );
            }
        }
        return null;


    }
}
