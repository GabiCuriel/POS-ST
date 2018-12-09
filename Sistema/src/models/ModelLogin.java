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
/**
 *
 * @author Juan Pablo
 */
public class ModelLogin {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pst;
    
    private String Usuario;
    private String Contraseña;

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    public void Login(){
        if(Usuario.isEmpty() || Contraseña.isEmpty()){
            JOptionPane.showMessageDialog(null, "No dejes campos vacíos");
        }else{ 
            try { 
                String sql = "SELECT * FROM usuarios WHERE USERNAME_US='"+Usuario+"' && PASSWORD_US='"+Contraseña+"'";
                conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Soul_Tech");
                st = conexion.createStatement();
                rs = st.executeQuery(sql);
                pst = (PreparedStatement) conexion.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()){          
                    if(Usuario.equals(rs.getString("USERNAME_US")) || Contraseña.equals(rs.getString("PASSWORD_US"))){                            
                            JOptionPane.showMessageDialog(null, "Bienvenido usuario : " +Usuario );
                    }else{
                            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");                         
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un problema intentalo de nuevo");
            }
        }
    }
}
    

