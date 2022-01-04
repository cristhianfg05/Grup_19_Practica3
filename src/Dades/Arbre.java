package Dades;

public class Arbre extends Planta {
	
	private int[] rangs; 
	// EN EL FICHERO RECIBIMOS UN NUMERO QUE NOS DARA LA CANTIDAD DE RANGOS (el
	// numero recibido x 2)
	private int edatactual;

	public Arbre(String nom, int[] rangs, int edatactual) {
		super(nom);
		this.rangs = rangs;
		this.edatactual = edatactual;
	}
	//NO HAY QUE REALIZAR CALCULO, VIENE TODO EN EL FICHERO

	public int[] getRangs() {
		return rangs;
	}

	public void setRangs(int[] rangs) {
		this.rangs = rangs;
	}

	public int getEdatactual() {
		return edatactual;
	}

	public void setEdatactual(int edatactual) {
		this.edatactual = edatactual;
	}
	
	public Planta copia() {
		return new Arbre(this.getNom(),this.rangs,this.edatactual);
	}
}
