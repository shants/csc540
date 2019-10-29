package db_files;

import config.DatabaseConnection;
import entities.Address;
import entities.Facility;

import java.sql.*;
import java.util.ArrayList;

public class FacilityCRUD {
    public static void createNewFacility(Facility facility, Address address) {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        CallableStatement statement;
        String procedure_call = "{call create_new_facility(?,?,?,?,?,?,?,?)}";
        try {
            statement = connection.prepareCall(procedure_call);
            statement.setString(1,address.getStreetName());
            statement.setString(2,address.getCityName());
            statement.setString(3,address.getStateName());
            statement.setString(4,address.getCountryName());
            statement.setString(5,address.getStreetNumber());
            statement.setString(6,facility.getName());
            statement.setString(7,facility.getClassification());
            statement.setInt(8, facility.getCapacity());
            statement.execute();
            System.out.println("New facility created");
        } catch (SQLException e) {
            System.out.println("Unable to create new facility:"+e.getMessage());
        }
    }

    public static ArrayList<Facility> read() {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "select  *  from facility";
        ArrayList<Facility> lstFacility = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Facility m = new Facility();
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
