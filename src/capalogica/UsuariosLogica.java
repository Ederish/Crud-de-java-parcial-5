/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capalogica;
import capacontrolador.Conexion;
import herreraederish_p5.frmUsuario;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class UsuariosLogica {
    Conexion conexion;

    public UsuariosLogica() {
        conexion = new Conexion();
    }

    public boolean InsertarUsuario(UsuariosDao pUsuariosDao) {
    String consultaSQL = "";
    consultaSQL = "INSERT INTO usuarios (correos, nombres, apellidos, claves, niveles) ";
    consultaSQL += "VALUES('" + pUsuariosDao.getCorreos() + "', '" 
                   + pUsuariosDao.getNombres() + "', '"
                   + pUsuariosDao.getApellidos() + "', '"
                   + pUsuariosDao.getClaves() + "', '"
                   + pUsuariosDao.getNiveles() + "')";
    try {
        return conexion.ejecutaSentenciasAccion(consultaSQL);
    } catch (Exception e) {
        System.out.println("ERROR: insertarUsuario: " + e.getMessage());
        return true;
    }
}
public UsuariosDao buscarUsuario(String correo) {
    String consultaSql = "SELECT * FROM usuarios WHERE correos = '" + correo + "'";
    ResultSet rs = conexion.ejecutaSentenciaSelect(consultaSql);
    UsuariosDao usuario = null;
    try {
        if (rs.next()) {
            usuario = new UsuariosDao();
            usuario.setCorreos(rs.getString("correos"));
            usuario.setNombres(rs.getString("nombres"));
            usuario.setApellidos(rs.getString("apellidos"));
            usuario.setClaves(rs.getString("claves"));
            usuario.setNiveles(rs.getInt("niveles"));
        }
    } catch (Exception e) {
        System.out.println("ERROR: en buscarUsuarioPorCorreo " + e.getMessage());
    }
    return usuario;
}

public boolean ActualizarUsuario(UsuariosDao pUsuarioDao) {
    String consultaSQL = "UPDATE usuarios SET ";
    consultaSQL += "nombres = '" + pUsuarioDao.getNombres() + "', ";
    consultaSQL += "apellidos = '" + pUsuarioDao.getApellidos() + "', ";
    consultaSQL += "claves = '" + pUsuarioDao.getClaves() + "', ";
    consultaSQL += "niveles = '" + pUsuarioDao.getNiveles() + "' ";
    consultaSQL += "WHERE correos = '" + pUsuarioDao.getCorreos() + "'";
    
    try {
        return conexion.ejecutaSentenciasAccion(consultaSQL);
    } catch (Exception e) {
        System.out.println("ERROR: actualizarUsuario: " + e.getMessage());
        return false;
    }
}


   public boolean EliminarUsuario(UsuariosDao pUsuarioDao) {
        String consultaSQL = "DELETE FROM usuarios WHERE correos = '" + pUsuarioDao.getCorreos() + "'";
        
        try {
            return conexion.ejecutaSentenciasAccion(consultaSQL);
        } catch (Exception e) {
            System.out.println("ERROR: eliminarUsuario: " + e.getMessage());
            return false;
        }
    }
}