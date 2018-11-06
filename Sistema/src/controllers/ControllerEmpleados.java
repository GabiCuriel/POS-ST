/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelEmpleados;
=======
import models.ModelEmpleados_CRUD;
>>>>>>> 40207481260a0c4b871cd4255c0081a19afe5059
import views.ViewEmpleados;

/**
 *
 * @author TeddyBear
 */
public class ControllerEmpleados {
    public ModelEmpleados_CRUD modelEmpleados;
    public ViewEmpleados viewEmpleados;
<<<<<<< HEAD
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
=======
    public ControllerEmpleados(ModelEmpleados_CRUD modelEmpleados, ViewEmpleados viewEmpleados) {
>>>>>>> 40207481260a0c4b871cd4255c0081a19afe5059
        
    }
    
}
