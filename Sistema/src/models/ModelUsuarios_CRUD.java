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
public class ModelUsuarios_CRUD {

    private Connection conexion; 
    private Statement st; 
    private ResultSet rs;
    private PreparedStatement ps;
    private String ID_U;
    private String User_U;
    private String Pas_U;
    private String Tipo_U;
    private String ID_E;


    public String getID_U() {
        return ID_U;
    }

    public void setID_U(String ID_U) {
        this.ID_U = ID_U;
    }

    public String getUser_U() {
        return User_U; 
    }

    public void setUser_U(String User_U) {
        this.User_U = User_U; //llamada a la clase 
    }
    
    public String getPas_U() {
        return Pas_U; 
    }

    public void setPas_U(String Pas_U) {
        this.Pas_U = Pas_U; //llamada a la clase 
    }
    
    public String getTipo_U() {
        return Tipo_U; 
    }

    public void setTipo_U(String Tipo_U) {
        this.Tipo_U = Tipo_U; //llamada a la clase 
    }
    
    public String getID_E() {
        return ID_E; 
    }

    public void setID_E(String ID_E) {
        this.ID_E = ID_E; //llamada a la clase 
    }
    
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "pass_us.2018");
            st = conexion.createStatement(); //para ejecutar sentencias sql desde java
            rs = st.executeQuery("SELECT * FROM Usuarios;"); //almacena temporalmente los datos de la consulta 
            rs.next(); //avanza de fila en fila 
            ID_U = rs.getString("ID_U"); //almacena los nombres de los usuario en ID_U
            User_U = rs.getString("User_U"); //almacena el nombre de los usuarios en User_U 
            Pas_U = rs.getString("Pas_U");
            Tipo_U = rs.getString("Tipo_U");
            ID_U = rs.getString("Tel_E");
            this.setID_U(ID_U);
            this.setUser_U(User_U);
            this.setUser_U(Pas_U);
            this.setPas_U(Tipo_U);
            this.setTipo_U(ID_E);
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error Model 001: " + err.getMessage()); //Regresa si encuentra error 
        }

    }

    public void insertarRegistro(String ID_U, String User_U, String Pas_U, String Tipo_U, String ID_E) throws SQLException {
        System.out.print("Programa accion insertarRegistro"); //Mensaje que asegure que funciona el booton insertarRegistro
        String sql = "INSERT INTO Usuarios(ID_U,User_U,Pas_U,Tipo_U,ID_E) VALUES" + "('" + ID_U + "','" + User_U + "'','" + Pas_U + "'','" + Tipo_U + "'','" + ID_E + "');";
        System.out.print(sql);
        st.executeUpdate(sql);
        this.conectarDB();
    }
    public void modificarRegistro(String ID_U, String User_U, String Pas_U, String Tipo_U, String ID_E) throws SQLException {
        System.out.print("Programa accion modificarRegistro"); //Mensaje que asegure que funciona el bootonpublic modificarRegistro
        String actualID_U = this.getID_U();
        String sql = "UPDATE Usuarios SET ID_U='" + ID_U + "',User_U='" + User_U + "',Pas_U='" + Pas_U + "',Tipo_U='" + Tipo_U + "',ID_E='" + ID_E + "';";
        System.out.print(sql);
        st.executeUpdate(sql);
        this.conectarDB();
    }

    public void eliminarRegistro(String ID_U) throws SQLException {
        System.out.print("Programa accion eliminarRegistro"); //Mensaje que asegure que funciona el booton eliminarRegistro
        String sql = "DELETE FROM Usuarios WHERE ID_U='" + ID_U + "';";
        System.out.print(sql);
        st.executeUpdate(sql); 
        this.conectarDB();
    }
}
