/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*;
import views.*;

/**
 *
 * @author TeddyBear
 */
public class ControllerEmpleados {
    public ModelEmpleados modelEmpleados;
    public ViewEmpleados viewEmpleados;

    ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    };
    public ControllerEmpleados(ModelEmpleados modelEmpleados, ViewEmpleados viewEmpleados) {
        this.modelEmpleados = modelEmpleados;
        this.viewEmpleados = viewEmpleados;
        setActionListener();
        initBD();
    }
    
    private void setActionListener(){
        
    }
    private void initBD(){
    }
    
    
}
