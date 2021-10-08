
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ModVentas {
    
    private int idventa;
    private String rut_cliente;
    private int id_pack;
    private int id_banco;
    private int id_rrss;
    private int id_estados_venta;
    private int id_comuna;
    private double vta_total;
    private String vta_fecha_venta;
    private String vta_fecha_transferencia;
    private int vta_codigo_transferencia;
    private int estado;
    private String vta_nombre_destinatario;
    private String vta_direccion_destinatario;
    private String vta_telefono;
    private int comuna;
    private String vta_correo;
    private String vta_fecha_entrega;
    private String vta_hora_entrega_inicial;
    private String vta_hora_entrega_final;
    private String vta_saludo;

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public String getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(String rut_cliente) {
        this.rut_cliente = rut_cliente;
    }

    public int getId_pack() {
        return id_pack;
    }

    public void setId_pack(int id_pack) {
        this.id_pack = id_pack;
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public int getId_rrss() {
        return id_rrss;
    }

    public void setId_rrss(int id_rrss) {
        this.id_rrss = id_rrss;
    }

    public int getId_estados_venta() {
        return id_estados_venta;
    }

    public void setId_estados_venta(int id_estados_venta) {
        this.id_estados_venta = id_estados_venta;
    }

    public int getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    public double getVta_total() {
        return vta_total;
    }

    public void setVta_total(double vta_total) {
        this.vta_total = vta_total;
    }

    public String getVta_fecha_venta() {
        return vta_fecha_venta;
    }

    public void setVta_fecha_venta(String vta_fecha_venta) {
        this.vta_fecha_venta = vta_fecha_venta;
    }

    public String getVta_fecha_transferencia() {
        return vta_fecha_transferencia;
    }

    public void setVta_fecha_transferencia(String vta_fecha_transferencia) {
        this.vta_fecha_transferencia = vta_fecha_transferencia;
    }

    public int getVta_codigo_transferencia() {
        return vta_codigo_transferencia;
    }

    public void setVta_codigo_transferencia(int vta_codigo_transferencia) {
        this.vta_codigo_transferencia = vta_codigo_transferencia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getVta_nombre_destinatario() {
        return vta_nombre_destinatario;
    }

    public void setVta_nombre_destinatario(String vta_nombre_destinatario) {
        this.vta_nombre_destinatario = vta_nombre_destinatario;
    }

    public String getVta_direccion_destinatario() {
        return vta_direccion_destinatario;
    }

    public void setVta_direccion_destinatario(String vta_direccion_destinatario) {
        this.vta_direccion_destinatario = vta_direccion_destinatario;
    }

    public String getVta_telefono() {
        return vta_telefono;
    }

    public void setVta_telefono(String vta_telefono) {
        this.vta_telefono = vta_telefono;
    }

    public int getComuna() {
        return comuna;
    }

    public void setComuna(int comuna) {
        this.comuna = comuna;
    }

    public String getVta_correo() {
        return vta_correo;
    }

    public void setVta_correo(String vta_correo) {
        this.vta_correo = vta_correo;
    }

    public String getVta_fecha_entrega() {
        return vta_fecha_entrega;
    }

    public void setVta_fecha_entrega(String vta_fecha_entrega) {
        this.vta_fecha_entrega = vta_fecha_entrega;
    }

    public String getVta_hora_entrega_inicial() {
        return vta_hora_entrega_inicial;
    }

    public void setVta_hora_entrega_inicial(String vta_hora_entrega_inicial) {
        this.vta_hora_entrega_inicial = vta_hora_entrega_inicial;
    }

    public String getVta_hora_entrega_final() {
        return vta_hora_entrega_final;
    }

    public void setVta_hora_entrega_final(String vta_hora_entrega_final) {
        this.vta_hora_entrega_final = vta_hora_entrega_final;
    }

    public String getVta_saludo() {
        return vta_saludo;
    }

    public void setVta_saludo(String vta_saludo) {
        this.vta_saludo = vta_saludo;
    }
    
    //Esto deberia estan en consultas Banco
    //Metodo para Agregar datos al ComboBOXBanco
    public static ArrayList<String> MostrarListadoBanco(){
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        ArrayList<String> datos = new ArrayList<String>();
        
        try{
            
            String sql = "SELECT * FROM banco";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                datos.add(rs.getString("ban_nombre"));
            }
            
            rs.close();
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        
        return datos;
        
    }
    
    //Esto deberia estan en consultas Estados de  Venta
    //Metodo para Agregar datos al ComboBoxEstadosVenta
    public static ArrayList<String> MostrarListadoEstadosVenta(){
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        ArrayList<String> datos = new ArrayList<String>();
        
        try{
            
            String sql = "SELECT * FROM estados_venta";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                datos.add(rs.getString("est_descripcion"));
            }
            
            rs.close();
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        
        return datos;
        
    }
    
    //Esto deberia estan en consultas Pack
    //Metodo para Agregar datos al ComboBoxPack
    public static ArrayList<String> MostrarListadoPack(){
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        ArrayList<String> datos = new ArrayList<String>();
        
        try{
            
            String sql = "SELECT * FROM pack";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                datos.add(rs.getString("pck_nombre"));
            }
            
            rs.close();
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        
        return datos;
        
    }
    
    //Esto deberia estan en consultas Comunas
    //Metodo para Agregar datos al ComboBoxComuna
    public static ArrayList<String> MostrarListadoComuna(){
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        ArrayList<String> datos = new ArrayList<String>();
        
        try{
            
            String sql = "SELECT * FROM comunas";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                datos.add(rs.getString("nombre_comunas"));
            }
            
            rs.close();
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        
        return datos;
        
    }
    
    //Esto deberia estan en consultas RRSS
    //Metodo para Agregar datos al ComboBoxRRSS
    public static ArrayList<String> MostrarListadoRRSS(){
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        ArrayList<String> datos = new ArrayList<String>();
        
        try{
            
            String sql = "SELECT * FROM rrss";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                datos.add(rs.getString("rrss_nombre"));
            }
            
            rs.close();
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        
        return datos;
        
    }
    
    //Esto deberia estan en consultas EstadosEntrega
    //Metodo para Agregar datos al ComboBoxEdoEntrega
    public static ArrayList<String> MostrarListadoEdoEntrega(){
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        ArrayList<String> datos = new ArrayList<String>();
        
        try{
            
            String sql = "SELECT * FROM estados_despacho";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                datos.add(rs.getString("estados_despacho_name"));
            }
            
            rs.close();
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        
        return datos;
        
    }
    
    
}
