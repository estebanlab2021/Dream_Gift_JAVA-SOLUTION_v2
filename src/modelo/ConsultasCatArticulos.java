
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasCatArticulos extends Conexion{
    
    public boolean registrar(Cat_Articulo catart) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "INSERT INTO categoria_articulo (categoria_articulo, estado) VALUES (?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, catart.getCategoria_articulo());
            ps.setInt(2, catart.getEstado());
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
    
    public boolean modificar(Cat_Articulo catart) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "UPDATE categoria_articulo SET categoria_articulo=?, estado=? WHERE (idcategoria_articulo=?)";
        //System.out.println(sql);
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, catart.getCategoria_articulo());
            ps.setInt(2, catart.getEstado());
            ps.setInt(3, catart.getIdcategoria_articulo());
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
    
    
    public boolean buscar(Cat_Articulo catart) throws SQLException{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();
        
        String sql = "SELECT * FROM categoria_articulo WHERE idcategoria_articulo=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, catart.getIdcategoria_articulo());
            rs = ps.executeQuery();
            
            if(rs.next()){
                catart.setIdcategoria_articulo(Integer.parseInt(rs.getString("idcategoria_articulo")));
                catart.setCategoria_articulo(rs.getString("categoria_articulo"));
                catart.setEstado(Integer.parseInt(rs.getString("estado")));
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
    
