package entities;

public class Address {
    private String streetNumber, streetName, cityName, stateName, CountryName;
    private int id;

    public Address(String streetNumber, String streetName, String cityName, String stateName, String countryName, int id){
        this.cityName = cityName;
        this.CountryName = countryName;
        this.stateName = stateName;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.id = id;
    }

    public Address(){}

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public String getCountryName() {
        return CountryName;
    }

    public String getStreetName() {
        return streetName;
    }
}
