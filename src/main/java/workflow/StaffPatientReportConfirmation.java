package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;

public class StaffPatientReportConfirmation extends IScreen {
    public void display(){

        //Display the report and
        //ask the user for
        //confirmation

        System.out.println(MessageUtils.STAFF_PATIENT_REPORT_CONFIRM);
        System.out.println(MessageUtils.GLOBAL_GO_BACK);
    }
    public void run(){

        boolean invalidOption;
        do {
            invalidOption = false;
            int option;
            display();
            String opt = CommandLineUtils.ReadInput();
            try {
                option = Integer.parseInt(opt);
                MessageUtils.STAFF_PATIENT_REPORT_CONFIR options = MessageUtils.STAFF_PATIENT_REPORT_CONFIR.values()[option];
                switch (options) {
                    case CONFIRM:
                        System.out.println("STAFF_PATIENT_REPORT_CONFIR");
                        invalidOption = false;
                        break;
                    case GO_BACK:
                        System.out.println("GO BACK");
                        invalidOption = false;
                        break;
                    default:
                        invalidOption = true;
                }
            } catch (Exception e) {
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                invalidOption = true;
            }
        } while (invalidOption);    }
}