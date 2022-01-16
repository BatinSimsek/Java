package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TopThreeWebcastController {
    private Database db = new Database();


    public ArrayList<String> getTopThreeWebcast(){
        ArrayList<String> Webcast = new ArrayList<>();
        String query = "SELECT TOP 3 Webcast.Title, SUM(Progression) AS totalPercentageWatched From Progress JOIN ContentItem ON ContentItem.ContentID = Progress.ContentID JOIN Webcast ON ContentItem.WebcastTitle = Webcast.Title WHERE ContentItem.WebcastTitle IS NOT NULL GROUP BY Webcast.Title ORDER BY  totalPercentageWatched DESC";
        try {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Webcast.add(rs.getString(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return Webcast;
    }
}
