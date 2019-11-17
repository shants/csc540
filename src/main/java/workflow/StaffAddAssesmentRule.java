package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_utils.AssessmentRuleCRUD;
import db_utils.SymptomCRUD;
import entities.Symptom;
import entities.SymptomSeverity;
import entities.AssessmentRule;

import java.util.ArrayList;


public class StaffAddAssesmentRule extends IScreen{

    private int totalOptions = 0;
    private ArrayList<Symptom> symptomsList = null;
    private ArrayList<String> severityList = null;
    private Symptom symptom = new Symptom();

    public void display(){

        this.symptomsList  = SymptomCRUD.read();
        int cSymptoms = symptomsList.size();
        System.out.println("The list of Symptoms are:");
        for(int i=0; i < symptomsList.size(); i++){
            System.out.println(Integer.toString(i) + " "  + ((Symptom)symptomsList.get(i)).getSymptom_name());
        }
        System.out.println(Integer.toString(cSymptoms) + " "  + ("Priority"));
        System.out.println(Integer.toString(cSymptoms+1) + " "  + ("Go Back"));
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);

        totalOptions = cSymptoms+1;
    }

    public void display_priority_values(){

        System.out.println("The priority values are :");
        System.out.println(MessageUtils.PRIORITY.HIGH.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.HIGH);
        System.out.println(MessageUtils.PRIORITY.NORMAL.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.NORMAL);
        System.out.println(MessageUtils.PRIORITY.QUARANTINE.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.QUARANTINE);

    }

    public void select_priority_values(AssessmentRule Rule){
        String opt;
        int priority_value;

        display_priority_values();
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println("Enter the Rule: ");
        Rule.setRule(CommandLineUtils.ReadInput());
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println("Enter the priority value: " + MessageUtils.GLOBAL_DELIMITER);
        opt = CommandLineUtils.ReadInput();
        priority_value = Integer.parseInt(opt) +1;
        Rule.setPriorityID(priority_value);

    }
    public void displaySymptom_severity(){

        SymptomSeverity symptom_severity = new SymptomSeverity();
        AssessmentRule asses_rule = new AssessmentRule();
        symptom_severity.setStaffID(ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.STAFF_ID));
        this.severityList= SymptomCRUD.read_symptom_severity(symptom, symptom_severity);
        System.out.println("severity values for the Symptom: " +symptom.getSymptom_name());
        for(int i=0; i < severityList.size(); i++){
            System.out.println(Integer.toString(i) + " "  + (severityList.get(i)));
        }

        asses_rule.setSymptom(symptom);
        select_priority_values(asses_rule);
        AssessmentRuleCRUD.AddRules(symptom_severity, asses_rule);

    }
    public void run(){

        display();
        String opt = CommandLineUtils.ReadInput();
        int option;
        try {
            option = Integer.parseInt(opt);
            while (true){
                if(option == totalOptions){
                    ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.StaffMenu);
                    return;
                }
                else if (option == totalOptions-1){
                    display_priority_values();
                }
                else{
                    this.symptom.setSymptom_name(symptomsList.get(option).getSymptom_name());
                    this.symptom.setSymptom_code(symptomsList.get(option).getSymptom_code());
                    displaySymptom_severity();
                }
                display();
                opt = CommandLineUtils.ReadInput();
                option = Integer.parseInt(opt);
            }
        }catch (Exception e){
            run();
        }
    }
}
