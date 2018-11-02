/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.*;
import models.*;
/**
 *
 * @author TeddyBear
 */
public class ControllerPrincipal {
    
    private final ModelPrincipal modelPrincipal;
    private final ViewPrincipal viewPrincipal;
    
    private Object controllers[];
    
    private ControllerProductos controllerProductos;
    
    public ControllerPrincipal(ModelPrincipal modelPrincipal, ViewPrincipal viewPrincipal, Object[] controllers){
        this.modelPrincipal = modelPrincipal;
        this.viewPrincipal = viewPrincipal;
        this.controllers = controllers;
        setControllers();
        setActionListener();
        initComponents();
    }
    private void setControllers(){
        controllerProductos = (ControllerProductos) controllers[0];
    }
    private void initComponents(){
        viewPrincipal.setTitle("SOUL TECH - FERRETERIAS ACME");
        viewPrincipal.setLocationRelativeTo(null);
        viewPrincipal.setVisible(true);
    }
    
    private void setActionListener(){
        viewPrincipal.JMI_Productos.addActionListener(actionListener);
    }
    
    private final ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewPrincipal.JMI_Productos){
                jmi_productos_actionPerformed();
            }
        }
    };
    
    private void jmi_productos_actionPerformed(){
        viewPrincipal.setContentPane(controllerProductos.viewProductos);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
}
