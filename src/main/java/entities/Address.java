package entities;

public class Address {
    private String streetNumber, streetName, cityName, stateName, countryName;
    private int id;

    public Address(String streetNumber, String streetName, String cityName, String stateName, String countryName, int id){
        this.cityName = cityName.toUpperCase();
        this.countryName = countryName.toUpperCase();
        this.stateName = stateName.toUpperCase();
        this.streetName = streetName.toUpperCase();
        this.streetNumber = streetNumber.toUpperCase();
        this.id = id;
    }

    public Address(){}

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber.toUpperCase();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName.toUpperCase();
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName.toUpperCase();
    }

    public void setStateName(String stateName) {
        this.stateName = stateName.toUpperCase();
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName.toUpperCase();
    }

    public String getStreetNumber() {
        return this.streetNumber;
    }

    public String getCityName() {
        return this.cityName;
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getStreetName() {
        return this.streetName;
    }
}
