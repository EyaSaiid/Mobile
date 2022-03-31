/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Categorie;
import com.mycompany.entities.Reservation;
import com.mycompany.utils.Statics;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class ReservationService {
     private ConnectionRequest req;
    public ArrayList<Reservation> reservations;
    public boolean resultOK;
    public static ReservationService instance = null;
    
    public static ReservationService getInstance(){
    
    if(instance==null)
        instance= new ReservationService();
    return instance;
    }
    
    public ReservationService(){
    
    req=new ConnectionRequest();
    }
  
    
    
    

   public boolean addReservation(Reservation r) {
        String url = Statics.BASE_URL + "/Reservation/ajouterResJson"+"?capacite="+r.getCapacite()
         +"&date_reservation="+r.getDate_reservation()+"&date_reservation="+r.getDate_reservation()
         +"&id_restaurant="+r.getId_restaurant()+"&id_client="+34;
       // http://127.0.0.1:8000/reservation/ajouterResJson?nombre=5&date_reservation=2022-03-17&id_restaurant=18&id_client=34&user_id=34

        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
}
