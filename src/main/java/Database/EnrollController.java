package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EnrollController {
    private Database database = new Database();




    public void executeQuery(String query){
        Connection conn = database.getConnection();
        try{
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void makeInsertQuery (int dateDay,int dateMonth, int dateYear, int certificateID, String courseName, String email){

        String query = "INSERT INTO cursisten VALUES('" + dateDay + "','"
                + dateMonth + "'," + dateYear + ","
                + certificateID + "," + courseName + ",'"
                + email + "')";
        executeQuery(query);
        System.out.println(query);
    }















}
