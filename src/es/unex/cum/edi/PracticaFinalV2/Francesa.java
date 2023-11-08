package es.unex.cum.edi.PracticaFinalV2;

import java.io.Serializable;

/**
 * Clase Francesa(bloque 1)
 * @author Juli�n Blanco Gonz�lez
 * @see Clase que hereda de la clase abstracta Carta
 *
 */
public class Francesa extends Carta implements Serializable {
	
	/**
	 * Atributo est�tico para poner los mismos simbolos a todas las cartas.
	 */
	public static final String SIMBOLOS []={"DIAMANTE", "TREBOL", "PICA", "CORAZON"};	
	/**
	 * Atributo de la clase herededada francesa
	 * Simbolo: valor Cadena (enumerado o no) que indica el s�mbolo de la carta francesa 
	 * (Diamante, Tr�bol, Pica y Coraz�n)
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
	 * @param simbol: String que dice el s�mbolo de la carta
	 */
	public Francesa(char v, String simbol) {
		
		super(v);
		simbolo=simbol;
	}
	/**
	 * M�todo Getter que devuelve el s�mbolo de la carta.
	 * @return simbolo: String que dice el s�mbolo de la carta.
	 */
	public String getSimbolo() {
		return simbolo;
	}
	/**
	 * M�todo Setter que cambia el simbolo de cada carta
	 * @param s: String que dice el s�mbolo de la carta.
	 */
	public void setSimbolo(String s) {
		
		simbolo=s;
		
	}
	/**
	 * M�todo toString que muestra el toString de la clase padre(super()) y el s�mbolo de la carta.
	 * Ejemplo: R de DIAMANTE
	 */
	public String toString() {
		
		return super.toString()+ " "+simbolo;
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
		Francesa other = (Francesa) obj;
		if (simbolo == null) {
			if (other.simbolo != null)
				return false;
		} else if (!simbolo.equals(other.simbolo))
			return false;
		return true;
	}
	

}
