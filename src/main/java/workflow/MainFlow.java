package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;

public class MainFlow{

    public static void display() {
        System.out.println(MessageUtils.MAIN.MAIN_PATIENT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.MAIN_PATIENT);
        System.out.println(MessageUtils.MAIN.MAIN_STAFF.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.MAIN_STAFF);
        System.out.println(MessageUtils.MAIN.MAIN_EXIT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_EXIT);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }

    public static void main(String[] args){
        boolean invalidOption;
        do {
            invalidOption = false;
            int option;
            display();
            String opt = CommandLineUtils.ReadInput();
            try {
                option = Integer.parseInt(opt);
                MessageUtils.MAIN options = MessageUtils.MAIN.values()[option];
                IScreen scr;
                switch (options) {
                    case MAIN_PATIENT:
                        scr = new Home();
                        scr.run();
                        break;
                    case MAIN_STAFF:
                        scr = new StaffSignIn();
                        scr.run();
                        break;
                    case MAIN_EXIT:
                        break;
                    default:
                        invalidOption = true;
                        break;
                }
                ViewerContext.destroyInstance();
            } catch (Exception e) {
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                invalidOption = true;
            }
        } while (invalidOption);
   }
}
