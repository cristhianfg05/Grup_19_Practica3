package Dades;

import java.util.Arrays;

public class ListaTipusTerreny {
	private TipusTerreny[] lista;
	private int NumTerreny;
	
	public ListaTipusTerreny() {
		super();
		this.lista = new TipusTerreny[0];				// se crea una lista vacia
		NumTerreny = 0;
	}

	public TipusTerreny[] getLista() {
		return lista;
	}

	public void setLista(TipusTerreny[] lista) {
		this.lista = lista;
	}

	public int getNumTerreny() {
		return NumTerreny;
	}

	public void setNumTerreny(int numTerreny) {
		NumTerreny = numTerreny;
	}

	@Override
	public String toString() {
		return "ListaTipusTerreny [lista=" + Arrays.toString(lista) + ", NumTerreny=" + NumTerreny + "]";
	}
	
	public String plantacionsTipusTerreny (Rodal rodal) {
		String frase = ""; 
		for (int i = 0; i < lista.length; i++) {
			if (lista[i].getNom().equalsIgnoreCase(rodal.getTipus().getNom())) {
				frase += "ListaTipusTerreny [lista=" + Arrays.toString(lista) + ", NumTerreny=" + NumTerreny + "]";
			}
		}
		return frase;
		
	}
	
	
	
}