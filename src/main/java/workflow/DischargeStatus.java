package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;

public class DischargeStatus extends IScreen {

    public void display() {
        System.out.println(MessageUtils.PATIENT_DISCHARGE_STATUS.PATIENT_SUCCESSFUL_TREATMENT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.PATIENT_SUCCESSFUL_TREATMENT);
        System.out.println(MessageUtils.PATIENT_DISCHARGE_STATUS.PATIENT_DECEASED.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.PATIENT_DECEASED);
        System.out.println(MessageUtils.PATIENT_DISCHARGE_STATUS.PATIENT_REFERRED.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.PATIENT_REFERRED);
        System.out.println(MessageUtils.PATIENT_DISCHARGE_STATUS.GLOBAL_GO_BACK.ordinal()
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
                MessageUtils.PATIENT_DISCHARGE_STATUS options = MessageUtils.PATIENT_DISCHARGE_STATUS.values()[option];
                //IScreen scr;
                switch (options) {
                    case PATIENT_SUCCESSFUL_TREATMENT:
                        // Do Something
                        break;
                    case PATIENT_DECEASED:
                        // Do Something
                        break;
                    case PATIENT_REFERRED:
                        // Do Something
                        break;
                    case GLOBAL_GO_BACK:
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
