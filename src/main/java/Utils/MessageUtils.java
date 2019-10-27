package Utils;

public class MessageUtils {
    public static String GLOBAL_SPACE = " ";
    public static String GLOBAL_DELIMITER = ":";
    public static String GLOBAL_UNABLE_TO_HANDLE = "Unable to handle";
    public static String GLOBAL_NEWLINE = "\n";
    public static String GLOBAL_ENTER_OPTION = "Enter Option";
    public static String GLOBAL_OPTION_ERROR = "Please enter valid option";
    public static String HOME_SIGN_IN = "Sign In";
    public static String HOME_SIGN_UP = "Sign Up";
    public static String HOME_DEMO_QUERIES = "Demo Queries";
    public static String HOME_EXIT= "Exit";
    public static String PATIENT_ROUTING_CHECK_IN="Check In";
    public static String PATIENT_ROUTING_CHECK_OUT_ACK="Check Out Acknowledgement";
    public static String PATIENT_ROUTING_GO_BACK="Go Back";
    public static String PATIENT_FACILITY_CHECK_IN = "Enter Id to Check-in";
    public enum PATIENT_ROUTING {
        PATIENT_ROUTING_CHECKIN, PATIENT_ROUTING_CHECK_OUT, PATIENT_ROUTING_GO_BACK
    }

    public enum HOME {
        HOME_SIGN_IN, HOME_SIGN_UP, HOME_DEMO_QUERIES, HOME_EXIT
    }
}

