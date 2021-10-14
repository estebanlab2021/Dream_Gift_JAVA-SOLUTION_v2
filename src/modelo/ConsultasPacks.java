package modelo;
/**
 **** Cristian Alvarado
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasPacks extends Conexion{
    
    public boolean registrar(Packs pck) throws SQLException{
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        String sql = "INSERT INTO pack (id_categoria_pack, pck_nombre, pck_costo, pck_stock, estado) VALUES(?,?,?,?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pck.getId_categoria_pack());
            ps.setString(2, pck.getPck_nombre());
            ps.setDouble(3, pck.getPck_costo());
            ps.setInt(4, pck.getPck_stock());
            ps.setInt(5, pck.getEstado());
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
    
    public boolean modificar(Packs pck) throws SQLException{
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        String sql = "UPDATE pack SET id_categoria_pack=?, pck_nombre=?, pck_costo=?, pck_stock=?, estado=? WHERE (idpack=?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, pck.getId_categoria_pack());
            ps.setString(2, pck.getPck_nombre());
            ps.setDouble(3, pck.getPck_costo());
            ps.setInt(4, pck.getPck_stock());
            ps.setInt(5, pck.getEstado());
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
    
    
    public boolean guardarDetallePack(ArticuloHasPack haspck) throws SQLException{
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql ="INSERT INTO articulo_has_pack (id_articulo_art, id_pack_pck, cantidad) VALUES(?.?,?)";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, haspck.getId_articulo_art());
            ps.setInt(2, haspck.getId_pack_pck());
            ps.setInt(3, haspck.getCantidad());
            
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
    
    
    
   /* 
    //*** Buscar Packs *****
    public boolean buscarPacks(Packs pck) throws SQLException{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();
        
        String sql = "SELECT * FROM pack WHERE idpack=?";
        
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, pck.getIdpack());
            rs = ps.executeQuery();
            
            if(rs.next()){
                pck.setIdpack(Integer.parseInt(pck.getString("idpack")));
                pck.setId_categoria_pack(Integer.parseInt(pck.getString("id_categoria_pack")));
                pck.setPck_nombre(pck.getString("pck_nombre"));
                pck.setPck_costo(Integer.parseInt(pck.getString("pck_costo")));
                pck.setPck_stock(Integer.parseInt(pck.getString("pck_stock")));
                pck.setEstado(Integer.papckeInt(pck.getString("estado")));
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
   
    } */
    
}