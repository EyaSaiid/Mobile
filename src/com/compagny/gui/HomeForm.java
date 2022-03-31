/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compagny.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import static com.mycompany.myapp.MyApplication.Sessionuser;


/**
 *
 * @author bhk
 */
public class HomeForm extends Form{
Form current;
Resources res;
    public HomeForm() {
        current=this; //Back 
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAddTask = new Button("List Restaurant");
        Button btnAddTasks2 = new Button("Ajouter Reservation");
        Button btnAddTasks3 = new Button("List offre de travail");
        Button btnAddTasks4 = new Button("Logout");
        Button btnAddTask5 = new Button("affichage ");

        Button btnStat = new Button("Statistique Restaurant");
        
        Button btnAddTask7 = new Button("Liste Categorie");
         btnAddTask7.addActionListener(e-> new ListCategorieBack(current).show());
         Button btnAddTask8 = new Button("Ajouter Categorie");
         btnAddTask7.addActionListener(e-> new Back_AjoutCategoriePlat(current).show());
        
        btnAddTask.addActionListener(e-> new ListRestaurant(current).show());
        btnAddTasks2.addActionListener(e-> new AjouterReservation(current).show());
        btnStat.addActionListener(e-> new Front_StatCategorie(res,current).show());
        btnAddTasks3.addActionListener(e-> new ListOffreTravail(current).show());
        btnAddTasks4.addActionListener(e-> new SignInForm(res).show());

        btnAddTask5.addActionListener(e-> new ListRestaurant(current).show());

if ( Sessionuser.getRole().equalsIgnoreCase("[ROLE_ADMIN]")) {
        addAll(btnAddTask,btnAddTasks2,btnStat,btnAddTasks3,btnAddTasks4,btnAddTask5,btnAddTask7,btnAddTask8);

}
   else{
      //  btnListTasks.addActionListener(e-> new ListCategorie(current).show());
       // btnListTasks.addActionListener(e-> new ListTasksForm(current).show());
        addAll(btnAddTask,btnAddTasks2,btnStat,btnAddTasks3,btnAddTasks4);
        
        }
        
        
    }
    
    
}
