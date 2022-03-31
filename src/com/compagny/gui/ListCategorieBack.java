/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compagny.gui;

import com.codename1.ui.Command;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Categorie;
import com.mycompany.entities.Restaurant;
import com.mycompany.services.CatgeorieService;
import com.mycompany.services.RestaurantService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class ListCategorieBack extends BaseForm {
     Form current;
     
    public ListCategorieBack(Form previous) {
         
        super.addSideMenu(res);
        
        current=this; //Back 
        setTitle("list Categorie");
        setLayout(BoxLayout.y());
       
        //this.add(addImage());
        ArrayList<Categorie> categorie;
        categorie = CatgeorieService.getInstance().getAllCategories();
        for (int i = 0; i < categorie.size(); i++) {
        this.add(addRestaurantsHolder(categorie.get(i)));
    
        }
    }
        
        
   
public Container addRestaurantsHolder(Categorie s) {
    try{
        Container holder = new Container(BoxLayout.x(),BorderLayout.CENTER);
        holder.getStyle().setBgColor(0xFFFFFF);
        holder.getStyle().setBgTransparency(255);
        Container details = new Container(BoxLayout.y());
        Container titleDuree = new Container(BoxLayout.x());
       Image img1 = null;
        try {
            img1= Image.createImage("/food.png");
        } catch (IOException ex) {}
        
        Image img = img1.scaled(300, 300);
        Label Limg = new Label();    
        
        Limg.setIcon(img);
        Label lbTitle = new Label(s.getNom_categorie());
        lbTitle.getStyle().setFgColor(0x2D6814);
        
         // boutton supprimer
        Label lsupprimer = new Label(" ");
        lsupprimer.setUIID("SevaTopline");
        Style supprimerStyle = new Style(lsupprimer.getUnselectedStyle());
        
        FontImage supprimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
        lsupprimer.setIcon(supprimerImage);
        lsupprimer.setTextPosition(RIGHT);
        
        // click supprimer icon
        lsupprimer.addPointerPressedListener((l)->{
                //Dialog.show(s.getTitle(),s.getDescription(),"ok",null);
            Dialog dig = new Dialog("suppression");
            if(dig.show("Suppression","vous voulez supprimer cette categorie ?","Annuler","Oui")){
                dig.dispose();
            }
            else {
                dig.dispose();
                //naaytou l fonction supprimer
                if(CatgeorieService.getInstance().deleteCategorie(s.getId_categorie())){
                    
                    Form f = new ListCategorieBack(current);
                    f.show();
                    
                    Dialog.show("Success","Connection accepted",new Command("OK"));
            
                }
            }



            //f.show();
            });
       
        //update icon
        Label lModifier = new Label(" ");
        lModifier.setUIID("SevaTopLine");
        Style modifierStyle = new Style(lModifier.getUnselectedStyle());
        
        FontImage modifierImage = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
        lModifier.setIcon(modifierImage);
        lModifier.setTextPosition(RIGHT);
        
        // action update
        lModifier.addPointerPressedListener((l)->{
            
            //System.out.println("hello update");
            new UpdateCategorie(s,res).show();
                
            
            });
        
        titleDuree.addAll(lbTitle);
        details.addAll(titleDuree);
        //holder.addAll(details);
        holder.addAll(Limg,details,lsupprimer,lModifier);
          
            
      
        return holder;
    }catch(NullPointerException e){
        System.out.println(e.getMessage());
    }
    return new Container(BoxLayout.x());
    }

    public Container addImage() {
    try{
        Container holder = new Container(BoxLayout.x(),BorderLayout.CENTER);
        holder.getStyle().setBgColor(0xFFFFFF);
        holder.getStyle().setBgTransparency(255);
        Image imgggg2 = null;
        try {
            imgggg2 = Image.createImage("/bg.jpg");
        } catch (IOException ex) {
        }
        Image img = imgggg2.scaled(1100, 400);
        
        Label Limg = new Label();    
        Limg.setIcon(img);
        holder.add(Limg);
        return holder;
    }catch(NullPointerException e){
        System.out.println(e.getMessage());
    }
    return new Container(BoxLayout.x());
    }
}
