package db_files;

import config.DatabaseConnection;
import entities.MedicalFacility;

import java.sql.*;
import java.util.ArrayList;

public class FacilityCRUD {
    public static void callPatientsTableProcedure(int facility_id) {
        Connection connection = DatabaseConnection.getInstance().getConnection();
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
        Connection connection = DatabaseConnection.getInstance().getConnection();
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

    public static ArrayList<MedicalFacility> read() {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "select  *  from facility";
        ArrayList<MedicalFacility> lstFacility = new ArrayList<MedicalFacility>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                MedicalFacility m = new MedicalFacility();
                m.setName(rs.getString("FACILITY_NAME"));
                m.setId(rs.getInt("FACILITY_ID"));
                lstFacility.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lstFacility;
    }
}
