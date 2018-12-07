/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.JOptionPane;

/**
 *
 * @author TeddyBear
 */
public class ModelLogueo {
    private String Usuario;
    private String Password;
    private boolean Value;
    
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isValue() {
        return Value;
    }

    public void setValue(boolean Value) {
        this.Value = Value;
    }
    
    public void login(){
        if("Admin".equals(Usuario) && "acmeshop".equals(Password)){
            JOptionPane.showMessageDialog(null, "Hola de nuevo "+Usuario);
            Value = true;
        } else{
            JOptionPane.showMessageDialog(null, "Upps! Usuario o contraseña incorrectos");
        }
    }
    
}
