package es.unex.cum.edi.PracticaFinalV2;

import java.io.Serializable;
import java.util.*;
/**
 * @author Julián Blanco González
 * @see Clase heredada de la clase abstracta Baraja que indica el Jugador (el usuario) que juega al juego.
 * Esta clase implementa también la interfaz Serializable y la interfaz comparable, para poder realizar
 * el método del ranking, ya que voy a ir comparando los objetos de tipo Jugador..
 */
public class Jugador extends Persona implements Serializable, Comparable<Jugador>{

	/**
	 * jugadas: ArrayList de Partidas que indica las veces que ha jugado el usuario.
	 * partidas: entero que indica el número de partidas jugadas.
	 * ganadas: entero que indica el número de partidas ganadas.
	 * perdidas: entero que indica el número de partidas pérdidas.
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
	 * Método Getter que devuelve el arrayList de partidas.
	 * @return jugadas: ArrayList de Partidas que indica las veces que ha jugado el usuario.
	 */

	public ArrayList <Partida>  getJugadas() {
		return jugadas;
	}
	/**
	 * Método Getter que devuelve el número de partidas jugadas.
	 * @return partidas: entero que indica el número de partidas jugadas.
	 */
	public int getPartidas() {
		return partidas;
	}
	/**
	 * Método Getter que devuelve el número de partidas ganadas.
	 * @return partidas: entero que indica el número de partidas ganadas.
	 */
	public int getGanadas() {
		return ganadas;
	}
	/**
	 * Método Getter que devuelve el número de partidas perdidas.
	 * @return partidas: entero que indica el número de partidas perdidas.
	 */
	public int getPerdidas() {
		return perdidas;
	}
	/**
	 * Método Setter que cambia el valor del ArrayList de Partida pasado por parámetro.
	 * @param j: ArrayList de Partidas que indica las veces que ha jugado el usuario.
	 */
	public void setJugadas(ArrayList <Partida> j) {
		jugadas = j;
	}
	/**
	 * Método Setter que cambia el valor de las partidas jugadas pasado por parámetro.
	 * @param p: entero que indica el número de partidas jugadas.
	 */
	public void setPartidas(int p) {
		partidas = p;
	}
	/**
	 * Método Setter que cambia el valor de las partidas ganadas pasado por parámetro.
	 * @param win: entero que indica el número de partidas ganadas.
	 */
	public void setGanadas(int win) {
		ganadas = win;
	}
	/**
	 * Método Setter que cambia el valor de las partidas perdidas pasado por parámetro.
	 * @param lose: entero que indica el número de partidas perdidas.
	 */
	public void setDerrotas(int lose) {
		perdidas = lose;
	}
	/**
	 * Método toString que devuelve por pantalla los datos del jugador.
	 */
	public String toString() {
		return super.toString();
	}
	
	/**
	 * Método equals que compara dos objetos de tipo Jugador.
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
	 * Método que permite añadir una partida a la lista de partidas jugadas
	 * @param j: Objeto de tipo Partida.
	 * @return función que añade a la lista de partidas, la añadida por parámetro.
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
