package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;

public class PatientCheckoutAcknowledgement extends IScreen {
    public void display(){

        //Display the report that
        //is filled by the staff

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
                        System.out.println("NO");
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
