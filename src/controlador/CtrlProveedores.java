
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConsultasProveedores;
import modelo.Proveedores;
import vista.MenuMaestro;


public class CtrlProveedores implements ActionListener{
    //Llamamos a las clases que hemos creado
    private Proveedores mod11;
    private ConsultasProveedores modC11;
    private MenuMaestro vistaA;
    
    
    public CtrlProveedores(Proveedores mod11, ConsultasProveedores modC11, MenuMaestro vistaA){
        
        this.mod11 = mod11;
        this.modC11 = modC11;
        this.vistaA = vistaA;
        this.vistaA.btnIngProv.addActionListener(this);
        this.vistaA.rbtnActivoProv.addActionListener(this);
        this.vistaA.rbtnInActivoProv.addActionListener(this);
        this.vistaA.btnModProv.addActionListener(this);
        this.vistaA.btnLimProv.addActionListener(this);
        
    }
    
    
    public void iniciar(){
        vistaA.setTitle("Menu Principal");
        vistaA.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaA.btnIngProv){
            mod11.setIdproveedor(vistaA.txtIdProv.getText());
            mod11.setPro_nombre(vistaA.txtNombreProv.getText());
            mod11.setPro_telefono(vistaA.txtTelProv.getText());
            mod11.setPro_correo(vistaA.txtMailProv.getText());
            mod11.setPro_direccion(vistaA.txtDirProv.getText());
            mod11.setRazon_social(vistaA.txtRazSocProv.getText());
            mod11.setEstado(Integer.parseInt(vistaA.guardarRadioButtonProv()));
            
            try {
                if(modC11.registrar(mod11)){
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        if(e.getSource() == vistaA.btnModProv){
            mod11.setIdproveedor(vistaA.txtIdProv.getText());
            mod11.setPro_nombre(vistaA.txtNombreProv.getText());
            mod11.setPro_telefono(vistaA.txtTelProv.getText());
            mod11.setPro_correo(vistaA.txtMailProv.getText());
            mod11.setPro_direccion(vistaA.txtDirProv.getText());
            mod11.setRazon_social(vistaA.txtRazSocProv.getText());
            mod11.setEstado(Integer.parseInt(vistaA.guardarRadioButtonProv()));
                     
            
            try {
                if(modC11.modificar(mod11)){
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    //System.out.println(modC1.modificar());
                    //limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlProveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
        if(e.getSource() == vistaA.btnLimProv){
            limpiar();
        }
        
        
    }
    
    public void limpiar(){
        vistaA.txtIdProv.setText(null);
        vistaA.txtNombreProv.setText(null);
        vistaA.txtDirProv.setText(null);
        vistaA.txtTelProv.setText(null);
        vistaA.txtMailProv.setText(null);
        vistaA.txtRazSocProv.setText(null);
        vistaA.buttonGroupProv.clearSelection();
                        
    }
    
}

