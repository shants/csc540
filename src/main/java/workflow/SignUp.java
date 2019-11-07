package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_utils.PatientCRUD;
import entities.Address;
import entities.Patient;

public class SignUp extends IScreen {
    private Patient patient;
    private Address address;

    public void display() {
        System.out.println(MessageUtils.PATIENT_SIGNUP.PATIENT_SIGNUP_START.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.HOME_SIGN_UP);
        System.out.println(MessageUtils.PATIENT_SIGNUP.PATIENT_SIGNUP_GO_BACK.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_GO_BACK);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }

    public void displaySignUp() {
        System.out.println(MessageUtils.PATIENT_SIGNUP_FIRSTNAME);
        patient.setFirstName(CommandLineUtils.ReadInput());
        System.out.println(MessageUtils.PATIENT_SIGNUP_LASTNAME);
        patient.setLastName(CommandLineUtils.ReadInput());
        System.out.println(MessageUtils.ADDRESS_START);
        System.out.println(MessageUtils.ADDRESS_STREETNUM);
        address.setStreetNumber(CommandLineUtils.ReadInput());
        System.out.println(MessageUtils.ADDRESS_STREETNAME);
        address.setStreetName(CommandLineUtils.ReadInput());
        System.out.println(MessageUtils.ADDRESS_CITYNAME);
        address.setCityName(CommandLineUtils.ReadInput());
        System.out.println(MessageUtils.ADDRESS_STATENAME);
        address.setStateName(CommandLineUtils.ReadInput());
        System.out.println(MessageUtils.ADDRESS_COUNTRYNAME);
        address.setCountryName(CommandLineUtils.ReadInput());
        System.out.println(MessageUtils.PATIENT_SIGNUP_DOB);
        patient.setDateOfBirth(CommandLineUtils.ReadInput());
        System.out.println(MessageUtils.PATIENT_SIGNUP_PHONE_NUM);
        patient.setPhoneNumber(Integer.parseInt(CommandLineUtils.ReadInput()));
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
                MessageUtils.PATIENT_SIGNUP options = MessageUtils.PATIENT_SIGNUP.values()[option];
                switch (options) {
                    case PATIENT_SIGNUP_START:
                        patient = new Patient();
                        address = new Address();
                        displaySignUp();
                        int facility_id = ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID) != null ?
                                ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID) : 0;
                        if(facility_id == 0) {
                            System.out.println("Please select a facility to sign up for.");
                            return;
                        }
                        patient.setFacilityId(facility_id);
                        PatientCRUD.signUp(patient,address);
                        break;
                    case PATIENT_SIGNUP_GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.Home);
                        break;
                    default:
                        invalidOption = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                invalidOption = true;
            }
        } while (invalidOption);
    }
}
