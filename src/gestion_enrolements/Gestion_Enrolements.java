/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestion_enrolements;

import gestion_enrolements.ConnectionBDD.ConnectionBDD;
import gestion_enrolements.Interfaces.login;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**

/**
 *
 * @author tepitech
 */
public class Gestion_Enrolements {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                    ConnectionBDD cnx = new ConnectionBDD();
                    login jframe = new login();
                    jframe.setVisible(true);
                
        // TODO code application logic here
    }
    
}
