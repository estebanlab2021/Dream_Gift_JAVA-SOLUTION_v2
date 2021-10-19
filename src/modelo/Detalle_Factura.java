
package modelo;


public class Detalle_Factura {
    private int iddetalle_factura;
    private int id_factura_pk;
    private int id_articulo_pk;
    private int det_cantidad;
    private Double det_valor;
    private String fecha_vencimiento;

    public int getIddetalle_factura() {
        return iddetalle_factura;
    }

    public void setIddetalle_factura(int iddetalle_factura) {
        this.iddetalle_factura = iddetalle_factura;
    }

    public int getId_factura_pk() {
        return id_factura_pk;
    }

    public void setId_factura_pk(int id_factura_pk) {
        this.id_factura_pk = id_factura_pk;
    }

    public int getId_articulo_pk() {
        return id_articulo_pk;
    }

    public void setId_articulo_pk(int id_articulo_pk) {
        this.id_articulo_pk = id_articulo_pk;
    }

    public int getDet_cantidad() {
        return det_cantidad;
    }

    public void setDet_cantidad(int det_cantidad) {
        this.det_cantidad = det_cantidad;
    }

    public Double getDet_valor() {
        return det_valor;
    }

    public void setDet_valor(Double det_valor) {
        this.det_valor = det_valor;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
    
    
    
}
