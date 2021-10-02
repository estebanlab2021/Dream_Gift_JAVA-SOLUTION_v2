
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;



public class Cat_Articulo {
    
    private int idcategoria_articulo;
    private String categoria_articulo;
    private int estado;
    

    public int getIdcategoria_articulo() {
        return idcategoria_articulo;
    }

    public void setIdcategoria_articulo(int idcategoria_articulo) {
        this.idcategoria_articulo = idcategoria_articulo;
    }

    public String getCategoria_articulo() {
        return categoria_articulo;
    }

    public void setCategoria_articulo(String categoria_articulo) {
        this.categoria_articulo = categoria_articulo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    //Metodo para Agregar datos al ComboBOXArticulo
    public static ArrayList<String> MostrarCategoriasArt(){
       
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        
        ArrayList<String> datos = new ArrayList<String>();
        
        try{
            
            String sql = "SELECT * FROM categoria_articulo";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                datos.add(rs.getString("categoria_articulo"));
            }
            
            rs.close();
            
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        
        return datos;
        
    }
    
    //Metodo para agregar datos a la tabla TableCategoriaArt
    
    
    
}
