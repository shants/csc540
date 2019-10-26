package entities;

public class Facility {
    private String name;
    private int classification;
    private Address address;
    private int id;


    public Facility(String name, int classification, Address address, int id){
        this.name = name;
        this.classification = classification;
        this.address = address;
        this.id = id;
    }

    public Facility() {}

    public String getName(){
        return this.name;
    }
    public int getClassification(){
        return this.classification;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
    public void setId(int _id) { this.id = _id;}
}
