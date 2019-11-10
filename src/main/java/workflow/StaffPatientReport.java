package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import entities.ReportRefererral;

public class StaffPatientReport extends IScreen {

    public void display() {
        System.out.println(MessageUtils.PATIENT_REPORT.REPORT_DISCHARGE_STATUS.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.REPORT_DISCHARGE_STATUS);
        System.out.println(MessageUtils.PATIENT_REPORT.REPORT_REFERRAL_STATUS.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.REPORT_REFERRAL_STATUS);
        System.out.println(MessageUtils.PATIENT_REPORT.REPORT_TREATMENT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.REPORT_TREATMENT);
        System.out.println(MessageUtils.PATIENT_REPORT.REPORT_NEGATIVE_EXPERIENCE.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.REPORT_NEGATIVE_EXPERIENCE);
        System.out.println(MessageUtils.PATIENT_REPORT.GLOBAL_GO_BACK.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_GO_BACK);
        System.out.println(MessageUtils.PATIENT_REPORT.GLOBAL_SUBMIT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_SUBMIT);
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
                MessageUtils.PATIENT_REPORT options = MessageUtils.PATIENT_REPORT.values()[option];
                IScreen scr;
                switch (options) {
                    case REPORT_DISCHARGE_STATUS:
                        scr = new DischargeStatus();
                        scr.run();
                        invalidOption = true;
                        break;
                    case REPORT_REFERRAL_STATUS:
                        scr = new ReferralStatus();
                        scr.run();
                        invalidOption = true;
                        break;
                    case REPORT_TREATMENT:
                        System.out.println(MessageUtils.PATIENT_REPORT_TREATMENT + MessageUtils.GLOBAL_DELIMITER);
                        String treatment = CommandLineUtils.ReadInput();
                        ReportRefererral rep = new ReportRefererral();
                        rep.setTreatment(treatment);
                        invalidOption = true;
                        break;
                    case REPORT_NEGATIVE_EXPERIENCE:
                        scr = new NegativeExperience();
                        scr.run();
                        invalidOption = true;
                        break;
                    case GLOBAL_GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.StaffMenu);
                        break;
                    case GLOBAL_SUBMIT:
                        // Write to DB
                        scr = new StaffPatientReportConfirmation();
                        scr.run();
                        break;
                    default:
                        invalidOption = true;
                        break;
                }
                if (ViewerContext.getInstance().getGoToPage() == ViewerContext.PAGES.StaffPatientReport) {
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
