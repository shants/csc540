package entities;

public class PatientSymptom {
    private int visitID, facilityID, duration;
    private String symptomCode, severityValue, postEvent, isRecurring;

    public PatientSymptom(int visitID, int facilityID, int duration, String symptomCode, String severityValue, String postEvent, String isRecurring) {
        this.visitID = visitID;
        this.facilityID = facilityID;
        this.duration = duration;
        this.symptomCode = symptomCode.toUpperCase();
        this.severityValue = severityValue.toUpperCase();
        this.postEvent = postEvent.toUpperCase();
        this.isRecurring = isRecurring.toUpperCase();
    }

    public int getVisitID() {
        return visitID;
    }

    public void setVisitID(int visitID) {
        this.visitID = visitID;
    }

    public int getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(int facilityID) {
        this.facilityID = facilityID;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSymptomCode() {
        return symptomCode;
    }

    public void setSymptomCode(String symptomCode) {
        this.symptomCode = symptomCode.toUpperCase();
    }

    public String getSeverityValue() {
        return severityValue;
    }

    public void setSeverityValue(String severityValue) {
        this.severityValue = severityValue.toUpperCase();
    }

    public String getPostEvent() {
        return postEvent;
    }

    public void setPostEvent(String postEvent) {
        this.postEvent = postEvent.toUpperCase();
    }

    public String getIsRecurring() {
        return isRecurring;
    }

    public void setIsRecurring(String isRecurring) {
        this.isRecurring = isRecurring.toUpperCase();
    }
}
