/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestion_enrolements.Interfaces;
import java.sql.*;
import gestion_enrolements.ConnectionBDD.ConnectionBDD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;
import gestion_enrolements.ConnectionBDD.ConnectionBDD;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code128.Code128Constants;
import org.krysalis.barcode4j.impl.code128.EAN128Bean;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
// Ajoutez d'autres imports selon les classes que vous utilisez


/**
 *
 * @author tepitech
 */
public class Enregistrement extends javax.swing.JFrame {

    /**
     * Creates new form Enregistrement
     */
    public Enregistrement() {
        initComponents();
        ConnectionBDD cnx = new ConnectionBDD();
           tableAfficher3();
           affichagePoste();
    }
   




                
private void tableAfficher3() {
    String queryAfficher = "SELECT * FROM citoyen WHERE DATE(DateSaisie) = CURDATE() ORDER BY nom, prenom";

    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolements", "root", "")) {
        PreparedStatement stmQueryAfficher = connection.prepareStatement(queryAfficher);
        ResultSet resultat = stmQueryAfficher.executeQuery();
        DefaultTableModel tableAffichage = (DefaultTableModel) table3.getModel();
        tableAffichage.setRowCount(0);

        while (resultat.next()) {
            String nom = resultat.getString("nom");
            String prenom = resultat.getString("prenom");
            Date DateNaissance = resultat.getDate("DateNaissance");
            String LieuNaissance = resultat.getString("LieuNaissance");
            String Profession = resultat.getString("profession");
            String Situation = resultat.getString("SituationMatri");
            String Adresse = resultat.getString("Adresse");
            String Pere = resultat.getString("NomPere");
            String Mere = resultat.getString("NomMere");
            String Sexe = resultat.getString("Sexe");
            int idCitoyen = resultat.getInt("id_citoyen");

            // Ajouter une nouvelle ligne avec id_citoyen en dernière colonne
            tableAffichage.addRow(new Object[]{nom, prenom, DateNaissance, LieuNaissance, Profession, Pere, Situation,Adresse, Mere, Sexe, idCitoyen});
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Gérer les erreurs de récupération des données
    }
}

public void affichagePoste() {
    String queryAfficher = "SELECT commune, quartier FROM poste";

    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolements", "root", "")) {
        PreparedStatement stmQueryAfficher = connection.prepareStatement(queryAfficher);
        ResultSet resultat = stmQueryAfficher.executeQuery();

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        while (resultat.next()) {
            String commune = resultat.getString("commune"); // Récupérer le nom de la commune
            String quartier = resultat.getString("quartier"); // Récupérer le nom du quartier
            String element = commune + " (" + quartier + ")"; // Concaténer commune et quartier
            comboBoxModel.addElement(element); // Ajouter la combinaison commune - quartier au modèle du JComboBox
        }

        poste.setModel(comboBoxModel); // Mettre à jour le modèle du JComboBox avec les données récupérées
    } catch (SQLException ex) {
        ex.printStackTrace();
        // Gérer les erreurs de récupération des données
    }
}


