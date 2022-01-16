package Database;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompletedCourseController {
    private Database db = new Database();

    public int getTotalEnrollmentsOfGender (String gender){
        int total = 0;

        String query = "SELECT COUNT(*) AS TotalEnrollments FROM Enrollment JOIN Student ON Enrollment.Email = Student.Email WHERE GENDER = '" + gender + "'GROUP BY Gender";
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

    public int getTotalCertificatesOfGender (String gender){
        int total = 0;

        String query = "SELECT COUNT(*) AS TotalCertifcates FROM Enrollment JOIN Student ON Enrollment.Email = Student.Email WHERE GENDER = '" + gender + "' AND CertificateID IS NOT NULL";
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
}
