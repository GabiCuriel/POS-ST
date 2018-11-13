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
        modelClientes.buscarCliente(viewClientes.JTF_Busqueda.getText());
        modelClientes.concatenarDireccionBusqueda(viewClientes.JTF_Busqueda.getText());
        viewClientes.JT_Clientes.setModel(modelClientes.getmBuscar());
        
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
        modelClientes.concatenarDireccionSQL();
        viewClientes.JT_Clientes.setModel(modelClientes.getModelo());
    }
}
