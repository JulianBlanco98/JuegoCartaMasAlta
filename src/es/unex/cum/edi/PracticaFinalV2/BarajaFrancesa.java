package es.unex.cum.edi.PracticaFinalV2;
import java.io.Serializable;
import java.util.*;
/**
 * @author Juli�n Blanco Gonz�lez
 * @see Clase heredada de la clase abstracta Baraja
 * Esta clase implementa todo el comportamiento del juego carta m�s alta.
 */
public class BarajaFrancesa extends Baraja implements Serializable{
	
	
	/**
	 * Constructor por defecto que al no tener ningun atributo, es el mismo de la clase Baraja
	 * super(): constructor por defecto de la clase padre
	 * inicializar(): se crea la baraja de cartas
	 * repartir(getMazo()): m�todo donde se desordenan las cartas. Recibe como par�metro la cola de cartas.
	 */
	
	public BarajaFrancesa()
	{
		super();
		inicializar();
		repartir(getMazo());
		
	}
	
	/**
	 * M�todo que crea una baraja con 52 cartas ordenadas.
	 */
	public void inicializar() {
		
		
		//System.out.println("Creando la baraja francesa ...");
		for(int i=0;i<getnumCP();i++)//Recorro los s�mbolos del 1 al 4
		{
			for(int j=0;j<getnumTipo();j++)//Recorro los numeros del 1 al 13
			{
				crearMazo(i, j);
			}
		}
		 
		
	}
	/**
	 * M�todo que desordena la cola de cartas recibida por par�metro.
	 * @param Queue <Carta> a: cola de cartas
	 */
	public void repartir(Queue <Carta> a) {
		
		
		/*ArrayList<Carta> aux =new ArrayList<Carta>(a); //Hago una coleccion auxiliar, ya que el m�todo shuffle no funciona con la cola.
		Collections.shuffle(aux); //M�todo que desordena la cola
		a.clear();//Limpio la cola antigua
		a.addAll(aux); //Todo el contenido de aux lo paso a a (cola)*/
		Collections.shuffle((List)a);
		
	}
	
	/**
	 * M�todo que muestra la cola de cartas recibida por par�metro.
	 * @param Queue <Carta> a: cola de cartas
	 */
	public void mostrar(Queue <Carta> a) {
		
		Iterator it=a.iterator();
		while(it.hasNext()) {
			Carta aux =(Carta)it.next();
			System.out.printf("\n%-20s",aux.toString());
		}
		
	}
	/**
	 * M�todo equals que compara dos objetos de tipo francesa.
	 * @param obj: objeto para poder comparar sus valores.
	 * @return devuelve true si son iguales y false si no lo son.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	
	

}
