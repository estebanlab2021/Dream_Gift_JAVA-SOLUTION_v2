package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConsultasPacks;
import modelo.Packs;
import vista.MenuMaestro;

/**
 ** Cristian Alvarado
 */
public class CtrlPacks implements ActionListener{
    private Packs mod1;
    private ConsultasPacks modC1;
    private MenuMaestro vistaA1;
    
    public CtrlPacks(Packs mod1, ConsultasPacks modC1, MenuMaestro vistaA1){
        this.mod1 = mod1;
        this.modC1 = modC1;
        this.vistaA1 = vistaA1;
        this.vistaA1.btnIngresaPack.addActionListener(this);
        this.vistaA1.rbtnActivaPack.addActionListener(this);
        this.vistaA1.rbtnInactivaPack.addActionListener(this);
        this.vistaA1.btnModPack.addActionListener(this);
        this.vistaA1.btnLimPack.addActionListener(this);
        this.vistaA1.btnAgregarArt.addActionListener(this);
        this.vistaA1.btnQuitarArt.addActionListener(this); 
    }
    
    public void iniciar(){
        vistaA1.setTitle("Menu Principal");
        vistaA1.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaA1.btnIngresaPack){
            mod1.setId_categoria_pack(Integer.parseInt(vistaA1.txtIdCategoriaP.getText()));
            mod1.setPck_nombre(vistaA1.txtPckNombre.getText());
            mod1.setPck_costo(Double.parseDouble(vistaA1.txtCostoPack.getText()));
            mod1.setPck_stock(Integer.parseInt(vistaA1.txtStockPack.getText()));
            mod1.setEstado(Integer.parseInt(vistaA1.guardarRBtnPack()));
            try {
                if(modC1.registrar(mod1)){
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlPacks.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        if(e.getSource() == vistaA1.btnModPack){
            mod1.setIdpack(Integer.parseInt(vistaA1.txtIdPack.getText()));
            mod1.setId_categoria_pack(Integer.parseInt(vistaA1.txtIdCategoriaP.getText()));
            mod1.setPck_nombre(vistaA1.txtPckNombre.getText());
            mod1.setPck_costo(Double.parseDouble(vistaA1.txtCostoPack.getText()));
            mod1.setPck_stock(Integer.parseInt(vistaA1.txtStockPack.getText()));
            mod1.setEstado(Integer.parseInt(vistaA1.guardarRBtnPack()));
            try {
                if(modC1.modificar(mod1)){
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlPacks.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
        if(e.getSource() == vistaA1.btnLimPack){
            limpiar();
        }
    }
    
    public void limpiar(){
        vistaA1.txtIdPack.setText(null);
        vistaA1.txtIdCategoriaP.setText(null);
        vistaA1.buttonGroupPack.clearSelection();
        vistaA1.txtPckNombre.setText(null);
        vistaA1.txtCostoPack.setText(null);
        vistaA1.txtStockPack.setText(null);
        vistaA1.txtCantArt.setText(null);
    }
}
