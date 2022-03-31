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
import com.mycompany.entities.Categorie;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dell
 */
public class CatgeorieService {
    
    
    private ConnectionRequest req;
    public ArrayList<Categorie> categories;
    public boolean resultOK;
    public static CatgeorieService instance = null;
    
    public static CatgeorieService getInstance(){
    
    if(instance==null)
        instance= new CatgeorieService();
    return instance;
    }
    
    public CatgeorieService(){
    
    req=new ConnectionRequest();
    }
    
    public ArrayList<Categorie> parseTasks(String jsonText) {
        try {
            categories = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
           Map<String,Object> categoriesListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)categoriesListJson.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Categorie c = new Categorie();
                float id = Float.parseFloat(obj.get("id_categorie").toString());
                c.setId_categorie((int) id);  
                c.setNom_categorie(obj.get("nom_categorie").toString());
         //Ajouter la tâche extraite de la réponse Json à la liste
                categories.add(c);
            }

        } catch (IOException ex) {

        }
        
        return categories;
    }
    
      public ArrayList<Categorie> getAllCategories() {
        String url = Statics.BASE_URL + "/categorie/listjson";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                categories = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return categories;
    }
   
      
      public ArrayList<Categorie> getCategoriesByRestaurant(int id) {
        String url = Statics.BASE_URL + "/restaurant/"+id+"/affCat";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                categories = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return categories;
    }
       public boolean addCategorie(Categorie c) {
        String url = Statics.BASE_URL + "/categorie/addCategorieJSON"+"?nom_categorie="+c.getNom_categorie(); 
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
       public boolean deleteCategorie(int id) {
        String url = Statics.BASE_URL + "/categorie/deleteCategorieJSON"+"/"+id;
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
        public boolean updateCategorie(Categorie c) {
        String url = Statics.BASE_URL + "/categorie/updateCategorieJSON"+"/"+c.getId_categorie()+"?nom_categorie="+c.getNom_categorie();
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
