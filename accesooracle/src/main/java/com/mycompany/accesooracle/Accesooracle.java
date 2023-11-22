/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accesooracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;
import java.sql.Types;

/**
 *
 * @author lucas
 */
public class Accesooracle {

    static String driver;
    static Connection conexion;
    
    public static void main(String[] args) throws ClassNotFoundException {
        
        try{
            
            //Iniciamos la conexion
            establecerConexion();
            
            //Ejecutar sentencia sql y mostrar los resultados
            //consultaSencilla();
            //consultaExecute();
            //consultaPrepared();
            
            //insertarExecuteUpdate();
            //insertarExecute();
            //insertarPrepared();
            
            //añadirCampo();
            
            //ejecutarProcedimiento();
            ejecutarFuncion(10);
            consultaSencilla();

            
            conexion.close();
        }
        catch(SQLException | ClassNotFoundException cnfe){
            System.out.println("Error catastrofico: "+cnfe.toString());
        }
    }
    
    private static void establecerConexion() throws SQLException, ClassNotFoundException{
        driver = "oracle.jdbc.driver.OracleDriver";
        String urlconnection = "jdbc:oracle:thin:@localhost:1521/ORCL18";
        
            Properties propiedades = new Properties();
            
            propiedades.setProperty("user", "dam2");
            propiedades.setProperty("password", "dam2");

            Class.forName(driver);
            conexion = DriverManager.getConnection(urlconnection,propiedades);
            //System.out.println("Se ha establecido la conexion al usuario: "+conexion.getSchema());
    }
    
    private static void consultaSencilla() throws SQLException{
        java.sql.Statement sentencia = conexion.createStatement();
            String sql = "Select * from departamentos";
            ResultSet resul = sentencia.executeQuery(sql);
            
            
            while (resul.next()){
                System.out.println(
                "Numero de departamento: "+resul.getInt(1)+
                        " Nombre de departamento: "+resul.getString(2)+
                        " Localidad: "+resul.getString(3));
            }
            sentencia.close();
            resul.close();
    }
    
    private static void consultaExecute() throws SQLException {
        
        String sql= "Select * from departamentos";
        
        Statement sentencia = conexion.createStatement();
        
        Boolean valor = sentencia.execute(sql);
        
        if (valor) {
            ResultSet resul = sentencia.getResultSet();
            
            while(resul.next()){
                System.out.println("Numero de departamento: "+resul.getInt(1)+
                        " Nombre de departamento: "+resul.getString(2)+
                        " Localidad: "+resul.getString(3));
            }
        }
    }
    
    private static void consultaPrepared() throws SQLException{
        String sql= "Select * from departamentos";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        
        int filas = sentencia.executeUpdate();
        
        while (filas >0) {
            
            ResultSet resul = sentencia.getResultSet();
            
            while(resul.next()){
                System.out.println("Numero de departamento: "+resul.getInt(1)+
                        " Nombre de departamento: "+resul.getString(2)+
                        " Localidad: "+resul.getString(3));
            }
            
            resul.close();
        }
        sentencia.close();
    }
    
    private static void insertarExecuteUpdate() throws SQLException{
        int dep = 4;
        String dnombre = "Suministros" ;
        String loc = "Sevilla";
        
        String sql = "insert into departamentos values (" + dep + ",'" + dnombre + "','" + loc + "')";
        
        Statement sentencia = conexion.createStatement();
        
        int filas = sentencia.executeUpdate(sql);
        
        sentencia.close();
    }
    
    private static void insertarExecute() throws SQLException{
        int dep = 5;
        String dnombre = "Exportacion" ;
        String loc = "Bilbao";
        
        String sql = "insert into departamentos values (" + dep + ",'" + dnombre + "','" + loc + "')";
        
        Statement sentencia = conexion.createStatement();
        
        Boolean valor = sentencia.execute(sql);
        
        if (!valor) {
            int filas = sentencia.getUpdateCount();
            System.out.println("Se ha insertado " + filas + " filas ");
        }
        sentencia.close();
    }
    
    private static void insertarPrepared() throws SQLException{
        int dep = 6;
        String dnombre = "Importacion" ;
        String loc = "Vigo";
        
        String sql = "insert into departamentos values (?,?,?)";
        
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        
        sentencia.setInt(1, dep);
        sentencia.setString(2,dnombre);
        sentencia.setString(3, loc);
        
        int filas = sentencia.executeUpdate();
        
        if(filas>0){
            System.out.println("se han insertado "+ filas +" filas ");
        
        }
        
        sentencia.close();
    }
    
    private static void añadirCampo() throws SQLException {
        
        //alter table departamentos add(tlfn number(9))
        String sql = "alter table departamentos add(tlfn number(9))";
        
        Statement sentencia = conexion.createStatement();
        //Al ser una instruccion DDL siempre devolvera un 0
        int filas = sentencia.executeUpdate(sql);
        
        
    }
    
    private static void ejecutarProcedimiento() throws SQLException{
        
        String sql= "{call nombre_depart_p(?,?)}";
        CallableStatement llamada = conexion.prepareCall(sql);
        
        int dep = 1;
        llamada.setInt(1,dep);
        
        llamada.registerOutParameter(2,Types.VARCHAR);
        
        try{
            llamada.executeUpdate();
        
        String salida_return = llamada.getString(2);
        
        System.out.println("El nombre del departamento es: "+salida_return);
    
        } catch (SQLException e){
            if(e.getErrorCode()==1403){
                System.out.println("El numero de departamento no existe");
            } else {
                throw e;
            }
        }
    }
    
    private static void ejecutarFuncion(int dept) throws SQLException{
        
        String sql= "{?= call nombre_depart_f(?)}";
        
        CallableStatement llamada = conexion.prepareCall(sql);
        
        llamada.setInt(2,dept);
        
        try{
            llamada.executeUpdate();
        String salida_return = llamada.getString(1);
        
        System.out.println("nombre depta: " + salida_return);
        } catch (SQLException e) {
            if(e.getErrorCode() == 1403) {
                System.out.println("num depart no existe");
            } else {
                throw e;         
            }
        }
    }
}
