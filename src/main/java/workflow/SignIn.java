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
            System.out.println(MessageUtils.PATIENT_SIGNIN.PATIENT_SIGNIN_START.ordinal()
                    + MessageUtils.GLOBAL_SPACE + MessageUtils.HOME_SIGN_IN);
            System.out.println(MessageUtils.PATIENT_SIGNIN.PATIENT_SIGNIN_GO_BACK.ordinal()
                    + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_GO_BACK);
            System.out.println(MessageUtils.GLOBAL_NEWLINE);
            System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
        }

    public void displaySignIn() {
        System.out.println(MessageUtils.PATIENT_SIGNIN_LASTNAME);
        patient.setLastName(CommandLineUtils.ReadInput());
        System.out.println(MessageUtils.PATIENT_SIGNIN_CITY);
        address.setCityName(CommandLineUtils.ReadInput());
        System.out.println(MessageUtils.PATIENT_SIGNIN_DOB);
        patient.setDateOfBirth(CommandLineUtils.ReadInput());
    }

        public void run() {
            boolean invalidOption;
            do {
                invalidOption = false;
                int option;
                display();
                String opt = CommandLineUtils.ReadInput();
                try {
                    option = Integer.parseInt(opt);
                    MessageUtils.PATIENT_SIGNIN options = MessageUtils.PATIENT_SIGNIN.values()[option];
                    switch (options) {
                        case PATIENT_SIGNIN_START:
                            patient = new Patient();
                            address = new Address();
                            displaySignIn();
                            int facility_id = ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID) != null ?
                                    ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID) : 0;
                            if(facility_id == 0) {
                                System.out.println("Please select a facility to sign in for.");
                                return;
                            }
                            PatientCRUD.signIn(facility_id, patient,address);
                            break;
                        case PATIENT_SIGNIN_GO_BACK:
                            break;
                        default:
                            invalidOption = true;
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                    invalidOption = true;
                }
            } while (invalidOption);
        }
}
