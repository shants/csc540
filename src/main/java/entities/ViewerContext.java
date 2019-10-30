package entities;

import Utils.StackFrame;

import java.util.HashMap;

public class ViewerContext {

    private static ViewerContext vcSingletonInstance;

    public enum IDENTIFIER_TYPES {
        PATIENT_ID, STAFF_ID, FACILITY_ID
    }

    private HashMap<IDENTIFIER_TYPES, Integer> identifiers = new HashMap<>();
    private StackFrame stackFrame;

    private ViewerContext(){
        stackFrame = StackFrame.getInstance();
    }

    public static ViewerContext getInstance() {
        if (vcSingletonInstance == null) {
            vcSingletonInstance = new ViewerContext();
        }
        return vcSingletonInstance;
    }

    public void addValue(int id, IDENTIFIER_TYPES type){
        identifiers.put(type, id);
    }

    public Integer getValue(IDENTIFIER_TYPES type) {
        if (!identifiers.containsKey(type)){
            return null;
        }
        else {
            return identifiers.get(type);
        }
    }

    public StackFrame getStackFrame() {
        return stackFrame;
    }
}
