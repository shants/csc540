package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_utils.StaffCRUD;
import entities.Staff;

public class StaffMenu extends IScreen {

    public void display() {
        System.out.println(MessageUtils.STAFF_MENU.STAFF_MENU_CHECKED_IN_PATIENT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.STAFF_MENU_CHECKED_IN_PATIENT);
        System.out.println(MessageUtils.STAFF_MENU.STAFF_MENU_TREATED_PATIENT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.STAFF_MENU_TREATED_PATIENT);
        System.out.println(MessageUtils.STAFF_MENU.STAFF_MENU_ADD_SYMPTOMS.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.STAFF_MENU_ADD_SYMPTOMS);
        System.out.println(MessageUtils.STAFF_MENU.STAFF_MENU_ADD_SEVERITY_SCALE.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.STAFF_MENU_ADD_SEVERITY_SCALE);
        System.out.println(MessageUtils.STAFF_MENU.STAFF_MENU_ADD_ASSESSMENT_RULE.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.STAFF_MENU_ADD_ASSESSMENT_RULE);
        System.out.println(MessageUtils.STAFF_MENU.STAFF_MENU_GO_BACK.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_GO_BACK);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }

    public void run() {
        boolean invalidOption, goBack;
        int staffID = ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.STAFF_ID) != null ?
                        ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.STAFF_ID ): 0;
        int facilityID = ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID) != null ?
                ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID): 0;
        if (staffID == 0 || facilityID == 0) {
            System.out.println(MessageUtils.GLOBAL_LOGIN_MESSAGE);
            return;
        }
        do {
            invalidOption = goBack = false;
            int option;
            display();
            String opt = CommandLineUtils.ReadInput();
            try {
                option = Integer.parseInt(opt);
                MessageUtils.STAFF_MENU options = MessageUtils.STAFF_MENU.values()[option];
                IScreen scr;
                Staff staff = new Staff();
                staff.setStaff_id(staffID);
                staff.setFacilityID(ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID));
                switch (options) {
                    case STAFF_MENU_CHECKED_IN_PATIENT:
                        if (StaffCRUD.isMedicalStaff(staff)) {
                            scr = new StaffProcessPatient();
                            scr.run();
                        }
                        else{
                            System.out.println(MessageUtils.GLOBAL_ACCESS_DENIED);
                        }
                        break;
                    case STAFF_MENU_TREATED_PATIENT:
                        scr = new StaffTreatedPatient();
                        scr.run();
                        break;
                    case STAFF_MENU_ADD_SYMPTOMS:
                        scr = new StaffAddSymptoms();
                        scr.run();
                        break;
                    case STAFF_MENU_ADD_SEVERITY_SCALE:
                        scr = new StaffAddSeverityScale();
                        scr.run();
                        break;
                    case STAFF_MENU_ADD_ASSESSMENT_RULE:
                        scr = new StaffAddAssesmentRule();
                        scr.run();
                        break;
                    case STAFF_MENU_GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.StaffSignIn);
                        break;
                    default:
                        invalidOption = true;
                        break;
                }
                if (ViewerContext.getInstance().getGoToPage() == ViewerContext.PAGES.StaffMenu) {
                    goBack = true;
                    ViewerContext.getInstance().resetGoToPage();
                }
            } catch (Exception e) {
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                invalidOption = true;
            }
        } while (invalidOption || goBack);
    }
}
