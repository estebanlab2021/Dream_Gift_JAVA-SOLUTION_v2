
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasCatVentas extends Conexion {
    
    public boolean registrar(Cat_Venta catven) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "INSERT INTO estados_venta (est_descripcion) VALUES(?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, catven.getEst_descripcion());
            ps.execute(); //faltó esto
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
     public boolean modificar(Cat_Venta catven) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "UPDATE estados_venta SET est_descripcion=? WHERE (idestados_venta=?)";
        //System.out.println(sql);
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, catven.getEst_descripcion());
           // ps.setString(2,catven.getCodigo_cat_venta());
            ps.setInt(2, catven.getIdestados_venta());
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
