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

	public int getPlantacions() {
		return numPlantacions;
	}

	public void setNumPlantacions(int numEstacions) {
		this.numPlantacions = numEstacions;
	}

	@Override
	public String toString() {
		return "ListaPlantacions -> lista: " + Arrays.toString(lista) + ", numPlantacions: " + numPlantacions;
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
	
	public Plantacions[] llistaPlantacionsSegunRodal (String nom) {
		Plantacions[] listaPlantacions= new Plantacions[numPlantacions];
		int posicion=0;
		for (int i=0; i<numPlantacions; i++) {	
			for (int j=0; j<lista[i].getRodals().length;j++) {
			if (lista[i].getRodals()[j].getTipus().getNom().equalsIgnoreCase(nom)) {
				listaPlantacions[posicion]=lista[i].copia();
				posicion++;	
			}
			}
		}
		return listaPlantacions;
	}
	
	public void eliminarPlantacio(Plantacions p) {
		for (int i=0; i<numPlantacions; i++) {
			for (int j=i; j<=numPlantacions-2;j++) {
				lista[j]=lista[j+1];
			}
			numPlantacions--;
			i--;
		}
	}
	
	private void ordenarPlantacionListaQuickSort(Plantacions[] listaP, int izq, int der) {
		// Ordenaremos las plantas por nombre alfabetico
		Plantacions pivote = listaP[izq];
		int i = izq;
		int j = der;
		Plantacions aux;

		while (i < j) {
			while (listaP[i].getNom().toCharArray()[0] <= pivote.getNom().toCharArray()[0] && i < j)
				i++;
			while (listaP[j].getNom().toCharArray()[0] > pivote.getNom().toCharArray()[0])
				j--;
			if (i < j) {
				aux = listaP[i].copia();
				listaP[i] = listaP[j].copia();
				listaP[j] = aux.copia();

			}
		}

		listaP[izq] = listaP[j].copia();
		listaP[j] = pivote.copia();
		
		if (izq < j - 1)
			ordenarPlantacionListaQuickSort(listaP, izq, j-1);
		if (j + 1 < der)
			ordenarPlantacionListaQuickSort(listaP, j + 1, der);
	}
	
	
}
