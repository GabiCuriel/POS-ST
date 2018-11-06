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
        
        
        Object[] controllers = new Object[10];
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
