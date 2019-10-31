package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_files.PatientCRUD;
import entities.Address;
import entities.Patient;

public class SignIn extends IScreen {
        private Patient patient;
        private Address address;
        public void display() {
            System.out.println(MessageUtils.PATIENT_SIGNIN_LASTNAME);
            patient.setLastName(CommandLineUtils.ReadInput());
            System.out.println(MessageUtils.PATIENT_SIGNIN_CITY);
            address.setCityName(CommandLineUtils.ReadInput());
            System.out.println(MessageUtils.PATIENT_SIGNIN_DOB);
            patient.setDateOfBirth(CommandLineUtils.ReadInput());
        }

        public void run() {
            patient = new Patient();
            address = new Address();
        display();
        int facility_id = ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID) != null ?
                ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID) : 0;
        if(facility_id == 0) {
            System.out.println("Please select a facility to sign up for.");
            return;
        }
        PatientCRUD.signIn(facility_id, patient,address);
        }
}
