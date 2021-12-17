package database;

//import javafx.collections.ObservableList;

import java.sql.*;

public class database {

    public Connection getConnection() {
        try {
            Connection connect = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=cursus;integratedSecurity=true;");
            return connect;

        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }


    public void showCursisten() {
        String query = "SELECT * FROM cursisten";
        Connection con;
        Statement st;
        ResultSet rs;

        try {
            con = getConnection();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()){
                String email = rs.getString("e_mail");
               String name = rs.getString("naam");
               Date geboortedatum = rs.getDate("geboortedatum");
              String geslacht = rs.getString("geslacht");
                String woonplaats = rs.getString("woonplaats");
                String adres = rs.getString("adres");
                String land = rs.getString("land");

                System.out.println(email + name + geboortedatum + geslacht + woonplaats + adres + land);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        }


    }

}
