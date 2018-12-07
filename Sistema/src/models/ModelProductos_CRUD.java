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


public class ModelProductos_CRUD {
    
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Conexion con = new Conexion();
    private Connection conn = con.getConexion();
    
    private String ID_P;
    private String Nombre_P;
    private String Tipo_P;
    private String Marca_P;
    private String SKU_P;
    private String Precio_P;
    private String ID_F;
    private String Existencia_FP;

    DefaultTableModel model = new DefaultTableModel();
    
    int cantColu;
    
    public String getID_P() {
        return ID_P;
    }

    public void setID_P(String ID_P) {
        this.ID_P = ID_P;
    }

    public String getNombre_P() {
        return Nombre_P;
    }

    public void setNombre_P(String Nombre_P) {
        this.Nombre_P = Nombre_P;
    }

    public String getTipo_P() {
        return Tipo_P;
    }

    public void setTipo_P(String Tipo_P) {
        this.Tipo_P = Tipo_P;
    }

    public String getMarca_P() {
        return Marca_P;
    }

    public void setMarca_P(String Marca_P) {
        this.Marca_P = Marca_P;
    }

    public String getSKU_P() {
        return SKU_P;
    }

    public void setSKU_P(String SKU_P) {
        this.SKU_P = SKU_P;
    }

    public String getPrecio_P() {
        return Precio_P;
    }

    public void setPrecio_P(String Precio_P) {
        this.Precio_P = Precio_P;
    }

    public String getID_F() {
        return ID_F;
    }

    public void setID_F(String ID_F) {
        this.ID_F = ID_F;
    }

    public String getExistencia_FP() {
        return Existencia_FP;
    }

    public void setExistencia_FP(String Existencia_FP) {
        this.Existencia_FP = Existencia_FP;
    }
    
    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public int getCantColu() {
        return cantColu;
    }

    public void setCantColu(int cantColu) {
        this.cantColu = cantColu;
    }
    
    
    public void modificar(){
        String update = ("UPDATE productos SET NOMBRE_P=? , SKU_P=? , TIPO_P=? , PRECIO_P=? , MARCA_P=?  WHERE ID_P=?;");
        double precio = Double.parseDouble(Precio_P);
        Connection con = conn;
        try {
            ps = (PreparedStatement) con.prepareStatement(update);            
            ps.setString(1, Nombre_P);
            ps.setString(2, SKU_P);
            ps.setString(3, Tipo_P);
            ps.setDouble(4, precio);
            ps.setString(5, Marca_P);
            ps.setString(6, ID_P);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizó el registro");
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null, "Error ModelProductos 001: "+ err.getMessage());
        }
    }
    
    public void eliminar(){
        String update = ("DELETE FROM productos WHERE ID_P=?");
     
        Connection con = conn;
        try {
            ps = (PreparedStatement) con.prepareStatement(update);            
            ps.setString(1, ID_P);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se Eliminó el registro");
            
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
        }
    }
    public void insertar(){   
        
        String insert = ("INSERT INTO productos(ID_P,NOMBRE_P,TIPO_P,MARCA_P,SKU_P,PRECIO_P) VALUES (?,?,?,?,?,?);");
        double precio = Double.parseDouble(Precio_P);
        System.out.println(Tipo_P);
        System.out.println(insert);
        Connection con = conn;
        try {
            ps = (PreparedStatement) con.prepareStatement(insert);            
            ps.setString(1, ID_P);
            ps.setString(2, Nombre_P);
            ps.setString(3, Tipo_P);
            ps.setString(4, Marca_P);
            ps.setString(5, SKU_P);
            ps.setDouble(6, precio);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se inserto el nuevo producto");

        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null, "No se pudo insertar el nuevo producto: " + err.getMessage());
        }
    }
    
    public void llenarTabla(){
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Tipo");
        model.addColumn("Marca");
        model.addColumn("SKU");
        model.addColumn("Precio");
        model.addColumn("Existencia");
        
        String sql = "SELECT * FROM productos;";
        try{
            System.out.println("Modelo - verProductos - llenarTabla");
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            this.setCantColu(rsMd.getColumnCount());
            
            while(rs.next()){
                Object[] filas = new Object[this.cantColu];
                for (int i = 0;  i < this.cantColu; i++){
                    filas[i] = rs.getObject(i+1);
                }
                this.model.addRow(filas);
            }
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelProductos_CRUD 001: "+ err.getMessage());
        }
    }
    
    public void obtenerExistencias(){
        String sql = "SELECT ferreteria_productos.EXISTENCIA_FP FROM ferreteria_productos INNER JOIN productos ON ferreteria_productos.ID_P = productos.ID_P;";
        try{
            System.out.println("Modelo - verProductos - obtenerExistencias");
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            this.setCantColu(rsMd.getColumnCount());
            int x=0;
            while(rs.next()){
                Object[] filas = new Object[this.cantColu];
                String existencia = "";
                for (int i = 0;  i < this.cantColu; i++){
                    filas[i] = rs.getObject(i+1);
                    existencia += filas[i];
                }
                model.setValueAt(existencia, x, 6);
                x++;
            }
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelProductos_CRUD 001: "+ err.getMessage());
        }
    }
}
