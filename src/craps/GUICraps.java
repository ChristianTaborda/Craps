/**
 * 
 */
package craps;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author paolajr-EISC
 *
 */
public class GUICraps extends JFrame{
	
	private JLabel dado1, dado2, etiquetaLanzar, punto;
	private JButton lanzar;
	private JTextField tiro, valorPunto;
	
	private ImageIcon imagen_dados;
	private ControlCraps control;
	
	public GUICraps(){
		super("Juego de Craps"); //invoca el constructor de JFrame
		
		Container contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		imagen_dados = new ImageIcon("src/imagenes/dado.png");
		dado1 = new JLabel(imagen_dados);
		dado2 = new JLabel(imagen_dados);
		
		//Se agrega el componente a la ventana
		
		contenedor.add(dado1);
		contenedor.add(dado2);
		
		//Objeto que va a estar atento al Evento (ActionEvent)
		EscuchaEventosAccion miEscucha = new EscuchaEventosAccion();
		
		lanzar = new JButton("Lanzar");
		lanzar.addActionListener(miEscucha); //Aquí es donde se enlaza el escucha de Eventos
		contenedor.add(lanzar);
		
		etiquetaLanzar = new JLabel("Lanzaste: ");
		etiquetaLanzar.setVisible(false);
		contenedor.add(etiquetaLanzar);
		
		tiro = new JTextField(3);
		tiro.setVisible(false);
		contenedor.add(tiro);
		
		punto = new JLabel("Tu punto es: ");
		punto.setVisible(false);
		contenedor.add(punto);
		
		valorPunto = new JTextField("");
		valorPunto.setVisible(false);
		contenedor.add(valorPunto);
		
		
		control = new ControlCraps();
		
		setSize(420, 250);
		setVisible(true);		
	}
	
	//Una clase interna o anidada (inner or nested class), 
	//puede acceder directamente a los miembros de la
	//clase que la contiene.

   private class EscuchaEventosAccion implements ActionListener {
	
			
	@Override
	public void actionPerformed(ActionEvent evento) {
		// TODO Auto-generated method stub
		
		if (evento.getSource() == lanzar) {
			
			visualizarCaras(); //Permite ver el tiro 
			
			/*Debe usar la Clase ControlCraps para determinar 
			  si se ganó, perdió o se estableció el punto y adecuar la ventana
			  Use JOptionPane.showMessageDialog(...) para mostrar mensajes
			*/	
			
			control.determinarJuego();
			switch (control.getEstado()){
						
						case 1: JOptionPane.showMessageDialog(null, "Natural has Ganado!!", "CRAPS", JOptionPane.PLAIN_MESSAGE);
						        break;
						        
						case 2: JOptionPane.showMessageDialog(null, "Craps has perdido :(", "CRAPS", JOptionPane.PLAIN_MESSAGE);
						        break;
						        
						case 3: JOptionPane.showMessageDialog(null, "Estableciste Punto, debes lazanzar nuevamente!!", "CRAPS", JOptionPane.PLAIN_MESSAGE);
								while(control.getEstado()==3){
										control.calcularTiro();
										control.determinarJuego();
								}
								if(control.getEstado()==1){
									JOptionPane.showMessageDialog(null, "Lograste nuevamente el punto, Ganaste :)", "CRAPS", JOptionPane.PLAIN_MESSAGE);
								}
								else{
									JOptionPane.showMessageDialog(null, "Ooops, Perdiste :(", "CRAPS", JOptionPane.PLAIN_MESSAGE);
								}
								break;
						}
						//seguirJuego();
						
		}		
	}
	
   } //fin clase EscuchaEventosAccion
   
   //método que permite visualizar la imagen de cada cara del dado 
   
   public void visualizarCaras(){
		
		/* Debe usar la Clase ControlCraps para Calcular el Tiro
		   Luego de usar la Clase ImageIcon para cargar al imagen correspondiente en 
		   el Jlabel de cada dado
		*/
	   
	   control.calcularTiro();
	   
	   ImageIcon imagen1;
	   ImageIcon imagen2;
	   
	   imagen1 = new ImageIcon("src/imagenes/" + control.getCaraDado1() + ".png");
	   imagen2 = new ImageIcon("src/imagenes/" + control.getCaraDado2() + ".png");
	   
	   dado1.setIcon(imagen1);
	   dado2.setIcon(imagen2);
	   
	    //Visualiza el valor del tiro en el JTextField 
	    etiquetaLanzar.setVisible(true);
		tiro.setText(Integer.toString(control.getTiro()));
		tiro.setVisible(true);
	  
	} 
   

}//Fin Clase GUICraps
