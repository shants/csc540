package workflow;
import Utils.CommandLineUtils;
import Utils.IScreen;
import db_files.PatientSymptomCRUD;
import db_files.SymptomCRUD;
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
            while (option!= totalOptions){
                if (option <= totalOptions){
                    IScreen meta = new PatientSymptomMeta();
                    meta.run();

                }
                if (option == totalOptions-1){
                    // all sysmptom meta data entered,
                    // go back
                    System.out.println("Hello1");
                    return;
                }

                display();
                opt = CommandLineUtils.ReadInput();
                option = Integer.parseInt(opt);

            }

        }catch (Exception e){
            run();
        }
        PatientSymptomCRUD.addPatientSymptoms();
    }

    public void display(){
        this.symptomsList  = SymptomCRUD.read();
        int cSymptoms = symptomsList.size();
        //System.out.println("loggin : PatientCheckIn");
        //System.out.println(arr);
        for(int i=0; i < symptomsList.size(); i++){
            System.out.println(Integer.toString(i) + " "  + ((Symptom)symptomsList.get(i)).getSymptom_name());
        }
        System.out.println(Integer.toString(cSymptoms) + " "  + ("Other"));
        System.out.println(Integer.toString(cSymptoms+1) + " "  + ("Done"));
        totalOptions = cSymptoms+1;
    }
}
