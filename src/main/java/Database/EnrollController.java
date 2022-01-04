package Database;

import Domain.Enroll;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class EnrollController {
    private Database db = new Database();



    // Onderstaande methode geeft een lijst met cursist objecten.
    public ObservableList<Enroll> getEnrollmentList() {
        ObservableList<Enroll> enrollList = FXCollections.observableArrayList();
        String query = "SELECT * FROM enrollment";

        try {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Enroll enroll = new Enroll(
                        rs.getString("emailFk"),
                        rs.getInt("certificateFK"),
                        rs.getDate("registrationDate").toLocalDate(),
                        rs.getString("courseNameFK"));
                enrollList.add(enroll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return enrollList;
    }


    public String makeInsertQuery (String email, int certificateFK, LocalDate registrationDate, String courseNameFK){

        String query = "INSERT INTO enrollment VALUES('" + registrationDate + "',"
                + certificateFK + ",'" + courseNameFK + "', '" + email + "'" +")";
        return query;
    }

    //Deze methode stelt een query samen om een cursist record te verwijderen
    public String makeDeleteQuery (String email){
        String query = "DELETE FROM student WHERE email =" + "'" + email + "'";
        return query;
    }

    // deze methode stelt een update query samen om een cursist te updaten
    public String makeUpdateQuery(String email, String courseNameFK) {
        String query = "UPDATE enrollment SET emailFk ='" + email + "', courseNameFK = '" + courseNameFK + "'";
        return query;
    }


}
