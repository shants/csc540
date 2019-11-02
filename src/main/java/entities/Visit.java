package entities;

public class Visit {
    private int visit_id,patient_id,priority_id, facilityID;
    private String start_time, end_time;
    private float bp_low, bp_high, body_temp;

    public int getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(int facilityID) {
        this.facilityID = facilityID;
    }

    public int getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(int visit_id) {
        this.visit_id = visit_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public float getBp_low() {
        return bp_low;
    }

    public void setBp_low(float bp_low) {
        this.bp_low = bp_low;
    }

    public float getBp_high() {
        return bp_high;
    }

    public void setBp_high(float bp_high) {
        this.bp_high = bp_high;
    }

    public float getBody_temp() {
        return body_temp;
    }

    public void setBody_temp(float body_temp) {
        this.body_temp = body_temp;
    }

    public int getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(int priority_id) {
        this.priority_id = priority_id;
    }
}
