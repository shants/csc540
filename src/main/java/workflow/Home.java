package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import db_utils.FacilityCRUD;

public class Home extends IScreen {

    public void display() {
        System.out.println(MessageUtils.HOME.HOME_SIGN_IN.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.HOME_SIGN_IN);
        System.out.println(MessageUtils.HOME.HOME_SIGN_UP.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.HOME_SIGN_UP);
        System.out.println(MessageUtils.HOME.HOME_DEMO_QUERIES.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.HOME_DEMO_QUERIES);
        System.out.println(MessageUtils.HOME.HOME_EXIT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_EXIT);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }

    public void run() {
        boolean invalidOption, goBack;
        do {
            invalidOption = goBack = false;
            int option;
            display();
            String opt = CommandLineUtils.ReadInput();
            try {
                option = Integer.parseInt(opt);
                MessageUtils.HOME options = MessageUtils.HOME.values()[option];
                IScreen scr;
                switch (options) {
                    case HOME_SIGN_IN:
                        FacilityCRUD.selectFacility();
                        scr = new SignIn();
                        scr.run();
                        break;
                    case HOME_SIGN_UP:
                        FacilityCRUD.selectFacility();
                        scr = new SignUp();
                        scr.run();
                        break;
                    case HOME_DEMO_QUERIES:
                        scr = new DummyQueries();
                        scr.run();
                        break;
                    case HOME_EXIT:
                        return;
                    default:
                        invalidOption = true;
                        break;
                }
                if (ViewerContext.getInstance().getGoToPage() == ViewerContext.PAGES.Home) {
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
