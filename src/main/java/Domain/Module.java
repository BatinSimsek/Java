package Domain;

import java.time.LocalDate;

public class Module extends ContentItem {
    private String title;
    private String description;
    private double version;
    private String nameContact;
    private String emailContact;
    private int serialNumber;

    public Module(int contentId, LocalDate publicationDate ,String status ,String title, String description, double version, String nameContact, String emailContact, int serialNumber ){
        super(contentId, publicationDate, status);
        this.title = title;
        this.description = description;
        this.version = version;
        this.nameContact = nameContact;
        this.emailContact = emailContact;
        this.serialNumber = serialNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getVersion() {
        return version;
    }

    public String getNameContact() {
        return nameContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public int getSerialNumber() {
        return serialNumber;
    }
}
