package Utils;

import entities.PatientSymptom;
import entities.Visit;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewerContext {

    private static ViewerContext vcSingletonInstance;

    public enum IDENTIFIER_TYPES {
        PATIENT_ID, STAFF_ID, FACILITY_ID, VISIT_ID
    }

    public enum PAGES {
        AddReason, AddSymptoms, DischargeStatus, Home, MainFlow, NegativeExperience,
        PatientCheckin, PatientCheckoutAcknowledgement, PatientRouting, PatientSymptomMeta,
        ReferralStatus, Signin, Signup, StaffEnterVitals, StaffMenu, StaffPatientReport,
        StaffPatientReportConfirmation, StaffProcessPatient, StaffTreatedPatient,
        StaffTreatedPatientCheckout, StaffTreatPatient
    }

    private PAGES goToPage = null;
    private HashMap<IDENTIFIER_TYPES, Integer> identifiers = new HashMap<>();
    private StackFrame stackFrame;
    private ArrayList<PatientSymptom> symptomList = new ArrayList<>();
    private Visit patientToCheckout;

    private ViewerContext(){
        stackFrame = StackFrame.getInstance();
    }

    public PAGES getGoToPage() {
        return goToPage;
    }

    public void setGoToPage(PAGES goToPage) {
        this.goToPage = goToPage;
    }

    public void resetGoToPage() {
        this.goToPage = null;
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
    public Visit getPatientToCheckout() {
        return patientToCheckout;
    }

    public void setPatientToCheckout(Visit patientToCheckout) {
        this.patientToCheckout = patientToCheckout;
    }
    public StackFrame getStackFrame() {
        return stackFrame;
    }
    public void addSymptom(PatientSymptom ps) { symptomList.add(ps);}
}
