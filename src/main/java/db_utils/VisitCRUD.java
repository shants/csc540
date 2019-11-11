package db_utils;

import Utils.ViewerContext;
import config.DatabaseConnection;
import entities.Facility;
import entities.Symptom;
import entities.Visit;

import java.sql.*;
import java.util.ArrayList;

public class VisitCRUD {

    public static ArrayList<Visit> getPatientsToTreat(Facility facility) {
        ArrayList<Visit> records = new ArrayList<>();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String visit_table = "VISIT_" + facility.getId();
        String query = "SELECT PATIENT_ID, VISIT_ID, START_TIME, END_TIME from " + visit_table + " where END_TIME IS NOT NULL and IS_TREATED IS NULL";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Visit visit = new Visit();
                visit.setPatient_id(rs.getInt("PATIENT_ID"));
                visit.setVisit_id(rs.getInt("VISIT_ID"));
                visit.setStart_time(rs.getTimestamp("START_TIME").toString());
                visit.setEnd_time(rs.getTimestamp("END_TIME").toString());
                records.add(visit);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching patients to treat:"+e.getMessage());
        }
        return records;
    }

    public static ArrayList<Visit> getCheckedInPatient(Facility facility) {
        ArrayList<Visit> records = new ArrayList<>();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String visit_table = "VISIT_" + facility.getId();
        String query = "SELECT PATIENT_ID, VISIT_ID, START_TIME from " + visit_table + " where END_TIME IS NULL";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Visit visit = new Visit();
                visit.setPatient_id(rs.getInt("PATIENT_ID"));
                visit.setVisit_id(rs.getInt("VISIT_ID"));
                visit.setStart_time(rs.getTimestamp("START_TIME").toString());
                records.add(visit);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching checked-in patients :"+e.getMessage());
        }
        return records;
    }

    public static void completeVitalsUpdate(Visit visit) {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "UPDATE VISIT_"+visit.getFacilityID() + " SET " +
                "END_TIME = to_timestamp(?,'YYYY/MM/DD HH24:MI'), BP_LOW = ?, BP_HIGH = ?, "+
                " BODY_TEMPERATURE = ?, PRIORITY_ID = ? WHERE VISIT_ID = ?";
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, visit.getEnd_time());
            statement.setFloat(2,visit.getBp_low());
            statement.setFloat(3,visit.getBp_high());
            statement.setFloat(4,visit.getBody_temp());
            statement.setInt(5, visit.getPriority_id());
            statement.setInt(6,visit.getVisit_id());
            statement.executeUpdate();
            System.out.println("Saved vitals. Checkin complete.");
        } catch (SQLException e) {
            System.out.println("Unable to complete entering vitals for patient:"+e.getMessage());
        }
    }

    public static ArrayList<Visit> getTreatedPatientsToCheckout(Facility facility) {
        ArrayList<Visit> records = new ArrayList<>();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String visit_table = "VISIT_" + facility.getId();
        String query = "SELECT PATIENT_ID, VISIT_ID, START_TIME, END_TIME from " + visit_table + " where IS_TREATED = 'Y'";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Visit visit = new Visit();
                visit.setPatient_id(rs.getInt("PATIENT_ID"));
                visit.setVisit_id(rs.getInt("VISIT_ID"));
                visit.setStart_time(rs.getTimestamp("START_TIME").toString());
                visit.setEnd_time(rs.getTimestamp("END_TIME").toString());
                records.add(visit);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching treated patients:"+e.getMessage());
        }
        return records;
    }

    public static boolean isCheckedIn() {
        Integer pid = ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.PATIENT_ID);
        if (pid == null){
            return false;
        }

        Integer fid = ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID);
        if (fid == null){
            return false;
        }

        Connection connection = DatabaseConnection.getInstance().getConnection();
        String visit_table = "VISIT_" + fid.toString();
        String query = "SELECT count(*) from " + visit_table + " where IS_TREATED is null " +
                "and END_TIME is null and PATIENT_ID = " + pid.toString();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                // if in the loop atleast 1 entry exists => pateint already checked in
                if (rs.getInt("COUNT(*)")==0){
                    return false;
                }
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching patient, facility, visit " +e.getMessage());
        }

        return false;
    }

    public static boolean insertCheckInInfo() {
        int visit_id = -1;
        Integer pid = ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.PATIENT_ID);
        if (pid == null){
            return false;
        }

        Integer fid = ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID);
        if (fid == null){
            return false;
        }

        Connection connection = DatabaseConnection.getInstance().getConnection();
        String visit_table = "VISIT_" + fid.toString();
        String query = "INSERT into " + visit_table + " (PATIENT_ID, START_TIME) " +
                "values( ? , ? )";
        try {
            PreparedStatement ps = connection.prepareStatement(query, new String[]{"VISIT_ID"});
            ps.setInt(1, fid);
            ps.setTimestamp(2,  new java.sql.Timestamp(System.currentTimeMillis()));

            boolean row_affected  = ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next())
                visit_id = rs.getInt(1);
                ViewerContext.getInstance().addValue(visit_id, ViewerContext.IDENTIFIER_TYPES.VISIT_ID);
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting for check_in " +e.getMessage());
        }

        return false;
    }

    public static ArrayList<Symptom> getPatientSymptoms(Visit visit) {
        ArrayList<Symptom> results = new ArrayList<>();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String visit_table = "PATIENT_SYMPTOMS_" + visit.getFacilityID();
        String query = "SELECT symptom.symptom_code, symptom.symptom_name, severity_value from " + visit_table + " INNER JOIN SYMPTOM on "+visit_table+
                    ".symptom_code = SYMPTOM.symptom_code where VISIT_ID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, visit.getVisit_id());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Symptom symptom = new Symptom();
                symptom.setSymptom_code(rs.getString("SYMPTOM_CODE"));
                symptom.setSymptom_name(rs.getString("SYMPTOM_NAME"));
                symptom.setSeverityValue(rs.getString("SEVERITY_VALUE"));
                results.add(symptom);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching symptoms" +e.getMessage());
        }
        return results;
    }
}
