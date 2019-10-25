package entities;

public class MedicalFacility {
    private String name;
    private int classification;
    private String street_number;
    private String street;
    private String city;
    private String state;
    private String country;

    public MedicalFacility(String name, int classification,
           String street_number, String street, String city, String state, String country){
        this.name = name;
        this.classification = classification;
        this.street_number = street_number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
    }
    public String getName(){
        return this.name;
    }
    public int getClassification(){
        return this.classification;
    }
    public String getStreetNumber(){
        return this.street_number;
    }
    public String getStreet(){
        return this.street;
    }
    public String getCity(){
        return this.city;
    }
    public String getState(){
        return this.state;
    }
    public String getCountry(){
        return this.country;
    }
}
