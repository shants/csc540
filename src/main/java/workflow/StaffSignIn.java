package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_files.FacilityCRUD;
import db_files.StaffCRUD;
import entities.Staff;

public class StaffSignIn extends IScreen {

    private Staff staff = new Staff();

    @Override
    public void display() {
        System.out.println(MessageUtils.STAFF_SIGNIN.STAFF_SIGNIN_START.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.STAFF_SIGNIN_START);
        System.out.println(MessageUtils.STAFF_SIGNIN.STAFF_SIGNIN_EXIT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_EXIT);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }

    public void signinStaff() {
        System.out.println(MessageUtils.STAFF_SIGNIN_NAME);
        staff.setName(CommandLineUtils.ReadInput());
    }

    @Override
    public void run() {
        boolean invalidOption;
        do {
            invalidOption = false;
            int option;
            display();
            String opt = CommandLineUtils.ReadInput();
            try {
                option = Integer.parseInt(opt);
                MessageUtils.STAFF_SIGNIN options = MessageUtils.STAFF_SIGNIN.values()[option];
                IScreen scr;
                switch (options) {
                    case STAFF_SIGNIN_START:
                        FacilityCRUD.selectFacility();
                        signinStaff();
                        staff.setFacilityID(ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.FACILITY_ID));
                        StaffCRUD.signin(staff);
                        if (ViewerContext.getInstance().getValue(ViewerContext.IDENTIFIER_TYPES.STAFF_ID) != null) {
                            System.out.println("WELCOME "+ staff.getName() + MessageUtils.GLOBAL_NEWLINE);
                            scr = new StaffMenu();
                            scr.run();
                        }
                        else{
                            invalidOption = true;
                        }
                        break;
                    case STAFF_SIGNIN_EXIT:
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
