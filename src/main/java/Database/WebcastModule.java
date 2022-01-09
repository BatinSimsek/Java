package Database;

import Domain.Webcast;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WebcastModule {
    private Database db = new Database();

    public ObservableList<Webcast> getWebcast() {
        ObservableList<Webcast> webcastsList = FXCollections.observableArrayList();
        String query = "SELECT * FROM webcast";
        try {
            Connection conn = db.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Webcast webcastLists = new Webcast(
                        rs.getInt("WebcastID"),
                        rs.getDate("DateOfPublication").toLocalDate(),
                        rs.getString("Status"),
                        rs.getString("Title"),
                        rs.getString("Description"),
                        rs.getDouble("Duration"),
                        rs.getDate("DateOfPublication").toLocalDate(),
                        rs.getString("Url"),
                        rs.getString("NameSpeaker"),
                        rs.getString("OrganizationSpeaker"));
                webcastsList.add(webcastLists);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return webcastsList;
    }
}
