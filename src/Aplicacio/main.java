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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class main {

	// ORGANIZAR MAIN EN METODOS SEPARADOS

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int eleccio = -1, any, i, aux;
		boolean trobat, bucle = true;
		String text = "";
		ListaPlantacions listaPlantacionsActual = new ListaPlantacions();
		ListaTipusTerreny listaTipusTerrenyActual = new ListaTipusTerreny();
		LlistaPlantes listaPlantesActual = new LlistaPlantes();

		listaPlantesActual = LlegirFitxerPlantes(); // listaPlantesActual se añade OK
		listaTipusTerrenyActual = LlegirFitxerTipusTerreny(); // listaTipusTerrenyActual se añade OK (todo serializable)

		/*
		 * LlistaPlantes plantas_terreno = new LlistaPlantes(); int[] unitatsHra1 = new
		 * int[5]; int[] unitatsHra2 = new int[5]; int[] unitatsHra3 = new int[5];
		 * TipusTerreny nuevo_terreno;
		 * 
		 * plantas_terreno.afegirPlanta(listaPlantesActual.
		 * buscarPlanta("Pinus sylvestris"));
		 * plantas_terreno.afegirPlanta(listaPlantesActual.buscarPlanta("Pinus nigra"));
		 * plantas_terreno.afegirPlanta(listaPlantesActual.
		 * buscarPlanta("Fraxinus excelsior"));
		 * plantas_terreno.afegirPlanta(listaPlantesActual.
		 * buscarPlanta("Acer pseudoplatanus"));
		 * plantas_terreno.afegirPlanta(listaPlantesActual.buscarPlanta("Populus nigra")
		 * ); unitatsHra1[0] = 150; unitatsHra1[1] = 130; unitatsHra1[2] = 220;
		 * unitatsHra1[3] = 210; unitatsHra1[4] = 190; nuevo_terreno = new
		 * TipusTerreny(plantas_terreno, "CalcariSolana", unitatsHra1);
		 * listaTipusTerrenyActual.afegirTerreny(nuevo_terreno);
		 * 
		 * plantas_terreno.afegirPlanta(listaPlantesActual.
		 * buscarPlanta("Pinus sylvestris"));
		 * plantas_terreno.afegirPlanta(listaPlantesActual.
		 * buscarPlanta("Corylus Avellana"));
		 * plantas_terreno.afegirPlanta(listaPlantesActual.
		 * buscarPlanta("Spartium junceum"));
		 * plantas_terreno.afegirPlanta(listaPlantesActual.buscarPlanta("Quercus ilex"))
		 * ;
		 * plantas_terreno.afegirPlanta(listaPlantesActual.buscarPlanta("Betula alba"));
		 * unitatsHra2[0] = 190; unitatsHra2[1] = 200; unitatsHra2[2] = 150;
		 * unitatsHra2[3] = 200; unitatsHra2[4] = 160; nuevo_terreno = new
		 * TipusTerreny(plantas_terreno, "CalcariObaga", unitatsHra2);
		 * listaTipusTerrenyActual.afegirTerreny(nuevo_terreno);
		 * 
		 * plantas_terreno.afegirPlanta(listaPlantesActual.
		 * buscarPlanta("Fraxinus excelsior"));
		 * plantas_terreno.afegirPlanta(listaPlantesActual.
		 * buscarPlanta("Corylus Avellana"));
		 * plantas_terreno.afegirPlanta(listaPlantesActual.
		 * buscarPlanta("Acer pseudoplatanus"));
		 * plantas_terreno.afegirPlanta(listaPlantesActual.buscarPlanta("Quercus ilex"))
		 * ;
		 * plantas_terreno.afegirPlanta(listaPlantesActual.buscarPlanta("Populus nigra")
		 * ); unitatsHra3[0] = 110; unitatsHra3[1] = 170; unitatsHra3[2] = 280;
		 * unitatsHra3[3] = 100; unitatsHra3[4] = 130; nuevo_terreno = new
		 * TipusTerreny(plantas_terreno, "ArgilaSolana", unitatsHra3);
		 * listaTipusTerrenyActual.afegirTerreny(nuevo_terreno);
		 */

		listaPlantacionsActual = LlegirFitxerPlantacions(listaTipusTerrenyActual); // listaPlantacionsActual se añade OK
		System.out.println("\n" + listaPlantesActual.toString());
		System.out.println(listaTipusTerrenyActual.toString());
		System.out.println(listaPlantacionsActual.toString());

		any = demanaAnyValid(scanner);
		do {
			mostrarOpcions();
			eleccio = demanaEleccioValida(scanner);

			// hay un problema con el buffer al leer (cuando pide leer por teclado no deja)

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
						for (int j = 0; j < listaPlantacionsActual.getLista()[i].getRodals().length; j++) {
							if (text.equalsIgnoreCase(
									listaPlantacionsActual.getLista()[i].getRodals()[j].getTipus().getNom())) {

								System.out.println("existe");

								trobat = true;
							}
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
				System.out.println("Escriu el nom de la plantacio.");
				// String nom = scanner.next();
				trobat = false;
				i = 0;
				while (i < listaPlantacionsActual.getLista().length && !trobat) {
					if (listaPlantacionsActual.getLista()[i].getNom().equalsIgnoreCase("Finca les pedres")) {
						trobat = true;
					}
					i++;
				}
				if (trobat) {
					for (int j = 0; j < listaPlantacionsActual.getLista()[i].getRodals().length; j++) {
						System.out.println(listaPlantacionsActual.getLista()[i].getRodals()[j].quantitatCO2());
					}
				} else {
					System.out.println("No s'ha trobat cap terreny amb aquest nom");
				}
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
					System.out.println("[1] - No.");
					eleccio = demanaGuardarValid(scanner);
					if (eleccio == 0) {
						GuardarFitxer(scanner, listaTipusTerrenyActual, listaPlantacionsActual, listaPlantesActual);
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
						arbol_nuevo = new Arbre(line.split(";")[1], rang, Integer.valueOf(line.split(";")[2]));
						listaPlantesActual.afegirPlanta(arbol_nuevo);
					} else {
						// 1 = arbusto
						arbusto_nuevo = new Arbust(Integer.valueOf(line.split(";")[2]), line.split(";")[1],
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

				FileInputStream fis = new FileInputStream("terrenys.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				listaTipusTerrenyActual = (ListaTipusTerreny) ois.readObject();
				ois.close();

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

	public static ListaPlantacions LlegirFitxerPlantacions(ListaTipusTerreny listaTipusTerrenyActual) {
		ListaPlantacions listaPlantacionsActual = new ListaPlantacions();
		try {
			String line;
			Rodal rodal_nuevo;
			Rodal[] array_rodal;
			TipusTerreny terreny_nuevo;
			LlistaPlantes listaPlantas;
			int unitatsHra[] = new int[5];
			File archivoPlantacions = new File("plantacions.txt");
			if (archivoPlantacions.exists()) {
				BufferedReader reader = new BufferedReader(new FileReader("plantacions.txt"));
				line = reader.readLine();
				while (line != null) {
					array_rodal = new Rodal[Integer.valueOf(line.split(";")[2])];
					int contador_co2 = 4;
					int contador_nom_terreny = 3;
					for (int i = 0; i < array_rodal.length; i++) {
						listaPlantas = listaTipusTerrenyActual
								.plantacionsTipusTerreny(line.split(";")[contador_nom_terreny]);

						unitatsHra = listaTipusTerrenyActual.HraTipusTerreny(line.split(";")[contador_nom_terreny]);

						terreny_nuevo = new TipusTerreny(listaPlantas, line.split(";")[contador_nom_terreny],
								unitatsHra);
						contador_nom_terreny += 2;
						rodal_nuevo = new Rodal(terreny_nuevo, Float.valueOf(line.split(";")[contador_co2]));
						contador_co2 += 2;
						array_rodal[i] = rodal_nuevo;
					}
					listaPlantacionsActual.afegirPlantacions(
							new Plantacions(line.split(";")[0], Integer.valueOf(line.split(";")[1]), array_rodal));
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
	public static void GuardarFitxer(Scanner scanner, ListaTipusTerreny listaTipusTerrenyActual,
			ListaPlantacions listaPlantacionsActual, LlistaPlantes listaPlantesActual) {
		try {
			File file = new File("plantes_save.txt");
			FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

			System.out.println("\nAUN NO SE SOBREESCRIBE - PLANTAS");
			for (int i = 0; i < listaPlantesActual.getNumPlantes(); i++) {
				if (listaPlantesActual.getLista()[i] instanceof Arbre) {
					bw.write("0;");
					bw.write(listaPlantesActual.getLista()[i].getNom() + ";");
					/*
					 * 
					 * bw.write(listaPlantesActual.getLista()[i].getEdatActual() + ";");
					 * bw.write(listaPlantesActual.getLista()[i].getRangs().length); for (int j = 0;
					 * j < listaPlantesActual.getLista()[i].getRangs().length; j++) { bw.write(";" +
					 * listaPlantesActual.getLista()[i].getRangs()[j]); }
					 * 
					 */
				} else {
					bw.write("1;");
					bw.write(listaPlantesActual.getLista()[i].getNom() + ";");
					// bw.write(listaPlantesActual.getLista()[i].getEdatmaxima() + ";");
					// bw.write(listaPlantesActual.getLista()[i].getAbsorcioCO2());
				}

				bw.newLine();
			}

			bw.close();
		} catch (Exception e) {
			System.out.println("!!! - Error al guardar el fitxer: " + e);
		}

		try {
			// Guardar terrenys.dat (Serializado)
			FileOutputStream fout = new FileOutputStream("terrenys.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(listaTipusTerrenyActual);
			oos.close();
			System.out.println("SE HA SOBREESCRITO EL ARCHIVO 'terrenys.dat' SERIALIZADO");
		} catch (Exception e) {
			System.out.println("!!! - Error al guardar el fitxer: " + e);
		}

		try {
			// guardar plantaciones
			System.out.println("AUN NO SE SOBREESCRIBE - PLANTACIONS");
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
				eleccio = Integer.parseInt(scanner.nextLine());
				if (eleccio < 1 || eleccio > 15) {
					System.out.println(" - Introdueix una opció vàlida.\n");
				}
			} catch (NumberFormatException e) {
				System.out.println(" - Error! Has d'introduir un valor numèric " + e + "\n");
			} catch (Exception e) {
				System.out.println(" - Error! Introdueix una opció vàlida " + e);
			}
		} while (eleccio < 1 || eleccio > 15);
		return eleccio;
	}

	private static int demanaAnyValid(Scanner scanner) {
		int any = -1;
		System.out.println();
		do {
			System.out.print("En quin any estem? ");
			try {
				any = Integer.parseInt(scanner.nextLine());
				if (any < 0) {
					System.out.println(" - Introdueix un any vàlid (no pot ser negatiu).\n");
				}
			} catch (NumberFormatException e) {
				System.out.println(" - Error! Has d'introduir un valor numèric " + e + "\n");
			} catch (Exception e) {
				System.out.println(" - Error! Introdueix un any vàlid " + e);
			}
		} while (any < 0);
		return any;
	}

	private static int demanaGuardarValid(Scanner scanner) {
		int eleccio = -1;
		do {
			try {
				System.out.print("Elecció: ");
				eleccio = Integer.parseInt(scanner.nextLine());
				if (eleccio != 0 && eleccio != 1) {
					System.out.println(" - Introdueix una opció vàlida.\n");
				}
			} catch (NumberFormatException e) {
				System.out.println(" - Error! Has d'introduir un valor numèric " + e + "\n");
			} catch (Exception e) {
				System.out.println(" - Error! Introdueix una opció vàlida " + e);
			}
		} while (eleccio != 0 && eleccio != 1);
		return eleccio;
	}
}
