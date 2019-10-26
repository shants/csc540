package entities;

public class Patient {
    private int facilityId, phoneNumber, id;
    private String firstName, lastName, dateOfBirth;
    private Address address;

    public Patient(int facilityId, int phoneNumber, String firstName,
                   String lastName, String dateOfBirth, Address address, int patientId){
        this.facilityId = facilityId;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.id = patientId;
    }

    public Patient(){}

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getFacilityId() {
        return facilityId;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
