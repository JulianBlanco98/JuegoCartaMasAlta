package es.unex.cum.edi.PracticaFinalV2;

import java.io.Serializable;
import java.util.*;
/**
 * @author Juli�n Blanco Gonz�lez
 * @see Clase heredada de la clase abstracta Baraja que indica el Jugador (el usuario) que juega al juego.
 * Esta clase implementa tambi�n la interfaz Serializable y la interfaz comparable, para poder realizar
 * el m�todo del ranking, ya que voy a ir comparando los objetos de tipo Jugador..
 */
public class Jugador extends Persona implements Serializable, Comparable<Jugador>{

	/**
	 * jugadas: ArrayList de Partidas que indica las veces que ha jugado el usuario.
	 * partidas: entero que indica el n�mero de partidas jugadas.
	 * ganadas: entero que indica el n�mero de partidas ganadas.
	 * perdidas: entero que indica el n�mero de partidas p�rdidas.
	 */
	protected ArrayList<Partida> jugadas;
	protected int partidas;
	protected int ganadas;
	protected int perdidas;
	/**
	 * Constructor por defecto de la clase Jugador
	 */
	public Jugador() {
		super();
		//super.baraja=new BarajaFrancesa();
		jugadas = new ArrayList<Partida>();
	}
	/**
	 * Constructor por defecto de la clase Jugador.
	 * @param name: String que indica el nombre del jugador
	 * @param id: entero que indica el id del juagdor.
	 */
	public Jugador(String name, int id) {
		super(name,id);
		//super.baraja=new BarajaFrancesa();
		jugadas = new ArrayList<Partida>();
	}
	/**
	 * M�todo Getter que devuelve el arrayList de partidas.
	 * @return jugadas: ArrayList de Partidas que indica las veces que ha jugado el usuario.
	 */

	public ArrayList <Partida>  getJugadas() {
		return jugadas;
	}
	/**
	 * M�todo Getter que devuelve el n�mero de partidas jugadas.
	 * @return partidas: entero que indica el n�mero de partidas jugadas.
	 */
	public int getPartidas() {
		return partidas;
	}
	/**
	 * M�todo Getter que devuelve el n�mero de partidas ganadas.
	 * @return partidas: entero que indica el n�mero de partidas ganadas.
	 */
	public int getGanadas() {
		return ganadas;
	}
	/**
	 * M�todo Getter que devuelve el n�mero de partidas perdidas.
	 * @return partidas: entero que indica el n�mero de partidas perdidas.
	 */
	public int getPerdidas() {
		return perdidas;
	}
	/**
	 * M�todo Setter que cambia el valor del ArrayList de Partida pasado por par�metro.
	 * @param j: ArrayList de Partidas que indica las veces que ha jugado el usuario.
	 */
	public void setJugadas(ArrayList <Partida> j) {
		jugadas = j;
	}
	/**
	 * M�todo Setter que cambia el valor de las partidas jugadas pasado por par�metro.
	 * @param p: entero que indica el n�mero de partidas jugadas.
	 */
	public void setPartidas(int p) {
		partidas = p;
	}
	/**
	 * M�todo Setter que cambia el valor de las partidas ganadas pasado por par�metro.
	 * @param win: entero que indica el n�mero de partidas ganadas.
	 */
	public void setGanadas(int win) {
		ganadas = win;
	}
	/**
	 * M�todo Setter que cambia el valor de las partidas perdidas pasado por par�metro.
	 * @param lose: entero que indica el n�mero de partidas perdidas.
	 */
	public void setDerrotas(int lose) {
		perdidas = lose;
	}
	/**
	 * M�todo toString que devuelve por pantalla los datos del jugador.
	 */
	public String toString() {
		return super.toString();
	}
	
	/**
	 * M�todo equals que compara dos objetos de tipo Jugador.
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
		Jugador other = (Jugador) obj;
		if (ganadas != other.ganadas)
			return false;
		if (jugadas == null) {
			if (other.jugadas != null)
				return false;
		} else if (!jugadas.equals(other.jugadas))
			return false;
		if (partidas != other.partidas)
			return false;
		if (perdidas != other.perdidas)
			return false;
		return true;
	}
	/**
	 * M�todo que permite a�adir una partida a la lista de partidas jugadas
	 * @param j: Objeto de tipo Partida.
	 * @return funci�n que a�ade a la lista de partidas, la a�adida por par�metro.
	 */
	public boolean addPartida(Partida j) {
		return jugadas.add(j);
	}
	@Override
	public int compareTo(Jugador o) {
		int opcion;
		if(ganadas > o.getGanadas()) {
			opcion=-1;
		}
		else
			if(ganadas == o.getGanadas()) {
				opcion=0;
			}
			else {
				opcion=1;
			}
		// TODO Auto-generated method stub
		return 1;
	}

}
