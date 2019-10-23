import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class Connection
{
    private static Connection instance = null;
    private static java.sql.Connection connection = null;

    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }


    public java.sql.Connection getConnection(){
        return connection;
    }

    public void destroyConnection(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error while closing connection:"+ e.getMessage());
            }
        }
    }

    public Connection(){
        try(InputStream input = new FileInputStream("src/resources/db.properties")){
            Properties props = new Properties();
            props.load(input);
            try {
                Class.forName(props.getProperty("db.driverClassName"));
                connection = DriverManager.getConnection(
                        props.getProperty("db.url"),
                        props.getProperty("db.username"),
                        props.getProperty("db.password"));
                System.out.println("Connection established.");
            }catch(Exception e) {
                System.out.println("Problems while connecting to database:"+e.getMessage());
            }
        }
        catch(IOException e){
            System.out.println("Cannot read properties"+e.getMessage());
        }
    }
}