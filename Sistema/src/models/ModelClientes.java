/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.*;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TeddyBear
 */
public class ModelClientes {
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableModel mBuscar = new DefaultTableModel();

    public DefaultTableModel getmBuscar() {
        return mBuscar;
    }

    public void setmBuscar(DefaultTableModel mBuscar) {
        this.mBuscar = mBuscar;
    }
    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
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
    private int cantColu;
    private Object[] tabla = new Object[cantColu];

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

    public int getCantColu() {
        return cantColu;
    }

    public void setCantColu(int cantColu) {
        this.cantColu = cantColu;
    }

    public Object[] getTabla() {
        return tabla;
    }

    public void setTabla(Object[] tabla) {
        this.tabla = tabla;
    }

    public void llenarTabla(){
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
            System.out.println("Modelo - verClientes - llenarTabla");
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
            String sql = "SELECT * FROM clientes;";
            ps = con.prepareStatement(sql);
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
            con.close();
        } catch (SQLException err){
            JOptionPane.showMessageDialog(null,"Error ModelClientes 001: "+ err.getMessage());
        }
    }
    
    public void concatenarDireccionSQL(){
        try{
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
            String sql = "SELECT direcciones.CALLE_D, direcciones.COL_D, direcciones.NO_INT_D, direcciones.NO_EXT_D, direcciones.CD_D, direcciones.CP_D, direcciones.EDO_D FROM direcciones INNER JOIN clientes ON clientes.ID_D = direcciones.ID_D;";
            ps = con.prepareStatement(sql);
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
                System.out.println("//////////////////7");
                System.out.println(direccion);
                modelo.setValueAt(direccion, x, 8);
                direccion = "";
                x++;
            }
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error ModelClientes 003: "+ e.getMessage());
        }          
    }
    
    public void buscarCliente(String value){
        try{
            mBuscar = new DefaultTableModel();
            mBuscar.addColumn("ID");
            mBuscar.addColumn("Nombre"); 
            mBuscar.addColumn("Apellido P");
            mBuscar.addColumn("Apellido M");
            mBuscar.addColumn("telefono");
            mBuscar.addColumn("RFC");
            mBuscar.addColumn("Email");
            mBuscar.addColumn("Payback");
            mBuscar.addColumn("Dirección");
            System.out.println("Modelo - verClientes - buscarClientes");
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
            String sql;
            sql = "SELECT * FROM clientes WHERE NOMBRE_CL = '"+value+"';";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            this.setCantColu(rsMd.getColumnCount());
            while (rs.next()){
                Object[] filas = new Object[this.getCantColu()];
                for (int i = 0; i < this.getCantColu(); i++){
                    filas[i] = rs.getObject(i +  1);
                }
                this.mBuscar.addRow(filas);
                System.out.println(Arrays.toString(filas));
            }
            con.close();
        } catch (SQLException err){
            JOptionPane.showMessageDialog(null,"Error ModelClientes 001: "+ err.getMessage());
        }
        
    }
    public void concatenarDireccionBusqueda(String value){
        try{
            PreparedStatement pps = null;
            ResultSet rrs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
            String sql = "SELECT direcciones.CALLE_D, direcciones.COL_D, direcciones.NO_INT_D, direcciones.NO_EXT_D, direcciones.CD_D, direcciones.CP_D, direcciones.EDO_D, direcciones.ID_D FROM direcciones INNER JOIN clientes ON clientes.ID_D = direcciones.ID_D WHERE clientes.NOMBRE_CL = '"+value+"';";
            pps = con.prepareStatement(sql);
            rrs = pps.executeQuery();
            String direccion = "";
            ResultSetMetaData rsMd = rrs.getMetaData();
            int cantCol = rsMd.getColumnCount(); 
            Object[] filas = new Object[cantCol];
            int x = 0;
            while (rrs.next()){
                for (int i = 0; i < cantCol; i++){
                    filas[i] =  rrs.getObject(i + 1);
                    direccion+=filas[i]+" ";
                }
                System.out.println("##########################3");
                System.out.println(direccion);
                mBuscar.setValueAt(direccion, x, 8);
                direccion = "";
                x++;
            }
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Error ModelClientes 003: "+ e.getMessage());
        }          
    }
}
