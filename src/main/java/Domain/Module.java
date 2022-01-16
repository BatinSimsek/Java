package Domain;

import java.time.LocalDate;

public class Module {
    private String title;
    private String descreption;
    private double version;
    private String emailContact;
    private int serialNumber;

    public Module( String title, String descreption, double version, String emailContact, int serialNumber){
        this.title = title;
        this.descreption = descreption;
        this.version = version;
        this.emailContact = emailContact;
        this.serialNumber = serialNumber;
    }


    public String getTitle() {
        return title;
    }

    public String getDescreption() {
        return descreption;
    }

    public double getVersion() {
        return version;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
