
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConsultasFacturas;
import modelo.Detalle_Factura;
import modelo.Factura;
import vista.compras;


public class ctrlFactura implements ActionListener{
    private Factura fac;
    private Detalle_Factura detfac;
    private ConsultasFacturas confac;
    private compras vistaC;
    
    public ctrlFactura (Factura fac, Detalle_Factura detfac, ConsultasFacturas confac, compras vistaC){
        this.fac = fac;
        this.detfac = detfac;
        this.confac = confac;
        this.vistaC = vistaC;
        this.vistaC.btnGuardarRegCompra.addActionListener(this);
        this.vistaC.btnLimpiarRegCompra.addActionListener(this);
        this.vistaC.btnAgregaArtFact.addActionListener(this);
        this.vistaC.btnLimpiarArtFact.addActionListener(this);     
        this.vistaC.btnLimpiarRevisonFacturas.addActionListener(this);
        this.vistaC.btnModificarFac.addActionListener(this);
    }
    
    public void iniciar(){
        vistaC.setTitle("Menu Factura");
        vistaC.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaC.btnGuardarRegCompra){
            
            fac.setId_proveedor(vistaC.txtRUTProveedor.getText());
            fac.setFac_numero(Integer.parseInt(vistaC.txtNumFactura.getText()));
            fac.setId_roden_compra(Integer.parseInt(vistaC.txtOrdenPedido.getText()));
            Date date = vistaC.FechaRegCompra.getDate();
            long d = date.getTime();
            java.sql.Date fecha = new java.sql.Date(d);
            fac.setFac_fecha_factura(fecha.toString());
            
            try{
                if(confac.agregarFactura(fac)){
                    JOptionPane.showMessageDialog(null, "Factura Registrada");
                    limpiarRegFacProveedores();
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
                    limpiarRegFacProveedores();
                }
            }catch (SQLException ex){
                Logger.getLogger(ctrlFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == vistaC.btnAgregaArtFact){
            
            detfac.setId_factura_pk(Integer.parseInt(vistaC.txtCodigoFactura.getText()));
            detfac.setId_articulo_pk(Integer.parseInt(vistaC.txtIdArticuloFac.getText()));
            detfac.setDet_cantidad(Integer.parseInt(vistaC.txtCantidadFactura.getText()));
            detfac.setDet_valor(Double.parseDouble(vistaC.txtValorFactura.getText()));
            
            if(vistaC.FechaVencimiento.isEnabled()==true){
                Date date1 = vistaC.FechaVencimiento.getDate();
                long d1 = date1.getTime();
                java.sql.Date fecha1 = new java.sql.Date(d1);
                detfac.setFecha_vencimiento(fecha1.toString());
            }else{
                detfac.setFecha_vencimiento(vistaC.txtFechaDefault.getText());
            }
            //detfac.setFecha_vencimiento(fecha1.toString());
            
            try{
                if(confac.agregarDetalleFactura(detfac)){
                    JOptionPane.showMessageDialog(null, "Articulo Agregado");
                    limpiarDetalleFacArticulos();
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR AL AGREGAR ARTICULO");
                    limpiarDetalleFacArticulos();
                }
            }catch (SQLException ex){
                Logger.getLogger(ctrlFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ///vistaC.btnModificarFac
        if(e.getSource() == vistaC.btnModificarFac){
            
            fac.setFac_numero(Integer.parseInt(vistaC.txtNumFactura2.getText()));
            fac.setId_proveedor(vistaC.txtRUTProveedor2.getText());
            Date date2 = vistaC.FechaRegCompra2.getDate();
            long d2 = date2.getTime();
            java.sql.Date fecha2 = new java.sql.Date(d2);
            fac.setFac_fecha_factura(fecha2.toString());
            fac.setFac_estado(Integer.parseInt(vistaC.guardarRadioBotonEdoFactura()));
            fac.setIdfactura(Integer.parseInt(vistaC.txtIdFacturaRev.getText()));
            
            try{
                if(confac.modificarFactura(fac)){
                    JOptionPane.showMessageDialog(null, "FACTURA MODIFICADA");
                    limpiarRevisionFacturas();
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");
                    limpiarRevisionFacturas();
                }
            }catch (SQLException ex){
                Logger.getLogger(ctrlFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == vistaC.btnLimpiarRegCompra){
            limpiarRegFacProveedores();
        }
        
        if(e.getSource() == vistaC.btnLimpiarArtFact){
            limpiarDetalleFacArticulos();
        }
        
        if(e.getSource() == vistaC.btnLimpiarRevisonFacturas){
            limpiarRevisionFacturas();
        }
        
        
    }
    
    //btnLimpiarRegCompra
    public void limpiarRegFacProveedores(){
        vistaC.ComboBoxProveedor.setSelectedIndex(0);;
        vistaC.txtIdProveedor.setText(null);
        vistaC.txtRUTProveedor.setText(null);
        vistaC.txtNumFactura.setText(null);
        vistaC.FechaRegCompra.setCalendar(null);
        vistaC.txtOrdenPedido.setText(null);
    }
    
    //btnLimpiarArtFact
    public void limpiarDetalleFacArticulos(){
        vistaC.ComboBoxArticulo.setSelectedIndex(0);
        vistaC.txtCodigoFactura.setText(null);
        vistaC.txtIdArticuloFac.setText(null);
        vistaC.txtFechaDefault.setText(null);
        vistaC.txtCantidadFactura.setText(null);
        vistaC.txtValorFactura.setText(null);
        vistaC.FechaVencimiento.setCalendar(null);
        vistaC.CheckBoxSinVenc.setSelected(false);
    }
    
    //btnLimpiarRevisonFacturas
    public void limpiarRevisionFacturas(){
        vistaC.txtNumFactura2.setText(null);
        vistaC.txtRUTProveedor2.setText(null);
        vistaC.FechaRegCompra2.setCalendar(null);
        vistaC.ComboBoxProveedor2.setSelectedIndex(0);
        vistaC.txtIdProveedor2.setText(null);
        vistaC.txtIdFacturaRev.setText(null);
        vistaC.buttonGroupEdoFactura.clearSelection();
    }
}
