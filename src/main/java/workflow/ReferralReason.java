package workflow;

import Utils.CommandLineUtils;
import Utils.IScreen;
import Utils.MessageUtils;
import Utils.ViewerContext;
import entities.ReportRefererral;

public class ReferralReason extends IScreen {
    public void display() {
        System.out.println(MessageUtils.SUBMIT_REASON.ADD_REASON.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.ADD_REASON);
        System.out.println(MessageUtils.SUBMIT_REASON.GLOBAL_GO_BACK.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.GLOBAL_GO_BACK);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }

    public void display_reason() {
        System.out.println(MessageUtils.REASON_CODE.SERVICE_UNAVAILABLE_TIME.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.SERVICE_UNAVAILABLE_TIME);
        System.out.println(MessageUtils.REASON_CODE.SERVICE_NOT_PRESENT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.SERVICE_NOT_PRESENT);
        System.out.println(MessageUtils.REASON_CODE.NON_PAYMENT.ordinal()
                + MessageUtils.GLOBAL_SPACE + MessageUtils.NON_PAYMENT);
        System.out.println(MessageUtils.GLOBAL_NEWLINE);
        System.out.println(MessageUtils.GLOBAL_ENTER_OPTION + MessageUtils.GLOBAL_DELIMITER);
    }

    public String getReasonFromCode(int code) {
        MessageUtils.REASON_CODE options = MessageUtils.REASON_CODE.values()[code];
        switch (options) {
            case SERVICE_UNAVAILABLE_TIME:
                return MessageUtils.SERVICE_UNAVAILABLE_TIME;
            case SERVICE_NOT_PRESENT:
                return MessageUtils.SERVICE_NOT_PRESENT;
            case NON_PAYMENT:
                return MessageUtils.NON_PAYMENT;
            default:
                break;
        }
        return "INVALID CODE";
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
                MessageUtils.SUBMIT_REASON options = MessageUtils.SUBMIT_REASON.values()[option];
                switch (options) {
                    case ADD_REASON:
                        display_reason();
                        String code = CommandLineUtils.ReadInput();
                        int reason_code = Integer.parseInt(code);
                        String reason = getReasonFromCode(reason_code);
                        ViewerContext.getInstance().getPatientReport().setReason_code(reason_code);
                        ViewerContext.getInstance().getPatientReport().setReason(reason);
                        break;
                    case GLOBAL_GO_BACK:
                        ViewerContext.getInstance().setGoToPage(ViewerContext.PAGES.ReferralStatus);
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
