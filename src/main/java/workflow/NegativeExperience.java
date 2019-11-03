package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_files.PatientCRUD;
import entities.Address;
import entities.Patient;

public class NegativeExperience extends IScreen {
    public void display(){
        System.out.println(MessageUtils.NEGATIVE_EXP_CODE);
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
                MessageUtils.NEGATIVE_EXP options = MessageUtils.NEGATIVE_EXP.values()[option];
                switch (options) {
                    case NEGATIVE_EXP_CODE:
                        System.out.println("NEGATIVE_EXP_CODE");
                        invalidOption = false;
                        break;
                    case GO_BACK:
                        System.out.println("GO BACK");
                        invalidOption = false;
                        break;
                    default:
                        invalidOption = true;
                }
            } catch (Exception e) {
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                invalidOption = true;
            }
        } while (invalidOption);    }
}
