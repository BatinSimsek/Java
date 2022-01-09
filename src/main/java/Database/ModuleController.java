package Database;

import Domain.Module;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ModuleController {
    private Database db = new Database();

    public ObservableList<Module> getModule() {
        ObservableList<Module> moduleList = FXCollections.observableArrayList();
        String query = "SELECT * FROM Module";
        try {
            Connection conn = db.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Module moduleLists = new Module(
                        rs.getInt("ModuleID"),
                        rs.getDate("publicationDate").toLocalDate(),
                        rs.getString("status"),
                        rs.getString("Title"),
                        rs.getString("Description"),
                        rs.getDouble("Version"),
                        rs.getString("NameContact"),
                        rs.getString("EmailContact"),
                        rs.getInt("SerialNumber"));
                moduleList.add(moduleLists);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moduleList;
    }
}
