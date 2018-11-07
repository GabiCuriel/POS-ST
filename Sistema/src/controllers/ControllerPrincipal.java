/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.*;
import views.*;
import models.*;
/**
 *
 * @author TeddyBear
 */
public class ControllerPrincipal {
    
    private final ModelPrincipal modelPrincipal;
    private final ViewPrincipal viewPrincipal;
    
    private Object controllers[];
    
    private ControllerClientes controllerClientes;
    private ControllerDirecciones controllerDirecciones;
    private ControllerEmpleados controllerEmpleados;
    private ControllerProductos controllerProductos;
    private ControllerProveedores controllerProveedores;
    private ControllerUsuarios controllerUsuarios;
    
    public ControllerPrincipal(ModelPrincipal modelPrincipal, ViewPrincipal viewPrincipal, Object[] controllers){
        this.modelPrincipal = modelPrincipal;
        this.viewPrincipal = viewPrincipal;
        this.controllers = controllers;
        setControllers();
        setActionListener();
        initComponents();
    }
    
    private void setControllers(){
        controllerClientes = (ControllerClientes) controllers[0];
        //controllerDirecciones = (ControllerDirecciones) controllers[1];
        controllerEmpleados = (ControllerEmpleados) controllers[1];
        controllerProductos = (ControllerProductos) controllers[2];
        controllerProveedores = (ControllerProveedores) controllers[3];
        controllerUsuarios = (ControllerUsuarios) controllers[4];
    }
    
    private void initComponents(){
        viewPrincipal.setTitle("SOUL TECH - FERRETERIAS ACME");
        viewPrincipal.setLocationRelativeTo(null);
        viewPrincipal.setVisible(true);
    }
    
    private void setActionListener(){
        viewPrincipal.JMI_Clientes.addActionListener(actionListener);
        viewPrincipal.JMI_Empleados.addActionListener(actionListener);
        viewPrincipal.JMI_Productos.addActionListener(actionListener);
        viewPrincipal.JMI_Proveedores.addActionListener(actionListener);
        viewPrincipal.JMI_Empleados.addActionListener(actionListener);
        viewPrincipal.JMI_Usuarios.addActionListener(actionListener);
        
    }
    
    private final ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewPrincipal.JMI_Clientes){
                System.out.println("Accion principal - clientes");
                jmi_clientes_actionPerformed();
            } else if (e.getSource() == viewPrincipal.JMI_Empleados){
                System.out.println("Accion principal - empleados");
                jmi_empleados_actionPerformed();
            } else if (e.getSource() == viewPrincipal.JMI_Productos){
                System.out.println("Accion principal - productos");
                jmi_productos_actionPerformed();
            } else if (e.getSource() == viewPrincipal.JMI_Proveedores){
                System.out.println("Accion principal - proveedores");
                jmi_proveedores_actionPerformed();
            } else if (e.getSource() == viewPrincipal.JMI_Usuarios){
                System.out.println("Accion principal - usuarios");
                jmi_usuarios_actionPerformed();
            }
        }
    };
    
    private void jmi_clientes_actionPerformed(){
        viewPrincipal.setContentPane(controllerClientes.viewClientes);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
    private void jmi_empleados_actionPerformed(){
        viewPrincipal.setContentPane(controllerEmpleados.viewEmpleados);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
    private void jmi_productos_actionPerformed(){
        viewPrincipal.setContentPane(controllerProductos.viewProductos);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
    private void jmi_proveedores_actionPerformed(){
        viewPrincipal.setContentPane(controllerProveedores.viewProveedores);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
    private void jmi_usuarios_actionPerformed(){
        viewPrincipal.setContentPane(controllerUsuarios.viewUsuarios);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
}


