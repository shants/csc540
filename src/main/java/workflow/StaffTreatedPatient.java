package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;

public class StaffTreatedPatient extends IScreen {
    public void display() {
        System.out.println(MessageUtils.STAFF_TREATED_PATIENT.STAFF_TREATED_PATIENT_CHECKOUT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.STAFF_TREATED_PATIENT_CHECKOUT);
        System.out.println(MessageUtils.STAFF_TREATED_PATIENT.STAFF_TREATED_PATIENT_GO_BACK.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_GO_BACK);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
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
                MessageUtils.STAFF_TREATED_PATIENT options = MessageUtils.STAFF_TREATED_PATIENT.values()[option];
                IScreen scr;
                switch (options) {
                    case STAFF_TREATED_PATIENT_CHECKOUT:
                        scr = new StaffTreatedPatientCheckout();
                        scr.run();
                        break;
                    case STAFF_TREATED_PATIENT_GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.StaffMenu);
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
