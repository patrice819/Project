/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gestion_enrolements.Interfaces;
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
import java.util.logging.Level;
import java.util.logging.Logger;
public class Techniciens extends javax.swing.JFrame {

         ConnectionBDD cnx = new ConnectionBDD();
         PreparedStatement stmt;
         ResultSet result;
    /**
     * Creates new form Techniciens
     */
    public Techniciens() {
        initComponents();
        ConnectionBDD cnx = new ConnectionBDD();
        tableAfficher();

        
    }

   //Créaation d'une méthode d'affichage
    private void tableAfficher(){
        String queryAfficher = "Select * from techniciens";
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/enrolements","root","")) {
            PreparedStatement stmQueryAfficher = connection.prepareStatement(queryAfficher);
            ResultSet resultat = stmQueryAfficher.executeQuery();
            DefaultTableModel tableAffichage = (DefaultTableModel)table3.getModel();
            tableAffichage.setRowCount(0);
            while(resultat.next()){
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String sexe = resultat.getString("sexe");
                String categorie = resultat.getString("categorie");
                String matricule =resultat.getString("Matricule");
                String Codes=resultat.getString("code");
                tableAffichage.addRow(new Object[]{nom,prenom,sexe,categorie,matricule,Codes});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        pass = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Cleaner = new javax.swing.JButton();
        sender = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        combo = new javax.swing.JComboBox<>();
        sexe = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtprenom1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mat = new javax.swing.JTextField();
        modif = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1388, 780));
        setSize(new java.awt.Dimension(750, 780));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("nom");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("prenom");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Sexe");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Categories");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton1.setText("Menu Principal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton1");

        Cleaner.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        Cleaner.setText("Supprimer");
        Cleaner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CleanerActionPerformed(evt);
            }
        });

        sender.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        sender.setText("Enregistrer");
        sender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senderActionPerformed(evt);
            }
        });

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "nom", "prenom", "Sexe", "Categorie", "Matricule", "Code"
            }
        ));
        table3.setGridColor(new java.awt.Color(242, 242, 242));
        table3.setSelectionBackground(new java.awt.Color(242, 242, 242));
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table3);

        combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " ", "Assistant operateur", "C O", "Admistrateur" }));

        sexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " ", "Feminin", "Masculin" }));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setText("ENREGISTREMENT   DES TECHNICIENS");

        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton6.setText("Effacer");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Password");

        txtprenom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprenom1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("No Matricule");

        mat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matActionPerformed(evt);
            }
        });

        modif.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        modif.setText("Modifier");
        modif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sexe, 0, 185, Short.MAX_VALUE)
                            .addComponent(txtname))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtprenom1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sender, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(modif, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(Cleaner, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mat, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButton1)))
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(681, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addGap(417, 417, 417)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtprenom1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexe, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(mat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sender, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modif, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cleaner, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(692, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
new Menu_Principale().setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void senderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senderActionPerformed
              String numat = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
              String code = UUID.randomUUID().toString().substring(0, 10).toUpperCase();

                  try{
            ConnectionBDD cnx = new ConnectionBDD();
            String MonNom= (String) txtname.getText();
            String prenom = (String)txtprenom1.getText();
            String sexe =(String)this.sexe.getSelectedItem();
            String cat=(String)this.combo.getSelectedItem();
            if(MonNom.isEmpty() || prenom.isEmpty() || sexe.isEmpty() || cat.isEmpty()) {
    JOptionPane.showMessageDialog(this, "remplissez les champs");
    return; // Empêche l'exécution de l'insertion si un champ est vide
} else {
    JOptionPane.showMessageDialog(this, "Opération en cours");
}

                   
            String query = "Insert into techniciens(nom,prenom,sexe,categorie,Matricule,code) values(?,?,?,?,?,?)";
            PreparedStatement stmQuery = cnx.preparedStatement(query);
            stmQuery.setString(1, (String) txtname.getText());
            stmQuery.setString(2, (String) txtprenom1.getText());
            stmQuery.setString(3, (String)this.sexe.getSelectedItem() );
            stmQuery.setString(4, (String) this.combo.getSelectedItem());
            stmQuery.setString(5, (String) numat);
            stmQuery.setString(6, (String) code);

            stmQuery.executeUpdate();
            cnx.close();
            
            JOptionPane.showMessageDialog(null, "Insertion effecture avec succès");
                pass.setText(code);
                mat.setText(numat);
                tableAfficher();
                 pass.setText("");
                mat.setText("");
        }catch(Exception e){
            e.printStackTrace();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_senderActionPerformed

    private void txtprenom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprenom1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprenom1ActionPerformed

    private void matActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matActionPerformed

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
                 // TODO add your handling code here:
                 DefaultTableModel table = (DefaultTableModel) table3.getModel();
        int selectRow = table3.getSelectedRow();
        if (selectRow>=0){
//            Region.setSelectedItem(String.valueOf(table3.getValueAt(selectRow, 0)));
            txtname.setText(String.valueOf(table3.getValueAt(selectRow, 0)));
            txtprenom1.setText(String.valueOf(table3.getValueAt(selectRow, 1)));
            sexe.setSelectedItem(String.valueOf(table3.getValueAt(selectRow, 2)));
            combo.setSelectedItem(String.valueOf(table3.getValueAt(selectRow, 3)));
            mat.setText(String.valueOf(table3.getValueAt(selectRow, 4)));
            pass.setText(String.valueOf(table3.getValueAt(selectRow, 5)));

            
        }
    }//GEN-LAST:event_table3MouseClicked

    private void CleanerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CleanerActionPerformed
               DefaultTableModel table = (DefaultTableModel) table3.getModel();
int selectRow = table3.getSelectedRow();

if (selectRow >= 0) {
    // Récupérer les valeurs des champs
    String nomValue = String.valueOf(table3.getValueAt(selectRow, 0));
    String prenomValue = String.valueOf(table3.getValueAt(selectRow, 1));
    String sexeValue = String.valueOf(table3.getValueAt(selectRow, 2));
    String comboValue = String.valueOf(table3.getValueAt(selectRow, 3));
    String matValue = String.valueOf(table3.getValueAt(selectRow, 4));
    String passValue = String.valueOf(table3.getValueAt(selectRow, 5));

    // Afficher une boîte de dialogue de confirmation
    int option = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer cet enregistrement ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);

    if (option == JOptionPane.YES_OPTION) {
        // Suppression depuis la base de données    int option = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer cet enregistrement ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);

        String deleteQuery = "DELETE FROM techniciens WHERE Nom = ? AND prenom = ? AND sexe = ? AND categorie = ? AND Matricule = ? AND code = ?";

        try (Connection connection = cnx.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            preparedStatement.setString(1, nomValue);
            preparedStatement.setString(2, prenomValue);
            preparedStatement.setString(3, sexeValue);
            preparedStatement.setString(4, comboValue);
            preparedStatement.setString(5, matValue);
            preparedStatement.setString(6, passValue);

            // Exécuter la requête de suppression
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Supprimer la ligne de la JTable
                table.removeRow(selectRow);

                // Réinitialiser les champs d'entrée après la suppression si nécessaire
                txtname.setText("");
                txtprenom1.setText("");
                sexe.setSelectedIndex(0);  // Remettez l'index à zéro ou à une valeur par défaut appropriée
                combo.setSelectedIndex(0); // Remettez l'index à zéro ou à une valeur par défaut appropriée
                mat.setText("");
                pass.setText("");

                // Afficher un message de succès dans la console
                JOptionPane.showMessageDialog(null, "Suppression réussie dans la base de données.");
            } else {
                // Afficher un message d'échec dans la console
                System.out.println("Aucune ligne supprimée dans la base de données.");
            }

            // Autres opérations nécessaires après la suppression
            // ...

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Gérer les exceptions appropriées
        }
    }
}

        // TODO add your handling code here:
    }//GEN-LAST:event_CleanerActionPerformed

    private void modifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifActionPerformed
                     // TODO add your handling code here:
                     
                     DefaultTableModel table = (DefaultTableModel) table3.getModel();
