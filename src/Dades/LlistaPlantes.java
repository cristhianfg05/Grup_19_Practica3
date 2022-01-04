package Dades;

public class LlistaPlantes {
	private Planta[] lista;
	private int numPlantes;
	
	public LlistaPlantes( int num) {
		this.numPlantes = num;
		this.lista = new Planta[num];
	}
	
}