package Dades;

import java.util.Arrays;

public class ListaPlantacions {
	private Plantacions[] lista;
	private int numPlantacions;
	
	public ListaPlantacions() {
		super();
		this.lista = new Plantacions[0];			// se crea una lista vacia
		this.numPlantacions = 0;
	}

	public Plantacions[] getLista() {
		return lista;
	}

	public void setLista(Plantacions[] lista) {
		this.lista = lista;
	}

	public int getNumEstacions() {
		return numPlantacions;
	}

	public void setNumEstacions(int numEstacions) {
		this.numPlantacions = numEstacions;
	}

	@Override
	public String toString() {
		return "ListaPlantacions [lista=" + Arrays.toString(lista) + ", numEstacions=" + numPlantacions + "]";
	}
	
	public void afegirPlantacions(Plantacions p) {
		if (numPlantacions >=this.lista.length) {
			Plantacions[] listaCopia = new Plantacions[numPlantacions + 2];
			for (int i=0; i<numPlantacions; i++) {
				listaCopia[i]=this.lista[i];
			}
			this.lista=listaCopia;
		}
		this.lista[numPlantacions]=p;
		numPlantacions++;
	}
	
	public ListaPlantacions[] llistaPlantacionsSegunRodal (String nom) {
		ListaPlantacions[] listaPlantacions= new ListaPlantacions[numPlantacions];
		int posicion=0;
		for (int i=0; i<numPlantacions; i++) {
			if (lista[i].getRodals().getTipus().getNom().equalsIgnoreCase(nom)) {
				listaPlantacions[posicion].afegirPlantacions(lista[i]);
				posicion++;
			}
		}
		return listaPlantacions;
	}
	
}
