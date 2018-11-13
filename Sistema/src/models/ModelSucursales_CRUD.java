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
public class ModelSucursales_CRUD {

    private Connection conexion; 
    private Statement st; 
    private ResultSet rs;
    private PreparedStatement ps;
    private String ID_S;
    private String Colonia_S;
    private String Calle_S;
    private String NumE_S;
    private String NumI_S;
    private String Ciudad_S;
    private String CodigoP_S;
    private String ID_F;
    private String ID_E;
    


    public String getID_S() {
        return ID_S;
    }

    public void setID_S(String ID_S) {
        this.ID_S = ID_S;
    }

    public String getColonia_S() {
        return Colonia_S; 
    }

    public void setColonia_S(String Colonia_S) {
        this.Colonia_S = Colonia_S; //llamada a la clase 
    }
    
    public String getCalle_S() {
        return Calle_S;
    }

    public void setCalle_S(String Calle_S) {
        this.Calle_S = Calle_S; //llamada a la clase 
    }
    
    public String getNumE_S() {
        return NumE_S; 
    }

    public void setNumE_S(String NumE_S) {
        this.NumE_S = NumE_S; //llamada a la clase 
    }
    
    public String getNumI_S() {
        return NumI_S; 
    }

    public void setNumI_S(String NumI_S) {
        this.NumI_S = NumI_S; //llamada a la clase 
    }
    
    public String getCiudad_S() {
        return Ciudad_S; 
    }

    public void setCiudad_S(String Ciudad_S) {
        this.Ciudad_S = Ciudad_S; //llamada a la clase 
    }
    
    public String getCodigoP_S() {
        return CodigoP_S; 
    }

    public void setCodigoP_S(String CodigoP_S) {
        this.CodigoP_S = CodigoP_S; //llamada a la clase 
    }
    
    public String getID_F() {
        return ID_F; 
    }

    public void setID_F(String ID_F) {
        this.ID_F = ID_F; //llamada a la clase 
    }
    
    public String getID_E() {
        return ID_E; 
    }

    public void setID_E(String ID_E) {
        this.ID_E = ID_E; //llamada a la clase 
    }
    
    
    
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sucursales", "root", "pass_suc.2018");
            st = conexion.createStatement(); //para ejecutar sentencias sql desde java
            rs = st.executeQuery("SELECT * FROM Sucursales;"); //almacena temporalmente los datos de la consulta 
            rs.next(); //avanza de fila en fila 
            this.setID_S(rs.getString("ID_S")); //Asigna y modifica un valor a la variable ID_S
            this.setColonia_S(rs.getString("Colonia_S")); //Asigna y modifica un valor a la variable Colonia_S
            this.setCalle_S(rs.getString("Calle_S")); //Asigna y modifica un valor a la variable Calle_S
            this.setNumE_S(rs.getString("NumE_S")); //Asigna y modifica un valor a la variable NumE_S
            this.setNumI_S(rs.getString("NumI_S")); //Asigna y modifica un valor a la variable NumI_S
            this.setCiudad_S(rs.getString("Ciudad_S")); //Asigna y modifica un valor a la variable Ciudad_S
            this.setCodigoP_S(rs.getString("CodigoP_S")); //Asigna y modifica un valor a la variable CodigoP_S
            this.setID_F(rs.getString("ID_F")); //Asigna y modifica un valor a la variable ID_F
            this.setID_E(rs.getString("ID_E")); //Asigna y modifica un valor a la variable ID_E 
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error Model 001: " + err.getMessage()); //Regresa si encuentra error 
        }

    }

    public void insertarRegistro(String ID_S, String Colonia_S, String Calle_S, String NumE_S, String NumI_S, String Ciudad_S, String CodigoP_S,String ID_F, String ID_E) throws SQLException {
        System.out.print("Programa accion insertarRegistro"); //Mensaje que asegure que funciona el booton insertarRegistro
        String sql = "INSERT INTO Sucursales(ID_S,Colonia_S,Calle_S,NumE_S,NumI_S,Ciudad_S,ID_F,ID_E) VALUES" + "('" + ID_S + "','" + Colonia_S + "'','" + Calle_S + "'','" + NumE_S + "'','" + NumI_S + "','" + Ciudad_S + "','" + CodigoP_S + "','" + ID_F + "','" + ID_E + "');" ;
        System.out.print(sql);//Para verificar el funcionamiento correcto de la concatenacion
        st.executeUpdate(sql); //Ejecutar la consulta sql       
    }
    public void modificarRegistro(String ID_S, String Colonia_S, String Calle_S, String NumE_S, String NumI_S, String Ciudad_S, String CodigoP_S,String ID_F, String ID_E) throws SQLException {
        System.out.print("Programa accion modificarRegistro"); //Mensaje que asegure que funciona el bootonpublic modificarRegistro
        String actualID_S = this.getID_S();
        String sql = "UPDATE Sucursales SET ID_S='" + ID_S + "',Colonia_S='" + Colonia_S + "', Calle_S='" + Calle_S + "',NumE_S='" + NumE_S +  "',NumI_S='" + NumI_S + "',Ciudad_S='" + Ciudad_S + "',CodigoP_S='" + CodigoP_S + "',ID_F='" + ID_F + "',ID_E='" + ID_E + "';";
        System.out.print(sql);//Para verificar el funcionamiento correcto de la concatenacion
        st.executeUpdate(sql); //Ejecutar la consulta sql 
    }

    public void eliminarRegistro(String ID_S) throws SQLException {
        System.out.print("Programa accion eliminarRegistro"); //Mensaje que asegure que funciona el booton eliminarRegistro
        String sql = "DELETE FROM Sucursales WHERE ID_S='" + ID_S + "';";
        System.out.print(sql); //Para verificar el funcionamiento correcto de la concatenacion
    }
}
