package main.workflow;
import main.db_files.PatientsCRUD;
//import java.sql.SQLException;

public class MainFlow{
    public static void main(String[] args){

        PatientsCRUD.checkIfPatientTableExistsElseCreate(1);
//        try {
//            PatientsCRUD.executeUpdates("drop table present_1");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
