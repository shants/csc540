package config;

import workflow.PatientRouting;

import java.sql.ResultSet;
import java.sql.Statement;


public class ConnectionTest {
    public static void main(String[] Args){
        System.out.println("Hello World");
        dummyQuery();
    }

    public static void dummyQuery(){
        DatabaseConnection connection = DatabaseConnection.getInstance();
        try {
        String query = "select * from dummy";
            Statement stmt = connection.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Result");
            System.out.println(rs);
            while (rs.next()){
                System.out.println("Query Result");
                System.out.println(rs);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        connection.destroyConnection();
    }
}
