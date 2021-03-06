package Domain;

import java.time.LocalDate;


public class Student {

    private String email;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private String city;
    private String postalCode;
    private String street;
    private int houseNr;
    private String country;

    //constructor
    public Student(String email, String name, LocalDate birthDate, String gender, String city, String postalCode, String street, int houseNr, String country) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
        this.postalCode = postalCode;
        this.street = street;
        this.houseNr = houseNr;
        this.gender = gender;
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

    public LocalDate getBirthdate() {
        return birthDate;
    }

    public int getBirthDay() {
        return this.birthDate.getDayOfMonth();
    }

    public int getBirthMonth() {
        return this.birthDate.getMonthValue();
    }

    public int getBirthYear() {
        return this.birthDate.getYear();

    }

    public String getGender() {
        return gender;
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

    public void setSex(String sex) {
        this.gender = gender;
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
