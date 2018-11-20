/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;


public class ModelProveedores_CRUD {
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Conexion con = new Conexion();
    private Connection conn = con.getConexion();

    private String ID_PR;
    private String Nombre_PR;
    private String ID_D;
    private String Telefono_PR;
    private String Email_PR;
    
    private int CantColu;
    
    private DefaultTableModel modelo = new DefaultTableModel();

    public String getID_PR() {
        return ID_PR;
    }

    public void setID_PR(String ID_PR) {
        this.ID_PR = ID_PR;
    }

    public String getNombre_PR() {
        return Nombre_PR;
    }

    public void setNombre_PR(String Nombre_PR) {
        this.Nombre_PR = Nombre_PR;
    }

    public String getID_D() {
        return ID_D;
    }

    public void setID_D(String ID_D) {
        this.ID_D = ID_D;
    }

    public String getTelefono_PR() {
        return Telefono_PR;
    }

    public void setTelefono_PR(String Telefono_PR) {
        this.Telefono_PR = Telefono_PR;
    }

    public String getEmail_PR() {
        return Email_PR;
    }

    public void setEmail_PR(String Email_PR) {
        this.Email_PR = Email_PR;
    }

    public int getCantColu() {
        return CantColu;
    }

    public void setCantColu(int CantColu) {
        this.CantColu = CantColu;
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

