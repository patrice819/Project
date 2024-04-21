/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_enrolements.Entity;

/**
 *
 * @author tepitech
 */
public class Technicien {
    int id;
    String nom;
    String prenom;
    String sexe;
    String Categories;
//constructeur avec parametre
    public Technicien(int id, String nom, String prenom, String sexe, String Categories) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.Categories = Categories;
    }
//constructeur sans parametre 
    public Technicien() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getCategories() {
        return Categories;
    }
    //les setteurs

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setCategories(String Categories) {
        this.Categories = Categories;
    }
    
    
}
