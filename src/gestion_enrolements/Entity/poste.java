/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion_enrolements.Entity;

/**
 *
 * @author tepitech
 */
public class poste {
     int id_poste;
     String region;
     String ville;
     String quartier;

    public poste(int id_poste, String religion, String ville, String quartier) {
        this.id_poste = id_poste;
        this.region = religion;
        this.ville = ville;
        this.quartier = quartier;
    }
     //constructeur sans parametre 

    public poste() {
    }
    
     //les getteurs

    public int getId_poste() {
        return id_poste;
    }

    public String getReligion() {
        return region;
    }

    public String getVille() {
        return ville;
    }

    public String getQuartier() {
        return quartier;
    }
    //les setteurs

    public void setId_poste(int id_poste) {
        this.id_poste = id_poste;
    }

    public void setReligion(String religion) {
        this.region = religion;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }
    
  
     
    
}
