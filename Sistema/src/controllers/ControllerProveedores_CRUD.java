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
public class ControllerProveedores_CRUD {
    public ModelProveedores_CRUD modelProveedores_CRUD;
    public ViewProveedores_CRUD viewProveedores_CRUD;
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    };

    public ControllerProveedores_CRUD(ModelProveedores_CRUD modelProveedores_CRUD, ViewProveedores_CRUD viewProveedores_CRUD) {
        this.modelProveedores_CRUD = modelProveedores_CRUD;
        this.viewProveedores_CRUD = viewProveedores_CRUD;
    }
}
