package entities;

public class ReportRefererral {
    private int report_id, facility_id, visit_id, reason_code, service_code, referrer_id, negative_experience_value,
            staff_id, reason_id, discharge_status_code;
    private String discharge_status, reason, treatment, negative_experience_text;

    public ReportRefererral(int visit_id, int facility_id, int referrer_id, int report_id, int reason_code,
                            int service_code, String discharge_status, String reason) {
        this.discharge_status = discharge_status;
        this.reason = reason;
        this.visit_id = visit_id;
        this.facility_id = facility_id;
        this.referrer_id = referrer_id;
        this.report_id = report_id;
        this.reason_code = reason_code;
        this.service_code = service_code;
    }

    public ReportRefererral() {}

    public int getDischarge_status_code() { return this.discharge_status_code; }

    public void setDischarge_status_code( int code) { this.discharge_status_code = code; }

    public int getReason_id() { return this.reason_id; }

    public void setReason_id(int id) { this.reason_id = id; }

    public int getStaff_id() { return this.staff_id; }

    public void setStaff_id(int id) { this.staff_id = id; }

    public int getNegative_experience_value() { return this.negative_experience_value; }

    public void setNegative_experience_value( int value) { this.negative_experience_value = value; }

    public String getNegative_experience_text() { return this.negative_experience_text; }

    public void setNegative_experience_text(String text) { this.negative_experience_text = text; }

    public int getReport_id() { return this.report_id; }

    public void setReport_id(int report_id) { this.report_id = report_id; }

    public int getFacility_id() { return this.facility_id; }

    public void setFacility_id(int facility_id) { this.facility_id = facility_id; }

    public int getVisit_id() { return this.visit_id; }

    public void setVisit_id(int visit_id) { this.visit_id = visit_id; }

    public int getReason_code() { return this.reason_code; }

    public void setReason_code(int reason_code) { this.reason_code = reason_code; }

    public int getService_code() { return this.service_code; }

    public void setService_code(int service_code) { this.service_code = service_code; }

    public int getReferrer_id() { return this.referrer_id; }

    public void setReferrer_id(int referrer_id) { this.referrer_id = referrer_id; }

    public String getDischarge_status() { return this.discharge_status; }

    public void setDischarge_status(String discharge_status) { this.discharge_status = discharge_status; }

    public String getReason() { return this.reason; }

    public void setReason(String reason) { this.reason = reason; }

    public String getTreatment() {
        return this.treatment;
    }

    public void setTreatment(String treatment) { this.treatment = treatment; }
}
