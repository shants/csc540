package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_utils.VisitCRUD;
import entities.Facility;
import entities.Visit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StaffEnterVitals extends IScreen {
    public void display() {
        System.out.println(MessageUtils.STAFF_ENTER_VITALS.STAFF_ENTER_VITALS_RECORD.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.STAFF_ENTER_VITALS_RECORD);
        System.out.println(MessageUtils.STAFF_ENTER_VITALS.STAFF_ENTER_VITALS_GO_BACK.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_GO_BACK);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }


    public void enterVitals() {
        Facility facility = new Facility();
        facility.setId(ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID));
        ArrayList<Visit> patients = VisitCRUD.getCheckedInPatient(facility);
        if (patients.size() > 0) {
            boolean isInvalid = true;
            int option;
            do {
                System.out.println("Select Patient to record vitals for");
                for (int itr = 0; itr < patients.size(); itr++) {
                    System.out.println(itr + MessageUtils.GLOBAL_HYPHEN + "Patient-ID: " +
                            patients.get(itr).getPatient_id() + ", START-TIME: " + patients.get(itr).getStart_time());
                }
                System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
                String opt = CommandLineUtils.ReadInput();
                option = Integer.parseInt(opt);
                if (option < patients.size()) {
                    isInvalid = false;
                }
            } while (isInvalid);
            Visit visit = getVitalsPrompt(patients.get(option));
            visit.setFacilityID(facility.getId());
            VisitCRUD.completeVitalsUpdate(visit);
        }
        else {
            System.out.println("No patients available at this time.");
        }
    }

    public  Visit getVitalsPrompt(Visit visit) {
        try {
            System.out.println(MessageUtils.STAFF_ENTER_VITALS_TEMPERATURE + MessageUtils.GLOBAL_DELIMITER);
            visit.setBody_temp(Float.parseFloat(CommandLineUtils.ReadInput()));
            System.out.println(MessageUtils.STAFF_ENTER_VITALS_BP_LOW + MessageUtils.GLOBAL_DELIMITER);
            visit.setBp_low(Float.parseFloat(CommandLineUtils.ReadInput()));
            System.out.println(MessageUtils.STAFF_ENTER_VITALS_BP_HIGH + MessageUtils.GLOBAL_DELIMITER);
            visit.setBp_high(Float.parseFloat(CommandLineUtils.ReadInput()));
            visit.setEnd_time(new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date()));
        }
        catch (Exception e) {
            System.out.println(MessageUtils.GLOBAL_PROPER_VALUE);
            getVitalsPrompt(visit);
        }
        return visit;
    }

    public void run() {
        boolean invalidOption;
        do {
            invalidOption = false;
            int option;
            display();
            String opt = CommandLineUtils.ReadInput();
            try {
                option = Integer.parseInt(opt);
                MessageUtils.STAFF_ENTER_VITALS options = MessageUtils.STAFF_ENTER_VITALS.values()[option];
                IScreen scr;
                switch (options) {
                    case STAFF_ENTER_VITALS_RECORD:
                        enterVitals();
                    case STAFF_ENTER_VITALS_GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.StaffProcessPatient);
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
