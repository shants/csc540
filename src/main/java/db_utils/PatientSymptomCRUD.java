package db_utils;

import Utils.ViewerContext;
import config.DatabaseConnection;
import entities.PatientSymptom;
import entities.Symptom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;

public class PatientSymptomCRUD {
    public static boolean addPatientSymptoms(){
        // add patient symptoms
        ArrayList<PatientSymptom> arr =  ViewerContext.getInstance().getSymptoms();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "insert into PATIENT_SYMPTOMS (VISIT_ID," +
                "SYMPTOM_CODE," +
                "SEVERITY_VALUE," +
                "POST_EVENT," +
                "IS_RECURRING," +
                "DURATION) values (?, ?, ?, ?, ?, ?)";
        try {
            int visit_id = ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.VISIT_ID);
            PreparedStatement ps = connection.prepareStatement(sql);
            for (PatientSymptom sym : arr) {
                ps.setInt(1, visit_id);
                ps.setString(2, sym.getSymptom().getSymptom_code());
                ps.setString(3, sym.getSeverityValue());
                ps.setString(4, sym.getPostEvent());
                ps.setString(5, sym.getIsRecurring());
                ps.setInt(6, sym.getDuration());
                ps.addBatch();
            }
            ps.executeBatch();
        }catch ( SQLException e){
            e.printStackTrace();
        }
        return true;
    }
}
