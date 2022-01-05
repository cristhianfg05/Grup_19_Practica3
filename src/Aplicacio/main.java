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
		int eleccio = -1, any, i, aux;
		boolean trobat, bucle = true;
		String text = "";
		ListaPlantacions listaPlantacionsActual = new ListaPlantacions();
		LlistaPlantes listaPlantesActual = new LlistaPlantes();

		any = demanaAnyValid(scanner);
		listaPlantesActual = LlegirFitxerPlantes();
		listaPlantacionsActual = LlegirFitxerPlantacions();

		do {
			mostrarOpcions();
			eleccio = demanaEleccioValida(scanner);

			switch (eleccio) {
			case 1:
				// Carregar les dades dels fitxers
				break;
			case 2:
				// Llistar dades de tots els tipus de terreny
				break;
			case 3:
				System.out.println(listaPlantacionsActual + "\n");
				// Llistar les dades de totes les plantacions
				break;
			case 4:
				// Llistar les dades de plantacions amb un rodal dun tipus de terreny

				// Deamana TipusTerreny
				// Comprobar plantacions amb aquest tipus terreny i i,mprimir les dades

				try {
					System.out.print("Introdueix el nom del tipus de Terreny: ");
					text = scanner.nextLine(); // en principio con poner nextline basta
					trobat = false;
					i = 0;
					while (i < listaPlantacionsActual.getNumEstacions() && !trobat) {
						// si el nom de la plantacio introducida esta en la lista de plantaciones
						if (text.equalsIgnoreCase(listaPlantacionsActual.getLista()[i].getNom())) {
							// Es demana l'any quan es troba la plantació (no abans)
							System.out.print("Introdueix l'any: ");
							any = demanaAnyValid(scanner);
							listaPlantacionsActual.getLista()[i].setAny(any);
							trobat = true;
						}
						i++;
					}
					if (!trobat) {
						System.out.println(" - No s'ha trobat cap plantació amb el nom: " + text);
					}
				} catch (Exception e) {
					System.out.println(" - Error al intentar cambiar l'any de la plantació.");
				}
				break;
			case 5:
				// Donada una plantació, mostrar quantes unitats de cada espècie s'hi ha plantat

				// Demana plantació
				// Buscar la plantació i mostrar les unidats de cada espècie plantades
				break;
			case 6:
				break;
			case 7:
				// Demanar nom especie
				// Demanar edat
				// mostrar quantitat de co2 que permet absorbir
				break;
			case 8:
				// demanar dades nova especie de planta
				// Afegir nova especie de planta
				break;
			case 9:
				// demanar nom plantacio
				// Esborrar les dades d'una plantacio
				break;
			case 10:
				// Modificar l'any d'una plantació
				// Demanar plantació que es vol cambiar l'any(demanar nom plantacio)
				try {
					System.out.print("Introdueix el nom de la plantació que vols cambiar l'any: ");
					text = scanner.nextLine(); // en principio con poner nextline basta
					trobat = false;
					i = 0;
					while (i < listaPlantacionsActual.getNumEstacions() && !trobat) {
						// si el nom de la plantacio introducida esta en la lista de plantaciones
						if (text.equalsIgnoreCase(listaPlantacionsActual.getLista()[i].getNom())) {
							// Es demana l'any quan es troba la plantació (no abans)
							System.out.print("Introdueix l'any: ");
							aux = demanaAnyValid(scanner);
							listaPlantacionsActual.getLista()[i].setAny(aux);
							trobat = true;
						}
						i++;
					}
					if (!trobat) {
						System.out.println(" - No s'ha trobat cap plantació amb el nom: " + text);
					}
				} catch (Exception e) {
					System.out.println(" - Error al intentar cambiar l'any de la plantació.");
				}
				break;
			case 11:
				// Demanar plantacio, rodal
				// Cambiar dades rodal
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
				// Mostrar quantitat de CO2 que permet absorir cada rodal d'una plantacio en
				// l'any actual
				// demanar nom plantacio
				break;
			case 14:
				// Mostrar quantitat de CO2 que permet absorir un conjunt de plantes d'una
				// especie de totes les plantacions on estigui en l'any actual
				// demanar nom plantacio
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

	// LEER DATOS
	public static LlistaPlantes LlegirFitxerPlantes() {
		LlistaPlantes listaPlantesActual = new LlistaPlantes();
		try {
			float rang[];
			int c;
			File archivoPlantes = new File("plantes.txt");
			String line;
			Arbre arbol_nuevo;
			Arbust arbusto_nuevo;
			if (archivoPlantes.exists()) {
				BufferedReader readerPlantes = new BufferedReader(new FileReader("plantes.txt"));
				listaPlantesActual = new LlistaPlantes(contarLineas(readerPlantes));
				// Es torna a inicialitzar per poder llegir el contigut (un cop es saben les
				// lines)
				readerPlantes = new BufferedReader(new FileReader("plantes.txt"));
				line = readerPlantes.readLine();
				// archivo plantas
				// 0 - arbol || 1 - arbusto
				while (line != null) {
					// 0 = arbol
					if (Integer.valueOf(line.split(";")[0]) == 0) {
						rang = new float[Integer.valueOf(line.split(";")[3])];
						c = 4;
						for (int i = 0; i < rang.length; i++) {
							rang[i] = Float.valueOf(line.split(";")[c]);
							c++;
						}
						arbol_nuevo = new Arbre(line.split(";")[1], rang, Integer.valueOf(line.split(";")[2]));
						listaPlantesActual.afegirPlanta(arbol_nuevo);
					} else {
						// 1 = arbusto
						arbusto_nuevo = new Arbust(Integer.valueOf(line.split(";")[2]), line.split(";")[1],
								Float.valueOf(line.split(";")[3]));
						listaPlantesActual.afegirPlanta(arbusto_nuevo);
					}
					// read next line
					line = readerPlantes.readLine();
				}
				System.out.println(" - S'ha carregat l'arxiu de les plantes.");
				readerPlantes.close();
			} else {
				System.out.println("- No hi ha arxiu de plantes que cargar.");
			}
		} catch (Exception e) {
			System.out.println("!!! - Error al llegir el fitxer de les plantes: " + e);
		}
		return listaPlantesActual;
	}

	public static ListaPlantacions LlegirFitxerPlantacions() {
		ListaPlantacions listaPlantacionsActual = new ListaPlantacions();
		try {
			// archivo plantas
			// 0 - arbol || 1 - arbusto
			File archivoPlantes = new File("plantes.txt");
			String line;
			Arbre arbol_nuevo;
			Arbust arbusto_nuevo;
			Plantacions plantacion_nueva;
			Rodal rodal_nuevo;
			Rodal[] array_rodal;
			TipusTerreny terreny_nuevo;
			// existe el archivo?

//			System.out.println(listaPlantesActual.toString());
			// LLEGIR PLANTACIONS

			File archivoPlantacions = new File("plantacions.txt");

			// existe el archivo?
			if (archivoPlantacions.exists()) {
				/*
				 * //demuestra que funciona int[] rang1= {1,2,3,4,5}; Arbre a1=new Arbre(rang1,
				 * 1); Arbust ar1= new Arbust(2); Planta[] listaplantas= {a1,ar1}; TipusTerreny
				 * t1= new TipusTerreny(listaplantas, "Terreny 1"); Rodal r1=new Rodal(t1, 10);
				 * Plantacions p= new Plantacions("Plantacions SA", 2, r1);
				 * listaPlantacionsActual.afegirPlantacions(p);
				 * listaPlantacionsActual.eliminarPlantacio(p);
				 * System.out.println(listaPlantacionsActual);
				 */

				BufferedReader readerPlantacions = new BufferedReader(new FileReader("plantacions.txt"));
				line = readerPlantacions.readLine();				
				while (line != null) {
					Planta[] arrayPlanta = new Planta[5];
					Planta planta_aux = new Arbust(100, "NomArbust", 50);
					arrayPlanta[0] = planta_aux;
					arrayPlanta[1] = planta_aux;
					arrayPlanta[2] = planta_aux;
					arrayPlanta[3] = planta_aux;
					arrayPlanta[4] = planta_aux;

					// array
					terreny_nuevo = new TipusTerreny(arrayPlanta, line.split(";")[2]);
					rodal_nuevo = new Rodal(terreny_nuevo, 2);
					array_rodal = new Rodal[Integer.valueOf(line.split(";")[2])];

					// rodal deberia ser un array de rodals

					plantacion_nueva = new Plantacions(line.split(";")[0], Integer.valueOf(line.split(";")[1]),
							array_rodal);

					listaPlantacionsActual.afegirPlantacions(plantacion_nueva);
					// read next line
					line = readerPlantacions.readLine();
				}
				System.out.println(" - S'ha carregat l'arxiu de les plantacions.");
			} else {
				System.out.println("- No hi ha arxiu de plantacions que cargar.");
			}

		} catch (Exception e) {
			System.out.println("!!! - Error al llegir el fitxer de les plantacions: " + e);
		}
		return listaPlantacionsActual;
	}

	// GUARDAR DATOS
	public static void GuardarFitxer() {
		try {

			// existe el archivo?
			// si
			// sobreescribir datos
			// no
			// crear archivo y guardar datos

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

	public static int contarLineas(BufferedReader br) { // simplemente contará cuantas líneas tiene el archivo original
		return (int) br.lines().count();
	}

	private static void mostrarOpcions() {
		System.out.println("\n[1] - Carregar les dades dels fitxers.");
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

}
