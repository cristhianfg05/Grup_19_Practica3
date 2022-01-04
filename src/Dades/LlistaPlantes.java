package Dades;

public class LlistaPlantes {
	private Planta[] lista;
	private int numPlantes;
	
	public LlistaPlantes () {
		this.lista = new Planta[2];
		this.numPlantes = 0;
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
		if(this.numPlantes>= this.lista.length) {
			Planta[] listaAux = new Planta[this.numPlantes + 5];
			for (int i = 0; i < this.numPlantes; i++) {
				listaAux[i] = this.lista[i];
			}
			this.lista = listaAux;
		}
		this.lista[numPlantes] = p;
		numPlantes++;
	}
}
