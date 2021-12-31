package Domain;


import java.time.LocalDateTime;
import java.util.Random;

public class Inschrijven {

    private Cursist cursist;
    private Course course;
    private LocalDateTime enroll;
    private int certeficaatID;

    public Inschrijven(Cursist cursist, Course course, LocalDateTime enroll) {
        this.cursist = cursist;
        this.course = course;
        this.enroll = enroll;
        this.certeficaatID = setCerteficaatID();
    }


    public int setCerteficaatID() {
        Random random = new Random();
        return random.nextInt(9999);
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

    public void setCerteficaatID(int certeficaatID) {
        this.certeficaatID = certeficaatID;
    }
}
