package db_files;

import config.DatabaseConnection;
import entities.Facility;
import entities.Symptom;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SymptomCRUD {
    public static ArrayList<Symptom> read(){
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "select  *  from symptom";
        ArrayList<Symptom> lstSymptom = new ArrayList<Symptom>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Symptom m = new Symptom();
                m.setSymptom_code(rs.getInt("SYMPTOM_CODE"));
                m.setSymptom_name(rs.getString("SYMPTOM_NAME"));
                lstSymptom.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lstSymptom;
    }
}
