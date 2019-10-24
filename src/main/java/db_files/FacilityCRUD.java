package main.java.db_files;

import main.java.config.DatabaseConnection;

import java.sql.*;

public class FacilityCRUD {
    public static void callPatientsTableProcedure(int facility_id) {
        Connection connection = new DatabaseConnection().getConnection();
        CallableStatement statement;
        String procedure_call = "{call create_new_patient_tables(?)}";
        try {
            statement = connection.prepareCall(procedure_call);
            statement.setInt(1,facility_id);
            statement.execute();
            System.out.println("Procedure to create new patients' tables executed.");
        } catch (SQLException e) {
            System.out.println("Unable to run patient's table procedure:"+e.getMessage());
        }
    }

    public static void createNewFacility() {
        Connection connection = new DatabaseConnection().getConnection();
        String new_facility = "INSERT INTO MEDICAL_FACILITY (name, capacity, classification_id, facility_address_id)"+
                " VALUES(?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(new_facility,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,"");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
