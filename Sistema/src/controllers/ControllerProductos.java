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
import javax.swing.JOptionPane;
import models.ModelProductos;
import views.Productos;

public class ControllerProductos {
    public ModelProductos modelsProductos;
    public Productos viewsProductos;
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent P) {
            if (P.getSource() == viewsProductos.jb_Eliminar) {
                Delete_producto();
            } else if (P.getSource() == viewsProductos.jb_Modificar){
                Modifica_Producto();
            }
        }

        private void Delete_producto() {
            
        }

        private void Modifica_Producto() {
           
        }

    };

    public ControllerProductos(ModelProductos modelsProductos, Productos viewsProductos) {
        this.modelsProductos = modelsProductos;
        this.viewsProductos = viewsProductos;
        initBD();
    }

    private void initBD() {
        
    }
    private void setActionListener() {
        viewsProductos.jb_Agregar.addActionListener(actionListener);
        viewsProductos.jb_Modificar.addActionListener(actionListener);
        viewsProductos.jb_Eliminar.addActionListener(actionListener);
    }
}
