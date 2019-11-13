package entities;

public class NegExpDescription {
    private int negCode;
    private String negDescription;

    public NegExpDescription(int negCode, String negDescription) {
        this.negCode = negCode;
        this.negDescription = negDescription;
    }

    public int getNegCode() {
        return negCode;
    }

    public void setNegCode(int negCode) {
        this.negCode = negCode;
    }

    public String getNegDescription() {
        return negDescription;
    }

    public void setNegDescription(String negDescription) {
        this.negDescription = negDescription;
    }
}
