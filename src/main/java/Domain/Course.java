package Domain;

import java.util.ArrayList;
import java.util.List;

public class Course {
    protected List<Course> recommendedCourse = new ArrayList<>();
    private ArrayList<ContentItems> addContentItems = new ArrayList<>();
    private String CourseName;
    private String topic;
    private String description;
    private String level;

    public Course(String CourseName, String topic, String description, String level){
        this.CourseName = CourseName;
        this.topic = topic;
        this.description = description;
        this.level = level;
    }

    public String getCourseName() {
        return CourseName;
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

    public void addContentItems(ContentItems contentItems){
       this.addContentItems.add(contentItems);
    }

    public void showContentItems(){
        for (ContentItems c : this.addContentItems){
            c.getContentID();
        }
    }

}
