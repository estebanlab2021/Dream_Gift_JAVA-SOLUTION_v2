
package modelo;


public class ArticuloHasPack {
    private int id_detalle;
    private int id_articulo_art;
    private int id_pack_pck;
    private int cantidad;

    public int getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(int id_detalle) {
        this.id_detalle = id_detalle;
    }

    public int getId_articulo_art() {
        return id_articulo_art;
    }

    public void setId_articulo_art(int id_articulo_art) {
        this.id_articulo_art = id_articulo_art;
    }

    public int getId_pack_pck() {
        return id_pack_pck;
    }

    public void setId_pack_pck(int id_pack_pck) {
        this.id_pack_pck = id_pack_pck;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
