package db_utils;

import config.DatabaseConnection;
import entities.NegExperience;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NegativeExperienceCRUD {
    public static ArrayList<NegExperience> readAll() {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "select  *  from negative_experience";
        ArrayList<NegExperience> lstNegativeExp = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                NegExperience m = new NegExperience();
                m.setNegExpId(rs.getInt("NEG_EXP_ID"));
                m.setExpName(rs.getString("EXP_NAME"));
                lstNegativeExp.add(m);
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return lstNegativeExp;
    }

}
