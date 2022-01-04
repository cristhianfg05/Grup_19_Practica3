package Dades;

public class LlistaPlantes {
	private Planta[] lista;
	private int numPlantes;

	public LlistaPlantes() {
		this.lista = new Planta[2];
		this.numPlantes = 0;
	}

	public LlistaPlantes(int dim) {
		this.lista = new Planta[dim];
		this.numPlantes = dim;
	}
	
	public Planta[] getLista() {
		return lista;
	}

	public void setLista(Planta[] lista) {
		this.lista = lista;
	}

	public int getNumPlantes() {
		return numPlantes;
	}

	public void setNumPlantes(int numPlantes) {
		this.numPlantes = numPlantes;
	}

	public void afegirPlanta(Planta p) {
		if (this.numPlantes >= this.lista.length) {
			Planta[] listaAux = new Planta[this.numPlantes + 5];
			for (int i = 0; i < this.numPlantes; i++) {
				listaAux[i] = this.lista[i];
			}
			this.lista = listaAux;
		}
		this.lista[numPlantes] = p;
		numPlantes++;
		//ordenarListaQuickSort(lista, 0, numPlantes);
	}

	private void ordenarListaQuickSort(Planta[] listaP, int izq, int der) {
		// Ordenaremos las plantas por nombre alfabetico
		char pivote = listaP[izq].getNom().toCharArray()[0];
		int i = izq;
		int j = der;
		Planta aux;

		while (i < j) {
			while (listaP[i].getNom().toCharArray()[0] <= pivote && i < j)
				i++;
			while (listaP[j].getNom().toCharArray()[0] > pivote)
				j--;
			if (i < j) {
				aux = listaP[i].copia();
				listaP[i] = listaP[j].copia();
				listaP[j] = aux.copia();

			}
		}

		if (izq < j - 1)
			ordenarListaQuickSort(listaP, izq, j - 1);
		if (j + 1 < der)
			ordenarListaQuickSort(listaP, j + 1, der);
	}
}