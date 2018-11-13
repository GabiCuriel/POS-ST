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

/**
 *
 * @author TeddyBear
 */
public class Conexion {
    private final String base = "soultech";
    private final String user = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost/" + base;
    private Connection con;
    static Statement st = null;
    static ResultSet rs;
    
    public Connection getConexion(){
        try{
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion Exitosa");

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return con;
    }
}

