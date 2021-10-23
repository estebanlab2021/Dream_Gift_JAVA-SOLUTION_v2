
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultasFacturas extends Conexion{
    
    public boolean agregarFactura(Factura fac) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql ="INSERT INTO factura (fac_numero, fac_fecha_factura, id_roden_compra, id_proveedor) VALUES(?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, fac.getFac_numero());
            ps.setString(2, fac.getFac_fecha_factura());
            ps.setInt(3, fac.getId_roden_compra());
            ps.setString(4, fac.getId_proveedor());
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
    
    public boolean agregarDetalleFactura(Detalle_Factura detfac) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql ="INSERT INTO detalle_factura (id_factura_pk, id_articulo_pk, det_cantidad, det_valor, fecha_vencimiento) VALUES(?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, detfac.getId_factura_pk());
            ps.setInt(2, detfac.getId_articulo_pk());
            ps.setInt(3, detfac.getDet_cantidad());
            ps.setDouble(4, detfac.getDet_valor());
            ps.setString(5, detfac.getFecha_vencimiento());
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
    
    public boolean modificarFactura(Factura fac) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql ="UPDATE factura SET fac_numero=?, id_proveedor=?, fac_fecha_factura=?, fac_estado=? WHERE (idfactura=?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, fac.getFac_numero());
            ps.setString(2, fac.getId_proveedor());
            ps.setString(3, fac.getFac_fecha_factura());
            ps.setInt(4, fac.getFac_estado());
            ps.setInt(5, fac.getIdfactura());
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
