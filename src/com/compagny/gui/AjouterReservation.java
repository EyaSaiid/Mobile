/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compagny.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.mycompany.entities.Reservation;
import com.mycompany.entities.Restaurant;
import com.mycompany.services.ReservationService;
import com.mycompany.services.RestaurantService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author dell
 */
public class AjouterReservation extends BaseForm{
   
    
    
    public AjouterReservation(Form previous) {
        super.addSideMenu(res);
        
        setTitle("Ajouter Reservation");
        setLayout(BoxLayout.y());
        
        Image imgggg2 = null;
        try {
            imgggg2 = Image.createImage("/book1.jpg");
        } catch (IOException ex) {
        }

        Image img = imgggg2.scaled(900, 500);
        //Image img = res.getImage("profile-background.jpg");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
       
        
        this.add(sl);
                Container holder = new Container(BoxLayout.x(),BorderLayout.CENTER);
                holder.getStyle().setBgColor(0xFFFFFF);
                holder.getStyle().setBgTransparency(255);
                Label lbTitle = new Label("        Ajouter une réservation");
                lbTitle.setUIID("Title");
                lbTitle.getAllStyles().setAlignment(Component.CENTER);
                
                holder.add(lbTitle);
                this.add(holder);
                        
        TextField Nbr = new TextField("","Nombre de place à reserver");
        
        
        /* datePicker 'DATE DEBUT' */
        Picker datePicker1 = new Picker();
        datePicker1.setType(Display.PICKER_TYPE_DATE);
        datePicker1.setDate(new Date());
        ComboBox<String> cat= new ComboBox<>();
        RestaurantService sc=new RestaurantService();
        ArrayList<Restaurant> listCat = sc.getAllRestaurants();
        for(int i=0;i<listCat.size();i++ )
        {
            cat.addItem(listCat.get(i).getNom_restaurant());
        }
        Button btnValider = new Button("Valider");
        btnValider.getAllStyles().setBgColor(0xFFFFFF);
        btnValider.getAllStyles().setFgColor(0xFF8469);
        btnValider.getAllStyles().setBackgroundGradientEndColor(0xFFFFFF);

        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((Nbr.getText().length()<=0)&&(Nbr.getText().length()>50) )
                    Dialog.show("Alert", "Le nombre doit entre entre [0..50]", new Command("OK"));
                
                else
                {
                    try {
                        Reservation r = new Reservation();//tekhou les champs
                        if( ReservationService.getInstance().addReservation(r)){
                            
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                           // ReservationService.getInstance().sendEmail("houssem.baccouche.1@esprit.tn");
                            }
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        addAll(BoxLayout.encloseX(BoxLayout.encloseX(Nbr)),
                BoxLayout.encloseX(BoxLayout.encloseX(datePicker1)),
                 BoxLayout.encloseX(BoxLayout.encloseX(cat)),
                BoxLayout.encloseX(BoxLayout.encloseX(btnValider)));
       
        
      
                
    }
}
