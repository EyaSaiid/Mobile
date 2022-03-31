/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Restaurant;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;



/**
 *
 * @author dell
 */
public class RestaurantService {
  
    private ConnectionRequest req;
    public ArrayList<Restaurant> restaurants;
    public boolean resultOK;
    public static RestaurantService instance = null;
    
    public static RestaurantService getInstance(){
    
    if(instance==null)
        instance= new RestaurantService();
    return instance;
    }
    
    public RestaurantService(){
    
    req=new ConnectionRequest();
    }
    
    public ArrayList<Restaurant> parseRestaurants(String jsonText) {
        try {
            restaurants = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
           Map<String,Object> restaurantsListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)restaurantsListJson.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Restaurant e = new Restaurant();
                float id = Float.parseFloat(obj.get("id_restaurant").toString());
                e.setId_restaurant((int) id);
                e.setCapacité(((int)Float.parseFloat(obj.get("capacite").toString())));
                e.setSpecialité(((obj.get("specialite").toString())));
                e.setNom_restaurant(obj.get("nom_restaurant").toString());
                e.setNum_tel(obj.get("num_tel").toString());
         //Ajouter la tâche extraite de la réponse Json à la liste
                restaurants.add(e);
            }

        } catch (IOException ex) {

        }
        
        return restaurants;
    }
    
      public ArrayList<Restaurant> getAllRestaurants() {
        String url = Statics.BASE_URL + "/restaurant/listjson";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                restaurants = parseRestaurants(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return restaurants;
    }
      
    
}
