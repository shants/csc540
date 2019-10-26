package entities;

public class MedicalFacility {
    private String name;
    private int classification;
    private String street_number;
    private String street;
    private String city;
    private String state;
    private String country;
    private int id;


    public MedicalFacility(String name, int classification,
           String street_number, String street, String city, String state, String country, int id){
        this.name = name;
        this.classification = classification;
        this.street_number = street_number;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.id = id;
    }
    public MedicalFacility() {

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
    public int getId(){
        return this.id;
    }

    public void setName(String _name){
        this.name = _name;
    }
    public void setClassification(int _classification){
         this.classification = _classification;
    }
    public void setStreetNumber(String _streetNumber){
        this.street_number= _streetNumber;
    }
    public void setStreet(String _street){
        this.street= _street;
    }
    public void setCity(String _city){
        this.city = _city;
    }
    public void setState(String _state){
        this.state = _state;
    }
    public void setCountry(String _country){
        this.country = _country;
    }
    public void setId(int _id) { this.id = _id;}
}
