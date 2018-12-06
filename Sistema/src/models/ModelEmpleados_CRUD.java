/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
/**
 *
 * @author Gabi Curiel
 */

/*@set No regresa nada y permite modificar*/
/*@get Regresa y permite conocer el valor que tiene la variable*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Gabi Curiel
 */
public class ModelEmpleados_CRUD {

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
    /*
    
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Empleados", "empleados", "pass_emp.2018");
            st = conexion.createStatement(); //para ejecutar sentencias sql desde java
            rs = st.executeQuery("SELECT * FROM contactos;"); //almacena temporalmente los datos de la consulta 
            rs.next(); //avanza de fila en fila 
            this.setID_E(rs.getString("ID_E")); //Actualiza y modifica un valor a la variable ID_E 
            this.setNombre_E(rs.getString("Nombre_E")); //Actualiza y modifica un valor a la variable Nombre_E 
            this.setAp_E(rs.getString("Ap_E")); //Actualiza y modifica un valor a la variable Ap_E 
            this.setAm_E(rs.getString("Am_E")); //Actualiza y modifica un valor a la variable Am_E 
            this.setTel_E(rs.getString("Tel_E")); //Actualiza y modifica un valor a la variable Tel_E 
            this.setRfc_E(rs.getString("Rfc_E")); //Actualiza y modifica un valor a la variable Rfc_E 
            this.setCurp_E(rs.getString("Curp_E")); //Actualiza y modifica un valor a la variable Curp_E 
            this.setNss_E(rs.getString("Nss_E")); //Actualiza y modifica un valor a la variable Nss_E 
            this.setID_D(rs.getString("ID_D")); //Actualiza y modifica un valor a la variable ID_D 
            this.setID_B(rs.getString("ID_B"));  //Actualiza y modifica un valor a la variable ID_B 
            this.setID_F(rs.getString("ID_F")); //Actualiza y modifica un valor a la variable ID_F
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error Model 001: " + err.getMessage()); //Regresa si encuentra error 
        }

    }

    public void insertarRegistro(String ID_E, String Nombre_E, String Ap_E, String Am_E, String Tel_E, String Rfc_E, String Curp_E, String Nss_E, String ID_D, String ID_B, String ID_F) throws SQLException {
        System.out.print("Programa accion insertarRegistro"); //Mensaje que asegure que funciona el booton insertarRegistro
        String sql = "INSERT INTO Empleados(ID_E,Nombre_E,Ap_E,Am_E,Tel_E,Rfc_E,Curp_E,Nss_E,ID_D,ID_B,ID_F) VALUES" + "('" + ID_E + "','" + Nombre_E + "'','" + Ap_E + "'','" + Am_E + "'','" + Tel_E + "'','" + Rfc_E + "'','" + Curp_E + "'','" + Nss_E + "'','" + ID_D + "'','" + ID_B + "'','" + ID_F + "');";
        System.out.print(sql);//Para verificar el funcionamiento correcto de la concatenacion
        st.executeUpdate(sql); //Ejecutar la consulta sql 
    }
    public void modificarRegistro(String ID_E, String Nombre_E, String Ap_E, String Am_E, String Tel_E, String Rfc_E, String Curp_E, String Nss_E, String ID_D, String ID_B, String ID_F) throws SQLException {
        System.out.print("Programa accion modificarRegistro"); //Mensaje que asegure que funciona el bootonpublic modificarRegistro
        String actualID_E = this.getID_E();
        String sql = "UPDATE Empleados SET ID_E='" + ID_E + "',Nombre_E='" + Nombre_E + "',Ap_E='" + Ap_E + "',Am_E='" + Am_E + "',Tel_E='" + Tel_E + "',Rfc_E='" + Rfc_E + "',Curp_E='" + Curp_E + "',Nss_E='" + Nss_E + "',ID_D='" + ID_D + "',ID_B='" + ID_B + "',ID_F='" + ID_F + "' WHERE ID_E='" + actualID_E + "';"; 
        System.out.print(sql);//Para verificar el funcionamiento correcto de la concatenacion
        st.executeUpdate(sql); //Ejecutar la consulta sql 
    }

    public void eliminarRegistro(String email) throws SQLException {
        System.out.print("Programa accion eliminarRegistro"); //Mensaje que asegure que funciona el booton eliminarRegistro
        String sql = "DELETE FROM Empleados WHERE ID_E='" + ID_E + "';";
        System.out.print(sql);//Para verificar el funcionamiento correcto de la concatenacion
        st.executeUpdate(sql); //Ejecutar la consulta sql 
    }
*/
    
    public void llenarTabla(){
        modelo = new DefaultTableModel();
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
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados_CRUD 001: "+ err.getMessage());
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
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados_CRUD 002: "+ err.getMessage());
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
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados_CRUD 003: "+ e.getMessage());
        }
    }
    
    public void insertarRegistro(){
        String sql ="INSERT INTO empleados (`ID_E`, `NOMBRE_E`, `AP_E`, `AM_E`, `TEL_E`, `RFC_E`, `CURP_E`, `ID_D`, `ID_B`, `ID_F`, `NSS_E`) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        Connection conec = conn;
        try{
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, this.getID_E());
            ps.setString(2, this.getNombre_E());
            ps.setString(3, this.getAP_E());
            ps.setString(4, this.getAP_E());
            ps.setString(5, this.getTelefono_E());
            ps.setString(6, this.getRFC_E());
            ps.setString(7, this.getCURP_E());
            ps.setString(8, this.getID_D());
            ps.setString(9, this.getID_B());
            ps.setString(10, this.getID_F());
            ps.setString(11, this.getNSS_E());
            System.out.println(sql);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Registro exitoso! :)");
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados_CRUD 004: "+ err.getMessage());
            System.out.println(sql);
        }
    }
    
    public void modificarRegistro(){
        String sql = "UPDATE empleados SET `NOMBRE_E`=?, `AP_E`=?, `AM_E`=?, `TEL_E`=?, `RFC_E`=?, `CURP_E`=?,`NSS_E`=? WHERE `ID_E`=?; ";
        Connection conec = conn;
        try{
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, this.getNombre_E());
            ps.setString(2, this.getAP_E());
            ps.setString(3, this.getAP_E());
            ps.setString(4, this.getTelefono_E());
            ps.setString(5, this.getRFC_E());
            ps.setString(6, this.getCURP_E());
            ps.setString(7, this.getNSS_E());
            ps.setString(8, this.getID_E());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro exitoso! :)");
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados_CRUD 005: "+ err.getMessage());
        }
    }
    public void eliminarRegistro(){
        String sql = ("DELETE FROM empleados WHERE `ID_E`=?;");
        Connection conec = conn;
        try{
            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setString(1, this.getID_E());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro eliminado con exito! :)");
        }catch(SQLException err){ 
            JOptionPane.showMessageDialog(null,"Error ModelEmpleados_CRUD 006: "+ err.getMessage());
        }
    }
}
