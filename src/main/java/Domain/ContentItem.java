package Domain;

import java.time.LocalDate;

public abstract class ContentItem {
    private int contentID;
    private LocalDate publicationDate;
    private String status;

    public ContentItem(int contentID, LocalDate publicationDate, String status) {
        this.contentID = contentID;
        this.publicationDate = publicationDate;
        this.status = status;
    }

    public int getContentID() {
        return contentID;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public String getStaus() {
        return status;
    }

}
