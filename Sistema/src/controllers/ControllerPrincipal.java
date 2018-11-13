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
    
    private ControllerClientes_CRUD controllerClientes_CRUD;
    //private ControllerDirecciones_CRUD controllerDirecciones_CRUD;
    private ControllerEmpleados_CRUD controllerEmpleados_CRUD;
    private ControllerProductos_CRUD controllerProductos_CRUD;
    private ControllerProveedores_CRUD controllerProveedores_CRUD;
    private ControllerUsuarios_CRUD controllerUsuarios_CRUD;
    
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
        controllerClientes_CRUD = (ControllerClientes_CRUD) controllers[1];
        //controllerDirecciones = (ControllerDirecciones) controllers[1];
        controllerEmpleados = (ControllerEmpleados) controllers[2];
        controllerEmpleados_CRUD = (ControllerEmpleados_CRUD) controllers[3];
        controllerProductos = (ControllerProductos) controllers[4];
        controllerProductos_CRUD = (ControllerProductos_CRUD) controllers[5];
        controllerProveedores = (ControllerProveedores) controllers[6];
        controllerProveedores_CRUD = (ControllerProveedores_CRUD) controllers[7];
        controllerUsuarios = (ControllerUsuarios) controllers[8];
        controllerUsuarios_CRUD = (ControllerUsuarios_CRUD) controllers[9];
    }
    
    private void initComponents(){
        viewPrincipal.setTitle("SOUL TECH - FERRETERIAS ACME");
        viewPrincipal.setLocationRelativeTo(null);
        viewPrincipal.setVisible(true);
    }
    
    private void setActionListener(){
        viewPrincipal.JMI_VerClientes.addActionListener(actionListener);
        viewPrincipal.JMI_EditarClientes.addActionListener(actionListener);
        viewPrincipal.JMI_VerEmpleados.addActionListener(actionListener);
        viewPrincipal.JMI_EditarEmpleados.addActionListener(actionListener);
        viewPrincipal.JMI_VerProductos.addActionListener(actionListener);
        viewPrincipal.JMI_EditarProductos.addActionListener(actionListener);
        viewPrincipal.JMI_VerProveedores.addActionListener(actionListener);
        viewPrincipal.JMI_EditarProveedores.addActionListener(actionListener);
        viewPrincipal.JMI_VerEmpleados.addActionListener(actionListener);
        viewPrincipal.JMI_EditarEmpleados.addActionListener(actionListener);
        viewPrincipal.JMI_VerUsuarios.addActionListener(actionListener);
        viewPrincipal.JMI_EditarUsuarios.addActionListener(actionListener);
        
    }
    
    private final ActionListener actionListener = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewPrincipal.JMI_VerClientes){
                System.out.println("Accion principal - Ver clientes");
                jmi_verClientes_actionPerformed();
            } else if (e.getSource() == viewPrincipal.JMI_VerEmpleados){
                System.out.println("Accion principal - Ver empleados");
                jmi_verEmpleados_actionPerformed();
            } else if (e.getSource() == viewPrincipal.JMI_VerProductos){
                System.out.println("Accion principal - productos");
                jmi_verProductos_actionPerformed();
            } else if (e.getSource() == viewPrincipal.JMI_VerProveedores){
                System.out.println("Accion principal - Ver proveedores");
                jmi_verProveedores_actionPerformed();
            } else if (e.getSource() == viewPrincipal.JMI_VerUsuarios){
                System.out.println("Accion principal - Ver usuarios");
                jmi_verUsuarios_actionPerformed();
            } else if (e.getSource() == viewPrincipal.JMI_EditarClientes){
                System.out.println("Accion principal - Editar clientes");
                jmi_editarClientes_actionPerformed();
            } else if (e.getSource() == viewPrincipal.JMI_EditarEmpleados){
                System.out.println("Accion principal - Editar empleados");
                jmi_editarEmpleados_actionPerformed();
            } else if (e.getSource() == viewPrincipal.JMI_EditarProductos){
                System.out.println("Accion principal - Editar productos");
                jmi_editarProductos_actionPerformed();
            } else if (e.getSource() == viewPrincipal.JMI_EditarProveedores){
                System.out.println("Accion principal - Editar proveedores");
                jmi_editarProveedores_actionPerformed();
            } else if (e.getSource() == viewPrincipal.JMI_EditarUsuarios){
                System.out.println("Accion principal - Editar usuarios");
                jmi_editarUsuarios_actionPerformed();
            }
        }
    };
    
    private void jmi_verClientes_actionPerformed(){
        viewPrincipal.setContentPane(controllerClientes.viewClientes);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
    private void jmi_editarClientes_actionPerformed(){
        viewPrincipal.setContentPane(controllerClientes_CRUD.viewClientes_CRUD);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
    private void jmi_verEmpleados_actionPerformed(){
        viewPrincipal.setContentPane(controllerEmpleados.viewEmpleados);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
    private void jmi_editarEmpleados_actionPerformed(){
        viewPrincipal.setContentPane(controllerEmpleados_CRUD.viewEmpleados_CRUD);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
    private void jmi_verProductos_actionPerformed(){
        viewPrincipal.setContentPane(controllerProductos.viewProductos);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
    private void jmi_editarProductos_actionPerformed(){
        viewPrincipal.setContentPane(controllerProductos_CRUD.viewProductos_CRUD);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
    private void jmi_verProveedores_actionPerformed(){
        viewPrincipal.setContentPane(controllerProveedores.viewProveedores);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
    private void jmi_editarProveedores_actionPerformed(){
        viewPrincipal.setContentPane(controllerProveedores_CRUD.viewProveedores_CRUD);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
    private void jmi_verUsuarios_actionPerformed(){
        viewPrincipal.setContentPane(controllerUsuarios.viewUsuarios);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
    
    private void jmi_editarUsuarios_actionPerformed(){
        viewPrincipal.setContentPane(controllerUsuarios_CRUD.viewUsuarios_CRUD);
        viewPrincipal.revalidate();
        viewPrincipal.repaint();
    }
}


