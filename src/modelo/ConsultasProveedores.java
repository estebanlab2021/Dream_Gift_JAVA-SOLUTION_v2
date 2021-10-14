
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasProveedores extends Conexion {
  
public boolean registrar(Proveedores prov) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "INSERT INTO proveedor (idproveedor, pro_nombre, pro_telefono, pro_correo, pro_direccion, razon_social, estado) VALUES(?,?,?,?,?,?,?)";
        
        try {
           
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getIdproveedor());
            ps.setString(2, prov.getPro_nombre());
            ps.setString(3, prov.getPro_telefono());
            ps.setString(4, prov.getPro_correo());
            ps.setString(5, prov.getPro_direccion());
            ps.setString(6, prov.getRazon_social());
            ps.setInt(7, prov.getEstado());
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
    
    public boolean modificar(Proveedores prov) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "UPDATE proveedor SET pro_nombre=?, pro_telefono=?, pro_correo=?, pro_direccion=?, razon_social=?, estado=? WHERE (idproveedor=?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getPro_nombre());
            ps.setString(2, prov.getPro_telefono());
            ps.setString(3, prov.getPro_correo());
            ps.setString(4, prov.getPro_direccion());
            ps.setString(5, prov.getRazon_social());
            ps.setInt(6, prov.getEstado());
            ps.setString(7, prov.getIdproveedor());
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
    
    //*** Buscar Proveedores *****
    public boolean buscarProveedores(Proveedores prov) throws SQLException{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();
        
        String sql = "SELECT * FROM proveedor WHERE idproveedor=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, prov.getIdproveedor());
            rs = ps.executeQuery();
            
            if(rs.next()){
                prov.setIdproveedor(rs.getString("idproveedor"));
                prov.setPro_nombre(rs.getString("pro_nombre"));
                prov.setPro_telefono(rs.getString("pro_telefono"));
                prov.setPro_correo(rs.getString("pro_correo"));
                prov.setPro_direccion(rs.getString("pro_direccion"));
                prov.setRazon_social(rs.getString("razon_social"));
                prov.setEstado(Integer.parseInt(rs.getString("estado")));
                
                
                return true;
            }
            return false;
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
