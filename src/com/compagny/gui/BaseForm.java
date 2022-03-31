/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compagny.gui;

import com.codename1.components.ScaleImageLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import static com.mycompany.myapp.MyApplication.Sessionuser;

/**
 *
 * @author dell
 */
public class BaseForm extends Form{
   // private AdMobManager admob;
    int n = 0;
       Resources res;
       Form current;

    public BaseForm() {
    }

    public BaseForm(Layout contentPaneLayout) {
        super(contentPaneLayout);
    }

    public BaseForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }

    public Component createLineSeparator() {
        Label separator = new Label("", "WhiteSeparator");
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    public Component createLineSeparator(int color) {
        Label separator = new Label("", "WhiteSeparator");
        separator.getUnselectedStyle().setBgColor(color);
        separator.getUnselectedStyle().setBgTransparency(255);
        separator.setShowEvenIfBlank(true);
        return separator;
    }

    protected void addSideMenu(Resources res) {
        /////////admob debut

        String admobId = "ca-app-pub-3940256099942544/1033173712";
        if (Display.getInstance().getPlatformName().equals("ios")) {
            admobId = "ca-app-pub-3940256099942544/1033173712";
        }

        // Note:  admobId is the ID of the target ads you want to display
        // not your admob App ID.
        // See instructions for Android and iOS below for specifying admob app ID
        // via build hints.
        //admob = new AdMobManager(admobId);
        ///////////////////addmob fin

        Toolbar tb = getToolbar();
        Image imgggg2 = null;
        try {
            imgggg2 = Image.createImage("/DMA9.png");
        } catch (IOException ex) {
        }

        Image img = imgggg2.scaled(400, 450);
        //Image img = res.getImage("profile-background.jpg");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
       
        
        tb.addComponentToLeftSideMenu(sl);
 if ( Sessionuser.getRole().equalsIgnoreCase("[ROLE_ADMIN]")) {
        tb.addMaterialCommandToSideMenu("Dashboard", FontImage.MATERIAL_SETTINGS, e -> new ProfileForm(res).show());
                   }

        tb.addMaterialCommandToSideMenu("Accueil", FontImage.MATERIAL_EXIT_TO_APP, e -> new HomeForm().show());
        tb.addMaterialCommandToSideMenu("Restaurants", FontImage.MATERIAL_UPDATE, e -> new ListRestaurant(current).show());
        tb.addMaterialCommandToSideMenu("Reservation", FontImage.MATERIAL_DASHBOARD, e -> new AjouterReservation(current).show());
        tb.addMaterialCommandToSideMenu("Statistique", FontImage.MATERIAL_DASHBOARD, e -> new Front_StatCategorie(res,current).show());
        tb.addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_SETTINGS, e -> new ProfileForm(res).show());
        tb.addMaterialCommandToSideMenu("Log out", FontImage.MATERIAL_EXIT_TO_APP, e-> new SignInForm(res).show());

       
        
    }

    
    
}
