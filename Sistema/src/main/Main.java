/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import models.*;
import views.*;
import controllers.*;
/**
 *
 * @author Salvador Hernández Mendoza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ModelClientes modelClientes = new ModelClientes();
        ViewClientes viewClientes = new ViewClientes();
        ControllerClientes controllerClientes = new ControllerClientes(modelClientes, viewClientes);
        
        ModelDirecciones modelDirecciones = new ModelDirecciones();
        ViewDirecciones viewDirecciones = new ViewDirecciones();
        ControllerDirecciones controllerDirecciones = new ControllerDirecciones(modelDirecciones, viewDirecciones);
        
        ModelEmpleados_CRUD modelEmpleados = new ModelEmpleados_CRUD();
        ViewEmpleados viewEmpleados = new ViewEmpleados();
        ControllerEmpleados controllerEmpleados = new ControllerEmpleados(modelEmpleados, viewEmpleados);
        
        ModelProductos modelProductos = new ModelProductos();
        ViewProductos viewProductos = new ViewProductos();
        ControllerProductos controllerProductos = new ControllerProductos(modelProductos, viewProductos);
        
        ModelProveedores modelProveedores = new ModelProveedores();
        ViewProveedores viewProveedores = new ViewProveedores();
        ControllerProveedores controllerProveedores = new ControllerProveedores(modelProveedores, viewProveedores);
        
        ModelUsuarios_CRUD modelUsuarios = new ModelUsuarios_CRUD();
        ViewUsuarios viewUsuarios = new ViewUsuarios();
        ControllerUsuarios controllerUsuarios = new ControllerUsuarios(modelUsuarios, viewUsuarios);
        
        Object[] controllers = new Object[5];
        controllers[0] = controllerClientes;
        controllers[1] = controllerEmpleados;
        controllers[2] = controllerProductos;
        controllers[3] = controllerProveedores;
        controllers[4] = controllerUsuarios;
        
        ModelPrincipal modelPrincipal = new ModelPrincipal();
        ViewPrincipal viewPrincipal = new ViewPrincipal();
        ControllerPrincipal controllerPrincipal = new ControllerPrincipal(modelPrincipal, viewPrincipal, controllers);
    }
    
}
