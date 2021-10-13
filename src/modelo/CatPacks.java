package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 ******"Cristian Alvarado"*******
 */

public class CatPacks {
    
private int idcategoria_pack;
private String categoria_pack;
private int estado_pack;

    public int getIdcategoria_pack() {
        return idcategoria_pack;
    }

    public void setIdcategoria_pack(int idcategoria_pack) {
        this.idcategoria_pack = idcategoria_pack;
    }

    public String getCategoria_pack() {
        return categoria_pack;
    }

    public void setCategoria_pack(String categoria_pack) {
        this.categoria_pack = categoria_pack;
    }

    public int getEstado_pack() {
        return estado_pack;
    }

    public void setEstado_pack(int estado_pack) {
        this.estado_pack = estado_pack;
    }

//Metodo para Agregar datos al ComboBOXArticulo
    public static ArrayList<String> MostrarCategoriasPack(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConexion();
        ArrayList<String> datos = new ArrayList<String>();
        try{
            String sql = "SELECT * FROM categoria_pack";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                datos.add(rs.getString("categoria_pack"));
            }
            rs.close();
        }catch(SQLException ex){
            System.err.println(ex.toString());
        }
        return datos;
    }

}
