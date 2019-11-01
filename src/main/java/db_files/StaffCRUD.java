package db_files;

import config.DatabaseConnection;
import entities.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StaffCRUD {
    public static boolean isMedicalStaff(Staff staff) {
        boolean isMedical = false;
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "SELECT staff_id from staff_" + staff.getFacilityID() +
                        " inner join staff_department_type on staff_" + staff.getFacilityID() +
                        ".type_id = staff_department_type.type_id where type_name = ? " +
                        " and staff_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,"MEDICAL");
            statement.setInt(2,staff.getStaff_id());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                isMedical = true;
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error occured while checking for medical staff:"+e.getMessage());
        }
        return isMedical;
    }
}
