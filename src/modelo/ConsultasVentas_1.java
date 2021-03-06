
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConsultasVentas_1 extends Conexion{
    
    
    public boolean registrarPedido(ModVentas vtn) throws SQLException{
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql ="INSERT INTO venta (rut_cliente, id_rrss, id_pack, id_estados_venta, vta_nombre_destinatario, vta_fecha_entrega, vta_direccion_destinatario, id_comuna, vta_saludo, vta_hora_entrega_inicial, vta_hora_entrega_final) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, vtn.getRut_cliente());
            ps.setInt(2, vtn.getId_rrss());
            ps.setInt(3, vtn.getId_pack());
            ps.setInt(4, vtn.getId_estados_venta());
            ps.setString(5, vtn.getVta_nombre_destinatario());
            ps.setString(6, vtn.getVta_fecha_entrega());
            ps.setString(7, vtn.getVta_direccion_destinatario());
            ps.setInt(8, vtn.getId_comuna());
            ps.setString(9, vtn.getVta_saludo());
            ps.setString(10, vtn.getVta_hora_entrega_inicial());
            ps.setString(11, vtn.getVta_hora_entrega_final());

            
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
