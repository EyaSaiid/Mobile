/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compagny.gui;

import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.entities.ProduitPlat;
import com.mycompany.entities.Restaurant;
import com.mycompany.services.ProduitPlatService;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class ListProduitPlat extends BaseForm{
    
    
     Form current;
    public ListProduitPlat(Form previous, int idres, int idcat) {
        super.addSideMenu(res);
        current=this; //Back 
        setTitle("list Produit Plat");
        setLayout(BoxLayout.y());
        this.add(addImage());
        
        
        
        
        ArrayList<ProduitPlat> produitplats;
        produitplats = ProduitPlatService.getInstance().getAllProduitPlatsByCategorie(idres,idcat);
        for (int i = 0; i < produitplats.size(); i++) {
        this.add(addProduitPlatsHolder(produitplats.get(i)));
      
        }
         Label lretour = new Label(" ");
        lretour.setUIID("retour");
        Style modstyle = new Style(lretour.getUnselectedStyle());
        modstyle.setFgColor(0x008000);

        FontImage retourimage = FontImage.createMaterial(FontImage.MATERIAL_ARROW_BACK, modstyle);
        lretour.setIcon(retourimage);
        lretour.setTextPosition(RIGHT);

        add(lretour);
        lretour.addPointerPressedListener(l -> new ListCategorie(current,idres).show());
}
    
    public Container addProduitPlatsHolder(ProduitPlat p) {
    try{
        Container holder = new Container(BoxLayout.x(),BorderLayout.CENTER);
        Container details = new Container(BoxLayout.y());
        Container details2 = new Container(BoxLayout.y(),BorderLayout.EAST);
        holder.getStyle().setBgColor(0xFFFFFF);
        holder.getStyle().setBgTransparency(255);
        Container titleDuree = new Container(BoxLayout.x());
       Image img1 = null;
        try {
            img1= Image.createImage("/food.png");
        } catch (IOException ex) {}
        
        Image img = img1.scaled(300, 300);
        Label Limg = new Label();    
        Limg.setIcon(img);
        Label lbTitle = new Label(p.getNom_produitplat());
        lbTitle.getStyle().setFgColor(0xFBB33B);
        Label lDescription = new Label(p.get$desc_produitplat());
        Float prixF=p.getPrix();
        Label lprix = new Label(prixF.toString());
        titleDuree.addAll(lbTitle);
        details.addAll(titleDuree, lDescription);
        details2.addAll(lprix);
        holder.addAll(Limg,details,details2);
        //holder.setLeadComponent(Limg);
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
            imgggg2 = Image.createImage("/food1.jpg");
        } catch (IOException ex) {
        }
        Image img = imgggg2.scaled(1100, 500);
        
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
