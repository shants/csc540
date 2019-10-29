package workflow;

import Utils.IScreen;
import db_files.PatientsCRUD;
import entities.Address;
import entities.Patient;

public class MainFlow{
    public static void main(String[] args){
        Patient patient = new Patient();
        Address address = new Address();
        patient.setLastName("Sharma");
        patient.setDateOfBirth("2019/10/24");
        address.setCityName("London");
        PatientsCRUD.signIn(1, patient,address);
//        IScreen scr = new Home();
//        scr.run();
    }
}
