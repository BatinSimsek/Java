package Database;

import Domain.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseController {
    private Database db = new Database();



    public ObservableList<Course> getCourse(){
        ObservableList<Course> courseList = FXCollections.observableArrayList();
        String query = "SELECT * FROM course";
        try{
            Connection conn = db.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Course course = new Course(
                        rs.getString("courseName"),
                        rs.getString("topic"),
                        rs.getString("description"),
                        rs.getString("level"));
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public String addCourse(String course, String topic, String description, String level){
        String query = "INSERT INTO course VALUES('" + course + "','"
                + topic + "','" + description + "','" + level + "')";
        return query;
    }

    public String updateCourse(String course, String topic, String description, String level) {
        String query = "UPDATE course SET course = '" + course + "', topic ='" + topic + "', description = '" + description + "', level = '" + level +
                "' WHERE course = '" + course +"'";
        return query;
    }

    public String makeDeleteQuery (String course){
        String query = "DELETE FROM course WHERE course =" + "'" + course + "'";
        return query;
    }
}
