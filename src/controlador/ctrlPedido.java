
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.ConsultasPedidos;
import modelo.Detalle_orden_compra;
import modelo.Pedido;
import vista.compras;


public class ctrlPedido implements ActionListener{
    private Pedido ped;
    private Detalle_orden_compra com;
    private ConsultasPedidos pedC;
    private compras vistaC;
    
    public ctrlPedido(Pedido ped, Detalle_orden_compra com, ConsultasPedidos pedC, compras vistaC){
        this.ped = ped;
        this.com = com;
        this.pedC = pedC;
        this.vistaC = vistaC;
        this.vistaC.btnIngresarPedido.addActionListener(this);
        this.vistaC.btnGuardarPedido.addActionListener(this);
        this.vistaC.btnModificarPedido.addActionListener(this);
        this.vistaC.btnLimpiarPedido.addActionListener(this);
        
        
    }
    
    public void iniciar(){
        vistaC.setTitle("Menu Pedido");
        vistaC.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        
        if(e.getSource() == vistaC.btnIngresarPedido){
            Date date = vistaC.FechaPedido.getDate();
            long d = date.getTime();
            java.sql.Date fecha = new java.sql.Date(d);
            ped.setFecha_orden_compra(fecha.toString());
            String estadoorden = "1";
            ped.setEdo_orden_compra(Integer.parseInt(estadoorden));
            try {
                if(pedC.agregarPedido(ped)){
                    JOptionPane.showMessageDialog(null, "Pedido INGRESADO");
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR AL INGRESAR PEDIDO");
                }
            }catch (SQLException ex){
                Logger.getLogger(ctrlPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        if(e.getSource() == vistaC.btnGuardarPedido){
            //int indice = vistaC.ListArticulosPedido.getLastVisibleIndex();
            //vistaC.txtPrueba.setText(String.valueOf(indice));
            //DefaultListModel modelo1 = new DefaultListModel();
            //vistaC.ListArticulosPedido.setModel(modelo1);
            //vistaC.txtPrueba.setText(vistaC.ListArticulosPedido.getSelectedValue());
            //vistaC.traerIdArticulo();
            
            com.setId_orden_compra_pk(Integer.parseInt(vistaC.txtIdPedido.getText()));
            com.setId_articulo_pk(Integer.parseInt(vistaC.txtIdArticulo.getText()));
            com.setCantidades(Integer.parseInt(vistaC.txtCantidad.getText()));
            try {
                if(pedC.actualizarPedido(com)){
                    JOptionPane.showMessageDialog(null, "Pedido Registrado");
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
                }
            }catch (SQLException ex){
                Logger.getLogger(ctrlPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(e.getSource() == vistaC.btnModificarPedido){
            Date date1 = vistaC.FechaPedido.getDate();
            long d1 = date1.getTime();
            java.sql.Date fecha1 = new java.sql.Date(d1);
            ped.setFecha_orden_compra(fecha1.toString());
            ped.setEdo_orden_compra(Integer.parseInt(vistaC.guardarRadioBotonEdoPedido()));
            ped.setIdorden_compra(Integer.parseInt(vistaC.txtIdPedido.getText()));
            try{
                if(pedC.modificarPedido(ped)){
                    JOptionPane.showMessageDialog(null, "Pedido MODIFICADO");
                    limpiarPedido();
                }else{
                    JOptionPane.showMessageDialog(null, "ERROR AL MODIFICAR");
                    limpiarPedido();
                }
            }catch (SQLException ex){
                Logger.getLogger(ctrlFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == vistaC.btnLimpiarPedido){
            limpiarPedido();
        }
    }
    
    //btnLimpiarPedido
    public void limpiarPedido(){
        vistaC.txtIdPedido.setText(null);
        vistaC.FechaPedido.setCalendar(null);
        vistaC.buttonGroupEdoPedido.clearSelection();
        vistaC.FechaPedido.setEnabled(true);
        vistaC.RadioButtonActivoPedido.setEnabled(false);
        vistaC.txtIdPedido.setEditable(false);
        vistaC.btnModificarPedido.setEnabled(false);
    }
    
    
}
