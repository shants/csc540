package entities;

public class Patient {
    private int facilityId, id;
    private String firstName, lastName, dateOfBirth;
    private Address address;
    private long phoneNumber;

    public Patient(int facilityId, long phoneNumber, String firstName,
                   String lastName, String dateOfBirth, Address address, int patientId){
        this.facilityId = facilityId;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName.toUpperCase();
        this.lastName = lastName.toUpperCase();
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
        this.firstName = firstName.toUpperCase();
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.toUpperCase();
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getFacilityId() {
        return facilityId;
    }
    public long getPhoneNumber() {
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
