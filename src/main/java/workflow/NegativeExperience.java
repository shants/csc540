package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_utils.NegativeExperienceCRUD;
import entities.NegExpDescription;
import entities.NegExperience;

import java.util.ArrayList;

import static Utils.CommandLineUtils.ReadInput;

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
            String opt = ReadInput();
            try {
                option = Integer.parseInt(opt);
                MessageUtils.NEGATIVE_EXP options = MessageUtils.NEGATIVE_EXP.values()[option];
                switch (options) {
                    case NEGATIVE_EXP_CODE:
                        System.out.println("NEGATIVE_EXP_CODE");
                        _displayExperience();
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

    public void _displayExperience(){
        ArrayList<NegExperience> nELst = NegativeExperienceCRUD.readAll();
        for(NegExperience f : nELst){
            System.out.println(Integer.toString(f.getNegExpId()) + " " + f.getExpName());
        }
        System.out.println("\n Enter Code");
        String id = CommandLineUtils.ReadInput();
        System.out.println("\n Enter description");
        String description = CommandLineUtils.ReadInput();
        ViewerContext.getInstance().getPatientReport().setNegative_experience_text(description);
        ViewerContext.getInstance().getPatientReport().setNegative_experience_value(Integer.parseInt(id));

    }

}
