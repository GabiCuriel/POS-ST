/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TeddyBear
 */
public class ModelEmpleados {
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Conexion con = new Conexion();
    private Connection conn = con.getConexion();
    
    private String ID_E;
    private String Nombre_E;
    private String AP_E;
    private String AM_E;
    private String Telefono_E;
    private String RFC_E;
    private String CURP_E;
    private String NSS_E;
    private String ID_D;
    private String ID_B;
    private String ID_F;
    
    private int CantColu;
    
    private DefaultTableModel modelo = new DefaultTableModel();

    public String getID_E() {
        return ID_E;
    }

    public void setID_E(String ID_E) {
        this.ID_E = ID_E;
    }

    public String getNombre_E() {
        return Nombre_E;
    }

    public void setNombre_E(String Nombre_E) {
        this.Nombre_E = Nombre_E;
    }

    public String getAP_E() {
        return AP_E;
    }

    public void setAP_E(String AP_E) {
        this.AP_E = AP_E;
    }

    public String getAM_E() {
        return AM_E;
    }

    public void setAM_E(String AM_E) {
        this.AM_E = AM_E;
    }

    public String getTelefono_E() {
        return Telefono_E;
    }

    public void setTelefono_E(String Telefono_E) {
        this.Telefono_E = Telefono_E;
    }

    public String getRFC_E() {
        return RFC_E;
    }

    public void setRFC_E(String RFC_E) {
        this.RFC_E = RFC_E;
    }

    public String getCURP_E() {
        return CURP_E;
    }

    public void setCURP_E(String CURP_E) {
        this.CURP_E = CURP_E;
    }

    public String getNSS_E() {
        return NSS_E;
    }

    public void setNSS_E(String NSS_E) {
        this.NSS_E = NSS_E;
    }

    public String getID_D() {
        return ID_D;
    }

    public void setID_D(String ID_D) {
        this.ID_D = ID_D;
    }

    public String getID_B() {
        return ID_B;
    }

    public void setID_B(String ID_B) {
        this.ID_B = ID_B;
    }

    public String getID_F() {
        return ID_F;
    }

