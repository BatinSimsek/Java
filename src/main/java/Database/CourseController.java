package Database;

import Domain.Course;
import Domain.Cursist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseController {
    private Database db = new Database();

    public void runQuery(String query) {
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
        String query = "SELECT * FROM Cursus";

        return courseList;
    }
}
