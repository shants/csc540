package workflow;
import Utils.*;
import db_files.VisitCRUD;

public class PatientRouting extends IScreen {
    public void run() {
        boolean invalidOption, goBack;
        do {
            invalidOption = goBack =false;
            display();
            String opt = CommandLineUtils.ReadInput();
            int option;
            try {
                option = Integer.parseInt(opt);
                MessageUtils.PATIENT_ROUTING options = MessageUtils.PATIENT_ROUTING.values()[option];
                switch (options) {
                    case PATIENT_ROUTING_CHECKIN:
                        if (ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID) == null) {
                            System.out.println(MessageUtils.SELECT_FACILITY_MESSAGE);
                            ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.Home);
                            break;
                        }
                        else if(
                            ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID) != null
                            &&
                            !VisitCRUD.isCheckedIn()
                        ) {
                                System.out.println(MessageUtils.CHECKIN_MESSAGE);
                                IScreen scr = new PatientCheckIn();
                                scr.run();
                        }
                        else {
                            invalidOption = true;
                        }
                        break;
                    case PATIENT_ROUTING_CHECK_OUT:
                        System.out.println(MessageUtils.PATIENT_ROUTING_CHECK_OUT_ACK);
                        break;
                    case PATIENT_ROUTING_GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.Home);
                        break;
                    default:
                        invalidOption = true;
                        break;
                }
                if (ViewerContext.getInstance().getGoToPage() == ViewerContext.PAGES.PatientRouting) {
                    goBack = true;
                    ViewerContext.getInstance().resetGoToPage();
                }
            }catch (Exception e){
                invalidOption = true;
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR +
                        MessageUtils.GLOBAL_DELIMITER + e.getMessage());
            }
        } while (invalidOption || goBack);
    }

    public void display(){
        System.out.println(MessageUtils.PATIENT_ROUTING.PATIENT_ROUTING_CHECKIN.ordinal()
               + MessageUtils.GLOBAL_SPACE + MessageUtils.PATIENT_ROUTING_CHECK_IN);
        System.out.println(MessageUtils.PATIENT_ROUTING.PATIENT_ROUTING_CHECK_OUT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.PATIENT_ROUTING_CHECK_OUT_ACK);
        System.out.println(MessageUtils.PATIENT_ROUTING.PATIENT_ROUTING_GO_BACK.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_GO_BACK);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }
}
