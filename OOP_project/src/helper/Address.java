package helper;

public class Address {
    public String country;
    public String city;

    public Address() {}

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public void setAddress(){
        setCountry();
        setCity();

    }

    public void setCountry() {
        country = Input.getString("enter country name: ", "wrong input! enter agin");
    }

    public void setCity() {
        city = Input.getString("enter city name: ", "wrong input! enter agin");
    }

}
