package Utils;

import java.util.Stack;

public class StackFrame {
    private static StackFrame _instance = null;
    private Stack stack = null;
    public void addFrame(Utils.IScreen screen){
        if (stack == null){
            stack = new Stack();
        }
        stack.push(screen);
    }

    public void popFrame(){
        if (stack == null){
            return ;
        }else {
            stack.pop();
        }
    }

    private StackFrame(){}
    public static StackFrame getInstance(){
        if (_instance == null){
            _instance = new StackFrame();
        }
        return _instance;
    }
}
