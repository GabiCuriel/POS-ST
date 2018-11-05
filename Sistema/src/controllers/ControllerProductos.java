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
import views.ViewProductos;

public class ControllerProductos {
    public ModelProductos modelProductos;
    public ViewProductos viewProductos;
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent P) {
       //     if (P.getSource() == viewProductos.JB_Eliminar) {
         //       Delete_producto();
        //    } else if (P.getSource() == viewProductos.JB_Modificar){
          //      Modifica_Producto();
          //  } else if (P.getSource() == viewProductos.JB_Agregar){
            //    Agregar_Producto();
          //  }
        }

        private void Delete_producto() {
            System.out.println("Delete - productos");
        }

        private void Modifica_Producto() {
           System.out.println("Modifica - productos");
        }

        private void Agregar_Producto() {
            System.out.println("Agrega - productos");
        }

    };

    public ControllerProductos(ModelProductos modelProductos, ViewProductos viewProductos) {
        this.modelProductos = modelProductos;
        this.viewProductos = viewProductos;
        setActionListener();
        initBD();
    }

    private void initBD() {
        
    }
    private void setActionListener() {
//        viewProductos.JB_Agregar.addActionListener(actionListener);
  //      viewProductos.JB_Modificar.addActionListener(actionListener);
    //    viewProductos.JB_Eliminar.addActionListener(actionListener);
    }
}
