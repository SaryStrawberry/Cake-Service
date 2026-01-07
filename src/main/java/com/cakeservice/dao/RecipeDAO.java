package com.cakeservice.dao;

import com.cakeservice.db.Database;
import com.cakeservice.model.Cake;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecipeDAO {
    public Cake getRecipeByName(String recipeName) throws SQLException, IOException {

        String sql = "SELECT * FROM recipes WHERE recipe_name = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, recipeName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Cake(
                        rs.getString("recipe_name"),
                        rs.getString("batter"),
                        rs.getString("frosting"),
                        rs.getString("topping"),
                        rs.getInt("prep_time"),
                        rs.getDouble("cost")
                );
            }
        }
        return null;
    }
}
