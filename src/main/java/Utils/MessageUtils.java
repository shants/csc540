package main.java.Utils;

public class MessageUtils {
    public static String GLOBAL_ENTER_OPTION = "Enter Option";
    public static String PATIENT_ROUTING_CHECK_IN="Check In";
    public static String PATIENT_ROUTING_CHECK_OUT_ACK="Check Out Acknowledgement";
    public static String PATIENT_ROUTING_GO_BACK="Go Back";

    public enum PATIENT_ROUTING {
        PATIENT_ROUTING_CHECKIN, PATIENT_ROUTING_CHECK_OUT, PATIENT_ROUTING_GO_BACK;
    }

}

