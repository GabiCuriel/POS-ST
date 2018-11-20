/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import views.*;
import models.*;
/**
 *
 * @author TeddyBear
 */
public class ControllerClientes_CRUD {
    public ModelClientes_CRUD modelClientes_CRUD;
    public ViewClientes_CRUD viewClientes_CRUD;
    
    public ControllerClientes_CRUD(ModelClientes_CRUD modelClientes_CRUD, ViewClientes_CRUD viewClientes_CRUD) {
        this.modelClientes_CRUD = modelClientes_CRUD;
        this.viewClientes_CRUD = viewClientes_CRUD;
        setActionListener();
        init();
    }
    
    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == viewClientes_CRUD.JT_Clientes){
                System.out.println("mose clicked");                
                int x = viewClientes_CRUD.JT_Clientes.getSelectedRow();
                viewClientes_CRUD.JTF_ID.setText((String)viewClientes_CRUD.JT_Clientes.getValueAt(x, 0));
                viewClientes_CRUD.JTF_Nombre.setText((String)viewClientes_CRUD.JT_Clientes.getValueAt(x, 1));
                viewClientes_CRUD.JTF_AP.setText((String)viewClientes_CRUD.JT_Clientes.getValueAt(x, 2));
                viewClientes_CRUD.JTF_AM.setText((String)viewClientes_CRUD.JT_Clientes.getValueAt(x, 3));
                viewClientes_CRUD.JTF_Telefono.setText((String)viewClientes_CRUD.JT_Clientes.getValueAt(x, 4));
                viewClientes_CRUD.JTF_RFC.setText((String)viewClientes_CRUD.JT_Clientes.getValueAt(x, 5));
                viewClientes_CRUD.JTF_Payback.setText(""+(double) viewClientes_CRUD.JT_Clientes.getValueAt(x, 7));
                viewClientes_CRUD.JTF_Email.setText((String)viewClientes_CRUD.JT_Clientes.getValueAt(x, 6));
                viewClientes_CRUD.JTF_Direccion.setText((String)viewClientes_CRUD.JT_Clientes.getValueAt(x, 8));
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == viewClientes_CRUD.JB_Agregar){
                agregar();
            } else if (e.getSource() == viewClientes_CRUD.JB_Cancelar){
                cancelar();
            } else if (e.getSource() == viewClientes_CRUD.JB_Direccion){
                generarDireccion();
            } else if (e.getSource() == viewClientes_CRUD.JB_Eliminar){
                eliminar();
            } else if (e.getSource() == viewClientes_CRUD.JB_Modificar){
                modificar();
            } else if (e.getSource() == viewClientes_CRUD.JB_Nuevo){
                nuevo();
            } else if (e.getSource() == viewClientes_CRUD.JB_RFC){
                generarRFC();
            }
        }
    };
    
    public void agregar(){
        System.out.println("Accion boton agregar - Clientes CRUD");
        modelClientes_CRUD.setID_CL(viewClientes_CRUD.JTF_ID.getText());
        modelClientes_CRUD.setNombre_CL(viewClientes_CRUD.JTF_Nombre.getText());
        modelClientes_CRUD.setAP_CL(viewClientes_CRUD.JTF_AP.getText());
        modelClientes_CRUD.setAM_CL(viewClientes_CRUD.JTF_AM.getText());
        modelClientes_CRUD.setTelefono_CL(viewClientes_CRUD.JTF_Telefono.getText());
        modelClientes_CRUD.setRFC_CL(viewClientes_CRUD.JTF_RFC.getText());
        modelClientes_CRUD.setEmail_CL(viewClientes_CRUD.JTF_Email.getText());
        modelClientes_CRUD.setPayback_CL(viewClientes_CRUD.JTF_Payback.getText());
        modelClientes_CRUD.setID_D(viewClientes_CRUD.JTF_Direccion.getText());
        modelClientes_CRUD.insertarRegistro();
        init();
    }
    
    public void cancelar(){
        System.out.println("Accion boton cancelar - Clientes CRUD");
    }
    
    public void generarDireccion(){
        System.out.println("Accion boton generar dir - Clientes CRUD");
    }
    
    public void eliminar(){
        System.out.println("Accion boton eliminar - Clientes CRUD");
    }
    
    public void nuevo(){
        System.out.println("Accion boton nuevo - Clientes CRUD");
    }
    
    public void modificar(){
        System.out.println("Accion boton modificar - Clientes CRUD");
    }
    
    public void generarRFC(){
        System.out.println("Accion boton generar RFC - Clientes CRUD");
    }

    private void setActionListener() {
        viewClientes_CRUD.JB_Agregar.addActionListener(actionListener);
        viewClientes_CRUD.JB_Cancelar.addActionListener(actionListener);
        viewClientes_CRUD.JB_Direccion.addActionListener(actionListener);
        viewClientes_CRUD.JB_Eliminar.addActionListener(actionListener);
        viewClientes_CRUD.JB_Modificar.addActionListener(actionListener);
        viewClientes_CRUD.JB_Nuevo.addActionListener(actionListener);
        viewClientes_CRUD.JB_RFC.addActionListener(actionListener);
        viewClientes_CRUD.JT_Clientes.addMouseListener(mouseListener);
    }

    private void init() {
        modelClientes_CRUD.llenarTabla();
        modelClientes_CRUD.concatenarDireccionSQL();
        viewClientes_CRUD.JT_Clientes.setModel(modelClientes_CRUD.getModelo());
        
    }
}
