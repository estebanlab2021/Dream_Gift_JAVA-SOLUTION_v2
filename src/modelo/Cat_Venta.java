
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;


public class Cat_Venta {
    private int idestado_venta;
    private String est_descripcion;

    public int getIdestado_venta() {
        return idestado_venta;
    }

    public void setIdestado_venta(int idestado_venta) {
        this.idestado_venta = idestado_venta;
    }

    public String getEst_descripcion() {
        return est_descripcion;
    }

    public void setEst_descripcion(String est_descripcion) {
        this.est_descripcion = est_descripcion;
    }
    


    
}
