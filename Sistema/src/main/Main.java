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
        
        ModelClientes_CRUD modelClientes_CRUD = new ModelClientes_CRUD();
        ViewClientes_CRUD viewClientes_CRUD = new ViewClientes_CRUD();
        ControllerClientes_CRUD controllerClientes_CRUD = new ControllerClientes_CRUD(modelClientes_CRUD, viewClientes_CRUD);
        
        ModelEmpleados modelEmpleados = new ModelEmpleados();
        ViewEmpleados viewEmpleados = new ViewEmpleados();
        ControllerEmpleados controllerEmpleados = new ControllerEmpleados(modelEmpleados, viewEmpleados);
        
        ModelEmpleados_CRUD modelEmpleados_CRUD = new ModelEmpleados_CRUD();
        ViewEmpleados_CRUD viewEmpleados_CRUD = new ViewEmpleados_CRUD();
        ControllerEmpleados_CRUD controllerEmpleados_CRUD = new ControllerEmpleados_CRUD(modelEmpleados_CRUD, viewEmpleados_CRUD);
        
        ModelProductos modelProductos = new ModelProductos();
        ViewProductos viewProductos = new ViewProductos();
        ControllerProductos controllerProductos = new ControllerProductos(modelProductos, viewProductos);
        
        ModelProductos_CRUD modelProductos_CRUD = new ModelProductos_CRUD();
        ViewProductos_CRUD viewProductos_CRUD = new ViewProductos_CRUD();
        ControllerProductos_CRUD controllerProductos_CRUD = new ControllerProductos_CRUD(modelProductos_CRUD, viewProductos_CRUD);
        
        ModelProveedores modelProveedores = new ModelProveedores();
        ViewProveedores viewProveedores = new ViewProveedores();
        ControllerProveedores controllerProveedores = new ControllerProveedores(modelProveedores, viewProveedores);
        
        ModelProveedores_CRUD modelProveedores_CRUD = new ModelProveedores_CRUD();
        ViewProveedores_CRUD viewProveedores_CRUD = new ViewProveedores_CRUD();
        ControllerProveedores_CRUD controllerProveedores_CRUD = new ControllerProveedores_CRUD(modelProveedores_CRUD, viewProveedores_CRUD);
        
        //ModelSucursales modelSucursales = new ModelSucursales();
        //ViewSucursales viewSucursales = new ViewSucursales();
        //ControllerSucursales controllerSucursales = new ControllerSucursales(modelSucursales, viewSucursales);
        
        //ModelSucursales_CRUD modelSucursales_CRUD = new ModelSucursales_CRUD();
        //ViewSucursales_CRUD viewSucursales_CRUD = new ViewSucursales_CRUD();
        //ControllerSucursales_CRUD controllerSucursales_CRUD = new ControllerSucursales_CRUD(modelSucursales_CRUD, viewSucursales_CRUD);
        
        ModelUsuarios modelUsuarios = new ModelUsuarios();
        ViewUsuarios viewUsuarios = new ViewUsuarios();
        ControllerUsuarios controllerUsuarios = new ControllerUsuarios(modelUsuarios, viewUsuarios);
                
        ModelUsuarios_CRUD modelUsuarios_CRUD = new ModelUsuarios_CRUD();
        ViewUsuarios_CRUD viewUsuarios_CRUD = new ViewUsuarios_CRUD();
        ControllerUsuarios_CRUD controllerUsuarios_CRUD = new ControllerUsuarios_CRUD(modelUsuarios_CRUD, viewUsuarios_CRUD);
        
        Object[] controllers = new Object[10];
        controllers[0] = controllerClientes;
        controllers[1] = controllerClientes_CRUD;
        controllers[2] = controllerEmpleados;
        controllers[3] = controllerEmpleados_CRUD;
        controllers[4] = controllerProductos;
        controllers[5] = controllerProductos_CRUD;
        controllers[6] = controllerProveedores;
        controllers[7] = controllerProveedores_CRUD;
        controllers[8] = controllerUsuarios;
        controllers[9] = controllerUsuarios_CRUD;
        
        
        ModelPrincipal modelPrincipal = new ModelPrincipal();
        ViewPrincipal viewPrincipal = new ViewPrincipal();
        ControllerPrincipal controllerPrincipal = new ControllerPrincipal(modelPrincipal, viewPrincipal, controllers);
    }
    
}
