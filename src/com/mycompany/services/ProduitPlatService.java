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
import com.mycompany.entities.ProduitPlat;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dell
 */
public class ProduitPlatService {
     private ConnectionRequest req;
    public ArrayList<ProduitPlat> produitplats;
    public boolean resultOK;
    public static ProduitPlatService instance = null;
    
    public static ProduitPlatService getInstance(){
    
    if(instance==null)
        instance= new ProduitPlatService();
    return instance;
    }
    
    public ProduitPlatService(){
    
    req=new ConnectionRequest();
    }
        public ArrayList<ProduitPlat> parseTasks(String jsonText) {
        try {
            produitplats = new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
           Map<String,Object> produitplatsListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)produitplatsListJson.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                ProduitPlat p = new ProduitPlat();
                float id = Float.parseFloat(obj.get("id_produitplat").toString());
                p.setId_produitplat((int) id);
                p.setNom_produitplat(obj.get("nom_produitplat").toString());
                float prix = Float.parseFloat(obj.get("prix").toString());
                p.setPrix(prix);
              
         //Ajouter la tâche extraite de la réponse Json à la liste
                produitplats.add(p);
            }

        } catch (IOException ex) {

        }
        
        return produitplats;
    }
    
      public ArrayList<ProduitPlat> getAllProduitPlatsByCategorie(int idRest, int idCat) {
        String url = Statics.BASE_URL + "/produit/plat/aff/"+idRest+"/"+idCat;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                produitplats = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produitplats;
    }
}
