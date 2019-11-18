package entities;

public class Referral_Reason {
    private int reason_code, service_code;
    private String reason_string;

    public int getReason_code() {
        return reason_code;
    }

    public void setReason_code(int reason_code) {
        this.reason_code = reason_code;
    }

    public int getService_code() {
        return service_code;
    }

    public void setService_code(int service_code) {
        this.service_code = service_code;
    }

    public String getReason_string() {
        return reason_string;
    }

    public void setReason_string(String reason_string) {
        this.reason_string = reason_string;
    }

    public Referral_Reason() {
    }
}
