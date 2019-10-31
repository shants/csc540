package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_files.FacilityCRUD;
import entities.Facility;
import java.util.ArrayList;

public class Home extends IScreen {

    public void display() {
        System.out.println(MessageUtils.HOME.HOME_SIGN_IN.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.HOME_SIGN_IN);
        System.out.println(MessageUtils.HOME.HOME_SIGN_UP.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.HOME_SIGN_UP);
        System.out.println(MessageUtils.HOME.HOME_DEMO_QUERIES.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.HOME_DEMO_QUERIES);
        System.out.println(MessageUtils.HOME.HOME_EXIT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.HOME_EXIT);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }

    public void selectFacility() {
        boolean invalid;
        ArrayList<Facility> facilityList = FacilityCRUD.readAll();
        do {
            invalid = false;
            System.out.println(MessageUtils.GLOBAL_SELECT_FACILITY);
            for (int i = 0; i < facilityList.size(); i++) {
                System.out.println(i + MessageUtils.GLOBAL_DELIMITER + facilityList.get(i).getName());
            }
            System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
            String opt = CommandLineUtils.ReadInput();
            try {
                int option = Integer.parseInt(opt);
                if (option >= facilityList.size()) {
                    System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                    invalid = true;
                } else {
                    ViewerContext.getInstance().addValue(facilityList.get(option).getId(), ViewerContext.IDENTIFIER_TYPES.FACILITY_ID);
                }
            } catch (NumberFormatException e) {
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                invalid = true;
            }
        }while(invalid);
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
                MessageUtils.HOME options = MessageUtils.HOME.values()[option];
                IScreen scr;
                switch (options) {
                    case HOME_SIGN_IN:
                        selectFacility();
                        scr = new SignIn();
                        scr.run();
                        break;
                    case HOME_SIGN_UP:
                        selectFacility();
                        scr = new SignUp();
                        scr.run();
                        break;
                    case HOME_DEMO_QUERIES:
                        break;
                    case HOME_EXIT:
                        return;
                    default:
                        invalidOption = true;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
                invalidOption = true;
            }
        } while (invalidOption);
    }
}
