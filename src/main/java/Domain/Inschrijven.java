package Domain;


import java.time.LocalDateTime;


public class Inschrijven {

    private Cursist cursist;
    private Course course;
    private LocalDateTime enroll;
    private int certeficaatID;

    public Inschrijven(Cursist cursist, Course course, LocalDateTime enroll) {
        this.cursist = cursist;
        this.course = course;
        this.enroll = enroll;

    }


    public Cursist getCursist() {
        return cursist;
    }

    public void setCursist(Cursist cursist) {
        this.cursist = cursist;
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
