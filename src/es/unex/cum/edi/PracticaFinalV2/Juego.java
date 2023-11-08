package es.unex.cum.edi.PracticaFinalV2;
import java.io.*;


import java.util.*;
/**
 * Clase en la que implementa todos los métodos del juego.
 * @author Julián Blanco González
 * @version Entrega 12 mayo de la asignatura de Estructura de Datos de la Información
 */
public class Juego {
	//personas: LinkedList de Persona donde al menos tiene que haber un crupier y varios jugadores.
	protected LinkedList<Persona> personas;

	/**
	 * Constructor por defecto de la clase Juego.
	 */
	public Juego() {
		personas=new LinkedList<Persona>();
	}
	/**
	 * Método Getter que devuelve la lista de Persona
	 * @return personas: LinkedList de Persona
	 */
	public LinkedList getPersonas() {
		return personas;
	}
	/**
	 * Método Setter que cambia el valor del LinkedList de persona pasado por parámetro.
	 * @param l: LinkedList de Persona
	 */
	public void setPersonas(LinkedList l) {
		personas=l; 
	}
	/**
	 * Método que cargar lista de Personas (jugadores/mesa)
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void cargar() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream archivoObjetosEnt = new ObjectInputStream(new FileInputStream("datos.dat"));
		personas = (LinkedList) archivoObjetosEnt.readObject();
		archivoObjetosEnt.close();
	}
	/**
	 * Método que añade un jugador o una mesa (crupier) nuevo al juego.
	 * @param p: objeto de tipo persona
	 * @return: función que añade la persona pasada por parámetro.
	 */
	public boolean addPersona(Persona p) {
		return personas.add(p);
	}
	/**
	 * Método más importante de la clase juego que implementa la lógica del JuegoCartaMasAlta.
	 */
	public void Jugar() {
		
		Scanner teclado=new Scanner(System.in); //Variable para introducir el entero por teclado.
		
		
		
		System.out.println("\n*****************************************");
		
		Jugador jugador=null;//jugador que va a jugar
		Mesa mesa=null;//mesa que va a jugar
		int contador=0;//contador de movimientos
		int jugador_acoger;//id del jugador escogido
		int mesa_acoger;//id de la mesa escogida
		boolean encontrado_jugador=false;//booleano que idica si se ha encontrado el jugador.
		boolean encontrado_mesa=false;//booleano que idica si se ha encontrado la mesa.
		
		//Paso 1. Indicar el identificador del jugador.
		System.out.print("Dime el id del jugador: ");
		
		do {
			encontrado_jugador=false;
			jugador_acoger = teclado.nextInt();
			Iterator iterator = personas.iterator();
			while (iterator.hasNext()) {
				Persona aux = (Persona) iterator.next();
				if (aux.getClass().equals(new Jugador().getClass())) {
					Jugador aux2=(Jugador)aux;
					if(aux2.getIdentificador() == jugador_acoger) {
						encontrado_jugador = true;
						jugador=aux2;
						
					}
					
				}
			}
			if(!encontrado_jugador) {
				System.out.print("Id no encontrada de jugador. Introduce una nueva: ");
			}
			
			
		}
		while(!encontrado_jugador);
		
		//jugador=new Jugador(jugador.getNombrePersona(),jugador.getIdentificador());
		//Paso 2. Seleccionar el crupier de la mesa.
		System.out.print("Dime el id de la mesa: "); 

		do {

			encontrado_mesa = false;
			mesa_acoger = teclado.nextInt();
			Iterator iterator = personas.iterator();
			while (iterator.hasNext()) {
				Persona aux = (Persona) iterator.next();
				if (aux.getClass().equals(new Mesa().getClass())) {
					Mesa aux2 = (Mesa) aux;
					if (aux2.getIdentificador() == mesa_acoger) {
						encontrado_mesa = true;
						mesa=aux2;
						
					}
				}

			}
			if (!encontrado_mesa) {
				System.out.print("Id no encontrada de mesa. Introduce una nueva: ");
			}

		} while (!encontrado_mesa);
		
		jugador.setBaraja();
		mesa.setBaraja();
		
		//mesa=new Mesa(mesa.getNombrePersona(),mesa.getIdentificador());
		//Paso 3. Coger el tiempo de comienzo del juego.
		//long tInicial = new Date().getTime();
		long tInicial = System.nanoTime();//Utilicé esté método, ya que el método al hacerlo la máquina, tarda muy poco.
		
		System.out.print("   "+jugador.getNombrePersona()+"\t- \t"+mesa.getNombrePersona()+"\n");
		
		//Paso 4. Jugar al juego CartaMasAlta. Juega un jugador contra la mesa. Cada uno tiene un mazo de 52 cartas.
		//En cada movimiento, se compara el valor de las cartas sacadas por ambos, y quien saque la carta de valor más
		//alto, gana ese movimiento. Gana el jugador que se lleve todas las cartas o el que tenga más cartas a los
		//100 movimientos.
		System.out.println(jugador.getBaraja().getCarta().getValorNumerico());
		while (jugador.getBaraja().getMazo().peek() != null && mesa.getBaraja().getMazo().peek() != null && contador < 100) {//si el jugador tiene cartas y la mesa también y no se han ehecho los 100 movimientos
		
			System.out.print(jugador.getBaraja().getCarta().toString()+"\t- \t"+mesa.getBaraja().getCarta().toString());
			
			if (jugador.getBaraja().getCarta().getValorNumerico() > mesa.getBaraja().getCarta().getValorNumerico()) {// Carta del jugador más alta que la mesa
				
				System.out.print("\tGana "+jugador.getNombrePersona()+"\t("+jugador.getBaraja().getCarta().getValorNumerico()+"-"+mesa.getBaraja().getCarta().getValorNumerico()+") \n");
				
				jugador.getBaraja().getMazo().add(jugador.getBaraja().getMazo().remove());
				jugador.getBaraja().getMazo().add(mesa.getBaraja().getMazo().remove());
				
			} 
			else {// o iguales o la carta de la mesa es mal alta
				if (mesa.getBaraja().getCarta().getValorNumerico() > jugador.getBaraja().getCarta().getValorNumerico()) {//Carta de la mesa más alta.
					
					System.out.print("\tGana "+mesa.getNombrePersona()+"\t("+jugador.getBaraja().getCarta().getValorNumerico()+"-"+mesa.getBaraja().getCarta().getValorNumerico()+") \n");
					mesa.getBaraja().getMazo().add(mesa.getBaraja().getMazo().remove());
					mesa.getBaraja().getMazo().add(jugador.getBaraja().getMazo().remove());
				} else {//Empate
					
					System.out.print("\tEmpate\t\t("+jugador.getBaraja().getCarta().getValorNumerico()+"-"+mesa.getBaraja().getCarta().getValorNumerico()+") \n");
					jugador.getBaraja().getMazo().add(jugador.getBaraja().getMazo().remove());
					mesa.getBaraja().getMazo().add(mesa.getBaraja().getMazo().remove());
				}
			}
			contador++;
		}
		//Paso 5. Coger el tiempo final del juego.
		long tFinal = System.nanoTime();
		//Paso 6. Salvar los datos de la partida en la lista de partidas del jugador.
		// partida jugada por el jugador
		jugador.setPartidas(jugador.getPartidas() + 1);
		// jugador mas cartas que la mesa
		if (jugador.getBaraja().getMazo().size() > mesa.getBaraja().getMazo().size()) {
			jugador.setGanadas(jugador.getGanadas() + 1);
			jugador.addPartida(new Partida(true, (tFinal - tInicial), new Date()));//añade la partida.
			System.out.println(jugador.getNombrePersona()+" ha ganado. Tiene un total de "+(jugador.getBaraja().getMazo().size()-mesa.getBaraja().getMazo().size())+" cartas mas que la mesa "+mesa.getNombrePersona());
		} 
		else if (jugador.getBaraja().getMazo().size() < mesa.getBaraja().getMazo().size()) {
			jugador.setDerrotas(jugador.getPerdidas() + 1);
			jugador.addPartida(new Partida(false, (tFinal - tInicial), new Date()));//añade la partida.
			System.out.println(mesa.getNombrePersona()+" ha ganado. Tiene un total de "+(mesa.getBaraja().getMazo().size()-jugador.getBaraja().getMazo().size())+" cartas mas que el jugador "+jugador.getNombrePersona());
		} 
		else {
			jugador.addPartida(new Partida(false, (tFinal - tInicial), new Date()));//añade la partida.
			System.out.println(jugador.getNombrePersona()+" y la mesa "+mesa.getNombrePersona()+" han empatado a "+jugador.getBaraja().getMazo().size()+" cartas.");
		}
		System.out.println("La partida ha durado: "+(tFinal-tInicial)+" nanosegundos");
				
			

	}
	/**
	 * Método que muestra las personas(jugadores y mesa) que hay en el sistema.
	 */
	public void mostrarJugMesa() {
		
		//1. Muestro los jugadores
		System.out.println("\n****Jugadores****");
		Iterator iterator = personas.iterator();
		while (iterator.hasNext()) {
			Persona aux = (Persona) iterator.next();
			if (aux.getClass().equals(new Jugador().getClass())) {
				Jugador aux2=(Jugador)aux;
				System.out.println(aux2.toString());
				
			}
		}
		//2. Muestro las mesas.
		System.out.println("\n****Mesas****");
		Iterator iterator2 = personas.iterator();
		while (iterator2.hasNext()) {
			Persona aux = (Persona) iterator2.next();
			if (aux.getClass().equals(new Mesa().getClass())) {
				Mesa aux2 = (Mesa) aux;
				System.out.println(aux2.toString());
				

			}
		}
		
	}
	/**
	 * Método que va a mostrar la información y partidas completadas para una determinar persona (dado su id)
	 * @param id: entero que determina el id del jugador
	 */
	public void getInformacion(int id) {
		Jugador jugador;
		boolean encontrado=false;
		Iterator iterator = personas.iterator();
		while (iterator.hasNext()) {
			Persona aux = (Persona) iterator.next();
			if (aux.getClass().equals(new Jugador().getClass())) {
				Jugador aux2=(Jugador)aux;
				if(aux2.getIdentificador() == id) {//si coincide el id
					encontrado=true;
					jugador=aux2;
					System.out.println(aux2.toString());
					System.out.println("\nPartidas jugadas: "+aux2.getPartidas());
					System.out.println("Partidas ganadas: "+aux2.getGanadas());
					System.out.println("Partidas perdidas: "+aux2.getPerdidas());
				}
				
			}
		}
		
		if(!encontrado) {
			System.out.println("id no ecnontrado.");
		}
	
	}
	public void salvar() throws FileNotFoundException, IOException {
		ObjectOutputStream archivoObjetosSal = new ObjectOutputStream(new FileOutputStream("datos.dat"));
		archivoObjetosSal.writeObject(personas);
		archivoObjetosSal.close();
	}
	/**
	 * Método que muestra por pantalla el jugador que ha tardado menos en jugar la partida.
	 */
	public void JugadorMasRapido() {
		
		long tiempoaux=Long.MAX_VALUE;
		Jugador masrapido=new Jugador();
		
		
		Iterator iterator = personas.iterator();
		while (iterator.hasNext()) {
			Persona aux = (Persona) iterator.next();
			if (aux.getClass().equals(new Jugador().getClass())) {
				Jugador aux2=(Jugador)aux;
				Iterator iterator2=aux2.jugadas.iterator();
				while(iterator2.hasNext()) {
					Partida p=(Partida)iterator2.next();
					if(p.getTiempo() <= tiempoaux) {
						tiempoaux=p.getTiempo();
						masrapido=aux2;
					}
				}
				
					
		
				}
				
			}
		
		System.out.println("\nEl jugador que menos ha tardado es: "+masrapido.getNombrePersona()+" con id: "+masrapido.getIdentificador());
		System.out.println("Ha tardado un total de: "+tiempoaux+" nanosegundos.");
		
	}

