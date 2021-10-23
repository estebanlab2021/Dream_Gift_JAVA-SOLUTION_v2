
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultasPedidos extends Conexion{
    
    public boolean agregarPedido(Pedido ped) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql ="INSERT INTO orden_compra (fecha_orden_compra, edo_orden_compra) VALUES (?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, ped.getFecha_orden_compra());
            ps.setInt(2, ped.getEdo_orden_compra());
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
    
    public boolean actualizarPedido(Detalle_orden_compra com) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql ="INSERT INTO detalle_orden_compra (id_orden_compra_pk, id_articulo_pk, cantidades) VALUES (?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, com.getId_orden_compra_pk());
            ps.setInt(2, com.getId_articulo_pk());
            ps.setInt(3, com.getCantidades());
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
    
    public boolean modificarPedido(Pedido ped) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql ="UPDATE orden_compra SET fecha_orden_compra=?, edo_orden_compra=? WHERE (idorden_compra=?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, ped.getFecha_orden_compra());
            ps.setInt(2, ped.getEdo_orden_compra());
            ps.setInt(3, ped.getIdorden_compra());
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
