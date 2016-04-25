package Check;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

/**
 *
 * @author pippo
 */
public class DataBase {
    // DEFINIZIONE: JDBC DRIVER, DATAT BASE URL, NOME SERVER, USERNAME, PASSWORD
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String URL = "sql8.freemysqlhosting.net";
    final String n_db = "sql8116404";
    final String user = "sql8116404";
    final String pass = "5XQVIzwSHy";
    // DEFINISCO DELLE VARIABILI DI TIPO CONNESSIONE, STATEMENT E RISULTATO
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;

    public DataBase() {
        //INIZIO IL TUTTO CON UN TRY
        try {
            // REGISTRAZIONE JDBC DRIVER
            Class.forName(JDBC_DRIVER);
            // APRO LA CONNESSIONE
            con = DriverManager.getConnection("jdbc:mysql://" + URL + ":3306/" + n_db + "?user=" + user + "&password=" + pass);
            
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public String Query(String query) throws SQLException{
        st = con.createStatement();
        rs = st.executeQuery(query);
        
        while(rs.next()) {
            String name = rs.getString("Nome");
            return "benvenuto " + name + "!";
        }
        return "Non sei registrato. Registrarsi e riprovare.";
    }
    
    public Boolean Inserisci(String query) throws SQLException {
        st = con.createStatement();
        st.executeUpdate(query);
        return true;      
    }
    
    public boolean CloseConnection() throws SQLException{
        // CHIUSURA CONNESSIONE E TUTTO IL RESTO
            rs.close();
            st.close();
            con.close();
            return true;
    }
}
