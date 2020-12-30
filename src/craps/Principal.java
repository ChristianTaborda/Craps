package craps;

import javax.swing.JFrame;

/**
 * @author paolajr-EISC
 *
 */
public class Principal {

	/**
	 * Método que inicia la aplicación
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*VistaConsola consola = new VistaConsola();
		consola.iniciarJuego();*/
		
		GUICraps myWindow = new GUICraps();
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}

}
