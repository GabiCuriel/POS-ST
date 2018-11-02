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
        ModelProductos modelProductos = new ModelProductos();
        ViewProductos viewProductos = new ViewProductos();
        ControllerProductos controllerProductos = new ControllerProductos(modelProductos, viewProductos);
        
        Object[] controllers = new Object[2];
        controllers[0] = controllerProductos;
        
        ModelPrincipal modelPrincipal = new ModelPrincipal();
        ViewPrincipal viewPrincipal = new ViewPrincipal();
        ControllerPrincipal controllerPrincipal = new ControllerPrincipal(modelPrincipal, viewPrincipal, controllers);
    }
    
}