// Appel de la méthode affichagePoste


   // Exemple d'appel à la méthode affichagePoste

    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField3 = new javax.swing.JTextField();
        barcodeExt1 = new org.krysalis.barcode4j.xalan.BarcodeExt();
        jScrollPane1 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        Mere = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Adresse = new javax.swing.JTextField();
        Sender = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        prenom = new javax.swing.JTextField();
        proffesion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        poste = new javax.swing.JComboBox<>();
        Pere = new javax.swing.JTextField();
        carte = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        prenoms = new javax.swing.JLabel();
        peres = new javax.swing.JLabel();
        meres = new javax.swing.JLabel();
        dates = new javax.swing.JLabel();
        lieu = new javax.swing.JLabel();
        ids = new javax.swing.JLabel();
        sexes = new javax.swing.JLabel();
        noms = new javax.swing.JLabel();
        profs = new javax.swing.JLabel();
        Add = new javax.swing.JLabel();
        postes = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        barcode = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        supprimer = new javax.swing.JButton();
        Clean = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Lieu = new javax.swing.JTextField();
        Etats = new javax.swing.JComboBox<>();
        sexe = new javax.swing.JLabel();
        sexe1 = new javax.swing.JComboBox<>();
        imprimer1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1388, 780));
        setPreferredSize(new java.awt.Dimension(1300, 707));
        setSize(new java.awt.Dimension(1380, 700));

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nom", "Prenom", "Date de Naissance", "Lieu de Naissance", "Proffession", "Adresse", "Situation Matrimoniale", "Pere", "Mere", "sexe", "Number"
            }
        ));
        table3.setGridColor(new java.awt.Color(153, 0, 0));
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table3);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("Enregistrement des Candidats");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Naissance");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Situation");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Nom");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Prenom");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Adresse");

        Adresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdresseActionPerformed(evt);
            }
        });

        Sender.setBackground(new java.awt.Color(242, 242, 242));
        Sender.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Sender.setText("Enregistrer");
        Sender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SenderActionPerformed(evt);
            }
        });

        modifier.setBackground(new java.awt.Color(242, 242, 242));
        modifier.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        modifier.setText("Modifier");
        modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifierActionPerformed(evt);
            }
        });

        proffesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proffesionActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Profession");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Mere");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Pere");

        jButton6.setBackground(new java.awt.Color(242, 242, 242));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton6.setText("Menu Principal");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        poste.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminin", "Masculin" }));

        Pere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PereActionPerformed(evt);
            }
        });

        carte.setBackground(new java.awt.Color(153, 255, 153));
        carte.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 102));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 153));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("     Republique TogoLaise");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 204));
        jLabel14.setText("  Travail Liberté Patrie");

        jLabel11.setText("Nom");

        jLabel15.setText("Prenoms");

        jLabel16.setText("Pere");

        jLabel17.setText("Mere");

        jLabel18.setText("Date de Naissance");

        jLabel19.setText("Lieu de Naissance");

        jLabel20.setText("Profession");

        jLabel21.setText("Adresse");

        jLabel22.setText("Sexe");

        prenoms.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        peres.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        meres.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        dates.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lieu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        ids.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        sexes.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        noms.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        profs.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        Add.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        postes.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(0, 51, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gestion_enrolements/Images/OOOO.png"))); // NOI18N

        javax.swing.GroupLayout carteLayout = new javax.swing.GroupLayout(carte);
        carte.setLayout(carteLayout);
        carteLayout.setHorizontalGroup(
            carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(carteLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carteLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(postes)
                        .addGap(162, 162, 162))
                    .addGroup(carteLayout.createSequentialGroup()
                        .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(carteLayout.createSequentialGroup()
                                .addGap(274, 274, 274)
                                .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ids, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jSeparator2)
            .addGroup(carteLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carteLayout.createSequentialGroup()
                        .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(carteLayout.createSequentialGroup()
                                .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, carteLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(58, 58, 58))
                                    .addGroup(carteLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(78, 78, 78)))
                                .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(noms)
                                    .addComponent(prenoms))
                                .addGap(24, 24, 24))
                            .addGroup(carteLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(82, 82, 82)
                                .addComponent(meres)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sexes)
                        .addGap(214, 214, 214))
                    .addGroup(carteLayout.createSequentialGroup()
                        .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(carteLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel21)
                                .addGap(84, 84, 84)
                                .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(carteLayout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(peres, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(profs)
                                    .addComponent(lieu)))
                            .addGroup(carteLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(37, 37, 37)
                                .addComponent(dates))
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addGroup(carteLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(82, 82, 82)
                                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        carteLayout.setVerticalGroup(
            carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(carteLayout.createSequentialGroup()
                .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(carteLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(carteLayout.createSequentialGroup()
                        .addComponent(postes)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, carteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carteLayout.createSequentialGroup()
                        .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(carteLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(noms))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(prenoms)))
                            .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel22)
                                .addComponent(sexes)))
                        .addGap(18, 18, 18)
                        .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(carteLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(44, 44, 44)
                                .addComponent(jLabel17))
                            .addGroup(carteLayout.createSequentialGroup()
                                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(meres)))
                        .addGap(41, 41, 41)
                        .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(dates, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(carteLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ids, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lieu))
                .addGroup(carteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(carteLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(profs)
                        .addGap(20, 20, 20)
                        .addComponent(peres, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(carteLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        supprimer.setBackground(new java.awt.Color(242, 242, 242));
        supprimer.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        supprimer.setText("Supprimer");
        supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supprimerActionPerformed(evt);
            }
        });

        Clean.setBackground(new java.awt.Color(242, 242, 242));
        Clean.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Clean.setText("Effacer");
        Clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CleanActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setText("Lieu");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Poste");

        Etats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Célibataire", "Marié(e)", "Divorcé(e)" }));

        sexe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sexe.setText("Sexe");

        sexe1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminin", "Masculin" }));

        imprimer1.setBackground(new java.awt.Color(242, 242, 242));
        imprimer1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        imprimer1.setText("Imprimer");
        imprimer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimer1ActionPerformed(evt);
            }
        });

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sexe1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nom)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Etats, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Mere, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(proffesion, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(poste, 0, 180, Short.MAX_VALUE)
                            .addComponent(Pere)
                            .addComponent(Adresse)
                            .addComponent(prenom)
                            .addComponent(Lieu, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(carte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(363, 363, 363))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Sender, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Clean, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(imprimer1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(proffesion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Mere, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Etats, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(poste, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(Pere, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Lieu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(62, 62, 62)))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(sexe1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Sender, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(imprimer1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Clean, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(carte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
              // TODO add your handling code here:
              new Menu_Principale().setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void AdresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdresseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdresseActionPerformed

    private void PereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PereActionPerformed

    private void supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supprimerActionPerformed

          ConnectionBDD cnx = new ConnectionBDD();
int selectedRow = table3.getSelectedRow();

if (selectedRow != -1) {
    int idCitoyen = Integer.parseInt(table3.getValueAt(selectedRow, 10).toString()); // Récupérer l'id_citoyen depuis la colonne 10
     JOptionPane.showMessageDialog(null,idCitoyen );
    int option = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer cet enregistrement ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);

    if (option == JOptionPane.YES_OPTION) {
        // Suppression depuis la base de données en utilisant l'id_citoyen
        String deleteQuery = "DELETE FROM citoyen WHERE id_citoyen = ?";

        try (Connection connection = cnx.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, idCitoyen);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                ((DefaultTableModel) table3.getModel()).removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "L'enregistrement a été supprimé avec succès.");
            } else {
                JOptionPane.showMessageDialog(this, "Erreur lors de la suppression de l'enregistrement.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Gérer les erreurs de suppression
        }
    }
}


       
    }//GEN-LAST:event_supprimerActionPerformed

    private void CleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CleanActionPerformed
              // TODO add your handling code here:
              nom.setText(""); // Efface le champ nom
        prenom.setText(""); // Efface le champ prénom
        jDateChooser1.setDate(null); // Efface la date de naissance
        Lieu.setText(""); // Efface le champ lieu de naissance
        Pere.setText(""); // Efface le champ nom du père
        Mere.setText(""); // Efface le champ nom de la mère
        proffesion.setText(""); // Efface le champ profession
        Etats.setSelectedIndex(0); // Réinitialise la sélection de la situation matrimoniale
        Adresse.setText(""); // Efface le champ adresse
        poste.setSelectedIndex(0); // Réinitialise la sélection du sexe
    }//GEN-LAST:event_CleanActionPerformed

    private void SenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SenderActionPerformed
         try{                                       
             // TODO add your handling code here:
             // String Ientifiant = UUID.randomUUID().toString().substring(0, 10).toUpperCase();
             try{
                 ConnectionBDD cnx = new ConnectionBDD();
                 //String Identification= (Identifiant;
                 String nom = (String)this.nom.getText();
                 String prenom=(String)this.prenom.getText();
                 java.sql.Date DateNaissance = new java.sql.Date(this.jDateChooser1.getDate().getTime());
                 String LieuNaissance  = (String)Lieu.getText();
                 String Pere = (String)this.Pere.getText();
                 String Mere  = (String)this.Mere.getText();
                 String profession  = (String)proffesion.getText();
                 String Situation = (String)this.Etats.getSelectedItem();
                 String Adresse = (String)this.Adresse.getText();
                 String Sexe  = (String)sexe1.getSelectedItem();
                 String posteSelectionne = (String) poste.getSelectedItem();
               //  JOptionPane.showMessageDialog(this, posteSelectionne);
                 
                 if( nom.isEmpty() || prenom.isEmpty() || DateNaissance.toString().isEmpty() ||LieuNaissance.isEmpty()||Pere.isEmpty()||Mere.isEmpty()||profession.isEmpty()||Situation.isEmpty()||Adresse.isEmpty()) {
                     JOptionPane.showMessageDialog(this, "remplissez les champs");
                     return; // Empêche l'exécution de l'insertion si un champ est vide
                 } else {
                    // JOptionPane.showMessageDialog(this, "Opération en cours");
                 }
                   
                 
                 
                 
              String query = "Insert into citoyen(nom,prenom,DateNaissance,LieuNaissance,Profession,SituationMatri,Adresse,NomPere,NomMere,sexe) values(?,?,?,?,?,?,?,?,?,?) ";
             PreparedStatement stmQuery = cnx.preparedStatement(query);
                 stmQuery.setString(1, nom);
                 stmQuery.setString(2, prenom);
                 java.sql.Date sqlDateNaissance = new java.sql.Date(DateNaissance.getTime()); // Convertir java.util.Date en java.sql.Date
                 
                 stmQuery.setDate(3, (Date) ( DateNaissance));
                 stmQuery.setString(4, LieuNaissance);
                 stmQuery.setString(8, Pere);
                 stmQuery.setString(9, Mere);
                 stmQuery.setString(5, profession);
                 stmQuery.setString(6, Situation);
                 stmQuery.setString(7, Adresse);
                  stmQuery.setString(10, Sexe);
                 
                 
                 stmQuery.executeUpdate();
                 cnx.close();
                 //JOptionPane.showMessageDialog(null, "Insertion effecture avec succès");
                 tableAfficher3();
                 noms.setText(nom);
                 prenoms.setText(prenom);
                 peres.setText(Pere);
                 meres.setText(Mere);
                 sexes.setText(Sexe);
                 profs.setText(profession);
                 lieu.setText(LieuNaissance);
                 Add.setText(Adresse);
                 // Convertir la date de naissance en chaîne de caractères au format souhaité
                 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Définir le format de la date
                 String dateNaissanceStr = sdf.format(DateNaissance); // Convertir la date en chaîne de caractères
                 
                 // Affecter la date de naissance au JLabel "dates"
                 dates.setText(dateNaissanceStr); // Afficher la date de naissance dans le JLabel
                 
                 postes.setText(posteSelectionne);
                 
                 
             }catch(Exception e){
                 e.printStackTrace();
             }
             Code128Bean code128 = new Code128Bean();
             String barcodeText = UUID.randomUUID().toString().substring(0, 10).toUpperCase();  // Générer un code-barres aléatoire
             BitmapCanvasProvider provider = new BitmapCanvasProvider(160, BufferedImage.TYPE_BYTE_BINARY, false, 0);
             
             code128.generateBarcode(provider, barcodeText);
             provider.finish();
             
             // Obtenir l'image générée
             BufferedImage barcodeImage = provider.getBufferedImage();
             
             // Afficher l'image du code-barres dans le JLabel
             ImageIcon icon = new ImageIcon(barcodeImage);
             barcode.setIcon(icon);
             
              String barcodeNumbers = barcodeText.replaceAll("[^0-9]", "");

            // Affecter les chiffres au JLabel "ids"
            ids.setText("TG" + barcodeNumbers);
             
             
         }catch(IOException ex){
            Logger.getLogger(Enregistrement.class.getName()).log(Level.SEVERE, null, ex);
        }



         
    }//GEN-LAST:event_SenderActionPerformed

    private void imprimer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimer1ActionPerformed
      
           imprimerPanel(carte, 15000, 12000); // Remplacez 800 et 1200 par les dimensions souhaitées
}

private void imprimerPanel(JPanel panel, int desiredWidth, int desiredHeight) {
    PrinterJob job = PrinterJob.getPrinterJob();
    job.setPrintable(new Printable() {
        @Override
        public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2d = (Graphics2D) g;
            g2d.translate(pf.getImageableX(), pf.getImageableY());

            int resolution = 300; // Définissez votre résolution souhaitée (points par pouce)
            BufferedImage image = new BufferedImage(
                    (int) (desiredWidth * resolution / 25.4),
                    (int) (desiredHeight * resolution / 25.4),
                    BufferedImage.TYPE_INT_ARGB
            );

            Graphics2D imageGraphics = image.createGraphics();
            imageGraphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            // Ajustez la taille du panel pour la largeur et la longueur
            panel.setSize(desiredWidth, desiredHeight);

            // Peignez le panel sur l'image avec la nouvelle taille
            panel.paint(imageGraphics);
            imageGraphics.dispose();

            // Dessinez l'image redimensionnée sur le graphique de l'imprimante
            g2d.drawImage(image, 0, 0, (int) pf.getWidth(), (int) pf.getHeight(), null);

            return Printable.PAGE_EXISTS;
        }
    });

    if (job.printDialog()) {
        try {
            job.print();
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }
        
        
    }//GEN-LAST:event_imprimer1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                 // TODO add your handling code here:
                  // Code à exécuter lorsque le bouton est cliqué
    selectImage();
}  

