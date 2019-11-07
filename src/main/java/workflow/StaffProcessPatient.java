package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;

public class StaffProcessPatient extends IScreen {
    public void display() {
        System.out.println(MessageUtils.STAFF_PROCESS_PATIENT.STAFF_PROCESS_PATIENT_ENTER_VITALS.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.STAFF_PROCESS_PATIENT_ENTER_VITALS);
        System.out.println(MessageUtils.STAFF_PROCESS_PATIENT.STAFF_PROCESS_PATIENT_TREAT_PATIENT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.STAFF_PROCESS_PATIENT_TREAT_PATIENT);
        System.out.println(MessageUtils.STAFF_PROCESS_PATIENT.STAFF_PROCESS_PATIENT_GO_BACK.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_GO_BACK);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }

    public void run() {
        boolean invalidOption, goBack;
        do {
            invalidOption = goBack = false;
            int option;
            display();
            String opt = CommandLineUtils.ReadInput();
            try {
                option = Integer.parseInt(opt);
                MessageUtils.STAFF_PROCESS_PATIENT options = MessageUtils.STAFF_PROCESS_PATIENT.values()[option];
                IScreen scr;
                switch (options) {
                    case STAFF_PROCESS_PATIENT_ENTER_VITALS:
                        scr = new StaffEnterVitals();
                        scr.run();
                        break;
                    case STAFF_PROCESS_PATIENT_TREAT_PATIENT:
                        scr = new StaffTreatPatient();
                        scr.run();
                        break;
                    case STAFF_PROCESS_PATIENT_GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.StaffMenu);
                        break;
                    default:
                        invalidOption = true;
                        break;
                }
                if (ViewerContext.getInstance().getGoToPage() == ViewerContext.PAGES.StaffProcessPatient) {
                    goBack = true;
                    ViewerContext.getInstance().resetGoToPage();
                }
            } catch (Exception e) {
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                invalidOption = true;
            }
        } while (invalidOption || goBack);
    }
}
