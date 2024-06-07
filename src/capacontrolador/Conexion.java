/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacontrolador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Ederi
 */
public class Conexion {
    private Connection conexion;
    private Statement ejecutaSentencias;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sistemas", "root", "");
            ejecutaSentencias = conexion.createStatement();
            System.out.println("Se conecto a Base de datos ");
        } catch (Exception e) {
            System.out.println("No se conecto a base de datos " + e.getMessage());
        }

    }

  public boolean ejecutaSentenciasAccion(String consultaSql) {
       try {
            return ejecutaSentencias.execute(consultaSql);
        } catch (Exception e) {
            
            System.out.println("ERROR: en ejecutaSentenciasAccion: " + e.getMessage());
            return true;
        }
    }

   public ResultSet ejecutaSentenciaSelect(String consultaSql){
            ResultSet listado =null;
            try{
                listado = ejecutaSentencias.executeQuery (consultaSql);
            } catch(Exception e) {
            System.out.println ("ERROR: en ejecutaSentenciasSelect: " + e. getMessage()) ;
            }
            return listado;
   }
}
