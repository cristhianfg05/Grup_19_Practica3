package Aplicacio;

import Dades.Arbre;
import Dades.Arbust;
import Dades.ListaPlantacions;
import Dades.ListaTipusTerreny;
import Dades.LlistaPlantes;
import Dades.Planta;
import Dades.Plantacions;
import Dades.Rodal;
import Dades.TipusTerreny;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class main {

	// ORGANIZAR MAIN EN METODOS SEPARADOS

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int eleccio = -1, any, i, aux;
		boolean trobat, bucle = true;
		char tria;
		String text = "";
		ListaPlantacions listaPlantacionsActual = new ListaPlantacions();
		ListaTipusTerreny listaTipusTerrenyActual = new ListaTipusTerreny();
		LlistaPlantes listaPlantesActual = new LlistaPlantes();

		listaPlantesActual = LlegirFitxerPlantes(); // listaPlantesActual se añade OK
		
		listaTipusTerrenyActual = LlegirFitxerTipusTerreny(); // Hay que crear el objeto terreny a mano (faltan metodos
																// para hacerlo (el buscar arbusto/arbol de listaPlantas
																// x ejemplo))
		
		listaPlantacionsActual = LlegirFitxerPlantacions(); // Se añade todo bien menos la lista de plantas que depende
															// de un tipus terreny

		// comprobacion que se carga bien desde los archivos
		System.out.println("\n" + listaPlantesActual.toString());
		System.out.println(listaTipusTerrenyActual.toString());
		System.out.println(listaPlantacionsActual.toString());
		/*
		 * //---------------------------------------------------------------------------
		 * ---- // CREO LA PRIMERA VEZ EL CODIGO DE TERRENYACTUAL
		 * 
		 * //buscar arbol con nombre y devolver //buscar arbusto con nombre y devolver
		 * 
		 * LlistaPlantes plantas_terreno = new LlistaPlantes();
		 * plantas_terreno.afegirPlanta(null); TipusTerreny nuevo_terreno = new
		 * TipusTerreny(plantas_terreno, "CalcariSolana");
		 * //---------------------------------------------------------------------------
		 * ----
		 */
		any = demanaAnyValid(scanner);
		do {
			mostrarOpcions();
			eleccio = demanaEleccioValida(scanner);

			//hay un problema con el buffer al leer
			
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
					while (i < listaPlantacionsActual.getPlantacions() && !trobat) {
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
					while (i < listaPlantacionsActual.getPlantacions() && !trobat) {
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

				if (listaPlantacionsActual != null || listaPlantesActual != null || listaTipusTerrenyActual != null) {
					System.out.println("\nVols sobreescriure els arxius desats anterioment?");
					System.out.println("[0] - Sí.");
					System.out.println("[Qualsevol caràcter] - No.");
					System.out.print("Elecció: ");
					tria = scanner.next().charAt(0);
					if (tria == '0') {
						GuardarFitxer(scanner, listaTipusTerrenyActual);
					} else {
						System.out.println(" - No s'han sobreescrit les dades.");
					}
				} else {
					System.out.println(" - No hi ha res que desar.");
				}
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
			String line;
			Arbre arbol_nuevo;
			Arbust arbusto_nuevo;
			File archivoPlantes = new File("plantes.txt");
			if (archivoPlantes.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader("plantes.txt"));
				listaPlantesActual = new LlistaPlantes(contarLineas(reader));
				// Es torna a inicialitzar per poder llegir el contigut (un cop es saben les
				// lines)
				reader = new BufferedReader(new FileReader("plantes.txt"));
				line = reader.readLine();
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
						// hay que añadir el nuevo parametro numPlantes (cambiar el 0 por ese valor)
						arbol_nuevo = new Arbre(line.split(";")[1], 0, rang, Integer.valueOf(line.split(";")[2]));
						listaPlantesActual.afegirPlanta(arbol_nuevo);
					} else {
						// 1 = arbusto
						arbusto_nuevo = new Arbust(Integer.valueOf(line.split(";")[2]), 0, line.split(";")[1],
								Float.valueOf(line.split(";")[3]));
						listaPlantesActual.afegirPlanta(arbusto_nuevo);
					}
					// read next line
					line = reader.readLine();
				}
				if (listaPlantesActual != null) {
					System.out.println(" - S'ha carregat l'arxiu de les plantes.");
				} else {
					System.out.println(" - No s'ha carregat el contingut de l'arxiu de les plantes.");
				}

				reader.close();
			} else {
				System.out.println("- No hi ha arxiu de plantes que carregar.");
			}
		} catch (Exception e) {
			System.out.println("!!! - Error al llegir el fitxer de les plantes: " + e);
		}
		return listaPlantesActual;
	}

	public static ListaTipusTerreny LlegirFitxerTipusTerreny() {
		ListaTipusTerreny listaTipusTerrenyActual = new ListaTipusTerreny();
		try {
			File archivoTerrenys = new File("terrenys.dat");
			if (archivoTerrenys.exists()) {

				// Creo que con estas lineas ya esta

				InputStream file = new FileInputStream("terrenys.dat");
				InputStream buffer = new BufferedInputStream(file);
				ObjectInput input = new ObjectInputStream(buffer);
				listaTipusTerrenyActual = (ListaTipusTerreny) input.readObject();

				if (listaTipusTerrenyActual != null) {
					System.out.println(" - S'ha carregat l'arxiu dels terrenys.");
				} else {
					System.out.println(" - No s'ha carregat el contingut de l'arxiu dels terrenys.");
				}
			} else {
				System.out.println("- No hi ha arxiu de terrenys que carregar.");
			}
		} catch (Exception e) {
			System.out.println("!!! - Error al llegir el fitxer de les terrenys: " + e);
		}
		return listaTipusTerrenyActual;
	}

	public static ListaPlantacions LlegirFitxerPlantacions() {
		ListaPlantacions listaPlantacionsActual = new ListaPlantacions();
		try {
			String line;
			Rodal rodal_nuevo;
			Rodal[] array_rodal;
			TipusTerreny terreny_nuevo;
			File archivoPlantacions = new File("plantacions.txt");
			if (archivoPlantacions.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader("plantacions.txt"));
				line = reader.readLine();
				while (line != null) {
					array_rodal = new Rodal[Integer.valueOf(line.split(";")[2])];
					int contador_co2 = 4;
					int contador_nom_terreny = 3;
					for (int i = 0; i < array_rodal.length; i++) {

						String nom_terreny = line.split(";")[contador_nom_terreny];

						// METODO QUE LE PASO UN NOM_TERRENY Y ME DEVUELVE SU LISTA DE PLANTAS
						LlistaPlantes a = null;

						terreny_nuevo = new TipusTerreny(a, nom_terreny);
						contador_nom_terreny += 2;
						rodal_nuevo = new Rodal(terreny_nuevo, Float.valueOf(line.split(";")[contador_co2]));
						contador_co2 += 2;
						array_rodal[i] = rodal_nuevo;
					}

					// imprimir array rodal para ver que se ha guardado

					listaPlantacionsActual.afegirPlantacions(
							new Plantacions(line.split(";")[0], Integer.valueOf(line.split(";")[1]), array_rodal));
					// read next line
					line = reader.readLine();
				}
				reader.close();
				if (listaPlantacionsActual != null) {
					System.out.println(" - S'ha carregat l'arxiu de les plantacions.");
				} else {
					System.out.println(" - No s'ha carregat el contingut de l'arxiu de les plantacions.");
				}
			} else {
				System.out.println("- No hi ha arxiu de plantacions que carregar.");
			}

		} catch (Exception e) {
			System.out.println("!!! - Error al llegir el fitxer de les plantacions: " + e);
		}
		return listaPlantacionsActual;
	}

	// GUARDAR DATOS
	public static void GuardarFitxer(Scanner scanner, ListaTipusTerreny listaTipusTerrenyActual) {
		try {
			File archivoPlantes = new File("plantes.txt");
			File archivoPlantacions = new File("plantacions.txt");
			File archivoTerrenys = new File("terrenys.dat");

			System.out.println("\nAUN NO SE SOBREESCRIBE - PLANTAS");
			System.out.println("AUN NO SE SOBREESCRIBE - PLANTACIONS");

			// Guardar terrenys.dat (Serializado)
			FileOutputStream fout = new FileOutputStream("terrenys.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(listaTipusTerrenyActual);
			System.out.println("SE HA SOBREESCRITO EL ARCHIVO 'terrenys.dat' SERIALIZADO");

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
			System.out.print("\nEn quin any estem? ");
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
