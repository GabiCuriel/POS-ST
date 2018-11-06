/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelUsuarios;
=======
import models.ModelUsuarios_CRUD;
>>>>>>> 40207481260a0c4b871cd4255c0081a19afe5059
import views.ViewUsuarios;

/**
 *
 * @author TeddyBear
 */
public class ControllerUsuarios {
    public ModelUsuarios_CRUD modelUsuarios;
    public ViewUsuarios viewUsuarios;
<<<<<<< HEAD
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
=======
    public ControllerUsuarios(ModelUsuarios_CRUD modelUsuarios, ViewUsuarios viewUsuarios) {
>>>>>>> 40207481260a0c4b871cd4255c0081a19afe5059
        
    }
    
}
