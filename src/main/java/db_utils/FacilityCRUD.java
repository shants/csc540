package db_utils;

import Utils.CommandLineUtils;
import Utils.MessageUtils;
import Utils.ViewerContext;
import config.DatabaseConnection;
import entities.Address;
import entities.Facility;

import java.sql.*;
import java.util.ArrayList;

public class FacilityCRUD {
    public static void createNewFacility(Facility facility, Address address) {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        CallableStatement statement=null;
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
        } finally {
            DatabaseConnection.getInstance().finallyHandler(statement);
        }

    }

    public static ArrayList<Facility> readAll() {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "select  *  from facility";
        ArrayList<Facility> lstFacility = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Facility m = new Facility();
                m.setName(rs.getString("FACILITY_NAME"));
                m.setId(rs.getInt("FACILITY_ID"));
                lstFacility.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.getInstance().finallyHandler(stmt, rs);
        }
        return lstFacility;
    }

    public static void selectFacility() {
        boolean invalid;
        ArrayList<Facility> facilityList = FacilityCRUD.readAll();
        do {
            invalid = false;
            System.out.println(MessageUtils.GLOBAL_SELECT_FACILITY);
            for (int i = 0; i < facilityList.size(); i++) {
                System.out.println(i + MessageUtils.GLOBAL_DELIMITER + facilityList.get(i).getName());
            }
            System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
            String opt = CommandLineUtils.ReadInput();
            try {
                int option = Integer.parseInt(opt);
                if (option >= facilityList.size()) {
                    System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                    invalid = true;
                } else {
                    ViewerContext.getInstance().addValue(facilityList.get(option).getId(), ViewerContext.IDENTIFIER_TYPES.FACILITY_ID);
                }
            } catch (Exception e) {
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                invalid = true;
            }
        }while(invalid);
    }
}