int selectRow = table3.getSelectedRow();

if (selectRow >= 0) {
    // Récupérer les valeurs des champs
    String nomValue = String.valueOf(table3.getValueAt(selectRow, 0));
    String prenomValue = String.valueOf(table3.getValueAt(selectRow, 1));
    String sexeValue = String.valueOf(table3.getValueAt(selectRow, 2));
    String comboValue = String.valueOf(table3.getValueAt(selectRow, 3));
    String matValue = String.valueOf(table3.getValueAt(selectRow, 4));
    String passValue = String.valueOf(table3.getValueAt(selectRow, 5));

    // Afficher une boîte de dialogue de confirmation
    int option = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment modifier cet enregistrement ?", "Confirmation de modification", JOptionPane.YES_NO_OPTION);

    if (option == JOptionPane.YES_OPTION) {
        // Mise à jour dans la base de données
        String updateQuery = "UPDATE techniciens SET Nom = ?, prenom = ?, sexe = ?, categorie = ?, Matricule = ?, code = ? WHERE nom = ? AND prenom = ? AND sexe = ? AND categorie = ? AND Matricule = ? AND code = ?";

        try (Connection connection = cnx.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            // Paramètres de mise à jour
            preparedStatement.setString(1, txtname.getText());
            preparedStatement.setString(2, txtprenom1.getText());
            preparedStatement.setString(3, (String) sexe.getSelectedItem());  // Assurez-vous que le composant est un JComboBox<String>
            preparedStatement.setString(4, (String) combo.getSelectedItem()); // Assurez-vous que le composant est un JComboBox<String>
            preparedStatement.setString(5, mat.getText());
            preparedStatement.setString(6, pass.getText());

            // Paramètres de recherche (pour identifier la ligne à mettre à jour)
            preparedStatement.setString(7, nomValue);
            preparedStatement.setString(8, prenomValue);
            preparedStatement.setString(9, sexeValue);
            preparedStatement.setString(10, comboValue);
            preparedStatement.setString(11, matValue);
            preparedStatement.setString(12, passValue);

            // Exécuter la requête de mise à jour
            int rowsAffected = preparedStatement.executeUpdate();
          
            if (rowsAffected > 0) {
                // Mise à jour réussie, vous pouvez effectuer des opérations supplémentaires si nécessaire
                JOptionPane.showMessageDialog(null, "Mise à jour réussie dans la base de données.");
                        tableAfficher();

            } else {
                // Aucune ligne mise à jour
                JOptionPane.showMessageDialog(null, "Aucune ligne mise à jour dans la base de données.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            // Gérer les exceptions appropriées
        }
    }
}

    }//GEN-LAST:event_modifActionPerformed

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
            java.util.logging.Logger.getLogger(Techniciens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Techniciens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Techniciens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Techniciens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Techniciens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cleaner;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mat;
    private javax.swing.JButton modif;
    private javax.swing.JTextField pass;
    private javax.swing.JButton sender;
    private javax.swing.JComboBox<String> sexe;
    private javax.swing.JTable table3;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtprenom1;
    // End of variables declaration//GEN-END:variables
}
