/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_enrolements.Entity;

/**
 *
 * @author tepitech
 */
public class citoyen {
    int id_citoyen;
    String nom;
    String prenom;
    String DateNaiss;
    String LieuNaiss;
    String SitMat;
    String Adresse;
    String profession;

    public citoyen(int id_citoyen, String nom, String prenom, String DateNaiss, String LieuNaiss, String SitMat, String Adresse, String profession) {
        this.id_citoyen = id_citoyen;
        this.nom = nom;
        this.prenom = prenom;
        this.DateNaiss = DateNaiss;
        this.LieuNaiss = LieuNaiss;
        this.SitMat = SitMat;
        this.Adresse = Adresse;
        this.profession = profession;
    }

    public citoyen() {
    }
    // les getteurs et setteurs

    public int getId_citoyen() {
        return id_citoyen;
    }

    public void setId_citoyen(int id_citoyen) {
        this.id_citoyen = id_citoyen;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaiss() {
        return DateNaiss;
    }

    public void setDateNaiss(String DateNaiss) {
        this.DateNaiss = DateNaiss;
    }

    public String getLieuNaiss() {
        return LieuNaiss;
    }

    public void setLieuNaiss(String LieuNaiss) {
        this.LieuNaiss = LieuNaiss;
    }

    public String getSitMat() {
        return SitMat;
    }

    public void setSitMat(String SitMat) {
        this.SitMat = SitMat;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }
    
    
}
