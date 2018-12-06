/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Juan Pablo
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelProductos;
import views.ViewProductos;

public class ControllerProductos {
    public ModelProductos modelProductos;
    public ViewProductos viewProductos;
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent P) {
            if (P.getSource() == viewProductos.JB_Buscar) {
                buscar();
            }
        }    
    };

    public ControllerProductos(ModelProductos modelProductos, ViewProductos viewProductos) {
        this.modelProductos = modelProductos;
        this.viewProductos = viewProductos;
        setActionListener();
        initBD();
    }

    private void initBD() {
        modelProductos.llenarTabla();
        modelProductos.obtenerExistencias();
        viewProductos.JT_Inventario.setModel(modelProductos.getModel());
    }
    private void setActionListener() {
        
    }
    
    private void buscar(){
        
    }
}
