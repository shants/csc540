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
        ArrayList<Symptom> syms = ViewerContext.getInstance().getSymptomsForCheckin();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "insert into PATIENT_SYMPTOMS (VISIT_ID," +
                "SYMPTOM_CODE," +
                "SEVERITY_VALUE," +
                "POST_EVENT," +
                "IS_RECURRING," +
                "DURATION) values (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            int visit_id = ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.VISIT_ID);
            ps = connection.prepareStatement(sql);
            for (int x = 0; x< arr.size(); x ++) {
                ps.setInt(1, visit_id);
                ps.setString(2, syms.get(x).getSymptom_code());
                ps.setString(3, arr.get(x).getSeverityValue());
                ps.setString(4, arr.get(x).getPostEvent());
                ps.setString(5, arr.get(x).getIsRecurring());
                ps.setInt(6, arr.get(x).getDuration());
                ps.addBatch();
            }
            ps.executeBatch();
        }catch ( SQLException e){
            e.printStackTrace();
        } finally {
            DatabaseConnection.getInstance().finallyHandler(ps);
        }
        return true;
    }
}
