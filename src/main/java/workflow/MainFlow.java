package workflow;

import Utils.IScreen;
import Utils.ViewerContext;

public class MainFlow{
    public static void main(String[] args){
//        IScreen scr = new Home();
//        scr.run();
        ViewerContext.getInstance().addValue(1, ViewerContext.IDENTIFIER_TYPES.FACILITY_ID);
        ViewerContext.getInstance().addValue(1, ViewerContext.IDENTIFIER_TYPES.STAFF_ID);
        IScreen scr = new StaffMenu();
        scr.run();
    }
}
