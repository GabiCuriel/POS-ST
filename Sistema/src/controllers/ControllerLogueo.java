/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelLogueo;
import views.ViewLogueo;
import main.Main;
/**
 *
 * @author TeddyBear
 */
public class ControllerLogueo {
    
    public Main main;
    public ModelLogueo modelLogueo;
    public ViewLogueo viewLogueo;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewLogueo.JB_Loguear){
                login();
            }
        }
    };
    
    public ControllerLogueo(ModelLogueo modelLogueo, ViewLogueo viewLogueo) {
        this.modelLogueo = modelLogueo;
        this.viewLogueo = viewLogueo;
        initComponents();
        setActionListener();
    }
    
    private void setActionListener(){
        viewLogueo.JB_Loguear.addActionListener(actionListener);
    }
    
    private void initComponents(){
        viewLogueo.setTitle("SOUL TECH - FERRETERIAS ACME - INICIAR SESIÓN");
        viewLogueo.setLocationRelativeTo(null);
        viewLogueo.setVisible(true);
    }
    
    private void login(){
        modelLogueo.setUsuario(viewLogueo.JTF_Usuario.getText());
        modelLogueo.setPassword(viewLogueo.JTF_Password.getText());
        modelLogueo.login();
        
    }
    
}
