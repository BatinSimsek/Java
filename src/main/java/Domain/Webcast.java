package Domain;

public class Webcast{
    private String title;
    private String description;
    private double duration;
    private String url;

    public Webcast(String title, String description, double duration, String url){
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.url = url;
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

    public String getUrl() {
        return url;
    }
}
