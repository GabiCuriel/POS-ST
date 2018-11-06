/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelUsuarios;
import views.ViewUsuarios;

/**
 *
 * @author TeddyBear
 */
public class ControllerUsuarios {
    public ModelUsuarios modelUsuarios;
    public ViewUsuarios viewUsuarios;
    ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    };
    public ControllerUsuarios(ModelUsuarios modelUsuarios, ViewUsuarios viewUsuarios) {
        this.modelUsuarios = modelUsuarios;
        this.viewUsuarios = viewUsuarios;
        setActionListener();
        initBD();
    }
    
    private void setActionListener(){
        
    }
    private void initBD(){
        
    }
    
}
