/****************************************
 ******ConsultasRRSS "DreamGift" ********
 ***************************************/

package modelo;

/**
 ******"Cristian Alvarado"*******
 */

//import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasRRSS extends Conexion{
    
    public boolean registrar(RRSS rs) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "INSERT INTO rrss (rrss_nombre, codigoRS, estado) VALUES(?,?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            //ps.setInt(1, rs.getIdrrss());
            ps.setString(1, rs.getRrss_nombre());
            ps.setString(2, rs.getCodigoRS());
            ps.setInt(3, rs.getEstado());
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
    
    public boolean modificar(RRSS rs) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "UPDATE rrss SET rrss_nombre=?, codigoRS=?, estado=? WHERE (idrrss=?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, rs.getRrss_nombre());
            ps.setString(2, rs.getCodigoRS());
            ps.setInt(3, rs.getEstado());
            ps.setInt(4, rs.getIdrrss());
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
    
    //*** Buscar RRSS *****
    public boolean buscarRrss(RRSS rrss) throws SQLException{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();
        
        String sql = "SELECT * FROM rrss WHERE idrrss=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, rrss.getIdrrss());
            rs = ps.executeQuery();
            
            if(rs.next()){
                rrss.setIdrrss(Integer.parseInt(rs.getString("idrrss")));
                rrss.setRrss_nombre(rs.getString("rrss_nombre"));
                rrss.setCodigoRS(rs.getString("codigoRS"));
                rrss.setEstado(Integer.parseInt(rs.getString("estado")));
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
