package Domain;


import java.time.LocalDate;


public class Enroll {


    private String emailFk;
    private int certificateFK;
    private LocalDate registrationDate;
    private String courseNameFK;

    public Enroll(String email, int certificateFK, LocalDate registrationDate, String courseNameFK) {

        this.emailFk = email;
        this.certificateFK = certificateFK;
        this.registrationDate = registrationDate;
        this.courseNameFK = courseNameFK;
    }


    public String getEmail() {
        return emailFk;
    }

    public void setEmail(String email) {
        this.emailFk = email;
    }

    public int getCertificateFK() {
        return certificateFK;
    }

    public void setCertificateFK(int certificateFK) {
        this.certificateFK = certificateFK;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCourseName() {
        return courseNameFK;
    }

    public void setCourseNameFK(String courseNameFK) {
        this.courseNameFK = courseNameFK;
    }
}
