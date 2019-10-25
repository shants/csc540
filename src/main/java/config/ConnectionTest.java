package config;

import Utils.StackFrame;
import config.DatabaseConnection;
import workflow.PatientRouting;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Stack;


public class ConnectionTest {
    public static void main(String[] Args){
        System.out.println("Hello World");
        //dummyQuery();
        StackFrame _globalStackFrame = StackFrame.getInstance();

        PatientRouting p = new PatientRouting();
        _globalStackFrame.addFrame(p);
        p.run();
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
