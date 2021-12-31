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

    public void executeQuery(String query) {
        Connection conn = db.getConnection();
        try{
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ObservableList<Course> getCourse(){
        ObservableList<Course> courseList = FXCollections.observableArrayList();
        String query = "SELECT * FROM cursus";
        try{
            Connection conn = db.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                Course course = new Course(
                        rs.getString("course"),
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
        String query = "INSERT INTO cursus VALUES('" + course + "','"
                + topic + "','" + description + "','" + level + "')";
        return query;
    }

    public String updateCourse(String course, String topic, String description, String level) {
        String query = "UPDATE cursus SET course = '" + course + "', topic ='" + topic + "', description = '" + description + "', level = '" + level +
                "' WHERE course = '" + course +"'";
        return query;
    }

    public String makeDeleteQuery (String course){
        String query = "DELETE FROM cursus WHERE course =" + "'" + course + "'";
        return query;
    }
}
