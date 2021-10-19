
package modelo;


public class Detalle_orden_compra {
    private int iddetalle_orden_compra;
    private int id_orden_compra_pk;
    private int id_articulo_pk;
    private int cantidades;
    private Double valor_articulo;

    public int getIddetalle_orden_compra() {
        return iddetalle_orden_compra;
    }

    public void setIddetalle_orden_compra(int iddetalle_orden_compra) {
        this.iddetalle_orden_compra = iddetalle_orden_compra;
    }

    public int getId_orden_compra_pk() {
        return id_orden_compra_pk;
    }

    public void setId_orden_compra_pk(int id_orden_compra_pk) {
        this.id_orden_compra_pk = id_orden_compra_pk;
    }

    public int getId_articulo_pk() {
        return id_articulo_pk;
    }

    public void setId_articulo_pk(int id_articulo_pk) {
        this.id_articulo_pk = id_articulo_pk;
    }

    public int getCantidades() {
        return cantidades;
    }

    public void setCantidades(int cantidades) {
        this.cantidades = cantidades;
    }

    public Double getValor_articulo() {
        return valor_articulo;
    }

    public void setValor_articulo(Double valor_articulo) {
        this.valor_articulo = valor_articulo;
    }
    
    
    
}
