/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.compagny.gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.FileSystemStorage;
import com.codename1.maps.Coord;
import com.codename1.maps.MapListener;
import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.contacts.Contact;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.OffreTravail;
import com.mycompany.myapp.MyApplication;
import com.mycompany.services.OffreTravailService;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAID EYA
 */
public class ListOffreTravail extends BaseForm{
    //public static final String BASE_URL="http://127.0.0.1:8000";

    public ListOffreTravail(Form previous ) {
        super.addSideMenu(res);
        
        setTitle("ListOffreTravail");
      //  setLayout(BoxLayout.y());

       //super("CareerKey", BoxLayout.y());
        //setTitle("List Formation");
       
        


        setLayout(BoxLayout.y());
        
       
        this.add(addImage());
        ArrayList<OffreTravail> restaurant;
        restaurant = OffreTravailService.getInstance().getAllOffreTravails(); 
        for (int i = 0; i < restaurant.size(); i++) {
        this.add(addOffreTravailsHolder(restaurant.get(i)));
    



        //SpanLabel sp = new SpanLabel();
        //p.setText(ServiceCategorie.getInstance().getAllCategories().toString());
        
      
    }}
    
    /**********************************/
   public Container addOffreTravailsHolder(OffreTravail s) {
    try{
        Container holder = new Container(BoxLayout.x(),BorderLayout.CENTER);
        holder.getStyle().setBgColor(0xFFFFFF);
        holder.getStyle().setBgTransparency(255);
        Container details = new Container(BoxLayout.y());
        Container titleDuree = new Container(BoxLayout.x());
       Image img1 = null;
        try {
            img1= Image.createImage("/restaurant.png");
        } catch (IOException ex) {}
        
        Image img = img1.scaled(300, 300);
        Label Limg = new Label();    
        Limg.setIcon(img);
        Label lbTitle = new Label(s.getTitre());
        lbTitle.getStyle().setFgColor(0x2D6814);
        Label lDescription = new Label(s.getDescription());
        titleDuree.addAll(lbTitle);
        details.addAll(titleDuree, lDescription);
        //holder.addAll(details);
        holder.addAll(Limg,details);
            lbTitle.addPointerReleasedListener((evnt)->{
            //Dialog.show(s.getTitle(),"voir menu",null);
            new ListCategorie(current,s.getId_OffreTravail()).show();
            });
            
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