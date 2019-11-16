package workflow;
import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.ViewerContext;
import db_utils.PatientSymptomCRUD;
import db_utils.SymptomCRUD;
import db_utils.VisitCRUD;
import entities.Symptom;

import java.util.ArrayList;

public class PatientCheckIn extends  IScreen {
    private int totalOptions = 0;
    private ArrayList<Symptom> symptomsList = null;
    public void run(){
        display();
        String opt = CommandLineUtils.ReadInput();
        int option;
        try {
            option = Integer.parseInt(opt);
            while (true){
                if (option == totalOptions){
                    // all symptom meta data entered,
                    // save and go back
                    VisitCRUD.insertCheckInInfo();
                    PatientSymptomCRUD.addPatientSymptoms();
                    ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.Home);
                    return;
                }
                else if (option == totalOptions-1){
                    // add for others
                }
                else if (option < totalOptions){
                    ViewerContext.getInstance().addSymptomForCheckin(symptomsList.get(option));
                    IScreen meta = new PatientSymptomMeta();
                    meta.run();
                }
                display();
                opt = CommandLineUtils.ReadInput();
                option = Integer.parseInt(opt);
            }
        }catch (Exception e){
            run();
        }
    }

    public void display(){
        this.symptomsList  = SymptomCRUD.read();
        int cSymptoms = symptomsList.size();
        for(int i=0; i < symptomsList.size(); i++){
            System.out.println(Integer.toString(i) + " "  + ((Symptom)symptomsList.get(i)).getSymptom_name());
        }
        System.out.println(Integer.toString(cSymptoms) + " "  + ("Other"));
        System.out.println(Integer.toString(cSymptoms+1) + " "  + ("Done"));
        totalOptions = cSymptoms+1;
    }
}
