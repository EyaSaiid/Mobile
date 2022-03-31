/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.OffreTravail;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;

/**
 *
 * @author SAID EYA
 */
public class OffreTravailService {


    private ConnectionRequest req;
    public ArrayList<OffreTravail> offreTravails;
    public boolean resultOK;
    public static OffreTravailService instance = null;
    
    public static OffreTravailService getInstance(){
    
        if(instance==null)
            instance= new OffreTravailService();
        return instance;
    }
    
    public OffreTravailService(){
    
        req=new ConnectionRequest();
    }

    public ArrayList<OffreTravail> parseOffreTravail(String jsonText) {
            try {
                offreTravails = new ArrayList<>();
                JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json
                
                Map<String,Object> offreTravailsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                
                List<Map<String,Object>> list = (List<Map<String,Object>>)offreTravailsListJson.get("root");

                //Parcourir la liste des tâches Json
                for (Map<String, Object> obj : list) {
                    //Création des tâches et récupération de leurs données
                    OffreTravail e = new OffreTravail();
                    float id = Float.parseFloat(obj.get("id").toString());
                    e.setId_OffreTravail((int)id);
                    e.setTitre(obj.get("titre").toString());
                    e.setDescription(obj.get("description").toString());
             //Ajouter la tâche extraite de la réponse Json à la liste
                    offreTravails.add(e);
                }

            } catch (Exception ex) {

            }

            return offreTravails;
        }

    public ArrayList<OffreTravail> getAllOffreTravails() {
            String url = Statics.BASE_URL + "/offre/travail/listjson";
            req.setUrl(url);
            req.setPost(false);
            req.addResponseListener(new ActionListener<NetworkEvent>() {
                @Override
                public void actionPerformed(NetworkEvent evt) {
                    offreTravails = parseOffreTravail(new String(req.getResponseData()));
                    req.removeResponseListener(this);
                }
            });
            NetworkManager.getInstance().addToQueueAndWait(req);
            return offreTravails;
        }
    
}
