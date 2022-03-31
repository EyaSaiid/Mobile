/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.entities;

/**
 *
 * @author SAID EYA
 */
public class OffreTravail {
    
    private int id_OffreTravail;

     private String titre;
     private String description;
     
    
    public OffreTravail(int id_OffreTravail, String titre,String description){
        this.id_OffreTravail=id_OffreTravail;
        this.titre=titre;
        this.description=description;
    }
    public OffreTravail(){
    
    }
    public void setId_OffreTravail(int id_OffreTravail) {
           this.id_OffreTravail = id_OffreTravail;
       }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setDescription(String description) {
            this.description = description;
        }
    
    public OffreTravail(String titre,String description){
            this.titre=titre;
            this.description=description;
        }
    public int getId_OffreTravail() {
               return id_OffreTravail;
           }

    public String getTitre() {
        return titre;
    }
    public String getDescription() {
            return description;
        }

    @Override
    public String toString() {
        return "Offre de travail{" + "id_OffreTravail=" + id_OffreTravail + ", titre=" + titre + ", description" + description + '}';
    }
}
