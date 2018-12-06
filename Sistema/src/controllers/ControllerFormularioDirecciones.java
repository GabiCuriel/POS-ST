/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.*;
import views.*;
/**
 *
 * @author TeddyBear
 */
public class ControllerFormularioDirecciones {
    public ModelFormularioDirecciones modelFormularioDirecciones = new ModelFormularioDirecciones();
    public ViewFormularioDirecciones viewFormularioDirecciones = new ViewFormularioDirecciones();

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewFormularioDirecciones.JB_Add){
                botonAdd();
            }
        }
    };
    
    public ControllerFormularioDirecciones(ModelFormularioDirecciones modelFormularioDirecciones, ViewFormularioDirecciones viewFormularioDirecciones) {
        this.modelFormularioDirecciones = modelFormularioDirecciones;
        this.viewFormularioDirecciones = viewFormularioDirecciones;
        initElements();
        setActionListener();
        setValues();
    }
    
    private void initElements(){
        viewFormularioDirecciones.setDefaultCloseOperation(ViewFormularioDirecciones.DISPOSE_ON_CLOSE);
        //viewFormularioDirecciones.setUndecorated(true);
        viewFormularioDirecciones.setVisible(true);
        viewFormularioDirecciones.setLocationRelativeTo(null);
        //viewFormularioDirecciones.setDefaultCloseOperation(viewFormularioDirecciones.EXIT_ON_CLOSE);
    }
    
    private void setActionListener(){
        viewFormularioDirecciones.JB_Add.addActionListener(actionListener);
    }
    
    private void botonAdd(){
        System.out.println("Boton de añadir - Formulario de direcciones");
        modelFormularioDirecciones.setID_D(viewFormularioDirecciones.JTF_ID.getText());
        modelFormularioDirecciones.setCalle_D(viewFormularioDirecciones.JTF_Calle.getText());
        modelFormularioDirecciones.setNumero_D(viewFormularioDirecciones.JTF_Numero.getText());
        modelFormularioDirecciones.setCol_D(viewFormularioDirecciones.JTF_Colonia.getText());
        modelFormularioDirecciones.setCP_D(viewFormularioDirecciones.JTF_CP.getText());
        modelFormularioDirecciones.setCD_D(viewFormularioDirecciones.JTF_Ciudad.getText());
        modelFormularioDirecciones.setEdo_D(viewFormularioDirecciones.JTF_Estado.getText());
        viewFormularioDirecciones.dispose();
    }
    
    private void setValues(){
        modelFormularioDirecciones.setValues();
        viewFormularioDirecciones.JTF_Estado.setText(modelFormularioDirecciones.getEdo_D());
        viewFormularioDirecciones.JTF_Ciudad.setText(modelFormularioDirecciones.getCD_D());
        viewFormularioDirecciones.JTF_CP.setText(modelFormularioDirecciones.getCP_D());
        viewFormularioDirecciones.JTF_Colonia.setText(modelFormularioDirecciones.getCol_D());
        viewFormularioDirecciones.JTF_Numero.setText(modelFormularioDirecciones.getNumero_D());
        viewFormularioDirecciones.JTF_Calle.setText(modelFormularioDirecciones.getCalle_D());
        viewFormularioDirecciones.JTF_ID.setText(modelFormularioDirecciones.getID_D());
    }
}
