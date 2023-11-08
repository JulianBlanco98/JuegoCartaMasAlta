package es.unex.cum.edi.PracticaFinalV2;
import java.util.*;
import java.io.*;
/**
 * Clase Main en la que se ejecuta el men� del Juego
 * @author Juli�n Blanco Gonz�lez
 * @version Entrega 12 mayo de la asignatura de Estructura de Datos de la Informaci�n
 */


public class JuegoCartaMasAlta {
	
	private JuegoCartaMasAlta jugar;
	

	public static void main(String[] args) throws IOException, ClassNotFoundException, FileNotFoundException{
		
		Juego juego=new Juego();
		boolean salir=false;
		Scanner teclado=new Scanner(System.in);
		
		//Voy a a�adir 3 personas predeterminadas y una mesa, para la primera vez no empezar desde 0.
		
		System.out.println("Juego de Carta M�s Alta");
		System.out.println("Eleccion: ");
		
		
		int eleccion;
		//Men� del Juego
		while(!salir) {
			System.out.println("\n\n\n1. Cargar Lista de Personas");
			System.out.println("2. A�adir nueva persona(jugador/mesa)");
			System.out.println("3. Jugar");
			System.out.println("4. Mostar las personas del sistema");
			System.out.println("5. Mostrar la informaci�n seg�n el ID");
			System.out.println("6. Salvar la lista de personas");
			System.out.println("7. Ranking de Jugadores");
			System.out.println("8. Jugador m�s r�pido");
			System.out.println("9. Salir del Juego");
			System.out.print("�Qu� quieres hacer?: ");
			
			eleccion=teclado.nextInt();
			/**
			 * Hago un switch para que el usuario la opc�on que quiera.
			 */
			switch(eleccion) {
			//Caso 1. Cargar Lista de Personas(Serializable)
			case 1:  
				try {
					juego.cargar();
				} catch (Exception e) {
					System.out.println("Problema al cargar. Empezamos de 0.");
					juego.personas = new LinkedList<Persona>();
					/*juego.personas.add(new Mesa("Mesa 1",1));
					juego.personas.add(new Jugador("Juli�n",10));
					juego.personas.add(new Jugador("Luis",5));
					juego.personas.add(new Jugador("Carlos",4));*/
				}

				break;
			//Caso 2. A�adir nueva persona(jugador/mesa
			case 2:
				int opcion;
				String name;
				int id;
				boolean encontrado = false;
				System.out.println("\n1-->Introduce Jugador/2-->Introduce Mesa");
				System.out.print("�Que qu�eres meter: ");
				opcion = teclado.nextInt();
				while (opcion < 1 || opcion > 2) {
					System.out.println("Error. Introduce una opci�n correcta");
					System.out.print("�Que qu�eres meter: ");
					opcion = teclado.nextInt();
				}
				
				System.out.print("Introduce su id: ");
				do {
					encontrado = false;
					id = teclado.nextInt();
					Iterator iterator = juego.personas.iterator();
					while (iterator.hasNext()) {
						Persona aux = (Persona) iterator.next();
						if (aux.getIdentificador() == id) {
							encontrado = true;
							System.out.print("Ya hay un jugador o mesa con esta id. Introduce una nueva: ");
						}

					}

				} while (encontrado);
				
				if (opcion == 1) {
					

					System.out.print("Introduce el nombre del jugador: ");
					name = teclado.next();
					juego.addPersona(new Jugador(name, id));
					System.out.println("Jugador creado.....");

				} else {

					System.out.print("Introduce el nombre de la mesa: ");
					name = teclado.next();
					juego.addPersona(new Mesa(name, id));
					System.out.println("Mesa creada.....");

				}

				break;
			//Caso 3. Jugar
			case 3:

				juego.Jugar();

				break;
			//Caso 4. Mostrar todos los jugadores y las mesas.	
			case 4:
				juego.mostrarJugMesa();
				break;
			//Caso 5. Mostrar informaci�n del jugador recibido su id.	
			case 5:
				int id1;
				System.out.print("Buscar al jugador con id: ");
				id1 = teclado.nextInt();
				juego.getInformacion(id1);
				break;
			//Caso 6. Salvar el juego.(Serializable).	
			case 6:
				
					juego.salvar();
				
					

				break;
			//Listar los 10 primeros jugadores con m�s partidas ganadas.
			//Listar los 10 primeros jugadores con m�s partidas perdidas.	
			case 7:
				System.out.println("\n***Ranking de los 10 primeros ganadores****");
				juego.RankingGanadores();
				System.out.println("***Ranking de los 10 primeros perdedores****");
				juego.RankingPerdedores();
				break;
			//Muestra el jugador que ha tardado menos en jugar la partida.	
			case 8:
				juego.JugadorMasRapido();
				break;
			//Sale del juego	
			case 9:
				salir = true;
				break;
			//Si no introduces el numero correcto, te lo pide de nuevo.	
			default:
				System.out.println("\nOpci�n incorrecta. Introduce una opci�n v�lida.");
				break;
			}
		}
		
	}
}
