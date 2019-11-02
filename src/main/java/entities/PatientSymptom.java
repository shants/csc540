package entities;

public class PatientSymptom {
    private int visitID, facilityID, duration;
    private String severityValue, postEvent, isRecurring, bodyPart;
    private Symptom symptom;

    public PatientSymptom(int visitID, int facilityID, int duration, Symptom symptom, String severityValue, String postEvent, String isRecurring) {
        this.visitID = visitID;
        this.facilityID = facilityID;
        this.duration = duration;
        this.severityValue = severityValue.toUpperCase();
        this.postEvent = postEvent.toUpperCase();
        this.symptom = symptom;
        this.isRecurring = isRecurring.toUpperCase();

    }

    public PatientSymptom(){}

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
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

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }
}
