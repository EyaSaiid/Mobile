/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compagny.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.entities.Categorie;
import com.mycompany.entities.Restaurant;
import com.mycompany.services.CatgeorieService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class ListCategorie extends BaseForm {
    
    
    Form current;
    
    public ListCategorie(Form previous, int idRest) {
         super.addSideMenu(res);
        current=this; 
        setTitle("Categorie");
        setLayout(BoxLayout.y());
         
        Image imgggg2 = null;
        try {
            imgggg2 = Image.createImage("/bgCategorie.jpg");
        } catch (IOException ex) {
        }

        Image img = imgggg2.scaled(300, 1300);
        //Image img = res.getImage("profile-background.jpg");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
       
        
        this.add(sl);
        
        ArrayList<Categorie> categorie;
        categorie = CatgeorieService.getInstance().getCategoriesByRestaurant(idRest);
        for (int i = 0; i < categorie.size(); i++) {
          this.add(addCategorieHolder(categorie.get(i),idRest));
        }
         ScaleImageLabel s2 = new ScaleImageLabel(img);
        s2.setUIID("BottomPad");
        s2.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
       
        
        this.add(s2);
        
        
   /* public ListCategorieByRestaurant(Form previous) {
         
        current=this; 
        setTitle("Categorie");
        setLayout(BoxLayout.y());
        
        
     ArrayList<Categorie> categorie;
        categorie = CatgeorieService.getInstance().getAllCategories();
        for (int i = 0; i < categorie.size(); i++) {
          this.add(addCategorieHolder(categorie.get(i)));
       
   
        }*/
  

    }

    public Container addCategorieHolder(Categorie c,int idRest) {
    try{
        Container holder = new Container(BoxLayout.x(),BorderLayout.CENTER);
        holder.getStyle().setBgColor(0xFFFFFF);
        holder.getStyle().setBgTransparency(255);
        Container details = new Container(BoxLayout.y(),BorderLayout.CENTER);
        
        Button lbTitle = new Button(c.getNom_categorie());
        lbTitle.addActionListener((evnt)->{
           
            new ListProduitPlat(current,idRest,c.getId_categorie()).show();
            });
        details.add(lbTitle);
        holder.addAll(details);
       
        return holder;
    }catch(NullPointerException e){
        System.out.println(e.getMessage());
    }
    return new Container(BoxLayout.x());
    }
    
      
         
       
       
    
    
}
