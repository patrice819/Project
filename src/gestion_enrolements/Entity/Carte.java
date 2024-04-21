/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_enrolements.Entity;

/**
 *
 * @author tepitech
 */
public class Carte {
      int id_carte;
      int numero;
      int id;
      int id_post;
//constructeur
    public Carte(int id_carte, int numero, int id, int id_post) {
        this.id_carte = id_carte;
        this.numero = numero;
        this.id = id;
        this.id_post = id_post;
    }
    // constructeur sans parametre

    public Carte() {
    }
    // les gettteurs

    public int getId() {
        return id;
    }

    public int getId_carte() {
        return id_carte;
    }

    public int getId_post() {
        return id_post;
    }

    public int getNumero() {
        return numero;
    }
    //les setteurs

    public void setId(int id) {
        this.id = id;
    }

    public void setId_carte(int id_carte) {
        this.id_carte = id_carte;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
      
    
}
