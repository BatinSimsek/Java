package Domain;

import java.util.Date;

public class Cursist {

    private String email;
    private String name;
    private String birthdate;
    private String sex;
    private String city;
    private String address;
    private String country;

    //constructor
    public Cursist(String email, String name, String birthdate, String sex, String city, String address, String country) {
        this.email = email;
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
        this.city = city;
        this.address = address;
        this.country = country;
    }

    //getters setters


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getSex() {
        return sex;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String naam) {
        this.name = naam;
    }

    public void setBirthdate(String geboorteDatum) {
        this.birthdate = geboorteDatum;
    }

    public void setSex(String geslacht) {
        this.sex = geslacht;
    }

    public void setCity(String woonPlaats) {
        this.city = woonPlaats;
    }

    public void setAddress(String adres) {
        this.address = adres;
    }

    public void setCountry(String land) {
        this.country = land;
    }
}
