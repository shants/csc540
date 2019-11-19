package db_utils;

import Utils.ViewerContext;
import config.DatabaseConnection;
import entities.Referral_Reason;
import entities.ReportRefererral;
import entities.Service;

import javax.swing.text.View;
import java.sql.*;
import java.util.ArrayList;

public class ReportCRUD {

    public static void reportReferral() {
        ReportRefererral rep = ViewerContext.getInstance().getPatientReport();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String report_table = "REPORT_REFERRAL";
        String query = "INSERT into " + report_table + " (REPORT_ID, STAFF_ID, FACILITY_ID)" +
                "values( ? , ?, ? )";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,  rep.getReport_id());
            ps.setInt(2, rep.getStaff_id());
            ps.setInt(3, rep.getFacility_id());
            ps.execute();
            ViewerContext.getInstance().setPatientReport(rep);
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting for report referral " +e.getMessage());
        } finally {
            DatabaseConnection.getInstance().finallyHandler(ps);
        }
    }

    public static void addReferralReason() {
        int reason_id = -1;
        ReportRefererral rep = ViewerContext.getInstance().getPatientReport();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String report_table = "REPORT_REFERRAL_REASON";
        String query = "INSERT into " + report_table + " (REPORT_ID, REASON_CODE, " +
                "REASON_DESCRIPTION, SERVICE_CODE)" + "values( ? , ? , ? , ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Referral_Reason> referral_reasons = ViewerContext.getInstance().getPatientReport().getReferralReasons();
        int entries = referral_reasons.size();
        for(int i=0; i< entries; i++) {
            try {
                ps = connection.prepareStatement(query, new String[]{"REASON_ID"});
                ps.setInt(1, rep.getReport_id());
                ps.setInt(2, referral_reasons.get(i).getReason_code());
                ps.setString(3, referral_reasons.get(i).getReason_string());
                ps.setString(4, referral_reasons.get(i).getService_code());
                ps.execute();
                rs = ps.getGeneratedKeys();
                if (rs.next())
                    reason_id = rs.getInt(1);
                rep.setReason_id(reason_id);
                ViewerContext.getInstance().setPatientReport(rep);
            } catch (SQLException e) {
                System.out.println("Error occurred while inserting for referral reason " + e.getMessage());
            } finally {
                DatabaseConnection.getInstance().finallyHandler(ps, rs);
            }
        }
    }

    public static void addPatientReport() {
        int report_id = -1;
        ReportRefererral rep = ViewerContext.getInstance().getPatientReport();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String report_table = "REPORT";
        String query = "INSERT into " + report_table + " (NEG_EXP_ID, NEGATIVE_EXPERIENCE_TEXT, " +
                "TREATMENT, VISIT_ID, DISCHARGE_STATUS) " + "values( ? , ? , ? , ? , ? )";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(query, new String[]{"REPORT_ID"});
            ps.setInt(1,  rep.getNegative_experience_value());
            ps.setString(2, rep.getNegative_experience_text());
            ps.setString(3, rep.getTreatment());
            ps.setInt(4, rep.getVisit_id());
            ps.setString(5, rep.getDischarge_status());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if(rs.next())
                report_id = rs.getInt(1);
            rep.setReport_id(report_id);
            ViewerContext.getInstance().setPatientReport(rep);
        } catch (SQLException e) {
            System.out.println("Error occurred while inserting for add report for patient " +e.getMessage());
        } finally {
            DatabaseConnection.getInstance().finallyHandler(ps, rs);
        }
    }
}
