package workflow;

import Utils.IScreen;

public class MainFlow{
    public static void main(String[] args){
        IScreen scr = new Home();
        scr.run();
    }
}
