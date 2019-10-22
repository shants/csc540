import java.sql.*;
import java.util.*;

public class Connection
{

    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";





    public static void main(String[] Args){
        System.out.println("Hello World");
        dummyQuery();
    }

    public static void dummyQuery(){
        try {
            String user = "ssharm34";
            String passwd = "200255931";

            Class.forName(JDBC_DRIVER);
            java.sql.Connection con=DriverManager.getConnection(
                    DB_URL,user, passwd);
            String query = "select * from dummy";
            Statement stmt = con.createStatement();
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
    }


}