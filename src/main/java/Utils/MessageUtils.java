package Utils;

public class MessageUtils {
    public static String ADDRESS_START = "Enter Address";
    public static String ADDRESS_STREETNUM = "Street number";
    public static String ADDRESS_STREETNAME = "Street name";
    public static String ADDRESS_CITYNAME = "City";
    public static String ADDRESS_STATENAME = "State";
    public static String ADDRESS_COUNTRYNAME = "Country";
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
    public static String HOME_DEMO_QUERIES = "Demo Queries";
    public static String HOME_EXIT= "Exit";
    public static String HOME_SIGN_IN = "Sign In";
    public static String HOME_SIGN_UP = "Sign Up";
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
    public static String NEGATIVE_EXP_CODE = "Negative experience Code";
    public static String STAFF_PATIENT_REPORT_CONFIRM = "Confirm";
    public static String STAFF_TREATED_PATIENT_CHECKOUT = "Check out";
    public static String GLOBAL_YES = "Yes";
    public static String GLOBAL_NO = "No";


    public enum PATIENT_ROUTING {
        PATIENT_ROUTING_CHECKIN, PATIENT_ROUTING_CHECK_OUT, PATIENT_ROUTING_GO_BACK
    }

    public enum STAFF_ENTER_VITALS {
        STAFF_ENTER_VITALS_RECORD, STAFF_ENTER_VITALS_GO_BACK
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
        STAFF_MENU_ADD_SEVERITY_SCALE, STAFF_MENU_ADD_ASSESSMENT_RULE
    }

    public enum STAFF_TREATED_PATIENT {
        STAFF_TREATED_PATIENT_CHECKOUT, STAFF_TREATED_PATIENT_GO_BACK
    }

    public enum HOME {
        HOME_SIGN_IN, HOME_SIGN_UP, HOME_DEMO_QUERIES, HOME_EXIT
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

