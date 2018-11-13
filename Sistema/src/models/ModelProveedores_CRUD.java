/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;


public class ModelProveedores_CRUD {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;

    private String ID;
    private String Nombre_Pr;
    private String Direccion;
    private String Telefono;
    private String Email;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre_Pr() {
        return Nombre_Pr;
    }

    public void setNombre_Pr(String Nombre_Pr) {
        this.Nombre_Pr = Nombre_Pr;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
    

   

    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Soul_Tech");
            st = conexion.createStatement();
            String sql = "SELECT * FROM Productos;";
            System.out.println(sql);
            rs = st.executeQuery(sql);
            rs.next();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelProductos 001: " + err.getMessage());
        }
    }
    public void setValues() {
        try {
            ID = rs.getString("ID_Pr");
            Nombre_Pr = rs.getString("Nombre_Pr");
            Telefono = rs.getString("Tel_Pr");
            Direccion = rs.getString("ID_D");
            Email = rs.getString("Email");
            
           
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + err.getMessage());
        }
    }
    public void Update_Registro(){
        String update = ("Update Proveedor Set Nombre_Pr=? , Tel_Pr=? , ID_D=? , Email=?  Where ID_Pr=?");
     
        Connection con = conexion;
        try {
            pst = (PreparedStatement) con.prepareStatement(update);            
            pst.setString(1, Nombre_Pr);
            pst.setString(2, Telefono);
            pst.setString(3, Direccion);
            pst.setString(4, Email);
            pst.setString(5, ID);
            
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se actualizó el registro");
            
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null, "No se pudo actualizar");
        }
    }
    public void Deletfrom(){
        String update = ("Delete from Productos Where ID_Pr=?");
     
        Connection con = conexion;
        try {
            pst = (PreparedStatement) con.prepareStatement(update);            
            pst.setString(1, ID);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se Eliminó el registro");
            
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
        }
    }
    public void Insert_Registro(){   
     String insert = ("Insert into Productos (Nombre_Pr,Tel_Pr,ID_D,Email) values (?,?,?,?)");
     
        Connection con = conexion;
        try {
            pst = (PreparedStatement) con.prepareStatement(insert);            
            pst.setString(1, Nombre_Pr);
            pst.setString(2, Telefono);
            pst.setString(3, Direccion);
            pst.setString(4, Email);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se inserto el nuevo producto");
            
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null, "No se pudo insertar el nuevo producto");
        }
    }    
}

