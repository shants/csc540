package db_utils;

import Utils.ViewerContext;
import config.DatabaseConnection;
import entities.Staff;
import entities.Visit;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffCRUD {
    public static boolean isMedicalStaff(Staff staff) {
        boolean isMedical = false;
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "SELECT staff_id from staff inner join staff_department_type on staff" +
                        ".type_id = staff_department_type.type_id where type_name = ? " +
                        " and staff_id = ? and facility_id = ?";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1,"MEDICAL");
            statement.setInt(2,staff.getStaff_id());
            statement.setInt(3,staff.getFacilityID());
            rs = statement.executeQuery();
            if (rs.next()) {
                isMedical = true;
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while checking for medical staff:"+e.getMessage());
        }finally {
            DatabaseConnection.getInstance().finallyHandler(statement, rs);
        }
        return isMedical;
    }

    public static boolean canTreatPatient(Visit visit) {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        boolean canTreat = false;
        String query = "SELECT a.body_part_code from "+
            " (SELECT body_part_code from serv_dept_spec"+
            " where service_dept_code in (select service_dept_code from "+
            " staff_in_serv_dept where staff_id = ?)) a "+
            " inner join (select body_part_code from patient_symptoms"+
            " inner join symptom_body_part on patient_symptoms.symptom_code "+
            "= symptom_body_part.symptom_code where visit_id = ?) b on a.body_part_code "+
            " = b.body_part_code";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1,1);
            statement.setInt(2,visit.getVisit_id());
            rs = statement.executeQuery();
            if (rs.next()) {
                canTreat = true;
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while checking staff's ability to treat patient:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().finallyHandler(statement, rs);
        }
        return canTreat;
    }

    public static void treatPatient(Visit visit) {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "UPDATE VISIT SET IS_TREATED = 'Y' WHERE VISIT_ID = ? and facility_id = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1,visit.getVisit_id());
            statement.setInt(2,visit.getFacilityID());
            statement.executeUpdate();
            System.out.println("Patient treated. Updated Status in records. ");
        } catch (SQLException e) {
            System.out.println("Unable to treat patient:"+e.getMessage());
        } finally {
            DatabaseConnection.getInstance().finallyHandler(statement);
        }
    }

    public static void signin(Staff staff) {
        int staff_id;
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "SELECT staff_id from STAFF where name = ? and facility_id = ?";
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1,staff.getName());
            statement.setInt(2,staff.getFacilityID());
            rs = statement.executeQuery();
            if (rs.next()) {
                staff_id = rs.getInt("STAFF_ID");
                ViewerContext.getInstance().addValue(staff_id, ViewerContext.IDENTIFIER_TYPES.STAFF_ID);
            }
            else {
                System.out.println("No records found. Please try again.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while signing in:"+e.getMessage());
        }finally {
            DatabaseConnection.getInstance().finallyHandler(statement, rs);
        }
    }
}
