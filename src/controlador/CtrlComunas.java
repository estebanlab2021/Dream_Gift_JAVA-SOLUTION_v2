package controlador;

//*** @author Jessica *********
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Comunas;
import modelo.ConsultasComunas;
import vista.MenuMaestro;

public class CtrlComunas implements ActionListener{
    
    //Llamamos a las clases que hemos creado
    private final Comunas mod1;
    private final ConsultasComunas modC1;
    private final MenuMaestro vistaA;
    
    
    public CtrlComunas(Comunas mod1, ConsultasComunas modC1, MenuMaestro vistaA){
        
        this.mod1 = mod1;
        this.modC1 = modC1;
        this.vistaA = vistaA;
        this.vistaA.btnIngresarComuna.addActionListener(this);
        this.vistaA.btnModComuna.addActionListener(this);
        this.vistaA.btnLimpiarComuna.addActionListener(this);
        this.vistaA.rbtnInactivoComuna.addActionListener(this);
        this.vistaA.rbtnActivoComuna .addActionListener(this);
        String estadobtn = null;
    }
    
    
    public void iniciar(){
        vistaA.setTitle("Menu Principal");
        vistaA.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaA.btnIngresarComuna){
            mod1.setCodigo_comunas(vistaA.txtCodigoComuna.getText());
            mod1.setNombre_comunas(vistaA.txtNombreComuna.getText());
            mod1.setCom_estado(Integer.parseInt(vistaA.guardarRadioBotonComunas()));
            
            try {
                if(modC1.registrar(mod1)){
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlComunas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(e.getSource() == vistaA.btnModComuna){
            mod1.setIdcomunas(Integer.parseInt(vistaA.txtIdComunas.getText()));
            mod1.setCodigo_comunas(vistaA.txtCodigoComuna.getText());
            mod1.setNombre_comunas(vistaA.txtNombreComuna.getText());
            mod1.setCom_estado(Integer.parseInt(vistaA.guardarRadioBotonComunas()));
            
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
                Logger.getLogger(CtrlComunas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == vistaA.btnLimpiarComuna){
            limpiar();
        }
        
        
    }
    
    public void limpiar(){
        vistaA.txtIdComunas.setText(null);
        vistaA.txtNombreComuna.setText(null);
        vistaA.btnGroupComunas.clearSelection();
        vistaA.txtCodigoComuna.setText(null);
                
    }
    
}
