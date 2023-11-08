package es.unex.cum.edi.PracticaFinalV2;

import java.io.Serializable;
/**
 * Clase abstracta de datos que recoge los usuarios que juegan al juego. 
 * Se implementa con el interface Serializable para que el proceso de cargar/salvar se haga autom�ticamente.
 * @author Juli�n Blanco Gonz�lez
 * @version Entrega 12 mayo de la asignatura de Estructura de Datos de la Informaci�n
 */
public abstract class Persona implements Serializable {
	
	/**
	 * nombrePersona: String que indica el nombre del usuario.
	 * identificador: entero que ubica al usuario.
	 * baraja: Objeto de tipo Baraja
	 */
	protected String nombrePersona;
	protected int identificador;
	protected Baraja baraja; //Hace falta poner transient
	/**
	 * Constructor por defecto de la clase Persona.
	 * IMPORTANTE: inicializar la baraja vac�a.
	 */
	public Persona() {
		nombrePersona=null;
		identificador=-1;
		baraja=null;
	}
	/**
	 * Constructor Parametrizado de la clase Persona.
	 * @param name: String que indica el nombre del usuario.
	 * @param id: entero que ubica al usuario.
	 */
	public Persona(String name, int id) {
		nombrePersona=name;
		identificador=id;
		baraja=null;//baraja vacia.
	}
	/**
	 * M�todo Getter que devuelve el nombre del usuario.
	 * @return nombrePersona: String que indica el nombre del usuario.
	 */
	public String getNombrePersona() {
		return nombrePersona;
	}
	/**
	 * M�todo Setter que cambia el nombre del usuario por par�metro.
	 * @param name: String que indica el nombre del usuario.
	 */
	public void SetNombrePersona(String name) {
		nombrePersona=name;
	}
	/**
	 * M�todo Setter que devuelve el id del usuario.
	 * @return identificador: entero que ubica al usuario.
	 */
	public int getIdentificador() {
		return identificador;
	}
	/**
	 * M�todo Setter que cambia el valor del id del usuario pasado por par�metro.
	 * @param id: entero que ubica al usuario.
	 */
	public void setIdentificador(int id) {
		identificador=id;
	}
	/**
	 * M�todo toString que devuelve por pantalla los datos del usuario.
	 */
	public String toString() {
		return "Nombre: "+nombrePersona+"/Id: "+identificador;
	}
	
	/**
	 * M�todo equals que compara dos objetos de tipo Persona.
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
		Persona other = (Persona) obj;
		if (baraja == null) {
			if (other.baraja != null)
				return false;
		} else if (!baraja.equals(other.baraja))
			return false;
		if (identificador != other.identificador)
			return false;
		if (nombrePersona == null) {
			if (other.nombrePersona != null)
				return false;
		} else if (!nombrePersona.equals(other.nombrePersona))
			return false;
		return true;
	}
	/**
	 * M�todo getter que devuelve la baraja con la que se juega.
	 * @return baraja: Objeto de tipo Baraja
	 */
	public Baraja getBaraja() {
		return baraja;
	}
	/**
	 * M�todo Setter que cambia el valor de baraja pasado por par�metro.
	 * @param baraja: Objeto de tipo Baraja
	 */
	public void setBaraja() {
		baraja=new BarajaFrancesa();
	}
	
	
	
}
