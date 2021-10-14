/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class ConsultaUsuario extends Conexion{
    
    public boolean BuscarUsuario(Usuarios user) throws SQLException{
        PreparedStatement ps = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        ResultSet rs = null;
        
        String sql = "SELECT * FROM usuario WHERE (usuario = ? AND password = ?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getPassword());
            //ps.execute();
            rs = ps.executeQuery();
            rs.close();
            return true;
        }catch(SQLException e){
            System.err.println(e.toString());
            return false;
        }
    }
    
    public boolean registrarUsuario(Usuarios user) throws SQLException{
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        
        String sql ="INSERT INTO usuario (usuario, password, user_estado) VALUES(?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getUser_estado());
            ps.execute();
            //rs = ps.executeQuery();
            //rs.close();
            //con.close();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    
    public boolean modificarUsuario(Usuarios user) throws SQLException{
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        
        String sql ="UPDATE usuario SET user_estado=? WHERE (idusuario = ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getUser_estado());
            ps.setInt(2, user.getIdusuario());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.err.println(e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    
    
    
}
