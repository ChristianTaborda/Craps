package craps;

/**
 * @author paolajr-EISC
 *
 */
public class ControlCraps {
	
	private Dado dado1, dado2;
	private int tiro, punto, estado, flag;
	private int[] caras;
	
	public ControlCraps(){
		dado1 = new Dado();
		dado2 = new Dado();
		caras = new int[2];
		flag=0;
	}
	
	/**
	 * Determina el valor de la cara visible del dado y calcula el valor del tiro.
	 * 
	 *@return devuelve un arreglo de dos elementos enteros que corresponden a las caras visibles de cada dado
	 */
	public void calcularTiro(){	
		caras[0] = dado1.getCara();
		caras[1] = dado2.getCara();
		tiro = caras[0] +  caras[1];
	}
	
	
	//Determina si el jugador gana, pierde o establece punto	
	public void determinarJuego(){
		
	 if(flag==0){
		//Es primer lanzamiento
		if (tiro==7 || tiro == 11){
			estado=1; //ganó
		}
		else
			if(tiro==2 || tiro==3 || tiro==12){
				estado=2; //perdió
			}
			else{
				estado=3; //Estableció punto
				punto=tiro;
				flag = 1; 
			}
      }
	 else{ 
	    //Ha establecido punto
		rondaPunto(); 
	 }
	  
	}
	
	//Determina si el jugador gana o pierde cuando ha establecido punto
	private void rondaPunto(){
		if(tiro==punto){
			estado=1; //ganó
			flag=0;
		}
		if(tiro==7){
			estado=2; //perdió
			flag=0;
		}
	}
	
	public int getTiro(){
		return tiro;
	}
	
	public int getEstado(){
		return estado;
	}
	
	public int getPunto(){
		return punto;
	}
	
	public int getCaraDado1(){
		return caras[0];
	}
	public int getCaraDado2(){
		return caras[1];
	}
}
