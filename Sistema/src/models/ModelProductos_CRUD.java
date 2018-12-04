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


public class ModelProductos_CRUD {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;

    private String ID;
    private String Nombre;
    private String SKU;
    private String Tipo;
    private String Precio;
    private String Marca;
    
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
    /**
     * Método que Realiza la conexión a la base de datos , asi como seleccionar todos los registros de la base,
     * Manda llamar el método setValues para llenar los datos a la tabla
     */
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
    /**
     * Método que jala los valores de la base de datos a las variables creadas
     */
    public void setValues() {
        try {
            ID = rs.getString("ID_P");
            Nombre = rs.getString("NOMBRE_P");
            SKU = rs.getString("SKU");
            Tipo = rs.getString("Tipo");
            Precio = rs.getString("Precio");
            Marca = rs.getString("Marca");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelProductos 002: " + err.getMessage());
        }
    }
    /**
     * Método que Actualiza Registros a la base de datos , pidiendo como valores 
     * Nombre,SKU,Tipo,Precio,Marca
     * Donde el ID exista en la base de datos 
     * Esto debido a la clausula Where
     */
    public void Update_Registro(){
        String update = ("Update Productos Set NOMBRE_P=? , TIPO_p=? , MARCA_p=? , SKU_P=? , PRECIO=?  Where ID_P=?");
     
        Connection con = conexion;
        try {
            pst = (PreparedStatement) con.prepareStatement(update);            
            pst.setString(1, Nombre);
            pst.setString(2, Tipo);
            pst.setString(3, Marca);
            pst.setString(4, SKU);
            pst.setString(5, Precio);
            pst.setString(6, ID);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se actualizó el registro");
            
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null, "No se pudo actualizar");
        }
    }
    /**
     * Método que Elimina Registros a la base de datos , pidiendo como unico valor el ID
     * Esto debido a la clausula where que pide que para que se pueda eliminar un producto el ID del mismo debe ser el mismo 
     */
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
    /**
     * Método que Inserta Registros a la base de datos , pidiendo como valores 
     * Nombre,SKU,Tipo,Precio,Marca,ID_Proveedor
     * El ID propio es autoincrementable asi que no se necesita
     */
    
    public void Insert_Registro(){   
     String insert = ("Insert into Productos (NOMBRE_P,TIPO_p,MARCA_p,SKU_P,PRECIO) values (?,?,?,?,?)");
     
        Connection con = conexion;
        try {
            pst = (PreparedStatement) con.prepareStatement(insert);            
            pst.setString(1, Nombre);
            pst.setString(2, Tipo);
            pst.setString(3, Marca);
            pst.setString(4, SKU);
            pst.setString(5, Precio);
            
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se inserto el nuevo producto");
            
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null, "No se pudo insertar el nuevo producto");
        }
    }    
}
