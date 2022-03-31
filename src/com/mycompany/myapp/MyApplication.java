package com.mycompany.myapp;


import static com.codename1.ui.CN.*;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.compagny.gui.AjouterReservation;
import com.compagny.gui.SignInForm;
//import com.compagny.gui.SignUpForm;
import com.compagny.gui.HomeForm;
//import com.compagny.gui.Accueil_User;
import com.compagny.gui.ListCategorie;
import com.compagny.gui.ListRestaurant;
import com.compagny.gui.ListOffreTravail;
import com.mycompany.entities.Users;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    public Resources theme;

    public static int iduser ;
    public static Users Sessionuser ;
    public static Users Resetuser ;
    public static Users signupuser ;    
    public static int verificationcode ;
    public static String verificationemail ;

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
        //Form F1 = new HomeForm();
        //Form F1 = new Accueil_User(theme);
       //F1.show();
        new SignInForm(theme).show();

    }

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }

}
