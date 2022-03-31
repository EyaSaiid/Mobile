/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compagny.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Categorie;
import com.mycompany.services.CatgeorieService;

/**
 *
 * @author dell
 */
public class UpdateCategorie extends BaseForm {
    Form current;
    Form previous;
    public UpdateCategorie (Categorie c,Resources res) {
     setTitle("Modify Category");
        setLayout(BoxLayout.y());
        
        TextField tf_categorie= new TextField(c.getNom_categorie(),"Nom Categorie");
        
        Button btnModifier = new Button("Modifier");
        
        btnModifier.addPointerPressedListener((l)->{
            
            //System.out.println("hello update");
            c.setNom_categorie(tf_categorie.getText());

            if(CatgeorieService.getInstance().updateCategorie(c)){
                    
                    Form f = new ListCategorieBack(previous);
                    f.show();
                    
                    Dialog.show("Success","Connection accepted",new Command("OK"));
            
                }
            
            Button btnAnnuler = new Button ("Annuler");
            
            
            
            });
        
        addAll(tf_categorie,btnModifier);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e -> {
                    Form f = new ListCategorieBack(previous);
                    f.show();
                }
                );
        
        
        
    }
    
    
}
