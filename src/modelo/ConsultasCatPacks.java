/*
 ****** Cristian Alvarado ******
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasCatPacks extends Conexion{
    
    public boolean registrar(CatPacks CP) throws SQLException{
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        String sql = "INSERT INTO categoria_pack (categoria_pack) VALUES(?)";
        
        try {
            ps = con.prepareStatement(sql);
            //ps.setInt(1, rs.getIdrrss());
            ps.setString(1, CP.getCategoria_pack());
            //ps.setInt(2, CP.getEstado_pack());
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
    
    public boolean modificar(CatPacks CP) throws SQLException{
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        String sql = "UPDATE categoria_pack SET categoria_pack=? WHERE (idcategoria_pack=?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, CP.getCategoria_pack());
            //ps.setInt(2, CP.getEstado_pack());
            ps.setInt(2, CP.getIdcategoria_pack());
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
    
    //*** Buscar Categoria Pack *****
    public boolean buscarRrss(CatPacks ccpp) throws SQLException{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();
        String sql = "SELECT * FROM categoria_pack WHERE idcategoria_pack=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, ccpp.getIdcategoria_pack());
            rs = ps.executeQuery();
            
            if(rs.next()){
                ccpp.setIdcategoria_pack(Integer.parseInt(rs.getString("idcategoria_pack")));
                ccpp.setCategoria_pack(rs.getString("categoria_pack"));
                ccpp.setEstado_pack(Integer.parseInt(rs.getString("estado_pack")));
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
