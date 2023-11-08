package es.unex.cum.edi.PracticaFinalV2;
import java.io.Serializable;
import java.util.Date;
/**
 * Clase : Almacena el tiempo que tarda un determinado jugador en resolver el juego.
 * @author Julián Blanco González
 * @version Entrega 12 mayo de la asignatura de Estructura de Datos de la Información
 *
 */
public class Partida implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3784731942355898798L;
	/**
	 * boolean ganada: Almacena si la partida la ha ganado o no.
	 * long tiempo: Almacena en formato long el tiempo que ha tardado
	 * long tiempo: Almacena en formato long el tiempo que ha tardado
	 */
	protected boolean ganada;
	protected long tiempo;
	protected Date fecha;
	/**
	 * Constructor por defecto de la clase Partida
	 * Inicializo la fecha
	 */
	public Partida() {
		ganada=false;
		tiempo=0;
		fecha=new Date();
	}
	/**
	 * Constructor parametrizado de la clase Partida
	 * @param win: booleano que indica si ha ganado el jugador o la mesa
	 * @param time: long que indica el tiempo de juego
	 */
	public Partida(boolean win, long time, Date fecha) {
		ganada=win;
		tiempo=time;
		this.fecha=new Date();
	}
	/**
	 * Método Getter que devuelve true si gana el jugador o false si gana la mesa.
	 * @return gandada: booleano que indica si gana la mesa o el jugador
	 */
	public boolean getGanada() {
		return ganada;
	}
	
	/**
	 * Método Setter que cambia el valor de la partida a true si se ha ganado, o false, si se ha perdido.
	 * @param ganada: booleano
	 */
	public void setGanada(boolean ganada) {
		this.ganada = ganada;
	}
	/**
	 * Método Getter que devuelve el tiempo transcurrido de la partida.
	 * @return tiempo: long que indica el tiempo de la partida.
	 */
	public long getTiempo() {
		return tiempo;
	}
	/**
	 * Método Setter que cambia el valor del tiempo de la partida
	 * @param time: long que indica el tiempo de la partida.
	 */
	public void setTiempo(long time) {
		tiempo=time;
	}
	/**
	 * Método Getter que devuelve la fecha de cuando se juega la partida.
	 * @return fecha: date de cuando se juega al juego.
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * Método Setter que cambia el valor de la fecha pasada por prarámetro
	 * @param date: date que indica cuando se ha jugado.
	 */
	public void setFecha(Date date) {
		fecha=date;
	}
	/**
	 * Método toString que devuelve por pantalla los atributos de la clase Partida.
	 */
	public String toString() {
		String mensaje2;
		if(ganada) {
			mensaje2="Has ganado";
		}
		else {
			mensaje2="Gana la casa";
		}
		return "Tiempo: "+tiempo+"/ Fecha: "+fecha+"/ "+mensaje2;	
	}
	/**
	 * Método equals que compara dos objetos de tipo Partida.
	 * @param obj: objeto para poder comparar sus valores.
	 * @return devuelve true si son iguales y false si no lo son.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (ganada != other.ganada)
			return false;
		if (tiempo != other.tiempo)
			return false;
		return true;
	}
	
	
}
