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
public class ControllerClientes_CRUD {
    public ModelClientes_CRUD modelClientes_CRUD;
    public ViewClientes_CRUD viewClientes_CRUD;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    };

    public ControllerClientes_CRUD(ModelClientes_CRUD modelClientes_CRUD, ViewClientes_CRUD viewClientes_CRUD) {
        this.modelClientes_CRUD = modelClientes_CRUD;
        this.viewClientes_CRUD = viewClientes_CRUD;
    }
}
