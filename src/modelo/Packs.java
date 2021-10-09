package modelo;
/**
 ***** Cristian Alvarado
 */
public class Packs {
private int idpack;
private int id_categoria_pack;
private String pck_nombre;
private double pck_costo;
private int pck_stock;
private int estado;

    public int getIdpack() {
        return idpack;
    }

    public void setIdpack(int idpack) {
        this.idpack = idpack;
    }

    public int getId_categoria_pack() {
        return id_categoria_pack;
    }

    public void setId_categoria_pack(int id_categoria_pack) {
        this.id_categoria_pack = id_categoria_pack;
    }

    public String getPck_nombre() {
        return pck_nombre;
    }

    public void setPck_nombre(String pck_nombre) {
        this.pck_nombre = pck_nombre;
    }

    public double getPck_costo() {
        return pck_costo;
    }

    public void setPck_costo(double pck_costo) {
        this.pck_costo = pck_costo;
    }

    public int getPck_stock() {
        return pck_stock;
    }

    public void setPck_stock(int pck_stock) {
        this.pck_stock = pck_stock;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }



}
