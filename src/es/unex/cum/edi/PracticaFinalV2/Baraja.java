package es.unex.cum.edi.PracticaFinalV2;
import java.io.Serializable;
import java.util.*;
/**
 * Clase abstracta de datos que modelar� el concepto de una baraja.
 * @author Juli�n Blanco Gonz�lez
 * @version Entrega 12 mayo de la asignatura de Estructura de Datos de la Informaci�n
 *
 */
public abstract class Baraja implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5310633256101166102L;
	/**
	 * Como no se especifica, yo he creado unos valores predeterminados.
	 * NUMCARTAS: 52 cartas en total
	 * NUMCP: 4 palos diferentes
	 * NUMTIPO: 13 tipos de cartas diferentes
	 */
	
	public static final int NUMCARTAS=52;
	public static final int NUMCP=4;
	public static final int NUMTIPO=13;	
	
	
	/**
	 * Atributos de la clase abstracta Baraja:
	 * int numCartas: N�mero de cartas totales
	 * int numCP: N�mero de cartas por cada tipo
	 * int numTipo: : N�mero de palos/tipos de cartas
	 * Queue<Carta>mazo: ; Cola de cartas
	 */
	protected int numCartas;
	protected int numCP;
	protected int numTipo;
	protected Queue<Carta>mazo;
	
	
	/**
	 * Constructor por Defecto que inicia los atributos de la clase.
	 */
	public Baraja() {
		
		numCartas=NUMCARTAS;
		numCP=NUMCP;
		numTipo=NUMTIPO;
		mazo=new LinkedList<Carta>();
	}
	/**
	 * Constructor Parametrizado de la clase
	 * @param nc: numero de cartas
	 * @param ncp: numero de cartas por cada tipo
	 * @param nt: n�mero de palos/tipos de cartas
	 * @param mazo: instancio la cola de cartas como un LinkedList
	 */
	
	public Baraja(int nc,int ncp, int nt) {
		
		numCartas=nc;
		numCP=ncp;
		numTipo=nt;
		mazo=new LinkedList<Carta>();
	}
	/**
	 * M�todo Getter que devuelve el n�mero de cartas de la baraja.
	 * @return numcartas: entero que devuelve el n�mero de cartas de la baraja.
	 */
	public int getnumCartas() {
		return numCartas;
	}
	/**
	 * M�todo Getter que devuelve el n�mero de cartas por cada tipo de la baraja.
	 * @return numCP: entero que devuelve el n�mero de cartas por cada tipo.
	 */
	public int getnumCP() {
		return numCP;
	}
	/**
	 * M�todo Getter que devuelve el n�mero de palos/tipos de cartas.
	 * @return numTipo: entero el n�mero de palos/tipos de cartas.
	 */
	public int getnumTipo() {
		return numTipo;
	}
	/**
	 * M�todo Getter que devuelve la cola de Cartas
	 * @return mazo: queue baraja de cartas
	 */
	public Queue <Carta> getMazo() {
		return mazo;
	}
	/**
	 * M�todo Setter que cambia el valor de la cola
	 * @param cola_: Cola de cartas.
	 */
	public void setMazo(Queue cola) {
		mazo=cola;
	}
	/**
	 * M�todo que devuelve el frente de la cola de cartas.
	 * @return mazo.peek(): funci�n peek --> devuelve el frente de una cola  
	 */
	public Carta getCarta() {
		return mazo.peek();
	}
	/**
	 * M�todo que a�ade cartas a la baraja
	 * @param c: Tipo Carta
	 * @return mazo.add: funcion add --> a�ade el objeto (Carta) a la cola
	 */
	public boolean addCartas(Carta c) {
		return mazo.add(c);
	}
	/**
	 * M�todo que crea el mazo o baraja para jugar.
	 * @param i: entero que corresponde a los simbolos de carta
	 * @param j: entero que corresponde a los valores de carta
	 * @return la creaci�n de todas las cartas del mazo que se especifica en la clase hija.
	 */
	public boolean crearMazo(int i,int j) {
		return mazo.add(new Francesa(Carta.VALOR[j],Francesa.SIMBOLOS[i]));
	}
	
	/**
	 * M�todo abstracto que se encarga de a�adir las cartas al mazo(ser� llamado desde el constructor de la clase derivada)
	 */
	public abstract void inicializar();
	/**
	 * M�todo abstracto que se encarga de repartir las cartas de forma desordenada (ser� llamado desde el constructor de la clase derivada)
	 * @param Queue <Carta> a: cola de cartas que repartir�/barajar�
	 */
	public abstract void repartir(Queue <Carta> a);
	/**
	 * M�todo abstracto que se encarga de mostrar la cola de carta (ser� llamado desde el constructor de la clase derivada)
	 * @param Queue <Carta> a: cola de cartas que mostrar�
	 */
	 
	public abstract void mostrar(Queue <Carta> a);
	
	/**
	 * M�todo equals que compara dos objetos de tipo Carta.
	 * @param obj: objeto para poder comparar sus valores.
	 * @return devuelve true si son iguales y false si no lo son.
	 */
	public boolean equals (Object obj) {
		
		Baraja aux= (Baraja) obj;
		
		return equals(aux) && numCartas == aux.numCartas && numCP == aux.numCP && numTipo == aux.numTipo;
	}
	

}