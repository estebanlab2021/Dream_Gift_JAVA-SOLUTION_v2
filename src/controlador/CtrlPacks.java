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
    //Llamamos a las clases que hemos creado
    private Packs mod1;
    private ConsultasPacks modC1;
    private MenuMaestro vistaA1;
    
    
    public CtrlPacks(Packs mod1, ConsultasPacks modC1, MenuMaestro vistaA1){
        
        this.mod1 = mod1;
        this.modC1 = modC1;
        this.vistaA1 = vistaA1;
        this.vistaA1.btnIngresaPack.addActionListener(this);
        this.vistaA1.rbtnActivaPack.addActionListener(this);
        this.vistaA1.RBtnInactivo.addActionListener(this);
        this.vistaA1.btnModPack.addActionListener(this);
        this.vistaA1.btnLimPack.addActionListener(this);
        
    }
    
    
    public void iniciar(){
        vistaA1.setTitle("Menu Principal");
        vistaA1.setLocationRelativeTo(null);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaA1.btnIngresaPack){
            mod1.setId_categoria_pack(Integer.parseInt(vistaA1.txtIdCategoriaP.getText()));
           // mod1.setCodigoRS(vistaA1.txtCodigoRs.getText());
            mod1.setEstado(Integer.parseInt(vistaA1.guardarRadioBotonRRSS()));
            
            try {
                if(modC1.registrar(mod1)){
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlRRSS.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(e.getSource() == vistaA1.btnModRrss){
           // mod1.setIdrrss(Integer.parseInt(vistaA1.txtIdRrss.getText()));
           // mod1.setRrss_nombre(vistaA1.txtRRSS.getText());
           // mod1.setCodigoRS(vistaA1.txtCodigoRs.getText());
            mod1.setEstado(Integer.parseInt(vistaA1.guardarRadioBotonRRSS()));
            
            try {
                if(modC1.modificar(mod1)){
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    //System.out.println(modC1.modificar());
                    //limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlRRSS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
        if(e.getSource() == vistaA1.btnLimpiarRrss){
            limpiar();
        }
        
        
    }
    
    public void limpiar(){
        vistaA1.txtIdRrss.setText(null);
        vistaA1.txtRRSS.setText(null);
        vistaA1.buttonGroupRRSS.clearSelection();
        vistaA1.txtCodigoRs.setText(null);
                
    }
    
}
