package db_utils;

import config.DatabaseConnection;
import entities.AssessmentRule;
import entities.Symptom;
import entities.SymptomSeverity;
import entities.Visit;

import java.sql.*;
import java.util.ArrayList;

public class AssessmentRuleCRUD {
    public static ArrayList<AssessmentRule> getRules(Visit visit, ArrayList<Symptom> symptoms) {
        ArrayList<AssessmentRule> rules = new ArrayList<>();
        Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;
        String rules_symptom_table = "RULES_SYMPTOMS";
        String asses_rules_table = "ASSES_RULES";
        StringBuilder query = new StringBuilder("SELECT symptom.symptom_code, symptom.symptom_name, a.asses_rule, "+
                " type from (SELECT symptom_code, asses_rule, priority_id from " + asses_rules_table +
                " inner join " + rules_symptom_table + " on " + asses_rules_table + ".rule_id = " + rules_symptom_table +
                ".rule_id where symptom_code in (");
        for (int x = 0; x < symptoms.size(); x++) {
            query.append("?");
            if (x != symptoms.size()-1) {
                query.append(",");
            }
        }
        query.append(")) a inner join symptom on a.symptom_code = symptom.symptom_code inner join priority using(priority_id)");
        try {
            statement = connection.prepareStatement(query.toString());
            for (int x = 1; x <= symptoms.size(); x++) {
                statement.setString(x, symptoms.get(x-1).getSymptom_code());
            }
            rs = statement.executeQuery();
            while (rs.next()) {
                AssessmentRule rule = new AssessmentRule();
                rule.setPriority(rs.getString("TYPE"));
                rule.setRule(rs.getString("ASSES_RULE"));
                Symptom s = new Symptom();
                s.setSymptom_code(rs.getString("SYMPTOM_CODE"));
                s.setSymptom_name(rs.getString("SYMPTOM_NAME"));
                rule.setSymptom(s);
                rules.add(rule);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching assessment rules" +e.getMessage());
        } finally {
            DatabaseConnection.getInstance().finallyHandler(statement, rs);
        }
        return rules;
    }

    public static void AddRules(SymptomSeverity symptom_severity, AssessmentRule rule){

        Connection connection = DatabaseConnection.getInstance().getConnection();
        CallableStatement statement;
        String procedure_call = "{call add_assesment_rules(?,?,?,?)}";
        try {
            statement = connection.prepareCall(procedure_call);
            statement.setInt(1, symptom_severity.getStaffID());
            statement.setString(2,rule.getRule());
            statement.setString(3,rule.getSymptom().getSymptom_code());
            statement.setInt(4,rule.getPriorityID());
            statement.execute();
            System.out.println("New Assesment rule Added.");
        } catch (SQLException e) {
            System.out.println("Unable to add a new Assesment rule:"+e.getMessage());
        }
    }
}