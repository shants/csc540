package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_utils.VisitCRUD;
import entities.Referral_Reason;
import entities.ReportRefererral;
import db_utils.ReportCRUD;

import java.util.ArrayList;

public class StaffPatientReportConfirmation extends IScreen {
    public void display(){

        ReportRefererral rep = ViewerContext.getInstance().getPatientReport();

        System.out.println("=======================");
        System.out.println("REPORT FOR THE VISIT");
        System.out.println("=======================");
        System.out.println("DISCHARGE STATUS:" + rep.getDischarge_status());
        /* TODO REFERRAL   STATUS */
        if (rep.getDischarge_status() == MessageUtils.REPORT_STATUS.REFERRED.toString()){
            System.out.println("REFERAL   STATUS");
            System.out.println("REFERRED BY " + Integer.toString(rep.getStaff_id()));
            ArrayList<Referral_Reason> refReasons =  rep.getReferralReasons();
            for(int i=0; i < refReasons.size(); ++i){
                System.out.println("REASON CODE " + Integer.toString(refReasons.get(i).getReason_code()));
                System.out.println("REASON TEXT " + refReasons.get(i).getReason_string());
                System.out.println("SERVICE CODE " + refReasons.get(i).getService_code());
            }
        }

        System.out.println("TREATMENT GIVEN " + rep.getTreatment());
        System.out.println("NEGATIVE EXPERIENCE " + rep.getNegative_experience_value() +  rep.getNegative_experience_text());
        System.out.println("=======================");


        System.out.println(MessageUtils.STAFF_PATIENT_REPORT_CONFIR.CONFIRM.ordinal() + MessageUtils.GLOBAL_DELIMITER +
                MessageUtils.STAFF_PATIENT_REPORT_CONFIRM);
        System.out.println(MessageUtils.STAFF_PATIENT_REPORT_CONFIR.GO_BACK.ordinal() + MessageUtils.GLOBAL_DELIMITER +
                MessageUtils.GLOBAL_GO_BACK);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
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
                        ReportCRUD.addPatientReport();
                        VisitCRUD.checkoutPatient();
                        if (ViewerContext.getInstance().getPatientReport().getDischarge_status_code() == 2) {
                            ReportCRUD.reportReferral();
                            ReportCRUD.addReferralReason();
                        }
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.StaffMenu);
                        invalidOption = false;
                        break;
                    case GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.StaffPatientReport);
                        break;
                    default:
                        invalidOption = true;
                }
            } catch (Exception e) {
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                invalidOption = true;
            }
        } while (invalidOption);
    }
}
