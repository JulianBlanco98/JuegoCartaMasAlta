package es.unex.cum.edi.PracticaFinalV2;

import java.io.Serializable;

/**
 * Clase Francesa(bloque 1)
 * @author Julián Blanco González
 * @see Clase que hereda de la clase abstracta Carta
 *
 */
public class Francesa extends Carta implements Serializable {
	
	/**
	 * Atributo estático para poner los mismos simbolos a todas las cartas.
	 */
	public static final String SIMBOLOS []={"DIAMANTE", "TREBOL", "PICA", "CORAZON"};	
	/**
	 * Atributo de la clase herededada francesa
	 * Simbolo: valor Cadena (enumerado o no) que indica el símbolo de la carta francesa 
	 * (Diamante, Trébol, Pica y Corazón)
	 */
	
	
	private String simbolo;
	/**
	 * Constructor por Defecto 
	 * super(): constructor de la clase carta
	 * simbolo: String 
	 */
	public Francesa() {
		
		super();
		simbolo=" ";
	}
	/**
	 * Constructor Parametrizado de la clase heredada francesa
	 * @param v: valor de la carta en char
	 * @param simbol: String que dice el símbolo de la carta
	 */
	public Francesa(char v, String simbol) {
		
		super(v);
		simbolo=simbol;
	}
	/**
	 * Método Getter que devuelve el símbolo de la carta.
	 * @return simbolo: String que dice el símbolo de la carta.
	 */
	public String getSimbolo() {
		return simbolo;
	}
	/**
	 * Método Setter que cambia el simbolo de cada carta
	 * @param s: String que dice el símbolo de la carta.
	 */
	public void setSimbolo(String s) {
		
		simbolo=s;
		
	}
	/**
	 * Método toString que muestra el toString de la clase padre(super()) y el símbolo de la carta.
	 * Ejemplo: R de DIAMANTE
	 */
	public String toString() {
		
		return super.toString()+ " "+simbolo;
	}
	/**
	 * Método equals que compara dos objetos de tipo francesa.
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
		Francesa other = (Francesa) obj;
		if (simbolo == null) {
			if (other.simbolo != null)
				return false;
		} else if (!simbolo.equals(other.simbolo))
			return false;
		return true;
	}
	

}
