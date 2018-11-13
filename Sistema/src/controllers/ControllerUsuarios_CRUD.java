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
public class ControllerUsuarios_CRUD {
    public ModelUsuarios_CRUD modelUsuarios_CRUD;
    public ViewUsuarios_CRUD viewUsuarios_CRUD;
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    };

    public ControllerUsuarios_CRUD(ModelUsuarios_CRUD modelUsuarios_CRUD, ViewUsuarios_CRUD viewUsuarios_CRUD) {
        this.modelUsuarios_CRUD = modelUsuarios_CRUD;
        this.viewUsuarios_CRUD = viewUsuarios_CRUD;
    }
}
