/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConsultaUsuario;
import modelo.Usuarios;
import vista.Login;

/**
 *
 * @author usuario
 */
public class crtlUsuario implements ActionListener{
    
    private Usuarios user;
    private ConsultaUsuario userc;
    private Login vistaU;
    
    public crtlUsuario(Usuarios user, ConsultaUsuario userc, Login vistaU){
        this.user = user;
        this.userc = userc;
        this.vistaU = vistaU;
        this.vistaU.btnEntrar.addActionListener(this);
        
    }
    
    public void iniciar(){
        vistaU.setTitle("Menu Usuario");
        vistaU.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaU.btnEntrar){
            user.setUsuario(vistaU.txtUsuario.getText());
            char p [] = vistaU.txtPassword.getPassword();
            String pass = new String(p);
            user.setPassword(pass);
           
            try{
                if(userc.BuscarUsuario(user)){
                    
                    JOptionPane.showMessageDialog(null, "Usuario Registrado, BIENVENIDO " + vistaU.txtUsuario.getText());
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario NO Registrado");
                }
            }catch (SQLException ex) {
                Logger.getLogger(crtlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
