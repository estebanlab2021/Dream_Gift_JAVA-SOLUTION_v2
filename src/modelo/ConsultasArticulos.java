
package modelo;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasArticulos extends Conexion{
    
    public boolean registrar(Articulos art) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "INSERT INTO articulo (id_categoria_articulo, art_descripcion, art_stock, art_fecha_vencimiento, art_estado) VALUES(?,?,?,?,?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            //ps.setInt(1, art.getIdarticulo());
            ps.setInt(1, art.getId_categoria_articulo());
            ps.setString(2, art.getArt_descripcion());
            ps.setInt(3, art.getArt_stock());
            ps.setString(4, art.getArt_fecha_vencimiento());
            ps.setInt(5,art.getArt_estado());
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
    
    public boolean modificar(Articulos art) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "UPDATE articulo SET id_categoria_articulo=?, art_descripcion=?, art_stock=?, art_fecha_vencimiento=?, art_estado=? WHERE (idarticulo=?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, art.getId_categoria_articulo());
            ps.setString(2, art.getArt_descripcion());
            ps.setInt(3, art.getArt_stock());
            ps.setString(4, art.getArt_fecha_vencimiento());
            ps.setInt(5, art.getArt_estado());
            ps.setInt(6, art.getIdarticulo());
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
    
    
    public boolean tomarItemCategoria(Cat_Articulo catart) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "SELECT idcategoria_articulo FROM categoria_articulo WHERE categoria_articulo = ?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, catart.getIdcategoria_articulo());
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