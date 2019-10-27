package entities;

import java.util.Date;

public class Visit {
    private int visit_id;
    private int patient_id;
    private Date start_time;
    private Date end_time;
    private int bp_low;
    private int bp_high;
    private int body_temp;
    private int priority_id;

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

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public int getBp_low() {
        return bp_low;
    }

    public void setBp_low(int bp_low) {
        this.bp_low = bp_low;
    }

    public int getBp_high() {
        return bp_high;
    }

    public void setBp_high(int bp_high) {
        this.bp_high = bp_high;
    }

    public int getBody_temp() {
        return body_temp;
    }

    public void setBody_temp(int body_temp) {
        this.body_temp = body_temp;
    }

    public int getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(int priority_id) {
        this.priority_id = priority_id;
    }
}
