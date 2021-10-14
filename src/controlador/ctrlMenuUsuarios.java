
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConsultaUsuario;
import modelo.Usuarios;
import vista.MenuMaestro;

public class ctrlMenuUsuarios implements ActionListener{
    private Usuarios user;
    private ConsultaUsuario userc;
    private MenuMaestro vistaM;
    
    public ctrlMenuUsuarios(Usuarios user, ConsultaUsuario userc, MenuMaestro vistaM){
        this.user = user;
        this.userc = userc;
        this.vistaM = vistaM;
        vistaM.btnIngresar.addActionListener(this);
        vistaM.btnModificar.addActionListener(this);
        vistaM.btnLimpiar.addActionListener(this);
    }
    public void iniciar(){
        vistaM.setTitle("Menu Usuario");
        vistaM.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaM.btnModificar){
            user.setIdusuario(Integer.parseInt(vistaM.txtIdUsuario.getText()));
            user.setUser_estado(Integer.parseInt(vistaM.guardarRadioButtonEdoUsuario()));
            
            try {
                if(userc.modificarUsuario(user)){
                    JOptionPane.showMessageDialog(null, "Usuario Modificado");
                    limpiarUsuario();
                }else{
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                    limpiarUsuario();
                }
            }catch (SQLException ex) {
                Logger.getLogger(ctrlMenuUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == vistaM.btnIngresar){
            vistaM.verificarCamposVacios();
            if(vistaM.verificarCamposVacios()==true){
                user.setUsuario(vistaM.txtNombreUsuario.getText());
                char p1 [] = vistaM.PasswordUsuario.getPassword();
                String pass1 = new String(p1);
                user.setPassword(pass1);
                String edoUser = "1";
                user.setUser_estado(Integer.parseInt(edoUser));
                
                try {
                    if(userc.registrarUsuario(user)){
                        JOptionPane.showMessageDialog(null, "Usuario Ingresado");
                        limpiarUsuario();
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al Ingresar");
                        limpiarUsuario();
                    }
                }catch (SQLException ex) {
                        Logger.getLogger(ctrlMenuUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if(e.getSource()== vistaM.btnLimpiar){
            limpiarUsuario();
        }
    
    }
    
    public void limpiarUsuario(){
        vistaM.txtNombreUsuario.setText(null);
        vistaM.txtNombreUsuario.setEditable(true);
        vistaM.PasswordUsuario.setText(null);
        vistaM.PasswordUsuario.setEditable(true);
        vistaM.PasswordVerified.setText(null);
        vistaM.PasswordVerified.setEditable(true);
        vistaM.buttonGroupUsuario.clearSelection();
        vistaM.RadioButtonUserActivo.setEnabled(false);
        vistaM.RadioButtonUserInactivo.setEnabled(false);
    }
    
}
