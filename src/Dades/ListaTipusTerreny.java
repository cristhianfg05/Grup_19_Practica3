package Dades;

import java.io.Serializable;
import java.util.Arrays;

public class ListaTipusTerreny implements Serializable {
	private TipusTerreny[] lista;
	private int numTerreny;

	public ListaTipusTerreny() {
		super();
		this.lista = new TipusTerreny[0]; // se crea una lista vacia
		numTerreny = 0;
	}

	public TipusTerreny[] getLista() {
		return lista;
	}

	public void setLista(TipusTerreny[] lista) {
		this.lista = lista;
	}

	public int getNumTerreny() {
		return numTerreny;
	}

	public void setNumTerreny(int numTerreny) {
		this.numTerreny = numTerreny;
	}

	public LlistaPlantes plantacionsTipusTerreny(String nom) {
		boolean trobat = false;
		int i = 0;
		LlistaPlantes aux = null;
		while (i < lista.length && !trobat) {
			if (lista[i].getNom().equalsIgnoreCase(nom)) {
				trobat = true;
				aux = lista[i].getListaplantas();
			}
			i++;
		}
		return aux;
	}
	
	public void afegirTerreny(TipusTerreny p) {
        if (this.numTerreny >= this.lista.length) {
            TipusTerreny[] listaAux = new TipusTerreny[this.numTerreny + 5];
            for (int i = 0; i < this.numTerreny; i++) {
                listaAux[i] = this.lista[i];
            }
            this.lista = listaAux;
        }
        this.lista[numTerreny] = p;
        numTerreny++;
    }

	@Override
	public String toString() {
		return "ListaTipusTerreny [lista=" + Arrays.toString(lista) + ", NumTerreny=" + numTerreny + "]";
	}
}