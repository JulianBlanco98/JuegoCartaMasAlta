package es.unex.cum.edi.PracticaFinalV2;

import java.io.Serializable;

/**
 * Clase abstracta de datos en la que se declara los atributos y los métodos de carta
 * @author Julián Blanco González
 * @version Entrega 12 mayo de la asignatura de Estructura de Datos de la Información
 *
 */
public abstract class Carta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6011201604195429303L;
	/**
	 * Atributo estático para poner los mismos valores a las cartas
	 */
	public static final char VALOR []= {'1','2','3','4','5','6','7','8','9','A','V','D','R'};
	/**
	 * Atributos de la clase abstracta Carta:
	 * char valor: 1,2 ,3 4, 5, 6, 7, 8 , 9 , 10 (A), y tres figuras, que se llaman Valet (V), Dame (D) y Roi (R).
	 * boolean oculta: false es si está bocarriba y true si está bocabajo.
	 * String imagenReverso: muestra la carta por detras
	 * String imagenFrontal: muestra la cartas por delante
	 */
	protected char valor;
	protected boolean oculta;
	protected String imagenReverso;
	protected String imagenFrontal;
	/**
	 * Constructor por defecto de la clase Carta que inicializa los atributos
	 * Atributos: char valor, boolean oculta, String imagenReverso, String imagenFrontal
	 */
	public Carta() {
		
		valor=' '; //1,2 ,3 4, 5, 6, 7, 8 , 9 , 10 (A),Valet(V), Dame (D) y Roi (R)
		oculta=true;
		imagenReverso=" ";
		imagenFrontal=" ";
	}
	/**
	 * Constructor parametrizado de la clase Carta que inicializa los atributos
	 * @param v: Valor de la carta (char)
	 */
	public Carta(char v) {
		
		valor=v;
		
	}
	/**
	 * Método Getter del atributo char valor
	 * @return el valor char de carta
	 */
	public int getValor() {
		return valor;
	}
	/**
	 * Método que devolverá el valor numérico asociada a la carta que será usado posteriormente.
	 * @return valorcarta: entero que devuelve el valor númerico de la carta.
	 */
	public int getValorNumerico() {
		
		int valorcarta = 0;

		switch (valor) {
		case 'A':
			valorcarta = 10;
			break;
		case 'V':
			valorcarta = 11;
			break;
		case 'D':
			valorcarta = 12;
			break;
		case 'R':
			valorcarta = 13;
			break;
		default:
			valorcarta = (int)valor-48;//Resto 48 para dar el numero correcto (codigo ASCII de 0).
			break;
		}
		
		return valorcarta;
	}
	/**
	 * 	Método Getter del atributo boolean oculta
	 * @return si true o false
	 */
	public boolean getOculta() {
		return oculta;
	}
	/**
	 * Método Getter del atributo String imagenReverso
	 * @return el string imagenReverso
	 */
	public String getImagenreverso() {
		return imagenReverso;
	}
	/**
	 * Método Getter del atributo String imagenFronta
	 * l
	 * @return el string imagenFrontal
	 */
	public String getImagenfrontal() {
		return imagenFrontal;
	}
	/**
	 * Método Setter del atributo char Valor que cambia el valor de char cuando se le llame
	 * @param v: char que dice el valor de la carta.
	 */
	public void setValor(char v) {
		
		
		valor=v;
		
	}
	/**
	 * Método Setter del atributo boolean Oculta que cambia el valor  cuando se le llame
	 * @param oc: True si la carta está bocabajo y false si está bocarriba.
	 */
	public void setOculta(boolean oc) {
		oculta=oc;
	}
	/**
	 * Método Setter que sirve para mostrar la carta por detrás de manera visual.
	 * @param reverso: String que la representa
	 */
	public void setImagenreverso(String reverso) {
		imagenReverso=reverso;
	}
	/**
	 * Método Setter que sirve para mostrar la carta por delante de manera visual.
	 * @param frontal: String que la representa
	 */
	public void setImagenfrontal(String frontal) {
		imagenFrontal=frontal;
	}
	/**
	 * Método que muestra por pantalla un String cuando se le llame, el valor de la carta.
	 */
	public String toString() {
	
		return valor+" de ";
		
		
	}
	/**
	 * Método equals que compara dos objetos de tipo Carta.
	 * @param obj: objeto para poder comparar sus valores.
	 * @return devuelve true si son iguales y false si no lo son
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carta other = (Carta) obj;
		if (imagenFrontal == null) {
			if (other.imagenFrontal != null)
				return false;
		} else if (!imagenFrontal.equals(other.imagenFrontal))
			return false;
		if (imagenReverso == null) {
			if (other.imagenReverso != null)
				return false;
		} else if (!imagenReverso.equals(other.imagenReverso))
			return false;
		if (oculta != other.oculta)
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}
	

}
