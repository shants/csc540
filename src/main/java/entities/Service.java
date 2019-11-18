package entities;

public class Service {

    int dept_code;
    String name, equipment;

    public Service(int dept_code, String name, String equipment, int code) {
        this.dept_code = dept_code;
        this.name = name;
        this.equipment = equipment;
        this.code = code;
    }

    public Service() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    int code;

    public int getDept_code() {
        return dept_code;
    }

    public void setDept_code(int dept_code) {
        this.dept_code = dept_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }




}
