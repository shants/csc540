package Utils;

public class MessageUtils {
    public static String ADDRESS_START = "Enter Address";
    public static String ADDRESS_STREETNUM = "Street number";
    public static String ADDRESS_STREETNAME = "Street name";
    public static String ADDRESS_CITYNAME = "City";
    public static String ADDRESS_STATENAME = "State";
    public static String ADDRESS_COUNTRYNAME = "Country";
    public static String ADD_REASON = "Enter Reason for Referral";
    public static String ENTER_FACILITY_ID = "Enter Facility-id";
    public static String ENTER_REFERRER_ID = "Enter Referrer-id";
    public static String GLOBAL_ACCESS_DENIED = "Access Denied";
    public static String GLOBAL_INADEQUATE_PRIVILEGES = "Inadequate Privileges";
    public static String GLOBAL_SPACE = " ";
    public static String GLOBAL_HYPHEN = "-";
    public static String GLOBAL_DELIMITER = ":";
    public static String GLOBAL_UNABLE_TO_HANDLE = "Unable to handle";
    public static String GLOBAL_PROPER_VALUE = "Please enter proper values";
    public static String GLOBAL_NEWLINE = "\n";
    public static String GLOBAL_ENTER_OPTION = "Enter Option";
    public static String GLOBAL_LOGIN_MESSAGE = "Please login to continue";
    public static String GLOBAL_SELECT_FACILITY = "Select facility from below";
    public static String GLOBAL_OPTION_ERROR = "Please enter valid option";
    public static String GLOBAL_GO_BACK ="Go Back";
    public static String GLOBAL_SUBMIT = "Submit";
    public static String GLOBAL_EXIT = "Exit";
    public static String HOME_DEMO_QUERIES = "Demo Queries";
    public static String HOME_SIGN_IN = "Sign In";
    public static String HOME_SIGN_UP = "Sign Up";
    public static String MEDICAL_FACILITY_ID = "Enter Medical-id ";
    public static String PATIENT_FACILITY_CHECK_IN = "Enter Id to Check-in";
    public static String PATIENT_ROUTING_CHECK_IN="Check In";
    public static String PATIENT_ROUTING_CHECK_OUT_ACK="Check Out Acknowledgement";
    public static String PATIENT_SIGNUP_FIRSTNAME = "Enter first name";
    public static String PATIENT_SIGNUP_LASTNAME = "Enter last name";
    public static String PATIENT_SIGNUP_DOB = "Enter date of birth (yyyy/mm/dd)";
    public static String PATIENT_SIGNUP_PHONE_NUM = "Enter phone number";
    public static String PATIENT_SIGNIN_LASTNAME = "Enter last name";
    public static String PATIENT_SIGNIN_DOB = "Enter date of birth (yyyy/mm/dd)";
    public static String PATIENT_SIGNIN_CITY = "Enter city of Address";
    public static String PATIENT_REPORT_TREATMENT = "Report the treatment";
    public static String PATIENT_REFERRER_ID = "Enter Referrer-id";
    public static String PATIENT_SUCCESSFUL_TREATMENT = "Patient Successfully Treated";
    public static String PATIENT_DECEASED = "Patient Deceased";
    public static String PATIENT_REFERRED = "Patient Referred";
    public static String REPORT_DISCHARGE_STATUS = "Report Discharge Status";
    public static String REPORT_REFERRAL_STATUS = "Report Referral Status";
    public static String REPORT_TREATMENT = "Report treatment";
    public static String REPORT_NEGATIVE_EXPERIENCE = "Report Negative Experience";
    public static String STAFF_MENU_CHECKED_IN_PATIENT = "Checked in patient list";
    public static String STAFF_MENU_TREATED_PATIENT = "Treated patient list";
    public static String STAFF_MENU_ADD_SYMPTOMS = "Add Symptoms";
    public static String STAFF_MENU_ADD_SEVERITY_SCALE = "Add Severity Scale";
    public static String STAFF_MENU_ADD_ASSESSMENT_RULE = "Add Assessment Rule";
    public static String STAFF_PROCESS_PATIENT_ENTER_VITALS = "Enter Vitals";
    public static String STAFF_PROCESS_PATIENT_TREAT_PATIENT = "Treat Patient";
    public static String STAFF_ENTER_VITALS_RECORD = "Record Vitals";
    public static String STAFF_ENTER_VITALS_TEMPERATURE = "Enter Body Temperature";
    public static String STAFF_ENTER_VITALS_BP_LOW = "Enter Systolic Blood Pressure";
    public static String STAFF_ENTER_VITALS_BP_HIGH = "Enter Diastolic Blood Pressure";
    public static String ADD_SYMPTOM_RECORD = "Add Symptom";
    public static String ADD_SYMPTOM_SYMPTOM_NAME = "Enter the symptom name";
    public static String ADD_SYMPTOM_BODY_PART = "Enter the body part";
    public static String ADD_SYMPTOM_SEVERITY_TYPE = "Enter the severity type";
    public static String ADD_SEVERITY_RANGE = "Add the new level";
    public static String ADD_SEVERITY_NO_LEVEL = "All the levels are added, No more levels";
    public static String NEGATIVE_EXP_CODE = "Negative experience Code";
    public static String STAFF_PATIENT_REPORT_CONFIRM = "Confirm";
    public static String STAFF_TREATED_PATIENT_CHECKOUT = "Check out";
    public static String STAFF_SIGNIN_NAME = "Enter Name";
    public static String STAFF_SIGNIN_START = "Sign in";
    public static String GLOBAL_YES = "Yes";
    public static String GLOBAL_NO = "No";
    public static String MAIN_PATIENT = "Visiting as a Patient";
    public static String MAIN_STAFF = "Visiting as a Staff";
    public static String CHECKIN_MESSAGE = "Checked in successfully";
    public static String SELECT_FACILITY_MESSAGE = "Select a facility to continue";

