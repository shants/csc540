package main.java.workflow;
import main.java.db_files.FacilityCRUD;

public class MainFlow{
    public static void main(String[] args){
        FacilityCRUD.callPatientsTableProcedure(8888);
//        PatientsCRUD.checkIfPatientTableExistsElseCreate(1);
    }
}
