package workflow;
import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import entities.Symptom;
import entities.SymptomSeverity;
import db_utils.SymptomCRUD;

import java.util.ArrayList;

public class StaffAddSeverityScale extends IScreen{

    public void display(){
        System.out.println(MessageUtils.ADD_SEVERITY_SCALE.ADD_SEVERITY_SCALE_RANGE.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.ADD_SEVERITY_RANGE);
        System.out.println(MessageUtils.ADD_SEVERITY_SCALE.ADD_SEVERITY_SCALE_NO_LEVEL.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.ADD_SEVERITY_NO_LEVEL);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }

    public void CompleteSeverityScale(ArrayList<String> values){

        Symptom symptom = new Symptom();
        SymptomSeverity symptom_severity = new SymptomSeverity();

        symptom_severity.setFacilityID(ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID));
        symptom_severity.setStaffID(ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.STAFF_ID));
        symptom.setSymptom_name(ViewerContext.getInstance().getNames(ViewerContext.IDENTIFIER_NAMES.SYMPTOM_NAME));
        SymptomCRUD.add_new_severity_scale(values, symptom, symptom_severity);

    }

    public void run(){

        boolean invalidOption;
        do {
            invalidOption = false;
            int option;
            display();
            String opt = CommandLineUtils.ReadInput();
            ArrayList<String> scale_values= new ArrayList<>();
            try {
                option = Integer.parseInt(opt);
                MessageUtils.ADD_SEVERITY_SCALE options = MessageUtils.ADD_SEVERITY_SCALE.values()[option];
                IScreen scr;
                switch (options) {
                    case ADD_SEVERITY_SCALE_RANGE:
                        System.out.println("Enter the Scale value:");
                        scale_values.add(CommandLineUtils.ReadInput());
                        invalidOption = true;
                        break;
                    case ADD_SEVERITY_SCALE_NO_LEVEL:
                        CompleteSeverityScale(scale_values);
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
