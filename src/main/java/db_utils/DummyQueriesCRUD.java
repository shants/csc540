package db_utils;

import config.DatabaseConnection;

import java.sql.*;
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

    public static ArrayList<ArrayList<String>> query3() {
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "select y.* from ( " +
                " select max(count) as maxval, facility_id from  " +
                "( " +
                "    select COUNT(referred_facility) as count, a.facility_id, referred_facility from  " +
                "    ( " +
                "        select facility_id from facility " +
                "    ) a " +
                "  left outer join  " +
                "    ( " +
                "      select r.facility_id as referred_facility, s.facility_id as facility_id from report_referral r inner join staff s on r.staff_id = s.staff_id " +
                "    ) b " +
                "  on a.facility_id = b.facility_id GROUP BY (a.facility_id, referred_facility) ORDER BY (COUNT(referred_facility)) DESC " +
                ") group by facility_id " +
                ") x  " +
                "inner join " +
                "(select COUNT(referred_facility) as count, a.facility_id, referred_facility from  " +
                "    ( " +
                "        select facility_id from facility " +
                "    ) a " +
                "  left outer join  " +
                "    ( " +
                "      select r.facility_id as referred_facility, s.facility_id as facility_id from report_referral r inner join staff s on r.staff_id = s.staff_id " +
                "    ) b " +
                "  on a.facility_id = b.facility_id GROUP BY (a.facility_id, referred_facility) ORDER BY (COUNT(referred_facility)) " +
                ") y on x.facility_id = y.facility_id and x.maxval = y.count";
        ArrayList<String> header = new ArrayList<>();
        header.add("FACILITY ID");
        header.add("REFERRED FACILITY ID");
        results.add(header);
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()){
                ArrayList<String> row = new ArrayList<>();
                row.add(String.valueOf(rs.getInt("FACILITY_ID")));
                row.add(String.valueOf(rs.getInt("REFERRED_FACILITY")));
                results.add(row);
            }
        } catch (SQLException e) {
            System.out.println("Error while executing query 3: " + e.getMessage());
        } finally {
            DatabaseConnection.getInstance().finallyHandler(stmt, rs);
        }
        return results;

    }
    
    
    public static ArrayList<String> query4() {
        String query = "SELECT V.facility_id FROM visit V, patient_symptoms S " +
                "WHERE V.visit_id IN (SELECT R.visit_id FROM report R WHERE R.neg_exp_id = 0) " +
                "AND V.visit_id = S.visit_id AND S.symptom_code in (select symptom_code from " +
                "symptom_body_part where body_part_code = (select body_part_code from body_part where name = ?))";
        ArrayList<String> results = new ArrayList<>();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1,"HEART");
            rs = statement.executeQuery();
            results.add("FACILITY_ID");
            while(rs.next()) {
                results.add(String.valueOf(rs.getInt("FACILITY_ID")));
            }
        } catch (SQLException e) {
            System.out.println("Error while executing query 4 :"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().finallyHandler(statement, rs);
        }
        return  results;
    }

    public static ArrayList<String> query5() {
        String query = "SELECT facility_id from ( SELECT COUNT(facility_id), facility_id from "+
                " report inner join visit on report.visit_id = visit.visit_id where neg_exp_id <> 0 "+
                " GROUP BY FACILITY_ID ORDER BY COUNT(facility_id) DESC ) where rownum <= 1";
        ArrayList<String> results = new ArrayList<>();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(query);
            rs = statement.executeQuery();
            results.add("FACILITY_ID");
            while(rs.next()) {
                results.add(String.valueOf(rs.getInt("FACILITY_ID")));
            }
        } catch (SQLException e) {
            System.out.println("Error while executing query 5 :"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().finallyHandler(statement, rs);
        }
        return  results;
    }
}
