package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;

public class DummyQueries extends Utils.IScreen {
    public void display() {
        System.out.println(MessageUtils.DUMMY_QUERIES.D1.ordinal() + MessageUtils.GLOBAL_DELIMITER +
                MessageUtils.DUMMY_QUERIES_1);
        System.out.println(MessageUtils.DUMMY_QUERIES.D2.ordinal() + MessageUtils.GLOBAL_DELIMITER +
                MessageUtils.DUMMY_QUERIES_2);
        System.out.println(MessageUtils.DUMMY_QUERIES.D3.ordinal() + MessageUtils.GLOBAL_DELIMITER +
                MessageUtils.DUMMY_QUERIES_3);
        System.out.println(MessageUtils.DUMMY_QUERIES.D4.ordinal() + MessageUtils.GLOBAL_DELIMITER +
                MessageUtils.DUMMY_QUERIES_4);
        System.out.println(MessageUtils.DUMMY_QUERIES.D5.ordinal() + MessageUtils.GLOBAL_DELIMITER +
                MessageUtils.DUMMY_QUERIES_5);
        System.out.println(MessageUtils.DUMMY_QUERIES.D6.ordinal() + MessageUtils.GLOBAL_DELIMITER +
                MessageUtils.DUMMY_QUERIES_6);
        System.out.println(MessageUtils.DUMMY_QUERIES.Back.ordinal() + MessageUtils.GLOBAL_DELIMITER +
                MessageUtils.GLOBAL_GO_BACK);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
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
                MessageUtils.DUMMY_QUERIES options = MessageUtils.DUMMY_QUERIES.values()[option];
                IScreen scr;
                switch (options) {
                    case D1:
                        break;
                    case D2:
                        break;
                    case D3:
                        break;
                    case D4:
                        break;
                    case D5:
                        break;
                    case D6:
                        break;
                    case Back:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.Home);
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
