package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import entities.ReportRefererral;
import oracle.jdbc.aq.AQMessageProperties;

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
                ReportRefererral rep = ViewerContext.getInstance().getPatientReport();
                String status;
                switch (options) {
                    case PATIENT_SUCCESSFUL_TREATMENT:
                        status = MessageUtils.PATIENT_SUCCESSFUL_TREATMENT;
                        rep.setDischarge_status(status);
                        break;
                    case PATIENT_DECEASED:
                        status = MessageUtils.PATIENT_DECEASED;
                        rep.setDischarge_status(status);
                        break;
                    case PATIENT_REFERRED:
                        status = MessageUtils.PATIENT_REFERRED;
                        rep.setDischarge_status(status);
                        break;
                    case GLOBAL_GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.StaffPatientReport);
                        break;
                    default:
                        invalidOption = true;
                        break;
                }
                System.out.println(rep.getFacility_id());
                System.out.println(rep.getDischarge_status());
                System.out.println(rep.getVisit_id());
                ViewerContext.getInstance().setPatientReport(rep);
            } catch (Exception e) {
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                invalidOption = true;
            }
        } while (invalidOption);
    }
}
