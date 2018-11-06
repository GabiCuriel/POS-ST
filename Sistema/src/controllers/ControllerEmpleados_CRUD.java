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
public class ControllerEmpleados_CRUD {
    public ModelEmpleados_CRUD modelEmpleados_CRUD;
    public ViewEmpleados_CRUD viewEmpleados_CRUD;
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    };

    public ControllerEmpleados_CRUD(ModelEmpleados_CRUD modelEmpleados_CRUD, ViewEmpleados_CRUD viewEmpleados_CRUD) {
        this.modelEmpleados_CRUD = modelEmpleados_CRUD;
        this.viewEmpleados_CRUD = viewEmpleados_CRUD;
    }

    
}
