
package Modelo_Fusion;

import controlador.CtrlArticulo;
import modelo.Articulos;
import modelo.ConsultasArticulos;
import vista.MenuMaestro;
import controlador.CtrlComunas;
import modelo.Comunas;
import modelo.ConsultasComunas;
import controlador.CtrlBancos;
import controlador.CtrlCategoriaArticulo;
import modelo.Bancos;
import modelo.ConsultasBancos;
import controlador.CtrlRRSS;
import modelo.Cat_Articulo;
import modelo.ConsultasCatArticulos;
import modelo.CatPacks;
import modelo.ConsultasRRSS;
import modelo.Cliente;
import modelo.ConsultasCliente;
import controlador.CtrlClientes;
import modelo.RRSS;
import vista.Login;


public class JavaDG_v2 {

    
    public static void main(String[] args) {
        // TODO code application logic here
        /*
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
		
        MenuMaestro vistaA = new MenuMaestro();
       
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
        */
        //vistaA.setVisible(true);
        
        Login log = new Login();
        log.setVisible(true);
    }
    
}