	/**
	 * Método que muestra de los primeros 10 jugadores, un ranking de victorias.
	 */
	public void RankingGanadores() {
		ArrayList<Jugador> listajugadores = new ArrayList<Jugador>();// Array auxiliar solo de jugadores
		int contador = 1;
		Iterator it = personas.iterator();
		while (it.hasNext()) {
			Persona p = (Persona) it.next();
			if (p.getClass().equals(new Jugador().getClass())) {
				Jugador aux = (Jugador) p;
				listajugadores.add(aux);// Guardo todo los jugadores de la lista en el array de juagdores auxilair.
			}
		}
		if (listajugadores.size() == 0) {
			System.out.println("No hay ningún jugador en la lista del juego");
		} else {
			Collections.sort(listajugadores);
			Iterator iterator = listajugadores.iterator();
			while (iterator.hasNext() && contador <= 10) {
				Jugador aux2 = (Jugador) iterator.next();
				System.out.println("Posición: " + contador + "\t" + aux2.getNombrePersona());
				contador++;
			}
		}

	}
	/**
	 * Método que muestra de los primeros 10 jugadores de la lista, un ranking de derrotas.
	 */
	public void RankingPerdedores() {
		ArrayList<Jugador> listajugadores = new ArrayList<Jugador>();// Array auxiliar solo de jugadores
		int contador = 1;
		Iterator it = personas.iterator();
		while (it.hasNext()) {
			Persona p = (Persona) it.next();
			if (p.getClass().equals(new Jugador().getClass())) {
				Jugador aux = (Jugador) p;
				listajugadores.add(aux);// Guardo todo los jugadores de la lista en el array de juagdores auxilair.
			}
		}
		if (listajugadores.size() == 0) {
			System.out.println("No hay ningún jugador en la lista del juego");
		} else {
			Collections.sort(listajugadores);
			Iterator iterator = listajugadores.iterator();
			ListIterator iteradorinverso = listajugadores.listIterator(listajugadores.size());
			while (iteradorinverso.hasPrevious() && contador <= 10) {
				Jugador aux2 = (Jugador) iteradorinverso.previous();
				System.out.println("Posición: " + contador + "\t" + aux2.getNombrePersona());
				contador++;
			}
		}
	}
}
