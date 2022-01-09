package Domain;

import java.util.ArrayList;
import java.util.List;

public class Course {
    protected List<Course> recommendedCourse = new ArrayList<>();
    private ArrayList<ContentItem> addContentItem = new ArrayList<>();
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

    public List<Course> getRecommendedCourse(){
        return this.recommendedCourse;
    }

    public void addRecommendedCourse(Course course){
        this.recommendedCourse.add(course);
    }

    public void addContentItems(ContentItem contentItem){
       this.addContentItem.add(contentItem);
    }

    public void showContentItems(){
        for (ContentItem c : this.addContentItem){
            c.getContentID();
        }
    }

}
