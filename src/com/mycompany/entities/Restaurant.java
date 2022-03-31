/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;



/**
 *
 * @author dell
 */
public class Restaurant {
    private int id_restaurant;
    private String nom_restaurant;
    private int capacité;
    private String specialité;
    private String Num_tel;
   
   

    public Restaurant(int id_restaurant, String nom_restaurant, int capacité, String specialité, String Num_tel) {
        this.id_restaurant = id_restaurant;
        this.nom_restaurant = nom_restaurant;
        this.capacité = capacité;
        this.specialité = specialité;
        this.Num_tel = Num_tel;
        
    }
    public Restaurant() {
           this.id_restaurant = id_restaurant;
        this.nom_restaurant = nom_restaurant;
        this.capacité = capacité;
        this.specialité = specialité;
        this.Num_tel = Num_tel;
        
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public void setNom_restaurant(String nom_restaurant) {
        this.nom_restaurant = nom_restaurant;
    }

    public void setCapacité(int capacité) {
        this.capacité = capacité;
    }

    public void setSpecialité(String specialité) {
        this.specialité = specialité;
    }

    public void setNum_tel(String Num_tel) {
        this.Num_tel = Num_tel;
    }

    

    public Restaurant(String nom_restaurant, int capacité, String specialité, String Num_tel) {
        this.nom_restaurant = nom_restaurant;
        this.capacité = capacité;
        this.specialité = specialité;
        this.Num_tel = Num_tel;
       
    }

    public int getId_restaurant() {
        return id_restaurant;
    }

    public String getNom_restaurant() {
        return nom_restaurant;
    }

    public int getCapacité() {
        return capacité;
    }

    public String getSpecialité() {
        return specialité;
    }

    public String getNum_tel() {
        return Num_tel;
    }

    @Override
    public String toString() {
        return "Restaurant{" + "id_restaurant=" + id_restaurant + ", nom_restaurant=" + nom_restaurant + ", capacit\u00e9=" + capacité + ", specialit\u00e9=" + specialité + ", Num_tel=" + Num_tel + '}';
    }

   
    
}
