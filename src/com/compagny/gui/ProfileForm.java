/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */

package com.compagny.gui;

import com.mycompany.entities.Users;
import com.mycompany.services.ServiceUsers;

import com.codename1.components.ScaleImageLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import static com.mycompany.myapp.MyApplication.Sessionuser;
import java.io.IOException;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.CategorySeries;
import com.codename1.charts.renderers.DefaultRenderer;
import com.codename1.charts.renderers.SimpleSeriesRenderer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.charts.views.PieChart;
import java.util.ArrayList;


import com.codename1.ui.Button;
import com.codename1.components.ToastBar;
import com.codename1.ui.FontImage;

/**
 * The user profile form
 *
 * @author Shai Almog
 */
public class ProfileForm extends BaseForm {

    public ProfileForm(Resources res) {
        super("Newsfeed", BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
      //  setTitle("Profile");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        
        tb.addSearchCommand(e -> {});
        
        
        //Image img = res.getImage("profile-background.jpg");
        //if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
          //  img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        //}
      //  ScaleImageLabel sl = new ScaleImageLabel(img);
       // sl.setUIID("BottomPad");
        //sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

/*        Label facebook = new Label(" followers", res.getImage("facebook-logo.png"), "BottomPad");
        Label twitter = new Label(" followers", res.getImage("twitter-logo.png"), "BottomPad");
        facebook.setTextPosition(BOTTOM);
        twitter.setTextPosition(BOTTOM);*/
        Image imgggg = null;
        try {
        //     imgggg = Image.createImage("/user.png") ;
imgggg = Image.createImage(FileSystemStorage.getInstance().getAppHomePath() + "/" + Sessionuser.getImage_user()) ;

        } catch (IOException ex) {
        }
        add(LayeredLayout.encloseIn(
             
                BorderLayout.south(
                    GridLayout.encloseIn(1, 
                          //  facebook,
                           FlowLayout.encloseCenter(
                                new Label(imgggg.scaled(250, 250), "PictureWhiteBackgrond"))//,
                            //twitter
                    )
                )
        ));

        TextField username = new TextField(Sessionuser.getNom());
        username.setUIID("TextFieldBlack");
        addStringValue("Nom", username);
        
        TextField Prenom = new TextField(Sessionuser.getPrenom(), "Prenom", 20, TextField.UNEDITABLE );
        Prenom.setUIID("TextFieldBlack");
        addStringValue("Prenom", Prenom);

        TextField email = new TextField(Sessionuser.getEmail(), "E-Mail", 20, TextField.UNEDITABLE);
        email.setUIID("TextFieldBlack");
        addStringValue("E-Mail", email);
        
        TextField password = new TextField(Sessionuser.getPassword(), "Password", 20, TextField.PASSWORD);
        password.setUIID("TextFieldBlack");
        addStringValue("Password", password);

     /*   CheckBox cb1 = CheckBox.createToggle(res.getImage("on-off-off.png"));
        cb1.setUIID("Label");
        cb1.setPressedIcon(res.getImage("on-off-on.png"));
        CheckBox cb2 = CheckBox.createToggle(res.getImage("on-off-off.png"));
        cb2.setUIID("Label");
        cb2.setPressedIcon(res.getImage("on-off-on.png"));
        
        addStringValue("Facebook", FlowLayout.encloseRightMiddle(cb1));
        addStringValue("Twitter", FlowLayout.encloseRightMiddle(cb2));*/
 if ( Sessionuser.getRole().equalsIgnoreCase("[ROLE_ADMIN]")) {

// Generate the values
        double[] values = new double[]{12, 14, 11, 10, 19};
        ArrayList<Users> users;
        users = ServiceUsers.getInstance().getallusers();

        // Set up the renderer
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.GREEN, ColorUtil.MAGENTA, ColorUtil.BLACK, ColorUtil.CYAN};
        DefaultRenderer renderer = buildCategoryRenderer(colors);
        renderer.setZoomButtonsVisible(true);
        renderer.setZoomEnabled(true);
        renderer.setChartTitleTextSize(25);
        renderer.setDisplayValues(true);
        renderer.setLabelsColor(ColorUtil.BLACK);
        renderer.setShowLabels(true);
        SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
        r.setGradientEnabled(true);
        r.setGradientStart(0, ColorUtil.BLUE);
        r.setGradientStop(0, ColorUtil.GREEN);
        r.setHighlighted(true);

        // Create the chart ... pass the values and renderer to the chart object.
        PieChart chart = new PieChart(buildCategoryDataset("Stat selon sexe:", users), renderer);

        // Wrap the chart in a Component so we can add it to a form
        ChartComponent c = new ChartComponent(chart);

        add(c);    
}

        Button next = new Button("Update Profile");
add( BoxLayout.encloseY(
                next        ));
      //  next.requestFocus();

next.addActionListener(e -> {
            Boolean verifier = true;
            if (username.getText().length() == 0 || Prenom.getText().length() == 0 ) {
                verifier = false;
                ToastBar.showMessage("don't leave empty field", FontImage.MATERIAL_INFO);
            } 

            if (verifier == true) {
               
                Sessionuser.setNom(username.getText());
                Sessionuser.setPrenom(Prenom.getText());


                System.out.println(Sessionuser);
                //mail
                Users newuser = ServiceUsers.getInstance().updateuser(Sessionuser);

                //
                ToastBar.showMessage("Success", FontImage.MATERIAL_INFO);

                new ProfileForm(res).show();

            } else {
                ToastBar.showMessage("Probleme saisie", FontImage.MATERIAL_INFO);
            }

        });

}
    
    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s, "PaddedLabel")).
                add(BorderLayout.CENTER, v));
        add(createLineSeparator(0xeeeeee));
    }
    
        /**
     * Creates a renderer for the specified colors.
     */
    private DefaultRenderer buildCategoryRenderer(int[] colors) {
        DefaultRenderer renderer = new DefaultRenderer();
        renderer.setLabelsTextSize(50);
        renderer.setLegendTextSize(50);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        for (int color : colors) {
            SimpleSeriesRenderer r = new SimpleSeriesRenderer();
            r.setColor(color);
            renderer.addSeriesRenderer(r);
        }
        return renderer;
    }

    /**
     * Builds a category series using the provided values.
     *
     * @param titles the series titles
     * @param values the values
     * @return the category series
     */
    protected CategorySeries buildCategoryDataset(String title, ArrayList<Users> users) {
        CategorySeries series = new CategorySeries(title);
        int h = 0;
        int f=0;
        for (Users obj : users) {
if(obj.getSexe().equalsIgnoreCase("Homme") ){h++;}
else{f++;}
        }
            series.add("Homme" , h);
            series.add("Femme" , f);
        
        return series;
    }

}
