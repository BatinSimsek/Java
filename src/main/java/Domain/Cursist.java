package Domain;

import java.util.Date;

public class Cursist {

    private String email;
    private String naam;
    private Date geboorteDatum;
    private char geslacht;
    private String woonPlaats;
    private String adres;
    private String land;

    //constructor
    public Cursist(String email, String naam, Date geboorteDatum, char geslacht, String woonPlaats, String adres, String land) {
        this.email = email;
        this.naam = naam;
        this.geboorteDatum = geboorteDatum;
        this.geslacht = geslacht;
        this.woonPlaats = woonPlaats;
        this.adres = adres;
        this.land = land;
    }

    //getters setters


    public String getEmail() {
        return email;
    }

    public String getNaam() {
        return naam;
    }

    public Date getGeboorteDatum() {
        return geboorteDatum;
    }

    public char getGeslacht() {
        return geslacht;
    }

    public String getWoonPlaats() {
        return woonPlaats;
    }

    public String getAdres() {
        return adres;
    }

    public String getLand() {
        return land;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setGeboorteDatum(Date geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public void setGeslacht(char geslacht) {
        this.geslacht = geslacht;
    }

    public void setWoonPlaats(String woonPlaats) {
        this.woonPlaats = woonPlaats;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setLand(String land) {
        this.land = land;
    }
}
