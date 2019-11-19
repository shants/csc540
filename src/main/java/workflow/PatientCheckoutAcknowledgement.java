package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import entities.NegExpDescription;
import entities.NegExperience;
import entities.ReportRefererral;
import entities.Referral_Reason;

import java.util.ArrayList;

public class PatientCheckoutAcknowledgement extends IScreen {
    public void display(){

        //Display the report that
        //is filled by the staff
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




        System.out.println(MessageUtils.GLOBAL_YES);
        System.out.println(MessageUtils.GLOBAL_NO);
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
                MessageUtils.PATIENT_CHECKOUT_ACK options = MessageUtils.PATIENT_CHECKOUT_ACK.values()[option];
                switch (options) {
                    case YES:
                        // YES
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.PatientRouting);
                        break;
                    case NO:
                        //System.out.println("NO");
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.PatientRouting);
                        break;
                    case GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.PatientRouting);
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
