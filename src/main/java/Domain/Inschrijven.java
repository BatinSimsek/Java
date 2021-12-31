package Domain;


import java.time.LocalDateTime;
import java.util.Random;

public class Inschrijven {

    private Cursist cursist;
    private Course course;

    private LocalDateTime enroll;
    private int certeficaatID;
    private String cursusNaam;
    private String email;

//    private CursistController cursistController;


    public Inschrijven(LocalDateTime enroll) {
//        this.enroll = enroll;
//        this.certeficaatID = setCerteficaatID();
//        this.cursusNaam = course.getCourseName();
//        this.email = cursist.getEmail();

    }


    public int setCerteficaatID() {
        Random random = new Random();
        return random.nextInt(9999);
    }



}
