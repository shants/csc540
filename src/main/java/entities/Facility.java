package entities;

public class Facility {
    private String name, classification;
    private int capacity, id;
    private Address address;


    public Facility(String name, String classification, int capacity, Address address, int id){
        this.name = name;
        this.classification = classification;
        this.capacity = capacity;
        this.address = address;
        this.id = id;
    }

    public Facility() {}

    public String getName(){
        return this.name;
    }
    public String getClassification(){
        return this.classification;
    }
    public Address getAddress() {
        return address;
    }
    public int getId(){
        return this.id;
    }
    public int getCapacity() { return this.capacity; }

    public void setName(String _name){
        this.name = _name;
    }
    public void setClassification(String _classification){
         this.classification = _classification;
    }
    public void setId(int _id) { this.id = _id;}
    public void setCapacity(int capacity) { this.capacity = capacity;}
    public void setAddress(Address address) {
        this.address = address;
    }

}
