/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;


import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasCliente extends Conexion{
    
    public boolean registrar(Cliente cli) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "INSERT INTO cliente (RUT, cli_nombre, cli_apellido, cli_direccion, cli_telefono, fecha_nac, estado, cli_mail) VALUES(?,?,?,?,?,?,?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getRut());
            ps.setString(2,cli.getCli_nombre());
            ps.setString(3, cli.getCli_apellido());
            ps.setString(4, cli.getCli_direccion());
            ps.setInt(5, cli.getCli_telefono());
            ps.setString(6, cli.getFecha_nac());
            ps.setInt(7, cli.getEstado());
            ps.setString(8, cli.getCli_mail());
            ps.execute();
            return true;
        
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally {
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
            
        }
    
    }
    
     public boolean modificar(Cliente cli)throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String  sql = "UPDATE cliente SET cli_nombre=? ,cli_apellido=?,cli_direccion=?,cli_telefono=?,fecha_nac=?,estado=?,cli_mail=? WHERE (RUT=?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1,cli.getCli_nombre());
            ps.setString(2, cli.getCli_apellido());
            ps.setString(3, cli.getCli_direccion());
            ps.setInt(4, cli.getCli_telefono());
            ps.setString(5, cli.getFecha_nac());
            ps.setInt(6, cli.getEstado());
            ps.setString(7, cli.getCli_mail());
            ps.setString(8, cli.getRut());
            ps.execute();
            return true;
        
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } finally {
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
            
        }
    
    
}
    
     
      public boolean buscar(Cliente cli){
         
         PreparedStatement ps = null;
         ResultSet rs = null;
         Connection con = getConexion();
         
         String sql = "SELECT * FROM cliente WHERE RUT=?";
         
    try {
            
            ps = con.prepareStatement(sql);            
            ps.setString(1, cli.getRut());         
            ps.executeQuery();
            
            if(rs.next())
            {
                cli.setRut(rs.getString("RUT"));
                cli.setCli_nombre(rs.getString("cli_nombre"));
                cli.setCli_apellido(rs.getString("cli_apellido"));
                cli.setCli_direccion(rs.getString("cli_direccion"));
                cli.setCli_telefono(Integer.parseInt(rs.getString("cli_telefono")));
                cli.setFecha_nac(rs.getString("fecha_nac"));
                cli.setEstado(Integer.parseInt(rs.getString("estado")));
                cli.setCli_mail(rs.getString("cli_mail"));
                return true;
            }
            
            
            return false;
        
        }catch(SQLException e){
            System.err.println(e);
            return false;
        } 
    }
    
    
}
