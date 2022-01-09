package Domain;

import java.time.LocalDate;

public class Webcast extends ContentItem{
    private String title;
    private String description;
    private double duration;
    private LocalDate dateOfPublication;
    private String url;
    private String nameSpeaker;
    private String organizationSpeaker;

    public Webcast(int contentID,LocalDate publicationDate, String status,String title, String description, double duration, LocalDate dateOfPublication, String url, String nameSpeaker, String organizationSpeaker) {
        super(contentID, publicationDate, status);
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.dateOfPublication = dateOfPublication;
        this.url = url;
        this.nameSpeaker = nameSpeaker;
        this.organizationSpeaker = organizationSpeaker;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getDuration() {
        return duration;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public String getUrl() {
        return url;
    }

    public String getNameSpeaker() {
        return nameSpeaker;
    }

    public String getOrganizationSpeaker() {
        return organizationSpeaker;
    }
}
