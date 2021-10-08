
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConsultasVentas;
import modelo.ModVentas;
import vista.ventas;


public class ctrlVentas implements ActionListener{
    
    //Llamamos a las clases que hemos creado
    private ModVentas mod1;
    private ConsultasVentas modC1;
    private ventas vistaA1;
    
    public ctrlVentas(ModVentas mod1, ConsultasVentas modC1, ventas vistaA1){
        
        this.mod1 = mod1;
        this.modC1 = modC1;
        this.vistaA1 = vistaA1;
        this.vistaA1.btnRegistrarPedido.addActionListener(this);
        
    
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== vistaA1.btnRegistrarPedido){
            mod1.setRut_cliente(vistaA1.txtRutCliente.getText());
            mod1.setId_rrss(Integer.parseInt(vistaA1.txtIdRRSS.getText()));
            mod1.setId_pack(Integer.parseInt(vistaA1.txtPack.getText()));
            String estadoventa = "4";
            mod1.setId_estados_venta(Integer.parseInt(estadoventa));
            mod1.setVta_nombre_destinatario(vistaA1.txtNombreDestinatario.getText());
            Date date = vistaA1.FechaEntrega.getDate();
            long d = date.getTime();
            java.sql.Date fecha = new java.sql.Date(d);
            mod1.setVta_fecha_entrega(fecha.toString());
            mod1.setVta_direccion_destinatario(vistaA1.txtDireccionDestinatario.getText());
            mod1.setId_comuna(Integer.parseInt(vistaA1.txtComunas.getText()));
            mod1.setVta_saludo(vistaA1.txtSaludo.getText());
            mod1.setVta_hora_entrega_inicial(vistaA1.ComboBoxHoraInicio.getSelectedItem().toString());
            mod1.setVta_hora_entrega_final(vistaA1.ComboBoxHoraFinal.getSelectedItem().toString());
            //mod1.setVta_hora_entrega_inicial(vistaA1.txtHoraIni.getText());
            //mod1.setVta_hora_entrega_final(vistaA1.txtHoraFin.getText());
            String edoBanco = "3";
            mod1.setId_banco(Integer.parseInt(edoBanco));
            
            try {
                if(modC1.registrarPedido(mod1)){
                JOptionPane.showMessageDialog(null, "Pedido Registrado");
                //limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR");
                //limpiar();
            }
                } catch (SQLException ex) {
                Logger.getLogger(ctrlVentas.class.getName()).log(Level.SEVERE, null, ex);
            
                }
        }
        
    }
    
}