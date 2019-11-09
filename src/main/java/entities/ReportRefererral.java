package entities;

public class ReportRefererral {
    private int report_id, facility_id, visit_id, reason_code, service_code, referrer_id;
    private String discharge_status, reason, treatment;

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
