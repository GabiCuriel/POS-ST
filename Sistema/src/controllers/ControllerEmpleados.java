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
            if(e.getSource() == viewEmpleados.JB_Buscar){
                buscar();
            }
        }
        
    };
    public ControllerEmpleados(ModelEmpleados modelEmpleados, ViewEmpleados viewEmpleados) {
        this.modelEmpleados = modelEmpleados;
        this.viewEmpleados = viewEmpleados;
        setActionListener();
        init();
    }
    
    private void setActionListener(){
        viewEmpleados.JB_Buscar.addActionListener(actionListener);
    }
    
    private void buscar(){
        modelEmpleados.buscar(viewEmpleados.JTF_Busqueda.getText());
        modelEmpleados.concatenarDireccionB(viewEmpleados.JTF_Busqueda.getText());
        modelEmpleados.obtenerDatosBancariosB(viewEmpleados.JTF_Busqueda.getText());
        viewEmpleados.JT_Empleados.setModel(modelEmpleados.getModelo());
    }
    
    private void init(){
        modelEmpleados.llenarTabla();
        modelEmpleados.concatenarDireccion();
        modelEmpleados.obtenerDatosBancarios();
        viewEmpleados.JT_Empleados.setModel(modelEmpleados.getModelo());
    }
    
    
}
