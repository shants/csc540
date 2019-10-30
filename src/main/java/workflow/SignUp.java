package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import db_files.PatientCRUD;
import entities.Address;
import entities.Patient;
import entities.ViewerContext;

public class SignUp extends IScreen {
    private Patient patient;
    private Address address;
    public void display() {
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
        patient = new Patient();
        address = new Address();
        display();
        int facility_id = ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID) != null ?
                ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID) : 0;
        if(facility_id == 0) {
            System.out.println("Please select a facility to sign up for.");
            return;
        }
        PatientCRUD.signUp(facility_id, patient,address);
    }
}
