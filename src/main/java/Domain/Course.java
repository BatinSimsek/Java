package Domain;

public class Course {
    private String courses;
    private String topic;
    private String description;
    private String level;

    public Course(String courses, String topic, String description, String level){
        this.courses = courses;
        this.topic = topic;
        this.description = description;
        this.level = level;
    }

    public String getCourses() {
        return courses;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getDescription() {
        return description;
    }

    public String getLevel() {
        return level;
    }
}
