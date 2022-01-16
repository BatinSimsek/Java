package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//   Voor een geselecteerde cursus, geef hoeveel cursisten deze in het geheel behaald hebben
public class AmmountPassedCourseController {

    private Database db = new Database();

    //Deze methode haalt de som op van hoe vaak een cursus behaald is.
    public int getAmmountOfCourseCompleted(String courseName) {
        int total = 0;

        String query = "SELECT COUNT(CertificateID) AS Completed FROM Enrollment WHERE CertificateID IS NOT NULL AND CourseName ='" + courseName + "'GROUP BY CourseName";
        try {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return total;
    }
    // deze methode haalt de  course namen op die aanwezig zijn in de inschrijvingen.
    public ArrayList<String> getCourses() {
        ArrayList<String> courseList = new ArrayList<>();
        String query = "SELECT DISTINCT CourseName FROM Enrollment";

        try {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                courseList.add(rs.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courseList;
    }
}
