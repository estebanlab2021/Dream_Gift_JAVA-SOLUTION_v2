/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class Cliente {
    
    String Rut;
    String cli_nombre;
    String cli_apellido;
    String cli_direccion;
    int cli_telefono;
    String fecha_nac;
    int estado;
    String cli_mail;

    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getCli_nombre() {
        return cli_nombre;
    }

    public void setCli_nombre(String cli_nombre) {
        this.cli_nombre = cli_nombre;
    }

    public String getCli_apellido() {
        return cli_apellido;
    }

    public void setCli_apellido(String cli_apellido) {
        this.cli_apellido = cli_apellido;
    }

    public String getCli_direccion() {
        return cli_direccion;
    }

    public void setCli_direccion(String cli_direccion) {
        this.cli_direccion = cli_direccion;
    }

    public int getCli_telefono() {
        return cli_telefono;
    }

    public void setCli_telefono(int cli_telefono) {
        this.cli_telefono = cli_telefono;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCli_mail() {
        return cli_mail;
    }

    public void setCli_mail(String cli_mail) {
        this.cli_mail = cli_mail;
    }
    
    
    
}