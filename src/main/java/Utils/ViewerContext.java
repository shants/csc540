package Utils;

import entities.PatientSymptom;
import entities.Visit;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewerContext {

    private static ViewerContext vcSingletonInstance;
    private PAGES goToPage = null;
    private HashMap<IDENTIFIER_TYPES, Integer> identifiers = new HashMap<>();
    private ArrayList<PatientSymptom> symptomList = new ArrayList<>();
    private Visit patientToCheckout;

    public enum IDENTIFIER_TYPES {
        PATIENT_ID, STAFF_ID, FACILITY_ID, VISIT_ID
    }


    public enum PAGES {
        AddReason, AddSeverityScale, AddSymptoms, DischargeStatus, Home, MainFlow, NegativeExperience,
        PatientCheckin, PatientCheckoutAcknowledgement, PatientRouting, PatientSymptomMeta,
        ReferralStatus, Signin, Signup, StaffAddSymptoms, StaffEnterVitals, StaffMenu, StaffPatientReport,
        StaffPatientReportConfirmation, StaffProcessPatient, StaffSignIn, StaffTreatedPatient,
        StaffTreatedPatientCheckout, StaffTreatPatient
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

    public static void destroyInstance() {
        vcSingletonInstance = null;
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


    public void addSymptom(PatientSymptom ps) { symptomList.add(ps);}
}
