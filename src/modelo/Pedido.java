
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Pedido {
    private int idorden_compra;
    private String fecha_orden_compra;
    private int edo_orden_compra;

    public int getIdorden_compra() {
        return idorden_compra;
    }

    public void setIdorden_compra(int idorden_compra) {
        this.idorden_compra = idorden_compra;
    }

    public String getFecha_orden_compra() {
        return fecha_orden_compra;
    }

    public void setFecha_orden_compra(String fecha_orden_compra) {
        this.fecha_orden_compra = fecha_orden_compra;
    }

    public int getEdo_orden_compra() {
        return edo_orden_compra;
    }

    public void setEdo_orden_compra(int edo_orden_compra) {
        this.edo_orden_compra = edo_orden_compra;
    }
    
    
    
    //Metodo para Agregar datos al ListArticulos de Pedidos
    public static ArrayList<String> MostrarListadoArticulos(){
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        ArrayList<String> datos = new ArrayList<String>();
        
        try{
            
            String sql = "SELECT * FROM articulo";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                datos.add(rs.getString("art_descripcion"));
            }
            
            rs.close();
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        
        return datos;
        
    }
    
    //Metodo para Agregar datos al ListArticulos de Proveedores
    public static ArrayList<String> MostrarListadoProveedores(){
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        ArrayList<String> datos = new ArrayList<String>();
        
        try{
            
            String sql = "SELECT * FROM proveedor";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                datos.add(rs.getString("razon_social"));
            }
            
            rs.close();
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        
        return datos;
        
    }
    
    //Metodo para Agregar datos al ListArticulos de DetalleFactura
    public static ArrayList<String> MostrarListadoArticulosFactura(){
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        ArrayList<String> datos = new ArrayList<String>();
        
        try{
            
            String sql = "SELECT detalle_factura.id_factura_pk, detalle_factura.id_articulo_pk, articulo.art_descripcion, detalle_factura.det_cantidad, det_valor, detalle_factura.fecha_vencimiento FROM detalle_factura JOIN articulo ON detalle_factura.id_articulo_pk = articulo.idarticulo";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                datos.add(rs.getString("art_descripcion"));
            }
            
            rs.close();
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        
        return datos;
        
    }
    
    
}
