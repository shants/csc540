package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_utils.SymptomCRUD;
import entities.PatientSymptom;
import entities.Symptom;

import java.util.ArrayList;

public class PatientSymptomMeta extends IScreen {
    public void display(){
        boolean invalid;
        do {
            invalid = false;
            System.out.println(MessageUtils.PATIENT_SYM_META_BP);
            String bodyPart = CommandLineUtils.ReadInput();

            System.out.println(MessageUtils.PATIENT_SYM_META_DUR);
            String durationStr = CommandLineUtils.ReadInput();
            int duration = 0;
            try {
                duration = Integer.parseInt(durationStr);
            } catch (Exception e) {
                System.out.println(MessageUtils.GLOBAL_PROPER_VALUE);
                invalid = true;
                continue;
            }
            System.out.println(MessageUtils.PATIENT_SYM_META_REOCCUR);
            String reoccuring = CommandLineUtils.ReadInput();
            if (!(reoccuring.toUpperCase().equals("Y") || reoccuring.toUpperCase().equals("N"))){
                System.out.println(MessageUtils.GLOBAL_PROPER_VALUE);
                invalid = true;
                continue;
            }

            ArrayList<String> symValues = getSymValues();

            System.out.println(MessageUtils.PATIENT_SYM_META_SEV);

            if (symValues != null){
                StringBuilder sb = new StringBuilder();
                for (String s : symValues) {
                    sb.append(s);
                    sb.append(" ");
                }
                System.out.println(" ( Allowed Values " + sb.toString() + " ) ");
            }

            String severity = CommandLineUtils.ReadInput();

            boolean found = false;
            for (String s : symValues){
                if (s.toUpperCase().equals(severity.toUpperCase())){
                    found = true;
                }
            }

            if (symValues != null) {
                if (found == false && !severity.equals("NA")) {
                    System.out.println(MessageUtils.GLOBAL_PROPER_VALUE);
                    invalid = true;
                    continue;
                }
            }
            System.out.println(MessageUtils.PATIENT_SYM_META_CAUSE);
            String incident = CommandLineUtils.ReadInput();

            PatientSymptom pSym = new PatientSymptom();
            pSym.setDuration(duration);
            pSym.setPostEvent(incident);
            pSym.setIsRecurring(reoccuring);
            pSym.setSeverityValue(severity);
            pSym.setBodyPart(bodyPart);
            ViewerContext.getInstance().addSymptom(pSym);
            return;
        }while(invalid);
    }


    public void run(){
        this.display();
        return;
    }

    private ArrayList<String> getSymValues(){
        String symCode = ViewerContext.getInstance().getSymptomCode();
        String genericSymCode = SymptomCRUD.getSymptonCodeForGeneric().getSymptom_code();
        if (symCode.toUpperCase().equals(genericSymCode.toUpperCase())){
            return null;
        }else
            return SymptomCRUD.getSymptonScale(symCode);
    }
}
