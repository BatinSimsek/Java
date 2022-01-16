package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class ModuleProgressionController {
    private Database db = new Database();

    public HashMap<String, Integer> getModuleProgression(String email, String courseName) {
        HashMap<String, Integer> moduleProgression = new HashMap<>();
        String query = "SELECT ModuleTitle, Progression FROM CourseContent Join ContentItem ON ContentItem.ContentID = CourseContent.ContentID Join Progress ON Progress.ContentID = ContentItem.ContentID WHERE Email = '" + email + "' AND CourseName = '" + courseName + "' AND ModuleTitle IS NOT NULL";
        try {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                moduleProgression.put(rs.getString(1), rs.getInt(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return moduleProgression;
    }

    public ArrayList<String> getCoursesFromAccount(String email) {
        ArrayList<String> progression = new ArrayList<>();
        String query = "SELECT DISTINCT CourseName FROM Enrollment WHERE Email = '" + email + "'";
        try {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                progression.add(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return progression;
    }

    public ArrayList<String> getEnrolledAccount() {
        ArrayList<String> progression = new ArrayList<>();
        String query = "SELECT DISTINCT Email FROM Enrollment";
        try {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                progression.add(rs.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return progression;
    }
}
