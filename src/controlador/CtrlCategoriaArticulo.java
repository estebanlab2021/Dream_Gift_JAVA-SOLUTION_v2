
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Cat_Articulo;
import modelo.ConsultasCatArticulos;
import vista.MenuMaestro;


public class CtrlCategoriaArticulo implements ActionListener{
    
    //Llamamos a las clases que hemos creado
    private Cat_Articulo mod1;
    private ConsultasCatArticulos modC1;
    private MenuMaestro vistaA1;
    
    
    public CtrlCategoriaArticulo(Cat_Articulo mod1, ConsultasCatArticulos modC1, MenuMaestro vistaA1){
        
        this.mod1 = mod1;
        this.modC1 = modC1;
        this.vistaA1 = vistaA1;
        this.vistaA1.btnCategoriaArticulo.addActionListener(this);
        this.vistaA1.RadioButtonEstado.addActionListener(this);
        this.vistaA1.RadioButtonEstado0.addActionListener(this);
        //this.vistaA1.radiobuttonGroup1.addActionListener(this);
        this.vistaA1.btnModificarCategoriaArticulo.addActionListener(this);
        //this.vistaA1.btnBuscarCatArt.addActionListener(this);
        this.vistaA1.btnLimpiar.addActionListener(this);
        String estadobtn = null;
        
    
    }
    
    public void iniciar(){
        vistaA1.setTitle("Menu Principal");
        vistaA1.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vistaA1.btnCategoriaArticulo){
            mod1.setCategoria_articulo(vistaA1.txtCategoriaArticulo.getText());
            mod1.setEstado(Integer.parseInt(vistaA1.guardarRadioButtonValue()));
            
            try {
                if(modC1.registrar(mod1)){
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                    limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlCategoriaArticulo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(e.getSource() == vistaA1.btnModificarCategoriaArticulo){
            mod1.setIdcategoria_articulo(Integer.parseInt(vistaA1.txtIdCategoria_Articulo.getText()));
            mod1.setCategoria_articulo(vistaA1.txtCategoriaArticulo.getText());
            mod1.setEstado(Integer.parseInt(vistaA1.guardarRadioButtonValue()));
            
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
                Logger.getLogger(CtrlCategoriaArticulo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /*
        if(e.getSource() == vistaA1.btnBuscarCatArt){
            mod1.setIdcategoria_articulo(Integer.parseInt(vistaA1.txtBuscar.getText()));
            
            try {
                if(modC1.buscar(mod1)){
                    vistaA1.txtCategoriaArticulo.setText(mod1.getCategoria_articulo());
                    //vistaA1.RadioButtonEstado.setText(String.valueOf(mod1.getEstado()));
                    //vistaA1.RadioButtonEstado0.setText(String.valueOf(mod1.getEstado()));
                    //vistaA1.radiobuttonGroup1.setSelected(true).setText(String.valueOf(mod1.getEstado()));
                    //vistaA1.guardarRadioButtonValue().setText(String.valueOf(mod1.getEstado()));
                    //JOptionPane.showMessageDialog(null, "Registro Encontrado");
                    //limpiar();
                }else {
                    JOptionPane.showMessageDialog(null, "No se encontró el registro");
                    limpiar();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlCategoriaArticulo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        
        if(e.getSource() == vistaA1.btnLimpiar){
            limpiar();
        }
        
        
    }
    
    public void limpiar(){
        vistaA1.txtIdCategoria_Articulo.setText(null);
        vistaA1.txtCategoriaArticulo.setText(null);
        //vistaA1.RadioButtonEstado.setSelected(false);
        //vistaA1.RadioButtonEstado0.setSelected(false);
        vistaA1.radiobuttonGroup1.clearSelection();
        vistaA1.txtBuscar.setText(null);
        
    }
    
    
    
}