    public void setID_F(String ID_F) {
        this.ID_F = ID_F;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public int getCantColu() {
        return CantColu;
    }

    public void setCantColu(int CantColu) {
        this.CantColu = CantColu;
    }
    
    
    
    public void llenarTabla(){
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido P");
        modelo.addColumn("Apellido M");
        modelo.addColumn("Telefono");
        modelo.addColumn("RFC");
        modelo.addColumn("CURP");
        modelo.addColumn("Dirección");
        modelo.addColumn("Datos Banco");
        modelo.addColumn("Sucursal");
        modelo.addColumn("NSS");
        String sql = "SELECT * FROM empleados";
        try{
            System.out.println("Modelo - verEmpleados - llenarTabla");
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            this.setCantColu(rsMd.getColumnCount());
            
            while(rs.next()){
                Object[] filas = new Object[this.getCantColu()];
                for (int i =0; i < this.getCantColu(); i++){
                    filas[i] = rs.getObject(i+1);
                }
                this.modelo.addRow(filas);
            }
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados 001: "+ err.getMessage());
        }
    }
    
    public void concatenarDireccion(){
        String sql = "SELECT direcciones.CALLE_D, direcciones.COL_D, direcciones.NUMERO_D, direcciones.CD_D, direcciones.CP_D, direcciones.EDO_D FROM direcciones INNER JOIN empleados ON empleados.ID_D = direcciones.ID_D;";
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
                modelo.setValueAt(direccion, x, 7);
                direccion = "";
                x++;
            }
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados 002: "+ err.getMessage());
        }
    }
    
    public void obtenerDatosBancarios(){
        String sql = "SELECT datos_banco.NOMBRE, datos_banco.NO_CUENTA FROM datos_banco INNER JOIN empleados ON empleados.ID_B = datos_banco.ID_B;";
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            this.setCantColu(rsMd.getColumnCount());
            String banco = "";
            int x=0;
            
            while(rs.next()){
                Object[] filas = new Object[this.getCantColu()];
                for (int i =0; i < this.getCantColu(); i++){
                    filas[i] = rs.getObject(i+1);
                    System.out.println(filas[i]);
                    banco += filas[i]+" - ";
                }
                modelo.setValueAt(banco, x, 8);
                banco = "";
                x++;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados 003: "+ e.getMessage());
        }
    }
    
    public void buscar(String value){
        String sql ="SELECT * FROM empleados "
                + "WHERE empleados.ID_E LIKE '%"+value+"%' "
                + "OR empleados.NOMBRE_E LIKE '%"+value+"%' "
                + "OR empleados.AP_E LIKE '%"+value+"%' "
                + "OR empleados.AM_E LIKE '%"+value+"%' "
                + "OR empleados.TEL_E LIKE '%"+value+"%' "
                + "OR empleados.RFC_E LIKE '%"+value+"%' "
                + "OR empleados.CURP_E LIKE '%"+value+"%' "
                + "OR empleados.ID_D LIKE '%"+value+"%' "
                + "OR empleados.ID_B LIKE '%"+value+"%' "
                + "OR empleados.ID_F LIKE '%"+value+"%' "
                + "OR empleados.NSS_E LIKE '%"+value+"%';";
        modelo =  new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido P");
        modelo.addColumn("Apellido M");
        modelo.addColumn("Telefono");
        modelo.addColumn("RFC");
        modelo.addColumn("CURP");
        modelo.addColumn("Dirección");
        modelo.addColumn("Datos Banco");
        modelo.addColumn("Sucursal");
        modelo.addColumn("NSS");
        try{
            System.out.println("Modelo - verEmpleados - buscar");
            System.out.println(sql);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            this.setCantColu(rsMd.getColumnCount());
            
            while(rs.next()){
                Object[] filas = new Object[this.getCantColu()];
                for (int i =0; i < this.getCantColu(); i++){
                    filas[i] = rs.getObject(i+1);
                }
                this.modelo.addRow(filas);
            }
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados 004: "+ err.getMessage());
        }
    }
    
    public void obtenerDatosBancariosB(String value){
        String sql = "SELECT datos_banco.NOMBRE, datos_banco.NO_CUENTA FROM datos_banco INNER JOIN empleados ON empleados.ID_B = datos_banco.ID_B "
                + "WHERE empleados.ID_E LIKE '%"+value+"%' "
                + "OR empleados.NOMBRE_E LIKE '%"+value+"%' "
                + "OR empleados.AP_E LIKE '%"+value+"%' "
                + "OR empleados.AM_E LIKE '%"+value+"%' "
                + "OR empleados.TEL_E LIKE '%"+value+"%' "
                + "OR empleados.RFC_E LIKE '%"+value+"%' "
                + "OR empleados.CURP_E LIKE '%"+value+"%' "
                + "OR empleados.ID_D LIKE '%"+value+"%' "
                + "OR empleados.ID_B LIKE '%"+value+"%' "
                + "OR empleados.ID_F LIKE '%"+value+"%' "
                + "OR empleados.NSS_E LIKE '%"+value+"%';";
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            this.setCantColu(rsMd.getColumnCount());
            String banco = "";
            int x=0;
            
            while(rs.next()){
                Object[] filas = new Object[this.getCantColu()];
                for (int i =0; i < this.getCantColu(); i++){
                    filas[i] = rs.getObject(i+1);
                    System.out.println(filas[i]);
                    banco += filas[i]+" - ";
                }
                modelo.setValueAt(banco, x, 8);
                banco = "";
                x++;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados 005: "+ e.getMessage());
        }
    }
    
    public void concatenarDireccionB(String value){
        String sql = "SELECT direcciones.CALLE_D, direcciones.COL_D, direcciones.NUMERO_D, direcciones.CD_D, direcciones.CP_D, direcciones.EDO_D FROM direcciones "
                + "INNER JOIN empleados on empleados.ID_D = direcciones.ID_D "
                + "WHERE empleados.ID_E LIKE '%"+value+"%' "
                + "OR empleados.NOMBRE_E LIKE '%"+value+"%' "
                + "OR empleados.AP_E LIKE '%"+value+"%' "
                + "OR empleados.AM_E LIKE '%"+value+"%' "
                + "OR empleados.TEL_E LIKE '%"+value+"%' "
                + "OR empleados.RFC_E LIKE '%"+value+"%' "
                + "OR empleados.CURP_E LIKE '%"+value+"%' "
                + "OR empleados.ID_D LIKE '%"+value+"%' "
                + "OR empleados.ID_B LIKE '%"+value+"%' "
                + "OR empleados.ID_F LIKE '%"+value+"%' "
                + "OR empleados.NSS_E LIKE '%"+value+"%';";    
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
                modelo.setValueAt(direccion, x, 7);
                direccion = "";
                x++;
            }
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados 006: "+ err.getMessage());
        }
    }
    
}
