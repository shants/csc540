package entities;

public class Symptom {
    private String symptom_code;
    private String symptom_name;
    private BodyPart bodyPart;
    private String severityValue;

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

    public String getSymptom_code() {
        return symptom_code;
    }

    public void setSymptom_code(String symptom_code) {
        this.symptom_code = symptom_code.toUpperCase();
    }

    public String getSymptom_name() {
        return symptom_name;
    }

    public void setSymptom_name(String symptom_name) {
        this.symptom_name = symptom_name.toUpperCase();
    }

    public String getSeverityValue() {
        return severityValue;
    }

    public void setSeverityValue(String severityValue) {
        this.severityValue = severityValue;
    }
}
