package workflow;
import Utils.CommandLineUtils;
import Utils.MessageUtils;
import Utils.IScreen;
import db_files.FacilityCRUD;
import db_files.SymptomCRUD;
import entities.Facility;
import entities.Symptom;

import java.util.ArrayList;

public class PatientCheckIn extends  IScreen {

    public void run(){
        display();
    }

    public void display(){
        ArrayList<Symptom> arr = SymptomCRUD.read();
        for(int i=0; i < arr.size(); i++){
            System.out.println(Integer.toString(i) + " "  + ((Symptom)arr.get(i)).getSymptom_name());
        }
    }
}
