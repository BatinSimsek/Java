package Database;

import Domain.Cursist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CursistController {
private Database db = new Database();



// Onderstaande methode geeft een lijst met cursist objecten.
    public ObservableList<Cursist> getCursistLijst() {
        ObservableList<Cursist> CursistLijst = FXCollections.observableArrayList();
        String query = "SELECT * FROM Cursisten";

        try {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Cursist cursist = new Cursist(
                        rs.getString("email"),
                        rs.getString("naam"),
                        rs.getString("geboorteDatum"),
                        rs.getString("geslacht"),
                        rs.getString("woonPlaats"),
                        rs.getString("adres"),
                        rs.getString("land"));
                CursistLijst.add(cursist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return CursistLijst;
    }

    //Deze methoden voert een query uit.
    public void VoerQueryUit(String query){
        Connection conn = db.getConnection();
        try{
            Statement st = conn.createStatement();
            st.executeUpdate(query);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Deze methode stelt een query samen om een cursist record toe te voegen.
    public String toevoegQuery (String email, String naam, String gbDatum, String geslacht, String wPlaats, String adres, String land){
        String query = "INSERT INTO cursisten VALUES('" + email + "','"
                + naam + "','" + gbDatum + "','"
               + geslacht + "','" + wPlaats + "','"
               + adres + "','" + land + "')";
     return query;
    }
}
