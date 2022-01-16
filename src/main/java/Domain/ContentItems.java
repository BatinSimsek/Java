package Domain;

import java.time.LocalDate;

public class ContentItems {
    private int contentID;
    private LocalDate publicationDate;
    private String status;
    private String moduleTitle;
    private String webcastTitle;

    public ContentItems(int contentID, LocalDate publicationDate, String status, String moduleTitle, String webcastTitle) {
        this.contentID = contentID;
        this.publicationDate = publicationDate;
        this.status = status;
        this.moduleTitle = moduleTitle;
        this.webcastTitle = webcastTitle;
    }

    public String getModuleTitle() {
        return moduleTitle;
    }

    public String getWebcastTitle() {
        return webcastTitle;
    }

    public String getStatus() {
        return status;
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
