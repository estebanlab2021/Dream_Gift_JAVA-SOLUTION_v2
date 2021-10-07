
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;


public class Cat_Venta {
    private int idestados_venta;
    private String est_descripcion;

    public int getIdestados_venta() {
        return idestados_venta;
    }

    public void setIdestados_venta(int idestados_venta) {
        this.idestados_venta = idestados_venta;
    }

    public String getEst_descripcion() {
        return est_descripcion;
    }

    public void setEst_descripcion(String est_descripcion) {
        this.est_descripcion = est_descripcion;
    }

   
    


    
}
