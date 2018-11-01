/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Juan Pablo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;


public class ModelProductos {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;

    private String ID;
    private String Nombre;
    private String SKU;
    private String Proveedor;
    private String Tipo;
    private String Precio;
    private String Marca;
    private String Cantidad;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String Cantidad) {
        this.Cantidad = Cantidad;
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
            ID = rs.getString("ID_p");
            Nombre = rs.getString("Nombre_P");
            Proveedor = rs.getString("ID_Proveedor");
            SKU = rs.getString("SKU");
            Tipo = rs.getString("Tipo");
            Precio = rs.getString("Precio");
            Marca = rs.getString("Marca");
            Cantidad = rs.getString("Cantidad_P");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + err.getMessage());
        }
    }
    public void Update_Registro(){
        String update = ("Update Productos Set Nombre_P=? , SKU=? , Tipo=? , Precio=? , Marca=?  Where ID_P=?");
     
        Connection con = conexion;
        try {
            pst = (PreparedStatement) con.prepareStatement(update);            
            pst.setString(1, Nombre);
            pst.setString(2, SKU);
            pst.setString(3, Tipo);
            pst.setString(4, Precio);
            pst.setString(5, Marca);
            pst.setString(6, ID);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se actualizó el registro");
            
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null, "No se pudo actualizar");
        }
    }
    public void Deletfrom(){
        String update = ("Delete from Productos Where ID_P=?");
     
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
     String insert = ("Insert into Productos (Nombre_P,SKU,Tipo,Precio,Marca,ID_Proveedor) values (?,?,?,?,?,?)");
     
        Connection con = conexion;
        try {
            pst = (PreparedStatement) con.prepareStatement(insert);            
            pst.setString(1, Nombre);
            pst.setString(2, SKU);
            pst.setString(3, Tipo);
            pst.setString(4, Precio);
            pst.setString(5, Marca);
            pst.setString(6, Proveedor);
            
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se inserto el nuevo producto");
            
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null, "No se pudo insertar el nuevo producto");
        }
    }    
}

