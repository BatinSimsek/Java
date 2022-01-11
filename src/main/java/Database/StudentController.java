package Database;

import Domain.Student;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class StudentController {
private Database db = new Database();



// Onderstaande methode geeft een lijst met cursist objecten.
    public ObservableList<Student> getStudentList() {
        ObservableList<Student> studentList = FXCollections.observableArrayList();
        String query = "SELECT * FROM Student";

        try {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Student student = new Student(
                        rs.getString("Email"),
                        rs.getString("Name"),
                        rs.getDate("Birthdate").toLocalDate(),
                        rs.getString("Gender"),
                        rs.getString("City"),
                        rs.getString("PostalCode"),
                        rs.getString("Street"),
                        rs.getInt("HouseNr"),
                        rs.getString("Country"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }


    // Deze methode stelt een query samen om een cursist record toe te voegen.
    public String makeInsertQuery (String email, String name, int bd, int bm, int by, String gender, String city,
                                   String postalCode, String street, int houseNr, String country){

        String query = "INSERT INTO Student VALUES('" + email + "','"
                + name + "','" + by + "-" + bm + "-" + bd + "','"
               + gender + "','" + city +  "','"
                + postalCode + "','" + street + "',"
                + houseNr + ",'" + country + "')";
     return query;
    }

    //Deze methode stelt een query samen om een cursist record te verwijderen
    public String makeDeleteQuery (String email){
        String query = "DELETE FROM Student WHERE email =" + "'" + email + "'";
        return query;
    }

    // deze methode stelt een update query samen om een cursist te updaten
    public String makeUpdateQuery(String emailNew, String name, int bd, int bm, int by, String gender, String city,
                                  String postalCode, String street, int houseNr, String country, String emailOld) {
        String query = "UPDATE Student SET Email ='" + emailNew + "', Name = '" + name +
                "', Birthdate = '" + by + "-" + bm + "-" + bd + "'," +
                "Gender = '" + gender +
                "', City = '" + city +
                "', PostalCode = '" + postalCode +
                "', Street = '" + street +
                "', HouseNr = '" + houseNr +
                "', Country = '" + country +
                "' WHERE Email = '" + emailOld +"'";
        return query;
    }
}
