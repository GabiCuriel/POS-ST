/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.*;
import models.*;
/**
 *
 * @author TeddyBear
 */
public class ControllerEmpleados_CRUD {
    public ModelEmpleados_CRUD modelEmpleados_CRUD;
    public ViewEmpleados_CRUD viewEmpleados_CRUD;
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == viewEmpleados_CRUD.JB_Agregar){
                agregar();
            } else if (e.getSource() == viewEmpleados_CRUD.JB_Modificar){
                modificar();
            } else if (e.getSource() == viewEmpleados_CRUD.JB_Eliminar){
                eliminar();
            } else if (e.getSource() == viewEmpleados_CRUD.JB_Nuevo){
                nuevo();
            } else if (e.getSource() == viewEmpleados_CRUD.JB_Cancelar){
                cancelar();
            }
        }
    };
    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() == viewEmpleados_CRUD.JT_Empleados){
                llenarJTF();
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

    public ControllerEmpleados_CRUD(ModelEmpleados_CRUD modelEmpleados_CRUD, ViewEmpleados_CRUD viewEmpleados_CRUD) {
        this.modelEmpleados_CRUD = modelEmpleados_CRUD;
        this.viewEmpleados_CRUD = viewEmpleados_CRUD;
        setActionListener();
        initElements();
    }

    private void setActionListener() {
        viewEmpleados_CRUD.JB_Agregar.addActionListener(actionListener);
        viewEmpleados_CRUD.JB_Cancelar.addActionListener(actionListener);
        viewEmpleados_CRUD.JB_Eliminar.addActionListener(actionListener);
        viewEmpleados_CRUD.JB_Modificar.addActionListener(actionListener);
        viewEmpleados_CRUD.JB_Nuevo.addActionListener(actionListener);
        viewEmpleados_CRUD.JT_Empleados.addMouseListener(mouseListener);
    }

    private void initElements() {
        modelEmpleados_CRUD.llenarTabla();
        modelEmpleados_CRUD.concatenarDireccion();
        modelEmpleados_CRUD.obtenerDatosBancarios();
        viewEmpleados_CRUD.JT_Empleados.setModel(modelEmpleados_CRUD.getModelo());
    }
    
    private void agregar(){
        modelEmpleados_CRUD.setID_E(viewEmpleados_CRUD.JTF_ID.getText());
        modelEmpleados_CRUD.setNombre_E(viewEmpleados_CRUD.JTF_Nombre.getText());
        modelEmpleados_CRUD.setAP_E(viewEmpleados_CRUD.JTF_AP.getText());
        modelEmpleados_CRUD.setAM_E(viewEmpleados_CRUD.JTF_AM.getText());
        modelEmpleados_CRUD.setRFC_E(viewEmpleados_CRUD.JTF_RFC.getText());
        modelEmpleados_CRUD.setCURP_E(viewEmpleados_CRUD.JTF_CURP.getText());
        modelEmpleados_CRUD.setID_F(viewEmpleados_CRUD.JTF_Ferreteria.getText());
        modelEmpleados_CRUD.setID_D(viewEmpleados_CRUD.JTF_Direccion.getText());
        modelEmpleados_CRUD.setID_B(viewEmpleados_CRUD.JTF_Banco.getText());
        modelEmpleados_CRUD.setTelefono_E(viewEmpleados_CRUD.JTF_Telefono.getText());
        modelEmpleados_CRUD.setNSS_E(viewEmpleados_CRUD.JTF_NSS.getText());
        modelEmpleados_CRUD.insertarRegistro();
        initElements();
        nuevo();
    }
    
    private void eliminar(){
        modelEmpleados_CRUD.setID_E(viewEmpleados_CRUD.JTF_ID.getText());
        modelEmpleados_CRUD.eliminarRegistro();
        initElements();
        nuevo();
    }
    
    private void nuevo(){
        viewEmpleados_CRUD.JTF_ID.setText(null);
        viewEmpleados_CRUD.JTF_Nombre.setText(null);
        viewEmpleados_CRUD.JTF_AP.setText(null);
        viewEmpleados_CRUD.JTF_AM.setText(null);
        viewEmpleados_CRUD.JTF_Telefono.setText(null);
        viewEmpleados_CRUD.JTF_RFC.setText(null);
        viewEmpleados_CRUD.JTF_CURP.setText(null);
        viewEmpleados_CRUD.JTF_Direccion.setText(null);
        viewEmpleados_CRUD.JTF_Banco.setText(null);
        viewEmpleados_CRUD.JTF_Ferreteria.setText(null);
        viewEmpleados_CRUD.JTF_NSS.setText(null);
    }
    
    private void modificar(){
        modelEmpleados_CRUD.setID_E(viewEmpleados_CRUD.JTF_ID.getText());
        System.out.println("$$$$$$$$$$");
        System.out.println(modelEmpleados_CRUD.getID_E());
        modelEmpleados_CRUD.setNombre_E(viewEmpleados_CRUD.JTF_Nombre.getText());
        modelEmpleados_CRUD.setAP_E(viewEmpleados_CRUD.JTF_AP.getText());
        modelEmpleados_CRUD.setAM_E(viewEmpleados_CRUD.JTF_AM.getText());
        modelEmpleados_CRUD.setRFC_E(viewEmpleados_CRUD.JTF_RFC.getText());
        modelEmpleados_CRUD.setCURP_E(viewEmpleados_CRUD.JTF_CURP.getText());
        //modelEmpleados_CRUD.setID_F(viewEmpleados_CRUD.JTF_Ferreteria.getText());
        //modelEmpleados_CRUD.setID_D(viewEmpleados_CRUD.JTF_Direccion.getText());
        //modelEmpleados_CRUD.setID_B(viewEmpleados_CRUD.JTF_Banco.getText());
        modelEmpleados_CRUD.setNSS_E(viewEmpleados_CRUD.JTF_Banco.getText());
        modelEmpleados_CRUD.setTelefono_E(viewEmpleados_CRUD.JTF_Telefono.getText());
        modelEmpleados_CRUD.modificarRegistro();
        initElements();
        nuevo();
    }
    
    private void llenarJTF(){
        int x = viewEmpleados_CRUD.JT_Empleados.getSelectedRow();
        viewEmpleados_CRUD.JTF_ID.setText((String)viewEmpleados_CRUD.JT_Empleados.getValueAt(x, 0));
        viewEmpleados_CRUD.JTF_Nombre.setText((String)viewEmpleados_CRUD.JT_Empleados.getValueAt(x, 1));
        viewEmpleados_CRUD.JTF_AP.setText((String)viewEmpleados_CRUD.JT_Empleados.getValueAt(x, 2));
        viewEmpleados_CRUD.JTF_AM.setText((String)viewEmpleados_CRUD.JT_Empleados.getValueAt(x, 3));
        viewEmpleados_CRUD.JTF_Telefono.setText((String)viewEmpleados_CRUD.JT_Empleados.getValueAt(x, 4));
        viewEmpleados_CRUD.JTF_RFC.setText((String)viewEmpleados_CRUD.JT_Empleados.getValueAt(x, 5));
        viewEmpleados_CRUD.JTF_CURP.setText((String)viewEmpleados_CRUD.JT_Empleados.getValueAt(x, 6));
        viewEmpleados_CRUD.JTF_Direccion.setText((String)viewEmpleados_CRUD.JT_Empleados.getValueAt(x, 7));
        viewEmpleados_CRUD.JTF_Banco.setText((String)viewEmpleados_CRUD.JT_Empleados.getValueAt(x, 8));
        viewEmpleados_CRUD.JTF_Ferreteria.setText((String)viewEmpleados_CRUD.JT_Empleados.getValueAt(x, 9));        
        viewEmpleados_CRUD.JTF_NSS.setText((String)viewEmpleados_CRUD.JT_Empleados.getValueAt(x, 10));
    }
    
    private void cancelar(){
        nuevo();
    }
}
        