    public enum MAIN {
        MAIN_PATIENT, MAIN_STAFF, MAIN_EXIT
    }

    public enum PATIENT_ROUTING {
        PATIENT_ROUTING_CHECKIN, PATIENT_ROUTING_CHECK_OUT, PATIENT_ROUTING_GO_BACK
    }

    public enum STAFF_ENTER_VITALS {
        STAFF_ENTER_VITALS_RECORD, STAFF_ENTER_VITALS_GO_BACK
    }

    public enum ADD_SYMPTOM {
        ADD_SYMPTOM_RECORD, ADD_SYMPTOM_GO_BACK
    }

    public enum ADD_SEVERITY_SCALE{
        ADD_SEVERITY_SCALE_RANGE, ADD_SEVERITY_SCALE_NO_LEVEL
    }

    public enum ADDRESS{
        ADDRESS_START, ADDRESS_STREETNUM, ADDRESS_STREETNAME, ADDRESS_CITYNAME, ADDRESS_STATENAME, ADDRESS_COUNTRY
    }

    public enum STAFF_PROCESS_PATIENT {
        STAFF_PROCESS_PATIENT_ENTER_VITALS, STAFF_PROCESS_PATIENT_TREAT_PATIENT, STAFF_PROCESS_PATIENT_GO_BACK
    }

    public enum PATIENT_SIGNUP {
        PATIENT_SIGNUP_START, PATIENT_SIGNUP_GO_BACK
    }

    public enum PATIENT_SIGNIN {
        PATIENT_SIGNIN_START, PATIENT_SIGNIN_GO_BACK
    }

    public enum STAFF_MENU {
        STAFF_MENU_CHECKED_IN_PATIENT, STAFF_MENU_TREATED_PATIENT, STAFF_MENU_ADD_SYMPTOMS,
        STAFF_MENU_ADD_SEVERITY_SCALE, STAFF_MENU_ADD_ASSESSMENT_RULE, STAFF_MENU_GO_BACK
    }

    public enum STAFF_TREATED_PATIENT {
        STAFF_TREATED_PATIENT_CHECKOUT, STAFF_TREATED_PATIENT_GO_BACK
    }

    public enum HOME {
        HOME_SIGN_IN, HOME_SIGN_UP, HOME_DEMO_QUERIES, HOME_EXIT
    }

    public enum PATIENT_REPORT {
        REPORT_DISCHARGE_STATUS, REPORT_REFERRAL_STATUS, REPORT_TREATMENT, REPORT_NEGATIVE_EXPERIENCE, GLOBAL_GO_BACK, GLOBAL_SUBMIT
    }

    public enum PATIENT_REFERRAL_STATUS {
        MEDICAL_FACILITY_ID, PATIENT_REFERRER_ID, ADD_REASON, GLOBAL_GO_BACK
    }

    public enum STAFF_SIGNIN {
        STAFF_SIGNIN_START, STAFF_SIGNIN_EXIT
    }

    public enum SUBMIT_REASON {
        ADD_REASON, GLOBAL_GO_BACK
    }

    public enum PATIENT_DISCHARGE_STATUS {
        PATIENT_SUCCESSFUL_TREATMENT, PATIENT_DECEASED, PATIENT_REFERRED, GLOBAL_GO_BACK
    }

    public enum NEGATIVE_EXP {
        NEGATIVE_EXP_CODE, GO_BACK
    }

    public enum STAFF_PATIENT_REPORT_CONFIR {
        CONFIRM, GO_BACK
    }

    public enum PATIENT_CHECKOUT_ACK {
        YES, NO, GO_BACK
    }

}

