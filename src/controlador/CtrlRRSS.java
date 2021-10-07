
package controlador;

//*** @author calva
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConsultasRRSS;
import modelo.RRSS;
import vista.MenuMaestro;


public class CtrlRRSS implements ActionListener{
    //Llamamos a las clases que hemos creado
    private RRSS mod1;
    private ConsultasRRSS modC1;
    private MenuMaestro vistaA1;
    
    
    public CtrlRRSS(RRSS mod1, ConsultasRRSS modC1, MenuMaestro vistaA1){
        
        this.mod1 = mod1;
        this.modC1 = modC1;
        this.vistaA1 = vistaA1;
        this.vistaA1.btnIngresarRrss.addActionListener(this);
        this.vistaA1.RBtnActivo.addActionListener(this);
        this.vistaA1.RBtnInactivo.addActionListener(this);
        this.vistaA1.btnModRrss.addActionListener(this);
        this.vistaA1.btnLimpiarRrss.addActionListener(this);
        
    }
    
    
    public void iniciar(){
        vistaA1.setTitle("Menu Principal");
        vistaA1.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaA1.btnIngresarRrss){
            mod1.setRrss_nombre(vistaA1.txtRRSS.getText());
            mod1.setCodigoRS(vistaA1.txtCodigoRs.getText());
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
            mod1.setIdrrss(Integer.parseInt(vistaA1.txtIdRrss.getText()));
            mod1.setRrss_nombre(vistaA1.txtRRSS.getText());
            mod1.setCodigoRS(vistaA1.txtCodigoRs.getText());
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
