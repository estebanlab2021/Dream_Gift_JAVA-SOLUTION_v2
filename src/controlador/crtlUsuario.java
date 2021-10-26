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
import vista.menu;

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
            //user.setUsuario(vistaU.txtUsuario.getText());
            String user = vistaU.txtUsuario.getText();
            char p [] = vistaU.txtPassword.getPassword();
            String pass = new String(p);
            //user.setPassword(pass);
           ArrayList<Usuarios> list;
           list = userc.loginUsuario(user, pass);
            try{
                if(list.size()>0){
                    JOptionPane.showMessageDialog(null, "Usuario Registrado, BIENVENIDO " + vistaU.txtUsuario.getText());
                    vistaU.dispose();
                    menu menuppal = new menu();
                    menuppal.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuario NO Registrado");
                    vistaU.txtUsuario.setText(null);
                    vistaU.txtPassword.setText(null);
                }
            }catch (Exception ex) {
                System.err.println(ex.toString());
            }
        }
        
    }
    
    
}
