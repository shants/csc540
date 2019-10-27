package db_files;
import config.DatabaseConnection;
import entities.Address;
import entities.Patient;

import java.sql.*;

public class PatientsCRUD
{
    public static void signUp(int facility_id, Patient patient, Address address) {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        PreparedStatement statement;
        String query ="INSERT INTO PATIENT_ADDRESS_"+facility_id+" ()";
        try {
            statement = connection.prepareStatement(query);
        }catch (SQLException e){

        }
    }
}