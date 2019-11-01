package db_files;

import config.DatabaseConnection;
import entities.Facility;
import entities.Symptom;

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
}
