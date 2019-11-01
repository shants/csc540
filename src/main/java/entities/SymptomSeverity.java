package entities;

public class SymptomSeverity {
    private String type, symptomCode;
    private int staffID, facilityID;

    public SymptomSeverity() {}

    public SymptomSeverity(String type, String symptomCode, int staffID, int facilityID) {
        this.type = type.toUpperCase();
        this.symptomCode = symptomCode.toUpperCase();
        this.staffID = staffID;
        this.facilityID = facilityID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type.toUpperCase();
    }

    public String getSymptomCode() {
        return symptomCode;
    }

    public void setSymptomCode(String symptom_code) {
        this.symptomCode = symptom_code.toUpperCase();
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    public int getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(int facilityID) {
        this.facilityID = facilityID;
    }

}
