/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

/**
 *
 * @author dell
 */
public class ProduitPlat {
      private int id_produitplat;
      private String nom_produitplat;
      private float prix;
      private String $desc_produitplat;
      private int id_categorie;

    public ProduitPlat(int id_produitplat, String nom_produitplat, float prix, String $desc_produitplat) {
        this.id_produitplat = id_produitplat;
        this.nom_produitplat = nom_produitplat;
        this.prix = prix;
        this.$desc_produitplat = $desc_produitplat;
    }
     public ProduitPlat() {
        this.id_produitplat = id_produitplat;
        this.nom_produitplat = nom_produitplat;
        this.prix = prix;
        this.$desc_produitplat = $desc_produitplat;
       
    }

    public int getId_produitplat() {
        return id_produitplat;
    }

    public String getNom_produitplat() {
        return nom_produitplat;
    }

    public float getPrix() {
        return prix;
    }

    public String get$desc_produitplat() {
        return $desc_produitplat;
    }

    public void setId_produitplat(int id_produitplat) {
        this.id_produitplat = id_produitplat;
    }

    public void setNom_produitplat(String nom_produitplat) {
        this.nom_produitplat = nom_produitplat;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void set$desc_produitplat(String $desc_produitplat) {
        this.$desc_produitplat = $desc_produitplat;
    }
      
    
}
