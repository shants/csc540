package entities;

public class SeverityScale {
    private int severityID, facilityID, indexNumber;
    private String value;

    public SeverityScale(int severityID, int facilityID, int indexNumber, String value) {
        this.severityID = severityID;
        this.facilityID = facilityID;
        this.indexNumber = indexNumber;
        this.value = value.toUpperCase();
    }

    public SeverityScale() { }

    public int getSeverityID() {
        return severityID;
    }

    public void setSeverityID(int severityID) {
        this.severityID = severityID;
    }

    public int getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(int facilityID) {
        this.facilityID = facilityID;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value.toUpperCase();
    }
}
