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
public class ControllerProductos_CRUD {
    public ModelProductos_CRUD modelProductos_CRUD;
    public ViewProductos_CRUD viewProductos_CRUD;
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    };

    public ControllerProductos_CRUD(ModelProductos_CRUD modelProductos_CRUD, ViewProductos_CRUD viewProductos_CRUD) {
        this.modelProductos_CRUD = modelProductos_CRUD;
        this.viewProductos_CRUD = viewProductos_CRUD;
    }
}
