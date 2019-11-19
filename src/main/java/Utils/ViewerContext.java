package Utils;

import config.DatabaseConnection;
import entities.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewerContext {

    private static ViewerContext vcSingletonInstance;
    private PAGES goToPage = null;
    private HashMap<IDENTIFIER_TYPES, Integer> identifiers = new HashMap<>();
    private HashMap<IDENTIFIER_NAMES, String> Names = new HashMap<>();
    private ArrayList<PatientSymptom> symptomList = new ArrayList<>();
    private ArrayList<Symptom> symptomsForCheckin = new ArrayList<>();
    private Visit patientToCheckout;
    private ReportRefererral patientReport;
    private NegExpDescription negExperienceDesc;
    private String symptomCode;


    public NegExpDescription getNegExperienceDesc() {
        return negExperienceDesc;
    }

    public void setNegExperienceDesc(NegExpDescription negExperienceDesc) {
        this.negExperienceDesc = negExperienceDesc;
    }

    public enum IDENTIFIER_TYPES {
        PATIENT_ID, STAFF_ID, FACILITY_ID, VISIT_ID
    }

    public ArrayList<Symptom> getSymptomsForCheckin() {
        return this.symptomsForCheckin;
    }

    public void addSymptomForCheckin(Symptom symptom){
        this.symptomsForCheckin.add(symptom);
    }


    public enum IDENTIFIER_NAMES{
        SYMPTOM_NAME
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
        DatabaseConnection.getInstance().destroyConnection();
        vcSingletonInstance = null;
    }


    public void addValue(int id, IDENTIFIER_TYPES type){ identifiers.put(type, id); }

    public void addNames(String name, IDENTIFIER_NAMES type) {Names.put(type, name); }

    public Integer getValue(IDENTIFIER_TYPES type) {
        if (!identifiers.containsKey(type)){
            return null;
        }
        else {
            return identifiers.get(type);
        }
    }

    public String getNames(IDENTIFIER_NAMES type) {
        if (!Names.containsKey(type)){
            return null;
        }
        else {
            return Names.get(type);
        }
    }

    public Visit getPatientToCheckout() {
        return patientToCheckout;
    }

    public void setPatientToCheckout(Visit patientToCheckout) {
        this.patientToCheckout = patientToCheckout;
    }

    public void addSymptom(PatientSymptom ps) { symptomList.add(ps);}

    public ArrayList<PatientSymptom> getSymptoms() { return symptomList;}

    public void setPatientReport(ReportRefererral rep) { this.patientReport = rep; }

    public ReportRefererral getPatientReport() { return patientReport; }

    public String getSymptomCode() {
        return symptomCode;
    }

    public void setSymptomCode(String symptomCode) {
        this.symptomCode = symptomCode;
    }

}
