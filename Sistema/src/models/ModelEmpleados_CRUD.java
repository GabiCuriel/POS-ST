/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
/*@set No regresa nada y permite modificar*/
/*@get Regresa y permite conocer el valor que tiene la variable*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Gabi Curiel
 */
public class ModelEmpleados_CRUD {

    private Connection conexion; 
    private Statement st; 
    private ResultSet rs;
    private PreparedStatement ps;
    private String ID_E;
    private String Nombre_E;
    private String Ap_E;
    private String Am_E;
    private String Tel_E;
    private String Rfc_E;
    private String Curp_E;
    private String Nss_E;
    private String ID_D;
    private String ID_B;
    private String ID_F;
    public String getID_D;

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
        this.Nombre_E = Nombre_E; //llamada a la clase 
    }
    
    public String getAp_E() {
        return Ap_E; 
    }

    public void setAp_E(String Ap_E) {
        this.Ap_E = Ap_E; //llamada a la clase 
    }
    
    public String getAm_E() {
        return Am_E; 
    }

    public void setAm_E(String Am_E) {
        this.Am_E = Am_E; //llamada a la clase 
    }
    
    public String getTel_E() {
        return Tel_E; 
    }

    public void setTel_E(String Tel_E) {
        this.Tel_E = Tel_E; //llamada a la clase 
    }
    
    public String getRfc_E() {
        return Rfc_E; 
    }

    public void setRfc_E(String Rfc_E) {
        this.Rfc_E = Rfc_E; //llamada a la clase 
    }
    public String getCurp_E() {
        return Curp_E; 
    }

    public void setCurp_E(String Curp_E) {
        this.Curp_E = Curp_E; //llamada a la clase 
    }
    
    public String getNss_E() {
        return Nss_E; 
    }

    public void setNss_E(String Nss_E) {
        this.Nss_E = Nss_E; //llamada a la clase 
    }
    
    public String getID_D() {
        return ID_D; 
    }

    public void setID_D(String ID_D) {
        this.ID_D = ID_D; //llamada a la clase 
    }
    
    public String getID_B() {
        return ID_B; 
    }

    public void setID_B(String ID_B) {
        this.ID_B = ID_B; //llamada a la clase 
    }
    
    public String getID_F() {
        return ID_F; 
    }

    public void setID_F(String ID_F) {
        this.ID_F = ID_F; //llamada a la clase 
    }
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Empleados", "empleados", "pass_emp.2018");
            st = conexion.createStatement(); //para ejecutar sentencias sql desde java
            rs = st.executeQuery("SELECT * FROM contactos;"); //almacena temporalmente los datos de la consulta 
            rs.next(); //avanza de fila en fila 
            ID_E = rs.getString("ID_E"); //almacena los nombres de los usuario en nombre
            Nombre_E = rs.getString("Nombre_E"); //almacena el nombre de los usuarios en email 
            Ap_E = rs.getString("Ap_E");
            Am_E = rs.getString("Am_E");
            Tel_E = rs.getString("Tel_E");
            Rfc_E = rs.getString("Rfc_E"); 
            Curp_E = rs.getString("Curp_E"); 
            Nss_E = rs.getString("Nss_E"); 
            ID_D = rs.getString("ID_D"); 
            ID_B = rs.getString("ID_B"); 
            ID_F = rs.getString("ID_F");
            this.setID_E(ID_E);
            this.setNombre_E(Nombre_E);
            this.setAp_E(Ap_E);
            this.setAm_E(Am_E);
            this.setTel_E(Tel_E);
            this.setRfc_E(Rfc_E);
            this.setCurp_E(Curp_E);
            this.setNss_E(Nss_E);
            this.setID_D(ID_D);
            this.setID_B(ID_B);  //asigna un valor a la variable email
            this.setID_F(ID_F); //asigna un valor a la variable nombre
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error Model 001: " + err.getMessage()); //Regresa si encuentra error 
        }

    }

    public void insertarRegistro(String ID_E, String Nombre_E, String Ap_E, String Am_E, String Tel_E, String Rfc_E, String Curp_E, String Nss_E, String ID_D, String ID_B, String ID_F) throws SQLException {
        System.out.print("Programa accion insertarRegistro"); //Mensaje que asegure que funciona el booton insertarRegistro
        String sql = "INSERT INTO Empleados(ID_E,Nombre_E,Ap_E,Am_E,Tel_E,Rfc_E,Curp_E,Nss_E,ID_D,ID_B,ID_F) VALUES" + "('" + ID_E + "','" + Nombre_E + "'','" + Ap_E + "'','" + Am_E + "'','" + Tel_E + "'','" + Rfc_E + "'','" + Curp_E + "'','" + Nss_E + "'','" + ID_D + "'','" + ID_B + "'','" + ID_F + "');";
        System.out.print(sql);
        st.executeUpdate(sql);        
        this.conectarDB();
    }
    public void modificarRegistro(String ID_E, String Nombre_E, String Ap_E, String Am_E, String Tel_E, String Rfc_E, String Curp_E, String Nss_E, String ID_D, String ID_B, String ID_F) throws SQLException {
        System.out.print("Programa accion modificarRegistro"); //Mensaje que asegure que funciona el bootonpublic modificarRegistro
        String actualID_E = this.getID_E();
        String sql = "UPDATE Empleados SET ID_E='" + ID_E + "',Nombre_E='" + Nombre_E + "',Ap_E='" + Ap_E + "',Am_E='" + Am_E + "',Tel_E='" + Tel_E + "',Rfc_E='" + Rfc_E + "',Curp_E='" + Curp_E + "',Nss_E='" + Nss_E + "',ID_D='" + ID_D + "',ID_B='" + ID_B + "',ID_F='" + ID_F + "' WHERE ID_E='" + actualID_E + "';"; 
        System.out.print(sql);
        st.executeUpdate(sql);
        this.conectarDB();
    }

    public void eliminarRegistro(String email) throws SQLException {
        System.out.print("Programa accion eliminarRegistro"); //Mensaje que asegure que funciona el booton eliminarRegistro
        String sql = "DELETE FROM Empleados WHERE ID_E='" + ID_E + "';";
        System.out.print(sql);
        st.executeUpdate(sql); 
        this.conectarDB();
    }
}
