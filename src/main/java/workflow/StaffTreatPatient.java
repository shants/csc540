package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_utils.StaffCRUD;
import db_utils.VisitCRUD;
import entities.Facility;
import entities.Visit;

import java.util.ArrayList;

public class StaffTreatPatient extends IScreen {

    public void display() {

    }

    public void run() {
        Facility facility = new Facility();
        facility.setId(ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID));
        ArrayList<Visit> patients = VisitCRUD.getPatientsToTreat(facility);
        if (patients.size() > 0) {
            boolean isInvalid = true;
            int option;
            do {
                System.out.println("Select Patient to treat");
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
            Visit visit = patients.get(option);
            visit.setFacilityID(facility.getId());
            treatPatient(visit);
        }
        else {
            System.out.println("No patients available at this time.");
        }
    }

    private void treatPatient(Visit visit) {
        if(StaffCRUD.canTreatPatient(visit)){
            StaffCRUD.treatPatient(visit);
        }
        else{
            System.out.println(MessageUtils.GLOBAL_ACCESS_DENIED + MessageUtils.GLOBAL_DELIMITER
            + MessageUtils.GLOBAL_INADEQUATE_PRIVILEGES);
        }
    }
}
