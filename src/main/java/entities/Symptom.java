package entities;

public class Symptom {
    private int symptom_code;
    private String symptom_name;

    public int getSymptom_code() {
        return symptom_code;
    }

    public String getSymptom_name() {
        return symptom_name;
    }

    public void setSymptom_code(int symptom_code) {
        this.symptom_code = symptom_code;
    }

    public void setSymptom_name(String symptom_name) {
        this.symptom_name = symptom_name;
    }
}
