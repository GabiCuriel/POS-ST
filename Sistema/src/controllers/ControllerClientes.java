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
public class ControllerClientes {
    public ModelClientes modelClientes;
    public ViewClientes viewClientes;
    ActionListener actionListner = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent CL) {
     //       if (CL.getSource() == viewClientes.JB_Eliminar) {
       //         Delete_cliente();
         //   } else if (CL.getSource() == viewClientes.JB_Modificar){
           //     Modifica_cliente();
      //      } else if (CL.getSource() == viewClientes.JB_Agregar){
        //        Agregar_cliente();
          //  }
        }
    };
    
    public void Delete_cliente(){
        System.out.println("Delete - clientes");
    }
    
    public void Modifica_cliente(){
        System.out.println("Modifica - clientes");
    }
    
    public void Agregar_cliente(){
        System.out.println("Agregar - clientes");
        
    }
    
    public ControllerClientes(ModelClientes modelClientes, ViewClientes viewClientes ){
        this.modelClientes = modelClientes;
        this.viewClientes = viewClientes;
        setActionListener();
        initBD();
    }

    private void setActionListener() {
  //      viewClientes.JB_Agregar.addActionListener(actionListner);
    //    viewClientes.JB_Eliminar.addActionListener(actionListner);
      //  viewClientes.JB_Modificar.addActionListener(actionListner);
       // viewClientes.jButton4.addActionListener(actionListner);
                
    }

    private void initBD() {
        
    }
}
