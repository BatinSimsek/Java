package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EnrollController {
    private Database db = new Database();






    public void makeInsertQuery (int dateDay,int dateMonth, int dateYear, int certificateID, String courseName, String email){

        String query = "INSERT INTO cursisten VALUES('" + dateDay + "','"
                + dateMonth + "'," + dateYear + ","
                + certificateID + "," + courseName + ",'"
                + email + "')";
        db.executeQuery(query);
        System.out.println(query);
    }















}
