/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entities;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dell
 */
public class Reservation {
     private int id_reservation;
    private int capacite;
    private Date date_reservation;
    private int id_client;
    private int id_restaurant;
    private String nom_restaurant;
    private ArrayList<Restaurant> restaurants;
    

    public Reservation(int id_reservation, int capacite, Date date_reservation, int id_client, int id_restaurant, String nom_restaurant) {
        this.id_reservation = id_reservation;
        this.capacite = capacite;
        this.date_reservation = date_reservation;
        this.id_client = id_client;
        this.id_restaurant = id_restaurant;
        this.nom_restaurant = nom_restaurant;
    }
     public Reservation() {
        this.id_reservation = id_reservation;
        this.capacite = capacite;
        this.date_reservation = date_reservation;
        this.id_client = id_client;
        this.id_restaurant = id_restaurant;
        this.nom_restaurant = nom_restaurant;
    }

    public Reservation(int capacite, Date date_reservation, int id_client, int id_restaurant, String nom_restaurant) {
        this.capacite = capacite;
        this.date_reservation = date_reservation;
        this.id_client = id_client;
        this.id_restaurant = id_restaurant;
        this.nom_restaurant = nom_restaurant;
    }
     public ArrayList<Restaurant> getResataurants() {
        return restaurants;
    }

    public void setServices(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
    

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public int getId_restaurant() {
        return id_restaurant;
    }

    public void setId_restaurant(int id_restaurant) {
        this.id_restaurant = id_restaurant;
    }

    public String getNom_restaurant() {
        return nom_restaurant;
    }

    public void setNom_restaurant(String nom_restaurant) {
        this.nom_restaurant = nom_restaurant;
    }
     
     
    
}
