/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TeddyBear
 */
public class ModelClientes_CRUD {
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Conexion con = new Conexion();
    private Connection conn = con.getConexion();
    
    private String ID_CL;
    private String Nombre_CL;
    private String AP_CL;
    private String AM_CL;
    private String Telefono_CL;
    private String RFC_CL;
    private String ID_D;    
    private String Direccion_CL;
    private String Payback_CL;
    private String Email_CL;
    private DefaultTableModel modelo = new DefaultTableModel();
    private int cantColu;

    public int getCantColu() {
        return cantColu;
    }

    public void setCantColu(int cantColu) {
        this.cantColu = cantColu;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    public String getID_CL() {
        return ID_CL;
    }

    public void setID_CL(String ID_CL) {
        this.ID_CL = ID_CL;
    }

    public String getNombre_CL() {
        return Nombre_CL;
    }

    public void setNombre_CL(String Nombre_CL) {
        this.Nombre_CL = Nombre_CL;
    }

    public String getAP_CL() {
        return AP_CL;
    }

    public void setAP_CL(String AP_CL) {
        this.AP_CL = AP_CL;
    }

    public String getAM_CL() {
        return AM_CL;
    }

    public void setAM_CL(String AM_CL) {
        this.AM_CL = AM_CL;
    }

    public String getTelefono_CL() {
        return Telefono_CL;
    }

    public void setTelefono_CL(String Telefono_CL) {
        this.Telefono_CL = Telefono_CL;
    }

    public String getRFC_CL() {
        return RFC_CL;
    }

    public void setRFC_CL(String RFC_CL) {
        this.RFC_CL = RFC_CL;
    }

    public String getID_D() {
        return ID_D;
    }

    public void setID_D(String ID_D) {
        this.ID_D = ID_D;
    }

    public String getDireccion_CL() {
        return Direccion_CL;
    }

    public void setDireccion_CL(String Direccion_CL) {
        this.Direccion_CL = Direccion_CL;
    }

    public String getPayback_CL() {
        return Payback_CL;
    }

    public void setPayback_CL(String Payback_CL) {
        this.Payback_CL = Payback_CL;
    }

    public String getEmail_CL() {
        return Email_CL;
    }

    public void setEmail_CL(String Email_CL) {
        this.Email_CL = Email_CL;
    }
    
    public void insertarRegistro(){
        String sql = ("INSERT INTO clientes (`ID_CL`, `NOMBRE_CL`, `AM_CL`, `AP_CL`, `TEL_CL`, `RFC_CL`, `EMAIL_CL`, `PAYBACK_CL`, `ID_D`) VALUES (?,?,?,?,?,?,?,?,?)");
        Connection conec = conn;
        try{
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, this.getID_CL());
            ps.setString(2, this.getNombre_CL());
            ps.setString(3, this.getAP_CL());
            ps.setString(4, this.getAM_CL());
            ps.setString(5, this.getTelefono_CL());
            ps.setString(6, this.getRFC_CL());
            ps.setString(7, this.getEmail_CL());
            ps.setString(8, this.getPayback_CL());
            ps.setString(9, this.getID_D());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso! :)");
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelClientes 001: "+ err.getMessage());
        }
    }
    
    public void llenarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre"); 
        modelo.addColumn("Apellido P");
        modelo.addColumn("Apellido M");
        modelo.addColumn("telefono");
        modelo.addColumn("RFC");
        modelo.addColumn("Email");
        modelo.addColumn("Payback");
        modelo.addColumn("Dirección");
        try{
            System.out.println("Modelo - editarClientes - llenarTabla");
            
            String sql = "SELECT * FROM clientes;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            this.setCantColu(rsMd.getColumnCount());
            while (rs.next()){
                Object[] filas = new Object[this.getCantColu()];
                for (int i = 0; i < this.getCantColu(); i++){
                    filas[i] = rs.getObject(i +  1);
                }
                this.modelo.addRow(filas);
                
            }
        } catch (SQLException err){
            JOptionPane.showMessageDialog(null,"Error ModelClientes 002: "+ err.getMessage());
        }
    }
    
    public void concatenarDireccionSQL(){
        try{
            String sql = "SELECT direcciones.CALLE_D, direcciones.COL_D, direcciones.NUMERO_D, direcciones.CD_D, direcciones.CP_D, direcciones.EDO_D FROM direcciones INNER JOIN clientes ON clientes.ID_D = direcciones.ID_D;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            String direccion = "";
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantCol = rsMd.getColumnCount(); 
            Object[] filas = new Object[cantCol];
            int x = 0;
            while (rs.next()){
                for (int i = 0; i < cantCol; i++){
                    filas[i] =  rs.getObject(i + 1);
                    direccion+=filas[i]+" ";
                }
                System.out.println("%%%%%%%%%%%%%%%%%%%");
                System.out.println(direccion);
                modelo.setValueAt(direccion, x, 8);
                direccion = "";
                x++;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error ModelClientes 003: "+ e.getMessage());
        }          
    }
    
    public void modificarRegistro(){
        String sql = ("UPDATE clientes SET `NOMBRE_CL`=?, `AM_CL`=?, `AP_CL`=?, `TEL_CL`=?, `RFC_CL`=?, `EMAIL_CL`=?, `PAYBACK_CL`=? WHERE ID_CL=?;");
        Connection conec = conn;
        try{
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, this.getNombre_CL());
            ps.setString(2, this.getAP_CL());
            ps.setString(3, this.getAM_CL());
            ps.setString(4, this.getTelefono_CL());
            ps.setString(5, this.getRFC_CL());
            ps.setString(6, this.getEmail_CL());
            ps.setString(7, this.getPayback_CL());
            ps.setString(8, this.getID_CL());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso! :)");
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelClientes 004: "+ err.getMessage());
        }
    }
    
    public void eliminarRegistro(){
        String sql = ("DELETE FROM clientes WHERE `ID_CL`=?;");
        Connection conec = conn;
        try{
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, this.getID_CL());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado con exito! :)");
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelClientes 005: "+ err.getMessage());
        }
    }
    public void obtenerIDD(){
        String sql = "SELECT ID_D FROM clientes WHERE ID_CL = ?;";
        try{
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, this.getID_CL());
            rs = ps.executeQuery();
            rs.next();
            this.ID_D = rs.getString("ID_D");
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelClientes_CRUD 006: "+ err.getMessage());
        }
    }
}
