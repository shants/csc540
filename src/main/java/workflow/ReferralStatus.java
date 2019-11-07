package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;

public class ReferralStatus extends IScreen {

    public void display() {
        System.out.println(MessageUtils.PATIENT_REFERRAL_STATUS.MEDICAL_FACILITY_ID.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.MEDICAL_FACILITY_ID);
        System.out.println(MessageUtils.PATIENT_REFERRAL_STATUS.PATIENT_REFERRER_ID.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.PATIENT_REFERRER_ID);
        System.out.println(MessageUtils.PATIENT_REFERRAL_STATUS.ADD_REASON.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.ADD_REASON);
        System.out.println(MessageUtils.PATIENT_REFERRAL_STATUS.GLOBAL_GO_BACK.ordinal()
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
                MessageUtils.PATIENT_REFERRAL_STATUS options = MessageUtils.PATIENT_REFERRAL_STATUS.values()[option];
                IScreen scr;
                switch (options) {
                    case MEDICAL_FACILITY_ID:
                        System.out.println(MessageUtils.ENTER_FACILITY_ID + MessageUtils.GLOBAL_DELIMITER);
                        String facility_id = CommandLineUtils.ReadInput();
                        break;
                    case PATIENT_REFERRER_ID:
                        System.out.println(MessageUtils.ENTER_REFERRER_ID + MessageUtils.GLOBAL_DELIMITER);
                        String referrer_id = CommandLineUtils.ReadInput();
                        break;
                    case ADD_REASON:
                        scr = new ReferralReason();
                        scr.run();
                        break;
                    case GLOBAL_GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.StaffPatientReport);
                    default:
                        invalidOption = true;
                        break;
                }
                if (ViewerContext.getInstance().getGoToPage() == ViewerContext.PAGES.ReferralStatus) {
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
