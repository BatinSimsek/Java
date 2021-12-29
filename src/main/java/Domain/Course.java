package Domain;

public class Course {
    private String courseName;
    private String topic;
    private String description;
    private String level;

    public Course(String courseName, String topic, String description, String level){
        this.courseName = courseName;
        this.topic = topic;
        this.description = description;
        this.level = level;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public String getLevel() {
        return level;
    }
}
