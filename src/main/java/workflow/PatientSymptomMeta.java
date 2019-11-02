package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.ViewerContext;
import entities.PatientSymptom;

public class PatientSymptomMeta extends IScreen {
    public void display(){
        System.out.println("1. Enter Body Part ( NA if not applicable )");
        String bodyPart = CommandLineUtils.ReadInput();

        System.out.println("2. Duration ( 0 if NA)");
        String durationStr = CommandLineUtils.ReadInput();
        int duration = 0;
        try {
            duration = Integer.parseInt(durationStr);
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("3. ReOccuring Yes / No");
        String reoccuring = CommandLineUtils.ReadInput();

        System.out.println("4. Severity NA if not applicable");
        String severity = CommandLineUtils.ReadInput();

        System.out.println("5. Cause ( incident ) NA if not applicable");
        String incident = CommandLineUtils.ReadInput();

        PatientSymptom pSym = new PatientSymptom();
        pSym.setDuration(duration);
        pSym.setPostEvent(incident);
        pSym.setIsRecurring(reoccuring);
        pSym.setSeverityValue(severity);
        pSym.setBodyPart(bodyPart);

        ViewerContext.getInstance().addSymptom(pSym);
        return;
    }

    public void run(){
        this.display();
        return;
    }
}
