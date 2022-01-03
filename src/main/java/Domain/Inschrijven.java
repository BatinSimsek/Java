package Domain;


import java.time.LocalDateTime;


public class Inschrijven {

    private Student student;
    private Course course;
    private LocalDateTime enroll;
    private int certeficaatID;

    public Inschrijven(Student student, Course course, LocalDateTime enroll) {
        this.student = student;
        this.course = course;
        this.enroll = enroll;

    }


    public Student getCursist() {
        return student;
    }

    public void setCursist(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getEnroll() {
        return enroll;
    }

    public void setEnroll(LocalDateTime enroll) {
        this.enroll = enroll;
    }

    public int getCerteficaatID() {
        return certeficaatID;
    }


}
