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
public class ControllerClientes_CRUD {
    public ModelClientes_CRUD modelClientes_CRUD;
    public ViewClientes_CRUD viewClientes_CRUD;
    ModelFormularioDirecciones modelFormularioDirecciones = new ModelFormularioDirecciones();
    ViewFormularioDirecciones viewFormularioDirecciones = new ViewFormularioDirecciones();
    
    
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
                modelClientes_CRUD.setID_CL((String)viewClientes_CRUD.JT_Clientes.getValueAt(x, 0));
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
                viewClientes_CRUD.JL_IDD.setText(modelFormularioDirecciones.getID_D());
                modelFormularioDirecciones.insertarDireccion();
                agregar();
            } else if (e.getSource() == viewClientes_CRUD.JB_Cancelar){
                cancelar();
            } else if (e.getSource() == viewClientes_CRUD.JB_Direccion){
                generarDireccion();
            } else if (e.getSource() == viewClientes_CRUD.JB_Eliminar){
                eliminar();
                modelFormularioDirecciones.eliminarDireccion();
            } else if (e.getSource() == viewClientes_CRUD.JB_Modificar){
                modelFormularioDirecciones.modificarDireccion(modelFormularioDirecciones.getID_D());
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
        modelClientes_CRUD.setID_D(modelFormularioDirecciones.getID_D());
        modelClientes_CRUD.insertarRegistro();
        init();
        vaciarJTF();
    }
    
    public void cancelar(){
        System.out.println("Accion boton cancelar - Clientes CRUD");
        vaciarJTF();
    }
    
    public void generarDireccion(){
        System.out.println("Accion boton generar dir - Clientes CRUD");
        modelClientes_CRUD.obtenerIDD();
        modelFormularioDirecciones.setID_D(modelClientes_CRUD.getID_D());
        ControllerFormularioDirecciones controllerFormularioDirecciones = new ControllerFormularioDirecciones(modelFormularioDirecciones, viewFormularioDirecciones);
    }
    
    public void eliminar(){
        System.out.println("Accion boton eliminar - Clientes CRUD");
        modelClientes_CRUD.setID_CL(viewClientes_CRUD.JTF_ID.getText());
        modelClientes_CRUD.eliminarRegistro();
        init();
        vaciarJTF();
    }
    
    public void nuevo(){
        System.out.println("Accion boton nuevo - Clientes CRUD");
        vaciarJTF();
    }
    
    public void modificar(){
        System.out.println("Accion boton modificar - Clientes CRUD");
        modelClientes_CRUD.setID_CL(viewClientes_CRUD.JTF_ID.getText());
        modelClientes_CRUD.setNombre_CL(viewClientes_CRUD.JTF_Nombre.getText());
        modelClientes_CRUD.setAP_CL(viewClientes_CRUD.JTF_AP.getText());
        modelClientes_CRUD.setAM_CL(viewClientes_CRUD.JTF_AM.getText());
        modelClientes_CRUD.setTelefono_CL(viewClientes_CRUD.JTF_Telefono.getText());
        modelClientes_CRUD.setRFC_CL(viewClientes_CRUD.JTF_RFC.getText());
        modelClientes_CRUD.setEmail_CL(viewClientes_CRUD.JTF_Email.getText());
        modelClientes_CRUD.setPayback_CL(viewClientes_CRUD.JTF_Payback.getText());
        modelClientes_CRUD.setID_D(viewClientes_CRUD.JTF_Direccion.getText());
        modelClientes_CRUD.modificarRegistro();
        init();
        vaciarJTF();
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
    
    private void vaciarJTF(){
        viewClientes_CRUD.JTF_AM.setText(null);
        viewClientes_CRUD.JTF_AP.setText(null);
        viewClientes_CRUD.JTF_Nombre.setText(null);
        viewClientes_CRUD.JTF_ID.setText(null);
        viewClientes_CRUD.JTF_Telefono.setText(null);
        viewClientes_CRUD.JTF_RFC.setText(null);
        viewClientes_CRUD.JTF_Payback.setText(null);
        viewClientes_CRUD.JTF_Direccion.setText(null);
        viewClientes_CRUD.JTF_Email.setText(null);
    }
}
