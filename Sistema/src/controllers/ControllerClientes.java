/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
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
            if (CL.getSource() == viewClientes.JB_Buscar) {
                Buscar_cliente();
            }
        }
    };
    
    public void Buscar_cliente(){
        System.out.println("buscar - clientes");
        DefaultTableModel modelo = new DefaultTableModel();
        viewClientes.JT_Clientes.setModel(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido P");
        modelo.addColumn("Apellido M");
        modelo.addColumn("telefono");
        modelo.addColumn("RFC");
        modelo.addColumn("Payback");
        modelo.addColumn("Email");
        modelo.addColumn("Dirección");
        modelo.addRow(modelClientes.getTabla());
        
    }
    
    public ControllerClientes(ModelClientes modelClientes, ViewClientes viewClientes ){
        this.modelClientes = modelClientes;
        this.viewClientes = viewClientes;
        setActionListener();
        initBD();
    }

    private void setActionListener() {
        viewClientes.JB_Buscar.addActionListener(actionListner);
    }

    private void initBD() {
        modelClientes.llenarTabla();
        viewClientes.JT_Clientes.setModel(modelClientes.getModelo());
    }
}
