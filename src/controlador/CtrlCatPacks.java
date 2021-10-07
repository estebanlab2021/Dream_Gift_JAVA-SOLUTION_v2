/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

//*** @author calva
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ConsultasCatPacks;
import modelo.CatPacks;
import vista.MenuMaestro;


public class CtrlCatPacks implements ActionListener{
    //Llamamos a las clases que hemos creado
    private CatPacks mod1;
    private ConsultasCatPacks modC1;
    private MenuMaestro vistaA1;
    
    
    public CtrlCatPacks(CatPacks mod1, ConsultasCatPacks modC1, MenuMaestro vistaA1){
        
        this.mod1 = mod1;
        this.modC1 = modC1;
        this.vistaA1 = vistaA1;
        this.vistaA1.btnIngCatPack.addActionListener(this);
        this.vistaA1.rbtnActivoCatPack.addActionListener(this);
        this.vistaA1.rbtnInActivoCatPack.addActionListener(this);
        this.vistaA1.btnModCatPack.addActionListener(this);
        this.vistaA1.btnLimCatPack.addActionListener(this);
        
    }
    
    
    public void iniciar(){
        vistaA1.setTitle("Menu Principal");
        vistaA1.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == vistaA1.btnIngCatPack){
            mod1.setCategoria_pack(vistaA1.txtCatPack.getText());
            //mod1.setCodigoRS(vistaA1.txtCodigoRs.getText());
            mod1.setEstado_pack(Integer.parseInt(vistaA1.guardarRBtnCatPack()));
            
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
        
        if(e.getSource() == vistaA1.btnModCatPack){
            mod1.setIdcategoria_pack(Integer.parseInt(vistaA1.txtIdCatPack.getText()));
            mod1.setCategoria_pack(vistaA1.txtCatPack.getText());
            mod1.setEstado_pack(Integer.parseInt(vistaA1.guardarRBtnCatPack()));
            
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
     
        if(e.getSource() == vistaA1.btnLimCatPack){
            limpiar();
        }
        
        
    }
    
    public void limpiar(){
        vistaA1.txtIdCatPack.setText(null);
        vistaA1.txtCatPack.setText(null);
        vistaA1.buttonGroupCatPack.clearSelection();
        //vistaA1.txtCodigoRs.setText(null);
                
    }

}