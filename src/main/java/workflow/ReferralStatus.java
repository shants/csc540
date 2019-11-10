package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import entities.ReportRefererral;

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
                ReportRefererral rep = new ReportRefererral();
                switch (options) {
                    case MEDICAL_FACILITY_ID:
                        System.out.println(MessageUtils.ENTER_FACILITY_ID + MessageUtils.GLOBAL_DELIMITER);
                        String input = CommandLineUtils.ReadInput();
                        int facility_id = Integer.parseInt(input);
                        rep.setFacility_id(facility_id);
                        invalidOption = true;
                        break;
                    case PATIENT_REFERRER_ID:
                        System.out.println(MessageUtils.ENTER_REFERRER_ID + MessageUtils.GLOBAL_DELIMITER);
                        String refer = CommandLineUtils.ReadInput();
                        int referrer_id = Integer.parseInt(refer);
                        rep.setFacility_id(referrer_id);
                        invalidOption = true;
                        break;
                    case ADD_REASON:
                        scr = new ReferralReason();
                        scr.run();
                        invalidOption = true;
                        break;
                    case GLOBAL_GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.StaffPatientReport);
                        break;
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
