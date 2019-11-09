package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import entities.BodyPart;
import entities.Symptom;
import entities.SymptomSeverity;
import db_utils.SymptomCRUD;

public class StaffAddSymptoms extends IScreen {

    public void display(){
        System.out.println(MessageUtils.ADD_SYMPTOM.ADD_SYMPTOM_RECORD.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.ADD_SYMPTOM_RECORD);
        System.out.println(MessageUtils.ADD_SYMPTOM.ADD_SYMPTOM_GO_BACK.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_GO_BACK);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }

    public void newSymptomsPrompt(Symptom symptom, BodyPart bp, SymptomSeverity symptom_severity){

        try {
            System.out.println(MessageUtils.ADD_SYMPTOM_SYMPTOM_NAME + MessageUtils.GLOBAL_DELIMITER);
            symptom.setSymptom_name(CommandLineUtils.ReadInput());
            System.out.println(MessageUtils.ADD_SYMPTOM_BODY_PART + MessageUtils.GLOBAL_DELIMITER);
            bp.setBody_part(CommandLineUtils.ReadInput());
            symptom.setBodyPart(bp);
            System.out.println(MessageUtils.ADD_SYMPTOM_SEVERITY_TYPE + MessageUtils.GLOBAL_DELIMITER);
            symptom_severity.setType(CommandLineUtils.ReadInput());

        }
        catch (Exception e) {
            System.out.println(MessageUtils.GLOBAL_PROPER_VALUE);
            newSymptomsPrompt(symptom, bp, symptom_severity);
        }
    }

    public void enterSymptom(){

        Symptom symptom = new Symptom();
        SymptomSeverity symptom_severity = new SymptomSeverity();
        BodyPart bp = new BodyPart();

        symptom_severity.setFacilityID(ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID));
        symptom_severity.setStaffID(ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.STAFF_ID));
        newSymptomsPrompt(symptom, bp, symptom_severity);
        ViewerContext.getInstance().addNames(symptom.getSymptom_name(), ViewerContext.IDENTIFIER_NAMES.SYMPTOM_NAME);
        SymptomCRUD.symptom_add(symptom, symptom_severity);

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
                MessageUtils.ADD_SYMPTOM options = MessageUtils.ADD_SYMPTOM.values()[option];
                IScreen scr;
                switch (options) {
                    case ADD_SYMPTOM_RECORD:
                        enterSymptom();
                    case ADD_SYMPTOM_GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.StaffMenu);
                        break;
                    default:
                        invalidOption = true;
                        break;
                }
            } catch (Exception e) {
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                invalidOption = true;
            }
        } while (invalidOption);
    }

}
