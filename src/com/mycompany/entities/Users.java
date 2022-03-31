/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.entities;

import java.util.Date;


/**
 *
 * @author SAID EYA
 */
public class Users {

    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String email;
    private int numero_tele;
    private String adress; 
    private Date date;
    private String password;
    private String image_user;
    private String role;

    public Users() {
    }

    public Users(String nom, String prenom, String sexe, String email, int numero_tele, Date date, String password, String image_user) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.email = email;
        this.numero_tele = numero_tele;
        this.date = date;
        this.password = password;
        this.image_user = image_user;
    }

    public Users(int id, String nom, String prenom, String sexe, String email, int numero_tele, String adress, Date date, String password, String image_user) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.email = email;
        this.numero_tele = numero_tele;
        this.adress = adress;
        this.date = date;
        this.password = password;
        this.image_user = image_user;
    }

    public Users(String nom, String prenom, String sexe, String email, int numero_tele, String adress, Date date, String password, String image_user) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.email = email;
        this.numero_tele = numero_tele;
        this.adress = adress;
        this.date = date;
        this.password = password;
        this.image_user = image_user;
    }

   

  

    @Override
    public String toString() {
        return "Users{Role :"+role + " id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", email=" + email + ", numero_tele=" + numero_tele + ", adress=" + adress + ", date=" + date + ", password=" + password + ", image_user=" + image_user +'}';
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero_tele() {
        return numero_tele;
    }

    public void setNumero_tele(int numero_tele) {
        this.numero_tele = numero_tele;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage_user() {
        return image_user;
    }

    public void setImage_user(String image_user) {
        this.image_user = image_user;
    }
    
public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
