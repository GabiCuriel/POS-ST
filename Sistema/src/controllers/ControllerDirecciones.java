/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelDirecciones;
import views.ViewDirecciones;

/**
 *
 * @author TeddyBear
 */
public class ControllerDirecciones {
    public ModelDirecciones modelDirecciones;
    public ViewDirecciones viewDirecciones;
    
    ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    };
    
    public ControllerDirecciones(ModelDirecciones modelDirecciones, ViewDirecciones viewDirecciones) {
        this.modelDirecciones = modelDirecciones;
        this.viewDirecciones = viewDirecciones;
    setActionListener();
        initBD();
    }
    
    private void setActionListener(){
        
    }
    private void initBD(){
        
    }
    
}
