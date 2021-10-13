/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
//
import controlador.CtrlArticulo;
import controlador.CtrlBancos;
import controlador.CtrlCategoriaArticulo;
import controlador.CtrlCategoriaVenta;
import controlador.CtrlClientes;
import controlador.CtrlComunas;
import controlador.CtrlRRSS;
import controlador.CtrlCatPacks;
import controlador.ctrlVentas;
import modelo.Articulos;
import modelo.Bancos;
import modelo.Cat_Articulo;
import modelo.Cat_Venta;
import modelo.Cliente;
import modelo.Comunas;
import modelo.ConsultasArticulos;
import modelo.ConsultasBancos;
import modelo.ConsultasCatArticulos;
import modelo.ConsultasCatVentas;
import modelo.ConsultasCliente;
import modelo.ConsultasComunas;
import modelo.ConsultasRRSS;
import modelo.RRSS;
import modelo.CatPacks;
import modelo.ConsultasCatPacks;
import modelo.ConsultasVentas;
import modelo.ModVentas;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 *
 * @author usuario
 */
public class menu extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();
    
    public menu() {
        
        this.setContentPane(fondo);
        initComponents();
        this.setTitle("Menu Principal");
        this.setLocationRelativeTo(null);
    }

    public void llamarMaestro(){
        MenuMaestro vistaA = new MenuMaestro();
        Articulos mod = new Articulos();
        ConsultasArticulos modC = new ConsultasArticulos();       
        Cat_Articulo mod1 = new Cat_Articulo();
        ConsultasCatArticulos modC1 = new ConsultasCatArticulos();
        RRSS mod2 = new RRSS();
        ConsultasRRSS modC2 = new ConsultasRRSS();
        Cliente mod3 = new Cliente();
        ConsultasCliente modC3 = new ConsultasCliente();
        Comunas mod6 = new Comunas();
        ConsultasComunas modC6 = new ConsultasComunas();
        Bancos mod8 = new Bancos();
        ConsultasBancos modC8 = new ConsultasBancos();
        
        //Agregar nuevos elementos
        Cat_Venta mod9 = new Cat_Venta(); //Instanciamos el modelo Cat_Ventas
        ConsultasCatVentas modC9 = new ConsultasCatVentas(); //Instanciamos las consultas ConsultasCatVentas
        CatPacks mod10 = new CatPacks();
        ConsultasCatPacks modC10 = new ConsultasCatPacks();
        
        CtrlArticulo ctrl = new CtrlArticulo(mod, modC, vistaA);
        ctrl.iniciar();
        CtrlCategoriaArticulo ctrl1 = new CtrlCategoriaArticulo(mod1, modC1, vistaA);
        ctrl1.iniciar();
        CtrlRRSS ctrl2 = new CtrlRRSS(mod2, modC2, vistaA);
        ctrl2.iniciar();
        CtrlClientes ctrl3 = new CtrlClientes(mod3, modC3,vistaA);
        ctrl3.iniciar();
        CtrlComunas ctrl6 = new CtrlComunas(mod6, modC6, vistaA);
        ctrl6.iniciar();
        CtrlBancos ctrl8 = new CtrlBancos(mod8, modC8, vistaA);
        ctrl8.iniciar();
        CtrlCategoriaVenta ctrl9 = new CtrlCategoriaVenta(mod9, modC9, vistaA); //Instanciamos el Controlador CtrlCategoriaVenta
        ctrl9.iniciar();
        CtrlCatPacks ctrl10 = new CtrlCatPacks(mod10, modC10, vistaA); // Cristian
        ctrl10.iniciar(); // Cristian
        
        vistaA.setVisible(true);
        this.setVisible(false);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DG1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnVentas = new javax.swing.JButton();
        btnCompras = new javax.swing.JButton();
        btnInformes = new javax.swing.JButton();
        btnMaestro = new javax.swing.JButton();
        DG2 = new javax.swing.JLabel();

        DG1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/REGALOTRANSCH.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("MENU PRINCIPAL");

        btnVentas.setText("Ventas");
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnCompras.setText("Compras");

        btnInformes.setText("Informes");

        btnMaestro.setText("Maestro");
        btnMaestro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaestroActionPerformed(evt);
            }
        });

        DG2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/REGALOTRANSCH.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnVentas)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(DG2)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCompras)
                                .addGap(53, 53, 53)
                                .addComponent(btnInformes)
                                .addGap(49, 49, 49)
                                .addComponent(btnMaestro))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DG2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVentas)
                    .addComponent(btnCompras)
                    .addComponent(btnInformes)
                    .addComponent(btnMaestro))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
        // TODO add your handling code here:
        ventas menuVentas = new ventas();
        ModVentas mod1 = new ModVentas();
        ConsultasVentas modC1 = new ConsultasVentas();
        
        ctrlVentas ctrl = new ctrlVentas(mod1, modC1, menuVentas);
        
        menuVentas.setVisible(true);
        menuVentas.setLocationRelativeTo(null);
        menuVentas.setTitle("Menu Ventas");
        this.setVisible(false);
    }//GEN-LAST:event_btnVentasActionPerformed

    private void btnMaestroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaestroActionPerformed
        // TODO add your handling code here:
        llamarMaestro();
        
    }//GEN-LAST:event_btnMaestroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel DG1;
    public javax.swing.JLabel DG2;
    private javax.swing.JButton btnCompras;
    private javax.swing.JButton btnInformes;
    private javax.swing.JButton btnMaestro;
    private javax.swing.JButton btnVentas;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
class FondoPanel extends JPanel
    {
        private Image imagen;
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("/imagenes/DarRegalo.jpg")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
    }
}
