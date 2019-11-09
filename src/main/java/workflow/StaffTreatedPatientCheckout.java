package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_utils.VisitCRUD;
import entities.Facility;
import entities.Visit;

import java.util.ArrayList;

public class StaffTreatedPatientCheckout extends IScreen {
    public void display() {
        Facility facility = new Facility();
        facility.setId(ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID));
        ArrayList<Visit> patients = VisitCRUD.getTreatedPatientsToCheckout(facility);
        if (patients.size() > 0) {
            boolean isInvalid = true;
            int option;
            do {
                System.out.println("Select Patient to check out");
                for (int itr = 0; itr < patients.size(); itr++) {
                    System.out.println(itr + MessageUtils.GLOBAL_HYPHEN + "Patient-ID: " +
                            patients.get(itr).getPatient_id() + ", START-TIME: " + patients.get(itr).getStart_time()
                            + ", END-TIME: " + patients.get(itr).getEnd_time());
                }
                System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
                String opt = CommandLineUtils.ReadInput();
                option = Integer.parseInt(opt);
                if (option < patients.size()) {
                    isInvalid = false;
                }
            } while (isInvalid);
            ViewerContext.getInstance().setPatientToCheckout(patients.get(option));
        }
        else {
            System.out.println("No patients available at this time.");
        }
    }

    public void run() {
        display();
        IScreen scr  =  new StaffPatientReport();
        scr.run();
    }
}
