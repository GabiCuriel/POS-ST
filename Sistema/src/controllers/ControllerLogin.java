/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.ViewLogin;
import models.ModelLogin;
/**
 *
 * @author Juan Pablo
 */
public class ControllerLogin {
    public ModelLogin modellogin;
    public ViewLogin viewlogin;
 ActionListener actionListner = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent CL) {
            if (CL.getSource() == viewlogin.JB_Login) {
                Verificar();
            }
            else if (CL.getSource() == viewlogin.JB_Info){
                Información();
            }
        }
    };

    public ControllerLogin(ModelLogin modellogin, ViewLogin viewlogin) {
        this.modellogin = modellogin;
        this.viewlogin = viewlogin;
        setActionListener();
    }

    private void setActionListener() {
        viewlogin.JB_Login.addActionListener(actionListner);
    }
    public void Verificar(){
        modellogin.setUsuario(viewlogin.JTF_User.getText());
        modellogin.setContraseña(viewlogin.JPF_Password.getText());
        modellogin.Login();
    }
    public void Información(){
        JOptionPane.showMessageDialog(null, "Ingresa tu nombre de usuario y contraseña otorgadas por tu gerente para poder ingresar al sistema");
    }
}
