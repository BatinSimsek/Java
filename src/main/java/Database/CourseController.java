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
        String query = "SELECT * FROM Course";
        try{
            Connection conn = db.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Course course = new Course(
                        rs.getString("CourseName"),
                        rs.getString("Topic"),
                        rs.getString("Description"),
                        rs.getString("Level"));
                courseList.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public String addCourse(String course, String topic, String description, String level){
        String query = "INSERT INTO Course VALUES('" + course + "','"
                + topic + "','" + description + "','" + level + "')";
        return query;
    }

    public String updateCourse(String course, String topic, String description, String level) {
        String query = "UPDATE Course SET Course = '" + course + "', Topic ='" + topic + "', Description = '" + description + "', Level = '" + level +
                "' WHERE course = '" + course +"'";
        return query;
    }

    public String makeDeleteQuery (String course){
        String query = "DELETE FROM Course WHERE Course =" + "'" + course + "'";
        return query;
    }
}
