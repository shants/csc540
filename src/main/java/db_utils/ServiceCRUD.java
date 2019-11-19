package db_utils;

import Utils.CommandLineUtils;
import Utils.MessageUtils;
import Utils.ViewerContext;
import config.DatabaseConnection;
import entities.Facility;
import entities.Service;

import javax.swing.text.View;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ServiceCRUD {
    public static ArrayList<Service> readAll() {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String sql = "select  *  from service";
        ArrayList<Service> servicelst = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Service s = new Service();
                s.setCode(rs.getString("SERVICE_CODE"));
                s.setName(rs.getString("NAME"));
                servicelst.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicelst;
    }

    public static String selectService() {
        boolean invalid;
        ArrayList<Service> serviceList = ServiceCRUD.readAll();
        do {
            invalid = false;
            System.out.println(MessageUtils.GLOBAL_SELECT_SERVICE);
            for (int i = 0; i < serviceList.size(); i++) {
                System.out.println(i + MessageUtils.GLOBAL_DELIMITER + serviceList.get(i).getName());
            }
            System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
            String opt = CommandLineUtils.ReadInput();
            try {
                int option = Integer.parseInt(opt);
                if (option >= serviceList.size()) {
                    System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                    invalid = true;
                } else {
                    return serviceList.get(option).getCode();
                }
            } catch (Exception e) {
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                invalid = true;
            }
        }while(invalid);
        return "";
    }
}
