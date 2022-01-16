package Database;

import Domain.Module;
import Domain.Webcast;
import Domain.ContentItems;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContentItemController {
    private Database db = new Database();

    //Haalt de content op van de database
    public ObservableList<ContentItems> getContentItemList() {
        ObservableList<ContentItems> contentList = FXCollections.observableArrayList();
        String query = "SELECT * FROM ContentItem";
        try {
            Connection conn = db.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()){
                ContentItems content = new ContentItems(
                        rs.getInt("ContentID"),
                        rs.getDate("PublicationDate").toLocalDate(),
                        rs.getString("Status"),
                        rs.getString("ModuleTitle"),
                        rs.getString("WebcastTitle"));
                    contentList.add(content);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return contentList;
    }

    //Haalt de module op van de database
    public ObservableList<Module> getModule() {
        ObservableList<Module> moduleList = FXCollections.observableArrayList();
        String query = "SELECT * FROM Module";
        try {
            Connection conn = db.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Module moduleLists = new Module(
                        rs.getString("Title"),
                        rs.getString("Description"),
                        rs.getDouble("Version"),
                        rs.getString("EmailContact"),
                        rs.getInt("SerialNumber"));
                moduleList.add(moduleLists);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moduleList;
    }

    //haalt webcast op van de database
    public ObservableList<Webcast> getWebcast() {
        ObservableList<Webcast> webcastsList = FXCollections.observableArrayList();
        String query = "SELECT * FROM webcast";
        try {
            Connection conn = db.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Webcast webcastLists = new Webcast(
                        rs.getString("Title"),
                        rs.getString("Description"),
                        rs.getDouble("Duration"),
                        rs.getString("Url"));
                webcastsList.add(webcastLists);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return webcastsList;
    }
}
