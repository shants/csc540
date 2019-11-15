package db_utils;
import Utils.ViewerContext;
import config.DatabaseConnection;
import entities.Address;
import entities.Patient;

import java.sql.*;

public class PatientCRUD
{
    public static void signUp(Patient patient, Address address) {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        CallableStatement statement;
        String procedure_call = "{call sign_up_new_patient(?,?,?,?,?,?,?,?,?,?)}";
        try {
            statement = connection.prepareCall(procedure_call);
            statement.setInt(1,patient.getFacilityId());
            statement.setString(2,address.getStreetName());
            statement.setString(3,address.getCityName());
            statement.setString(4,address.getStateName());
            statement.setString(5,address.getCountryName());
            statement.setString(6,address.getStreetNumber());
            statement.setString(7,patient.getFirstName());
            statement.setString(8,patient.getLastName());
            statement.setString(9,patient.getDateOfBirth());
            statement.setInt(10,patient.getPhoneNumber());
            statement.execute();
            System.out.println("New Patient signed up.");
        } catch (SQLException e) {
            System.out.println("Unable to sign up a new patient:"+e.getMessage());
        }
    }

    public static void signIn(Patient patient, Address address) {
        int patient_id;
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String patient_table = "PATIENT";
        String patient_address_table = "PATIENT_ADDRESS";
        String query = "SELECT PATIENT_ID from (SELECT * from " + patient_table +
                    " inner join " + patient_address_table + " on " + patient_table +
                    ".patient_address_id = " + patient_address_table + ".patient_address_id) tbl inner join city " +
                    " on tbl.city_id = city.city_id where LAST_NAME = ? and CITY_NAME = ? and DATE_OF_BIRTH = to_date(?, 'yyyy/mm/dd')";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,patient.getLastName());
            statement.setString(2,address.getCityName());
            statement.setString(3,patient.getDateOfBirth());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                patient_id = rs.getInt("PATIENT_ID");
                ViewerContext.getInstance().addValue(patient_id, ViewerContext.IDENTIFIER_TYPES.PATIENT_ID);
            }
            else {
                System.out.println("No records found. Please try again.");
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while signing in:"+e.getMessage());
        }
    }
}
