package Domain;

public class Course {
    private String course;
    private String topic;
    private String description;
    private String level;

    public Course(String course, String topic, String description, String level){
        this.course = course;
        this.topic = topic;
        this.description = description;
        this.level = level;
    }

    public String getCourse() {
        return course;
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
