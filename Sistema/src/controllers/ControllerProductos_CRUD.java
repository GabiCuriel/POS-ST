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
import models.*;
import views.*;
/**
 *
 * @author TeddyBear
 */
public class ControllerProductos_CRUD {
    public ModelProductos_CRUD modelProductos_CRUD;
    public ViewProductos_CRUD viewProductos_CRUD;
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==viewProductos_CRUD.JB_Agregar){
                agregar();
            }else if(e.getSource()==viewProductos_CRUD.JB_Modificar){
                modificar();
            }else if(e.getSource()==viewProductos_CRUD.JB_Eliminar){
                eliminar();
            }else if(e.getSource()==viewProductos_CRUD.JB_Nuevo){
                nuevo();
            }else if(e.getSource()==viewProductos_CRUD.JB_Cancelar){
                cancelar();
            }
        }
    };
    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            llenarJTF();
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

    public ControllerProductos_CRUD(ModelProductos_CRUD modelProductos_CRUD, ViewProductos_CRUD viewProductos_CRUD) {
        this.modelProductos_CRUD = modelProductos_CRUD;
        this.viewProductos_CRUD = viewProductos_CRUD;
        setActionListener();
        initElements();
    }
    
    private void setActionListener(){
        viewProductos_CRUD.JB_Agregar.addActionListener(actionListener);
        viewProductos_CRUD.JB_Modificar.addActionListener(actionListener);
        viewProductos_CRUD.JB_Nuevo.addActionListener(actionListener);
        viewProductos_CRUD.JB_Cancelar.addActionListener(actionListener);
        viewProductos_CRUD.JB_Eliminar.addActionListener(actionListener);
        viewProductos_CRUD.JT_Inventario.addMouseListener(mouseListener);
    }
    
    private void initElements(){
        modelProductos_CRUD.llenarTabla();
        modelProductos_CRUD.obtenerExistencias();
        viewProductos_CRUD.JT_Inventario.setModel(modelProductos_CRUD.getModel());
    }
    
    private void nuevo(){
        viewProductos_CRUD.JTF_ID.setText(null);
        viewProductos_CRUD.JTF_Nombre.setText(null);
        viewProductos_CRUD.JCB_Tipo.setSelectedIndex(0);
        viewProductos_CRUD.JTF_Marca.setText(null);
        viewProductos_CRUD.JTF_SKU.setText(null);
        viewProductos_CRUD.JTF_Precio.setText(null);
    }
    
    private void cancelar(){
        
    }
    
    private void modificar(){
        modelProductos_CRUD.setID_P(viewProductos_CRUD.JTF_ID.getText());
        modelProductos_CRUD.setNombre_P(viewProductos_CRUD.JTF_Nombre.getText());
        modelProductos_CRUD.setTipo_P((String) viewProductos_CRUD.JCB_Tipo.getSelectedItem());
        modelProductos_CRUD.setMarca_P(viewProductos_CRUD.JTF_Marca.getText());
        modelProductos_CRUD.setPrecio_P(viewProductos_CRUD.JTF_Precio.getText());
        modelProductos_CRUD.setSKU_P(viewProductos_CRUD.JTF_SKU.getText());
        modelProductos_CRUD.modificar();
        initElements();
        nuevo();
    }
    
    private void agregar(){
        modelProductos_CRUD.setID_P(viewProductos_CRUD.JTF_ID.getText());
        modelProductos_CRUD.setNombre_P(viewProductos_CRUD.JTF_Nombre.getText());
        modelProductos_CRUD.setTipo_P((String) viewProductos_CRUD.JCB_Tipo.getSelectedItem());
        modelProductos_CRUD.setMarca_P(viewProductos_CRUD.JTF_Marca.getText());
        modelProductos_CRUD.setPrecio_P(viewProductos_CRUD.JTF_Precio.getText());
        modelProductos_CRUD.setSKU_P(viewProductos_CRUD.JTF_SKU.getText());
        modelProductos_CRUD.insertar();
        initElements();
        nuevo();
    }
    
    private void eliminar(){
        modelProductos_CRUD.setID_P(viewProductos_CRUD.JTF_ID.getText());
        modelProductos_CRUD.eliminar();
        initElements();
        nuevo();
    }
    
    private void llenarJTF(){
        int x = viewProductos_CRUD.JT_Inventario.getSelectedRow();
        viewProductos_CRUD.JTF_ID.setText((String) viewProductos_CRUD.JT_Inventario.getValueAt(x, 0));
        viewProductos_CRUD.JTF_Nombre.setText((String) viewProductos_CRUD.JT_Inventario.getValueAt(x, 1));
        viewProductos_CRUD.JCB_Tipo.setSelectedItem((String)viewProductos_CRUD.JT_Inventario.getValueAt(x, 2));
        viewProductos_CRUD.JTF_Marca.setText((String) viewProductos_CRUD.JT_Inventario.getValueAt(x, 3));
        viewProductos_CRUD.JTF_SKU.setText((String) viewProductos_CRUD.JT_Inventario.getValueAt(x, 4));
        viewProductos_CRUD.JTF_Precio.setText(""+(double) viewProductos_CRUD.JT_Inventario.getValueAt(x, 5));
        
    }
    
}
