
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cat_Venta;
import modelo.ConsultasCatVentas;
import vista.MenuMaestro;

public class CtrlCategoriaVenta implements ActionListener {
    
    private Cat_Venta mod9;
    private ConsultasCatVentas modC9;
    private MenuMaestro vistaA;
    
    public CtrlCategoriaVenta(Cat_Venta mod9, ConsultasCatVentas modC9, MenuMaestro vistaA){
        
        this.mod9 = mod9;
        this.modC9 = modC9;
        this.vistaA = vistaA;
        this.vistaA.btnIngresarCatVenta.addActionListener(this);
        this.vistaA.btnModificarCatVenta.addActionListener(this);
        this.vistaA.btnLimpiarCatVenta.addActionListener(this);
        String estadobtn = null;
    }

    public void iniciar(){
        vistaA.setTitle("Menu Maestro");
        vistaA.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vistaA.btnIngresarCatVenta){
            mod9.setEst_descripcion(vistaA.txtCatVenta.getText());
           // mod9.setIdestados_venta(Integer.parseInt(vistaA.txtIdCatVenta.getText()));
            
            
            try {
                if(modC9.registrar(mod9)){
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    //limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlCategoriaVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == vistaA.btnModificarCatVenta){
            mod9.setIdestados_venta(Integer.parseInt(vistaA.txtIdCatVenta.getText()));
            mod9.setEst_descripcion(vistaA.txtCatVenta.getText());
           // mod9.setCategoria_venta(vistaA.txtCodigoCatVenta.getText());
            
            try {
                if(modC9.modificar(mod9)){
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlCategoriaVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        if(e.getSource() == vistaA.btnLimpiarCatVenta){
            limpiar();
        }
        
        
    }
    
    public void limpiar(){
        vistaA.txtIdCatVenta.setText(null);
        vistaA.txtCatVenta.setText(null);
      //  vistaA.txtCodigoCatVenta.setText(null);
        vistaA.txtBuscarCatVenta.setText(null);
        
    }
    
    
    
}
