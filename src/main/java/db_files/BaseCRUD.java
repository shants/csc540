package db_files;

import config.DatabaseConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseCRUD {
    public static void executeSingleUpdate(String query) throws SQLException {
        Connection connection = DatabaseConnection.getInstance().getConnection();
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
