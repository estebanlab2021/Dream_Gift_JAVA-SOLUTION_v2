
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Articulos;
import modelo.ConsultasArticulos;
import vista.MenuMaestro;


public class CtrlArticulo implements ActionListener{
    
    //Llamamos a las clases que hemos creado
    private Articulos mod;
    private ConsultasArticulos modC;
    private MenuMaestro vistaA;
    
    
    public CtrlArticulo(Articulos mod, ConsultasArticulos modC, MenuMaestro vistaA){
        
        this.mod = mod;
        this.modC = modC;
        this.vistaA = vistaA;
        this.vistaA.btnIngregarArticulo.addActionListener(this);
        this.vistaA.btnModificarArticulo.addActionListener(this);
        this.vistaA.btnLimpiarArticulo.addActionListener(this);
    
    }
    
    
    public void iniciar(){
        vistaA.setTitle("Menu Principal");
        vistaA.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaA.btnIngregarArticulo){
            //mod.setIdarticulo(Integer.parseInt(vistaA.txtIdart.getText()));
            mod.setId_categoria_articulo(Integer.parseInt(vistaA.txtCategoriaArt.getText()));
            mod.setArt_descripcion(vistaA.txtNombreArticulo.getText());
            mod.setArt_stock(Integer.parseInt(vistaA.txtStockArticulo.getText()));
            
            if(vistaA.txtFechaArticulo.isVisible()==true){
                mod.setArt_fecha_vencimiento(vistaA.txtFechaArticulo.getText());
            }else{
                mod.setArt_fecha_vencimiento(vistaA.txtDefaul.getText());
            }
            //mod.setArt_fecha_vencimiento(vistaA.txtFechaArticulo.getText());
            mod.setArt_estado(Integer.parseInt(vistaA.guardarRadioButtonArticulo()));
            
            try {
                if(modC.registrar(mod)){
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlArticulo.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(e.getSource() == vistaA.btnModificarArticulo){
            mod.setIdarticulo(Integer.parseInt(vistaA.txtIdArticulo.getText()));
            mod.setId_categoria_articulo(Integer.parseInt(vistaA.txtCategoriaArt.getText()));
            mod.setArt_descripcion(vistaA.txtNombreArticulo.getText());
            mod.setArt_stock(Integer.parseInt(vistaA.txtStockArticulo.getText()));
            mod.setArt_fecha_vencimiento(vistaA.txtFechaArticulo.getText());
            mod.setArt_estado(Integer.parseInt(vistaA.guardarRadioButtonArticulo()));
            
            try {
                if(modC.modificar(mod)){
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    //System.out.println(modC1.modificar());
                    limpiarArt();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                    limpiarArt();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlCategoriaArticulo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == vistaA.btnLimpiarArticulo){
            limpiarArt();
        }
        
    }
    
    
    public void limpiarArt(){
        vistaA.txtIdArticulo.setText(null);
        vistaA.txtCategoriaArt.setText(null);
        vistaA.txtNombreArticulo.setText(null);
        vistaA.txtStockArticulo.setText(null);
        vistaA.txtFechaArticulo.setText(null);
        vistaA.ComboBoxArticulo.setSelectedIndex(0);
        vistaA.CheckBoxVencimientoArticulo.setSelected(false);
        //vistaA.CheckBoxVencimientoArticulo.doClick();
        vistaA.buttonGroupArticulos.clearSelection();
        
    }
    
}
