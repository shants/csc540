package db_files;

import config.DatabaseConnection;
import entities.Facility;
import entities.Symptom;
import entities.SymptomSeverity;

import java.sql.*;
import java.util.ArrayList;

public class SymptomCRUD {
    public static ArrayList<Symptom> read() {
        Connection connection = DatabaseConnection.getInstance().getConnection();

        ArrayList<Symptom> lstSymptom = new ArrayList<>();
        try {
            String sql = "select * from symptom";
            PreparedStatement stmt1   = connection.prepareStatement(sql);
            ResultSet rs1 = stmt1.executeQuery();
            while (rs1.next()) {
                Symptom m = new Symptom();
                m.setSymptom_name(rs1.getString("SYMPTOM_NAME"));
                m.setSymptom_code(rs1.getString("SYMPTOM_CODE"));
                lstSymptom.add(m);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lstSymptom;
    }


    public static void  symptom_add(Symptom symptom, SymptomSeverity symptom_severity){

        Connection connection = DatabaseConnection.getInstance().getConnection();
        CallableStatement statement;
        String procedure_call = "{call add_new_symptom(?,?,?,?,?,)}";
        try {
            statement = connection.prepareCall(procedure_call);
            statement.setInt(1,symptom_severity.getFacilityID());
            statement.setInt(2,symptom_severity.getStaffID());
            statement.setString(3,symptom.getSymptom_name());
            statement.setString(4, symptom.getBodyPart().getBody_part());
            statement.setString(5,symptom_severity.getType());
            statement.execute();
            System.out.println("New Symptom added.");
        } catch (SQLException e) {
            System.out.println("Unable to add a new symptom:"+e.getMessage());
        }
    }
}
