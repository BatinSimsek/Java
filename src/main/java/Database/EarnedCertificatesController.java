package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EarnedCertificatesController {
private Database db = new Database();

// haalt alle ingeschreven email adressen op en returned deze in een arraylist.
    public ArrayList<String> getListOfEnrolledAccounts (){
        ArrayList<String> enrolledAccounts = new ArrayList<>();

        String query = "SELECT DISTINCT Email FROM Enrollment";
        try {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                enrolledAccounts.add(rs.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return enrolledAccounts;
    }


    // haalt alle behaalde certificaten van een account op
    public ArrayList<String> GetCertificatesOfAccount(String email){
        ArrayList<String> certificatesOfAccount = new ArrayList<>();
        String query = "SELECT CourseName FROM Enrollment WHERE CertificateID IS NOT NULL AND Email = '" + email + "'";

        try {
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                certificatesOfAccount.add(rs.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(certificatesOfAccount.isEmpty()){
            certificatesOfAccount.add("Geen");
        }
        return certificatesOfAccount;
    }
}


