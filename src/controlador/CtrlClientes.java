package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ConsultasCliente;
import vista.MenuMaestro;



/**
 *
 * @author usuario
 */
public class CtrlClientes implements ActionListener {
    
     private Cliente mod1;
     private ConsultasCliente modC1;
     private MenuMaestro frm2;
    
    
    public CtrlClientes(Cliente mod1, ConsultasCliente modC1, MenuMaestro frm2){
        
        this.mod1 = mod1;
        this.modC1 = modC1;
        this.frm2 = frm2;
        this.frm2.btnRegistrarCli.addActionListener(this);
        this.frm2.btnModificarCli.addActionListener(this);
        this.frm2.btnLimpiarCli.addActionListener(this);
    }

    public void iniciar(){
        frm2.setTitle("Menu Principal");
        frm2.setLocationRelativeTo(null);
    }
      
    
    @Override
    public void actionPerformed(ActionEvent e){
    
        if(e.getSource() == frm2.btnRegistrarCli){
            mod1.setRut(frm2.txtRut.getText());
            mod1.setCli_nombre(frm2.txtNombresClientes.getText());
            mod1.setCli_apellido(frm2.txtApellidosClientes.getText());
            mod1.setCli_direccion(frm2.txtDireccionClientes.getText());
            mod1.setCli_telefono(Integer.parseInt(frm2.txtTelefono.getText()));
            mod1.setFecha_nac(frm2.txtFECHA.getText());
            mod1.setEstado(Integer.parseInt(frm2.guardarRadioBotonCliente()));
            mod1.setCli_mail(frm2.txtMail.getText());
            try {
                if(modC1.registrar(mod1)){
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR");
                limpiar();
            }
                } catch (SQLException ex) {
                Logger.getLogger(CtrlRRSS.class.getName()).log(Level.SEVERE, null, ex);
            
                }
        }
        
         if(e.getSource() == frm2.btnModificarCli){
            mod1.setRut(frm2.txtRut.getText());
            mod1.setCli_nombre(frm2.txtNombresClientes.getText());
            mod1.setCli_apellido(frm2.txtApellidosClientes.getText());
            mod1.setCli_direccion(frm2.txtDireccionClientes.getText());
            mod1.setCli_telefono(Integer.parseInt(frm2.txtTelefono.getText()));
            mod1.setFecha_nac(frm2.txtFECHA.getText());
            mod1.setEstado(Integer.parseInt(frm2.guardarRadioBotonCliente()));
            mod1.setCli_mail(frm2.txtMail.getText());
            
            try {
                if(modC1.modificar(mod1)){
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                    limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == frm2.btnLimpiarCli){
            limpiar();
        }
         
         
          if(e.getSource() == frm2.btnLimpiarCli){
              limpiar();
          } 
    }
    public void limpiar(){
        frm2.txtRut.setText(null);
        frm2.txtNombresClientes.setText(null);
        frm2.txtApellidosClientes.setText(null);
        frm2.txtDireccionClientes.setText(null);
        frm2.txtFECHA.setText(null);
        frm2.buttonGroupCli.clearSelection();
        frm2.txtMail.setText(null);
        frm2.txtTelefono.setText(null);
       
    }
 }

   
    
    