private void selectImage() {
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        // Charger l'image depuis le fichier sélectionné
        ImageIcon imageIcon = new ImageIcon(selectedFile.getAbsolutePath());

        // Redimensionner l'image pour s'adapter au JLabel
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(photo.getWidth(), photo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(resizedImage);

        // Afficher l'image dans le JLabel
        photo.setIcon(resizedImageIcon);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
   DefaultTableModel tableModel = (DefaultTableModel) table3.getModel();
int selectedRow = table3.getSelectedRow();

if (selectedRow >= 0 && tableModel.getColumnCount() > 9) { // Assurez-vous que le modèle a plus de 9 colonnes
    String nomValue = String.valueOf(tableModel.getValueAt(selectedRow, 0));
    String prenomValue = String.valueOf(tableModel.getValueAt(selectedRow, 1));
    java.sql.Date dateNaissanceValue = (java.sql.Date) tableModel.getValueAt(selectedRow, 2);
    String lieuNaissanceValue = String.valueOf(tableModel.getValueAt(selectedRow, 3));
    String pereValue = String.valueOf(tableModel.getValueAt(selectedRow, 5));
    String mereValue = String.valueOf(tableModel.getValueAt(selectedRow, 8));
    String professionValue = String.valueOf(tableModel.getValueAt(selectedRow, 4));
    String situationValue = String.valueOf(tableModel.getValueAt(selectedRow, 6));
    String adresseValue = String.valueOf(tableModel.getValueAt(selectedRow, 7));
    String sexeValue = String.valueOf(tableModel.getValueAt(selectedRow, 9)); // Utilisez l'indice 9 pour la colonne du sexe

    // Mettre à jour les champs de votre interface utilisateur
    nom.setText(nomValue);
    prenom.setText(prenomValue);
    jDateChooser1.setDate(dateNaissanceValue);
    Lieu.setText(lieuNaissanceValue);
    Pere.setText(pereValue);
    Mere.setText(mereValue);
    proffesion.setText(professionValue);
    Etats.setSelectedItem(situationValue);
    Adresse.setText(adresseValue);
    sexe1.setSelectedItem(sexeValue);
} else {
    JOptionPane.showMessageDialog(this, "Aucune ligne sélectionnée ou le modèle de tableau ne contient pas suffisamment de colonnes.", "Erreur", JOptionPane.ERROR_MESSAGE);
}



    }//GEN-LAST:event_table3MouseClicked

    private void modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifierActionPerformed
   ConnectionBDD cnx = new ConnectionBDD();
               // TODO add your handling code here:
           int selectedRow = table3.getSelectedRow();
    
    if (selectedRow != -1) {
        String nouveauNom = nom.getText();
        String nouveauPrenom = prenom.getText();
       java.sql.Date nouvelleDateNaissance = new java.sql.Date(jDateChooser1.getDate().getTime());
        String nouveauLieuNaissance = Lieu.getText();
        String nouveauPere = Pere.getText();
        String nouvelleMere = Mere.getText();
        String nouvelleProfession = proffesion.getText();
        String nouvelleSituation = (String) Etats.getSelectedItem();
        String nouvelleAdresse = Adresse.getText();
        String nouveauSexe = (String) sexe1.getSelectedItem();

        // Mettre à jour les valeurs dans le JTable table2
        // Mettre à jour les données dans le modèle de tableau
    table3.setValueAt(nouveauNom, selectedRow, 0);
    table3.setValueAt(nouveauPrenom, selectedRow, 1);
    table3.setValueAt(nouvelleDateNaissance, selectedRow, 2);
    table3.setValueAt(nouveauLieuNaissance, selectedRow, 3);
    table3.setValueAt(nouveauPere, selectedRow, 4);
    table3.setValueAt(nouvelleMere, selectedRow, 5);
    table3.setValueAt(nouvelleProfession, selectedRow, 6);
    table3.setValueAt(nouvelleSituation, selectedRow, 7);
    table3.setValueAt(nouvelleAdresse, selectedRow, 8);
    table3.setValueAt(nouveauSexe, selectedRow, 9);
    

        // Mettre à jour les données dans la base de données
       try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolements", "root", "")) {
    String updateQuery = "UPDATE citoyen SET nom = ?, prenom = ?, DateNaissance = ?, lieuNaissance = ?, NomPere = ?, NomMere = ?, profession = ?, SituationMatri = ?, adresse = ?, sexe = ? WHERE id_citoyen = ?";
    PreparedStatement stmUpdate = connection.prepareStatement(updateQuery);
    
    stmUpdate.setString(1, nouveauNom);
    stmUpdate.setString(2, nouveauPrenom);
    stmUpdate.setDate(3, nouvelleDateNaissance);
    stmUpdate.setString(4, nouveauLieuNaissance);
    stmUpdate.setString(5, nouveauPere);
    stmUpdate.setString(6, nouvelleMere);
    stmUpdate.setString(7, nouvelleProfession);
    stmUpdate.setString(8, nouvelleSituation);
    stmUpdate.setString(9, nouvelleAdresse);
    stmUpdate.setString(10, nouveauSexe);
           String idCitoyenStr = (String) table3.getValueAt(selectedRow, 0);

    // Convertir la chaîne en entier
               int idCitoyen = Integer.parseInt(idCitoyenStr);

        JOptionPane.showMessageDialog(null, "Modification effectuée!!!");
        nom.setText(nouveauNom);
    prenom.setText(nouveauPrenom);
    jDateChooser1.setDate(nouvelleDateNaissance);
    Lieu.setText(nouveauLieuNaissance);
    Pere.setText(nouveauPere);
    Mere.setText(nouvelleMere);
    proffesion.setText(nouvelleProfession);
    Etats.setSelectedItem(nouvelleSituation);
    Adresse.setText(nouvelleAdresse);
    sexe1.setSelectedItem(nouveauSexe);
    stmUpdate.executeUpdate(); // Exécutez la mise à jour
    
            
            // Rafraîchir l'affichage du JTable en récupérant les données actualisées
            tableAfficher3();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    






    }//GEN-LAST:event_modifierActionPerformed

    private void proffesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proffesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proffesionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Enregistrement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Enregistrement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Enregistrement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Enregistrement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
         
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new Enregistrement().setVisible(true);

            }
        });
    }

                  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add;
    private javax.swing.JTextField Adresse;
    private javax.swing.JButton Clean;
    private javax.swing.JComboBox<String> Etats;
    private javax.swing.JTextField Lieu;
    private javax.swing.JTextField Mere;
    private javax.swing.JTextField Pere;
    private javax.swing.JButton Sender;
    private javax.swing.JLabel barcode;
    private org.krysalis.barcode4j.xalan.BarcodeExt barcodeExt1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel carte;
    private javax.swing.JLabel dates;
    private javax.swing.JLabel ids;
    private javax.swing.JButton imprimer1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lieu;
    private javax.swing.JLabel meres;
    private javax.swing.JButton modifier;
    private javax.swing.JTextField nom;
    private javax.swing.JLabel noms;
    private javax.swing.JLabel peres;
    private javax.swing.JLabel photo;
    private javax.swing.JComboBox<String> poste;
    private javax.swing.JLabel postes;
    private javax.swing.JTextField prenom;
    private javax.swing.JLabel prenoms;
    private javax.swing.JTextField proffesion;
    private javax.swing.JLabel profs;
    private javax.swing.JLabel sexe;
    private javax.swing.JComboBox<String> sexe1;
    private javax.swing.JLabel sexes;
    private javax.swing.JButton supprimer;
    private javax.swing.JTable table3;
    // End of variables declaration//GEN-END:variables

    private int getIdFromDatabase(int selectedRow) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
        }
