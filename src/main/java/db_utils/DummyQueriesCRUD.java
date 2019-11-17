package db_utils;

import config.DatabaseConnection;
import entities.Symptom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DummyQueriesCRUD {
    public static ArrayList<ArrayList<String>> query1(){
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "SELECT V.facility_id, P.first_name, P.last_name, V.start_time, V.discharge_date, T.neg_exp " +
                "FROM  (select visit_id, negative_experience_text AS neg_exp " +
                "FROM report WHERE neg_exp_id IS NOT NULL AND negative_experience_text IS NOT NULL) T, " +
                "visit V, patient P WHERE V.visit_id = T.visit_id AND P.patient_id = V.patient_id";
        ArrayList<String> header = new ArrayList<>();
        header.add("Facility ID");
        header.add("First Name");
        header.add("Last Name");
        header.add("Start Time");
        header.add("Discharge Date");
        header.add("Negative Experience");
        results.add(header);
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()){
                ArrayList<String> row = new ArrayList<>();
                row.add(String.valueOf(rs.getInt("FACILITY_ID")));
                row.add(rs.getString("FIRST_NAME"));
                row.add(rs.getString("LAST_NAME"));
                row.add(rs.getTimestamp("START_TIME").toString());
                row.add(rs.getTimestamp("DISCHARGE_DATE").toString());
                row.add(rs.getString("NEG_EXP"));
                results.add(row);
            }
        } catch (SQLException e) {
            System.out.println("Error while executing query 1: " + e.getMessage());
        } finally {
            DatabaseConnection.getInstance().finallyHandler(stmt, rs);
        }
        return results;
    }
}
