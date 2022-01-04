package Aplicacio;

import Dades.Arbre;
import Dades.Arbust;
import Dades.ListaPlantacions;
import Dades.LlistaPlantes;
import Dades.Planta;
import Dades.Plantacions;
import Dades.Rodal;
import Dades.TipusTerreny;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class main {

	// ORGANIZAR MAIN EN METODOS SEPARADOS

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int eleccio = -1, any;
		boolean bucle = true;

		
		/*
		//demuestra que funciona
		int[] rang1= {1,2,3,4,5};
		Arbre a1=new Arbre(rang1, 1);
		Arbust ar1= new Arbust(2);
		Planta[] listaplantas= {a1,ar1};
		TipusTerreny t1= new TipusTerreny(listaplantas, "Terreny 1");
		Rodal r1=new Rodal(t1, 10);
		Plantacions p= new Plantacions("Plantacions SA", 2, r1);
		ListaPlantacions listaPlantacionsActual= new ListaPlantacions();
		listaPlantacionsActual.afegirPlantacions(p);
		listaPlantacionsActual.eliminarPlantacio(p);
		System.out.println(listaPlantacionsActual);
		*/
		
		any = demanaAnyValid(scanner);		
		InformeAfegits(LlegirFitxer());
		
		//cargar datos automaticamente, si no carga nada porque no hay nada que cargar se notifica
		
		do {
			mostrarOpcions();
			eleccio = demanaEleccioValida(scanner);

			switch (eleccio) {
			case 1:
				InformeAfegits(LlegirFitxer());
				// Carregar les dades dels fitxers
				break;
			case 2:
				// Llistar dades de tots els tipus de terreny
				break;
			case 3:
				// Llistar les dades de totes les plantacions
				break;
			case 4:
				// Llistar les dades de plantacions amb un rodal dun tipus de terreny
				
				//Deamana TipusTerreny
				//Comprobar plantacions amb aquest tipus terreny i imprimir les dades				
				break;
			case 5:
				//Donada una plantació, mostrar quantes unitats de cada espècie s'hi ha plantat
				
				//Demana plantació
				//Buscar la plantació i mostrar les unidats de cada espècie plantades
				break;
			case 6:
				//Llistar dades de totes les especies
				break;
			case 7:
				//Demanar nom especie
				//Demanar edat
				//mostrar quantitat de co2 que permet absorbir
				break;
			case 8:
				//demanar dades nova especie de planta
				//Afegir nova especie de planta
				break;
			case 9:
				//demanar nom plantacio
				//Esborrar les dades d'una plantacio
				break;
			case 10:
				//Modificar l'any d'una plantació
				//Demanar plantació que es vol cambiar l'any(demanar nom plantacio)
				break;
			case 11:
				//Demanar plantacio, rodal
				//Cambiar dades rodal
				break;
			case 12:
				try {
					System.out.print("Introdueix l'any: ");
					any = scanner.nextInt();
					if (any < 0) {
						System.out.println(" - Any no vàlid (no pot ser negatiu).\n");
					} else {
						System.out.println(" - L'any es " + any + " y es vàlid!");

						// ----------------------------------------------
						// Llamar a metodo que cambia el año

					}
				} catch (Exception e) {
					System.out.println(" - Error! Any no vàlid.\n");
					scanner.next();
				}
				break;
			case 13:
				//Mostrar quantitat de CO2 que permet absorir cada rodal d'una plantacio en l'any actual
				//demanar nom plantacio
				break;
			case 14:
				//Mostrar quantitat de CO2 que permet absorir un conjunt de plantes d'una especie de totes les plantacions on estigui en l'any actual
				//demanar nom plantacio
				break;
			case 15:
				bucle = false;
				// Preguntar al usuario si quiere guardar los archivos (sobreescribiendo los
				// antiguos)
				break;
			default:
				System.out.println("Error!!! - Opció default.");
				// Mai entra al default
				break;
			}

		} while (bucle);
	}

	private static void InformeAfegits(int llegirFitxer) {

		//-1 error al añadir algo, 0 no se ha añadido nada
		// 1 se ha añadido plantas, 2 se ha añadido plantaciones
		//3 se ha añadido terrenos, 4 se ha añadido plantas y plantaciones
		//5 se ha añadido plantas y terrenos, 6 se ha añadido plantaciones y terrenos
		//7 se ha añadido todo
		switch (llegirFitxer) {
		case -1:
			System.out.println(" - Error al llegir algun fitxer.\n");
			break;
		case 0:
			System.out.println(" - No s'ha carregat cap dada.\n");
			break;
		case 1:
			System.out.println(" - S'han carregat les plantes.\n");
			break;
		case 2:
			System.out.println(" - S'han carregat les plantacions.\n");
			break;
		case 3:
			System.out.println(" - S'han carregat els terrenys.\n");
			break;
		case 4:
			System.out.println(" - S'han carregat les plantes y les plantacions.\n");
			break;
		case 5:
			System.out.println(" - S'han carregat les plantes y els terrenys.\n");
			break;
		case 6:
			System.out.println(" - S'han carregat les plantacions y els terrenys.\n");
			break;
		case 7:
			System.out.println(" - S'han carregat les plantes, plantacions y els terrenys.\n");
			break;
		default:
			System.out.println("Error!!! - Opció default (Informació al carregar dades).");
			// Mai entra al default
			break;
		}
	}

	private static void mostrarOpcions() {
		System.out.println("[1] - Carregar les dades dels fitxers.");
		System.out.println("[2] - Llistar les dades de tots els tipus de terreny.");
		System.out.println("[3] - Llistar les dades de totes les plantacions.");
		System.out.println("[4] - Llistar les dades de les plantacions que tenen algun rodal d’un tipus de terreny.");
		System.out.println("[5] - Donada una plantació, mostrar quantes unitats de cada espècie s’hi ha plantat.");
		System.out.println("[6] - Llistar les dades de totes les espècies.");
		System.out.println("[7] - Donada una espècie i una edat, mostrar la quantitat de CO2 que permet absorbir.");
		System.out.println("[8] - Afegir una nova espècie de planta.");
		System.out.println("[9] - Esborrar les dades d’una plantació.");
		System.out.println("[10] - Modificar l’any de plantació d’una plantació");
		System.out.println("[11] - Modificar les dades d’un rodal d’una plantació.");
		System.out.println("[12] - Modificar l’any en què ens trobem.");
		System.out.println(
				"[13] - Mostrar la quantitat de CO2 que permet absorbir cada rodal d’una plantació en l’any actual.");
		System.out.println(
				"[14] - Mostrar la quantitat de CO2 que permet absorbir el conjunt d’unitats plantades d’una espècie (entre totes les plantacions que tenim guardades) en l’any actual.");
		System.out.println("[15] - Sortir.");
	}

	private static int demanaEleccioValida(Scanner scanner) {
		int eleccio = -1;
		do {
			try {
				System.out.print("Elecció: ");
				eleccio = scanner.nextInt();
				if (eleccio < 0) {
					System.out.println(" - Introdueix una opció vàlida.\n");
				}
			} catch (Exception e) {
				System.out.println(" - Error! Introdueix una opció vàlida.\n");
				scanner.next();
			}
		} while (eleccio < 0 || eleccio > 15);
		return eleccio;
	}

	private static int demanaAnyValid(Scanner scanner) {
		int any = -1;
		do {
			System.out.print("En quin any estem? ");
			try {
				any = scanner.nextInt();
				if (any < 0) {
					System.out.println(" - Introdueix un any vàlid (no negatiu).\n");
				}
			} catch (Exception e) {
				System.out.println(" - Error! Introdueix un any vàlid.\n");
				scanner.next();
			}

		} while (any < 0);
		return any;
	}

	// LEER DATOS
	public static int LlegirFitxer() {
		int resultado = 0;
		//-1 error al añadir algo, 0 no se ha añadido nada
		// 1 se ha añadido plantas, 2 se ha añadido plantaciones
		//3 se ha añadido terrenos, 4 se ha añadido plantas y plantaciones
		//5 se ha añadido plantas y terrenos, 6 se ha añadido plantaciones y terrenos
		//7 se ha añadido todo
		try {
			
			//archivo plantas
			//0 - arbol || 1 - arbusto	
			
			BufferedReader readerPlantacions = new BufferedReader(new FileReader("plantes.txt"));
			File archivoPlantes = new File ("plantes.txt");

			//existe el archivo?
			if (archivoPlantes.exists()) {
				BufferedReader readerPlantes = new BufferedReader(new FileReader("plantes.txt"));
				
				//crear lista plantas con tamaño segun lineas tenga el archivo de plantas
				LlistaPlantes plantes = new LlistaPlantes(contarLineas(readerPlantes));
				
				String line = readerPlantes.readLine();
				while (line != null) {
					//cargar datos
					//al cargar los datos se tiene que inicializar todo
					Planta aux = new Planta;
					//line tiene toda la linea de texto				
					
					

					int[] rang1= {1,2,3,4,5};
					Arbre a1=new Arbre(rang1, 1);
					
					
					
					
					
					
					// read next line
					line = readerPlantes.readLine();
				}
				readerPlantes.close();
				resultado = 1;
			} else {
				
			}
		} catch (Exception e) {
			System.out.println("!!! - Error al llegir el fitxer: " + e);
			resultado = -1;
		}
		return resultado;
	}

	// GUARDAR DATOS
	public static void GuardarFitxer() {
		try {
			
			//existe el archivo?
				//si
					//sobreescribir datos
				//no
					//crear archivo y guardar datos
			
			BufferedReader reader = new BufferedReader(new FileReader("dades.txt"));
			String line = reader.readLine();
			while (line != null) {

				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("!!! - Error al guardar el fitxer: " + e);
		}
	}

	public static int contarLineas(BufferedReader br) {	//simplemente contará cuantas líneas tiene el archivo original
		return (int) br.lines().count();
	}
}
