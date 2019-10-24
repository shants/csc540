package main.java.db_files;

import main.java.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseCRUD {
    public static void executeSingleUpdate(String query) throws SQLException {
        Connection connection = new DatabaseConnection().getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            try {
                statement.close();
            }
            catch (SQLException e) {
                throw e;
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
