package clases;

import helper.*;

public abstract class Human {

    private Name name;
    private Gender gender;
    private Address address;
    private PerthDate perthDate;

    public Human(){}

    public Human(Name name, Address address, Gender gender, PerthDate perthDate){
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.perthDate = perthDate;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PerthDate getPerthDate() {
        return perthDate;
    }

    public void setPerthDate(PerthDate perthDate) {
        this.perthDate = perthDate;
    }

    // print some data from this object
    public void getRecord(){
        System.out.printf("%-13.13s %-13.13s %-10.10s",
                name.fName,
                name.lName,
                gender
        );
    }

    public void getMetadata(){
        System.out.printf("%-13.13s %-13.13s %-10.10s","first name", "last name", "gender");
    }

    // print full data from this object
    public void getFullRecord(){
        System.out.printf(
                        "%-13.13s %-13.13s %-13.13s %-10.10s %-13.13s %-13.13s %-5.5s %-1s/%-1s/%-6.6s",
                name.fName
                        , name.mName
                        , name.lName
                        , gender
                        , address.country
                        , address.city
                        , perthDate.getAge()
                        , perthDate.year
                        , perthDate.month
                        , perthDate.day
        );
    }

    public void getFullMetadata(){
        System.out.printf("%-13.13s %-13.13s %-13.13s %-10.10s %-13.13s %-13.13s %-5.5s %-13.13s", "first name", "middle name", "last name", "gender", "country", "city", "age", "perth date");
    }
}
