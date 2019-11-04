package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;

public class AddReason extends IScreen {
    public void display() {
        System.out.println(MessageUtils.SUBMIT_REASON.ADD_REASON.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.ADD_REASON);
        System.out.println(MessageUtils.SUBMIT_REASON.GLOBAL_GO_BACK.ordinal()
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
                MessageUtils.PATIENT_REFERRAL_STATUS options = MessageUtils.PATIENT_REFERRAL_STATUS.values()[option];
                //IScreen scr;
                switch (options) {
                    case ADD_REASON:
                        // ADD Reason
                        break;
                    case GLOBAL_GO_BACK:
                        // Do Something
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
