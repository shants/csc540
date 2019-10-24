package main.java.workflow;
import java.text.ParseException;

public class PatientRouting {
    public void run() {
        _display();
        String opt = CommandLineUtils.ReadOption();
        int option = 0;
        try {
            option = Integer.parseInt(opt);

        } catch (NumberFormatException e) {

        }

        }
    private void _display(){
        System.out.println(MessagesUtil.PATIENT_ROUTING.PATIENT_ROUTING_CHECKIN.toString() + MessagesUtil.PATIENT_ROUTING_CHECK_IN);
        System.out.println(MessagesUtil.PATIENT_ROUTING.PATIENT_ROUTING_CHECK_OUT.toString() + MessagesUtil.PATIENT_ROUTING_CHECK_OUT_ACK);
        System.out.println(MessagesUtil.PATIENT_ROUTING.PATIENT_ROUTING_GO_BACK.toString() + MessagesUtil.PATIENT_ROUTING_GO_BACK);
        System.out.println(MessagesUtil.GLOBAL_ENTER_OPTION);

    }
}
