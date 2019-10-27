package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;

public class Home implements IScreen {

    public void display() {
        System.out.println(MessageUtils.HOME.HOME_SIGN_IN.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.HOME_SIGN_IN);
        System.out.println(MessageUtils.HOME.HOME_SIGN_UP.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.HOME_SIGN_UP);
        System.out.println(MessageUtils.HOME.HOME_DEMO_QUERIES.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.HOME_EXIT);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }

    public void run() {
        display();
        String opt = CommandLineUtils.ReadOption();
        int option;
        try {
            option = Integer.parseInt(opt);
            MessageUtils.HOME options = MessageUtils.HOME.values()[option];
            switch(options) {
                case HOME_SIGN_IN:
                    IScreen scr = new SignIn();
                    scr.run();
                    break;
                case HOME_SIGN_UP:
                    break;
                case HOME_DEMO_QUERIES:
                    break;
                case HOME_EXIT:
                    return;
            }
        }catch (NumberFormatException e){
            System.out.println(MessageUtils.GLOBAL_OPTION_ERROR);
        }
    }
}
