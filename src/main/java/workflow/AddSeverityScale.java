package workflow;
import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;

public class AddSeverityScale extends IScreen{

    public void display(){
        System.out.println(MessageUtils.ADD_SEVERITY_SCALE.ADD_SEVERITY_SCALE_RANGE.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.ADD_SEVERITY_RANGE);
        System.out.println(MessageUtils.ADD_SEVERITY_SCALE.ADD_SEVERITY_SCALE_NO_LEVEL.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.ADD_SEVERITY_NO_LEVEL);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }

    public void enterSeverityScale(){
        //take the inputs here
    }
    public void run(){

        boolean invalidOption;
        do {
            invalidOption = false;
            int option;
            display();
            String opt = CommandLineUtils.ReadInput();
            try {
                option = Integer.parseInt(opt);
                MessageUtils.ADD_SEVERITY_SCALE options = MessageUtils.ADD_SEVERITY_SCALE.values()[option];
                IScreen scr;
                switch (options) {
                    case ADD_SEVERITY_SCALE_RANGE:
                        enterSeverityScale();
                    case ADD_SEVERITY_SCALE_NO_LEVEL:
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
