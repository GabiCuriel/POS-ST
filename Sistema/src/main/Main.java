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
        ModelLogueo modelLogueo = new ModelLogueo();
        ViewLogueo viewLogueo = new ViewLogueo();
        ControllerLogueo controllerLogueo = new ControllerLogueo(modelLogueo, viewLogueo);
        System.out.println(modelLogueo.isValue());
        while (true){
            if (modelLogueo.isValue() == true){
                System.out.println(modelLogueo.isValue());
                Constructores constructores = new Constructores();
                constructores.Constructores();
                viewLogueo.dispose();
                break;
            }
        }
    }
}
