/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_enrolements.ConnectionBDD;

import com.mysql.cj.jdbc.DatabaseMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



/**
 *
 * @author tepitech
 */
public class ConnectionBDD {
   String url="jdbc:mysql://localhost:3306/enrolements";
    String username="root";
    String password="";
    Connection cnx;
    PreparedStatement stmt;

    public ConnectionBDD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(url, username, password);
            //JOptionPane.showMessageDialog(null, "connexion etablie avec succes !!!");
            // Connexion réussie
        } catch (Exception e) {
            e.printStackTrace();
                      JOptionPane.showMessageDialog(null, "erreur de  connexion !!!");
  // Gestion des erreurs de connexion
        }
    }
  public PreparedStatement preparedStatement(String sql) throws SQLException{
      return cnx.prepareStatement(sql);
  }
    public Connection getConnection() {
        return cnx;
    }

    public void close() {
        try {
            if(cnx!=null &&!cnx.isClosed()){
            cnx.close();
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    

   /* public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
*/
    /**
     *
     * @return
     */

      
     

}
