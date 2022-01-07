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
        String query = "SELECT * FROM student";

        try {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Student student = new Student(
                        rs.getString("email"),
                        rs.getString("name"),
                        rs.getDate("birthDate").toLocalDate(),
                        rs.getString("gender"),
                        rs.getString("city"),
                        rs.getString("postalCode"),
                        rs.getString("street"),
                        rs.getInt("houseNr"),
                        rs.getString("country"));
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

        String query = "INSERT INTO student VALUES('" + email + "','"
                + name + "','" + by + "-" + bm + "-" + bd + "','"
               + gender + "','" + city +  "','"
                + postalCode + "','" + street + "',"
                + houseNr + ",'" + country + "')";
     return query;
    }

    //Deze methode stelt een query samen om een cursist record te verwijderen
    public String makeDeleteQuery (String email){
        String query = "DELETE FROM student WHERE email =" + "'" + email + "'";
        return query;
    }

    // deze methode stelt een update query samen om een cursist te updaten
    public String makeUpdateQuery(String emailNew, String name, int bd, int bm, int by, String gender, String city,
                                  String postalCode, String street, int houseNr, String country, String emailOld) {
        String query = "UPDATE student SET email ='" + emailNew + "', name = '" + name +
                "', birthDate = '" + by + "-" + bm + "-" + bd + "'," +
                "gender = '" + gender +
                "', city = '" + city +
                "', postalCode = '" + postalCode +
                "', street = '" + street +
                "', houseNr = '" + houseNr +
                "', country = '" + country +
                "' WHERE email = '" + emailOld +"'";
        return query;
    }
}
