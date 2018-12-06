/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author TeddyBear
 */
public class ModelFormularioDirecciones {
    
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Conexion con = new Conexion();
    private Connection conn = con.getConexion();
    
    private String ID_D;
    private String Calle_D;
    private String Col_D;
    private String Numero_D;
    private String CP_D;
    private String CD_D;
    private String Edo_D;

    public String getID_D() {
        return ID_D;
    }

    public void setID_D(String ID_D) {
        this.ID_D = ID_D;
    }

    public String getCalle_D() {
        return Calle_D;
    }

    public void setCalle_D(String Calle_D) {
        this.Calle_D = Calle_D;
    }

    public String getCol_D() {
        return Col_D;
    }

    public void setCol_D(String Col_D) {
        this.Col_D = Col_D;
    }

    public String getNumero_D() {
        return Numero_D;
    }

    public void setNumero_D(String Numero_D) {
        this.Numero_D = Numero_D;
    }

    public String getCP_D() {
        return CP_D;
    }

    public void setCP_D(String CP_D) {
        this.CP_D = CP_D;
    }

    public String getCD_D() {
        return CD_D;
    }

    public void setCD_D(String CD_D) {
        this.CD_D = CD_D;
    }

    public String getEdo_D() {
        return Edo_D;
    }

    public void setEdo_D(String Edo_D) {
        this.Edo_D = Edo_D;
    }
    
    public void insertarDireccion(){
        System.out.println("insertar direccion - modelFormularioDirecciones");
        String sql = ("INSERT INTO direcciones(ID_D, CALLE_D, COL_D, NUMERO_D, CP_D, CD_D, EDO_D) VALUES (?,?,?,?,?,?,?)");
        Connection conec = conn;
        try{
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, ID_D);
            ps.setString(2, Calle_D);
            ps.setString(3, Col_D);
            ps.setString(4, Numero_D);
            ps.setString(5, CP_D);
            ps.setString(6, CD_D);
            ps.setString(7, Edo_D);
            ps.executeUpdate();
            System.out.println("Direccion insertada");
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelDirecciones 001: "+ err.getMessage());
        }
    }
    
    public void modificarDireccion(String ID){
        System.out.println("modificar direccion - modelFormularioDirecciones");
        String sql = ("UPDATE direcciones SET CALLE_D=?, COL_D=?, NUMERO_D=?, CP_D=?, CD_D=?, EDO_D=? WHERE ID_D=?;");
        Connection conec = conn;
        try{
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, Calle_D);
            ps.setString(2, Col_D);
            ps.setString(3, Numero_D);
            ps.setString(4, CP_D);
            ps.setString(5, CD_D);
            ps.setString(6, Edo_D);
            ps.setString(7, ID);
            ps.executeUpdate();
            System.out.println("Direccion actualizada");
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelDirecciones 001: "+ err.getMessage());
        }
    }
    
    public void eliminarDireccion(){
        System.out.println("eliminar direccion - modelFormularioDirecciones");
        String sql = "DELETE FROM direcciones WHERE ID_D = ?";
        try{
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, this.getID_D());
            ps.executeUpdate();
            System.out.println("Direccion borrada");
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelDirecciones 001: "+ err.getMessage());
        }
    }
    
    public void setValues(){
        String sql = "SELECT * FROM direcciones WHERE ID_D = ?;";
        try{
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, this.getID_D());
            rs = ps.executeQuery();
            rs.next();
            this.setCD_D(rs.getString("CD_D"));
            this.setCP_D(rs.getString("CP_D"));
            this.setCalle_D(rs.getString("CALLE_D"));
            this.setCol_D(rs.getString("COL_D"));
            this.setEdo_D(rs.getString("CALLE_D"));
            this.setNumero_D(rs.getString("NUMERO_D"));
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelDirecciones 001: "+ err.getMessage());
        }
    }
}
