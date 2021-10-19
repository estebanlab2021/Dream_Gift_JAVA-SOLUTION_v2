package modelo;


public class Factura {
    private int idfactura;
    private int fac_numero;
    private String fac_fecha_factura;
    private int id_roden_compra;
    private String id_proveedor;

    public int getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(int idfactura) {
        this.idfactura = idfactura;
    }

    public int getFac_numero() {
        return fac_numero;
    }

    public void setFac_numero(int fac_numero) {
        this.fac_numero = fac_numero;
    }

    public String getFac_fecha_factura() {
        return fac_fecha_factura;
    }

    public void setFac_fecha_factura(String fac_fecha_factura) {
        this.fac_fecha_factura = fac_fecha_factura;
    }

    public int getId_roden_compra() {
        return id_roden_compra;
    }

    public void setId_roden_compra(int id_roden_compra) {
        this.id_roden_compra = id_roden_compra;
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    
    
    
}
