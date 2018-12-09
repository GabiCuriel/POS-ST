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

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    
    
   

    
    public void Update_Registro(){
        String update = ("UPDATE proveedor SET NOMBRE_PR=? , TEL_PR=?, EMAIL_PR=?  WHERE ID_PR=?");
     
        try {
            ps = (PreparedStatement) conn.prepareStatement(update);            
            ps.setString(1, Nombre_PR);
            ps.setString(2, Telefono_PR);
            ps.setString(3, Email_PR);
            ps.setString(4, ID_PR);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizó el registro");
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    public void Deletfrom(){
        String update = ("DELETE FROM productos WHERE ID_PR=?");
        try {
            ps = (PreparedStatement) conn.prepareStatement(update);            
            ps.setString(1, ID_PR);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se Eliminó el registro");
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    public void Insert_Registro(){   
     String insert = ("INSERT INTO productos (NOMBRE_PR,TEL_PR,ID_D,EMAIL_PR) VALUES (?,?,?,?)");
        try {
            ps = (PreparedStatement) conn.prepareStatement(insert);            
            ps.setString(1, Nombre_PR);
            ps.setString(2, Telefono_PR);
            ps.setString(3, ID_D);
            ps.setString(4, Email_PR);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se inserto el nuevo producto");
           
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }    
    
    
    public void llenarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Telefono");
        modelo.addColumn("Direccion");
        modelo.addColumn("Email");
        String sql = "SELECT * FROM proveedores;";
        try{
            System.out.println("Modelo -editarProveedores - llenarTabla");
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            this.setCantColu(rsMd.getColumnCount());
            
            while(rs.next()){
                Object[] filas = new Object[this.getCantColu()];
                for (int i = 0; i <this.getCantColu();i++){
                    filas[i] = rs.getObject(i+1);
                }
                this.modelo.addRow(filas);
            }
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados_CRUD 001: "+ err.getMessage());
        }
    }
    public void obtenerDireccion(){
            String sql = "SELECT direcciones.CALLE_D, direcciones.COL_D, direcciones.NO_INT_D, direcciones.NO_EXT_D, direcciones.CD_D, direcciones.CP_D, direcciones.EDO_D FROM direcciones INNER JOIN proveedores ON proveedores.ID_D = direcciones.ID_D;";
        try{
            int x=0;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            String direccion = "";
            ResultSetMetaData rsMd = rs.getMetaData();
            this.setCantColu(rsMd.getColumnCount());
            
            while(rs.next()){
                Object[] filas = new Object[this.getCantColu()];
                for (int i =0; i < this.getCantColu(); i++){
                    filas[i] = rs.getObject(i+1);
                    direccion+=filas[i]+" ";
                }
                modelo.setValueAt(direccion, x, 3);
                direccion = "";
                x++;
            }
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados_CRUD 002: "+ err.getMessage());
        }
    }
}

