package Domain;

import java.util.Date;

public class Cursist {

    private String email;
    private String name;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private String sex;
    private String city;
    private String postalCode;
    private String street;
    private int houseNr;
    private String country;

    //constructor
    public Cursist(String email, String name, int birthDay, int birthMonth, int birthYear, String sex, String city, String postalCode, String street, int houseNr, String country) {
        this.email = email;
        this.name = name;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.postalCode = postalCode;
        this.street = street;
        this.houseNr = houseNr;
        this.sex = sex;
        this.city = city;
        this.country = country;
    }

    //getters setters


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getBirthDay() {
        return birthDay;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getSex() {
        return sex;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNr() {
        return houseNr;
    }

    public String getCountry() {
        return country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(int birthDay) {
        this.birthDay = birthDay;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseNr(int houseNr) {
        this.houseNr = houseNr;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
