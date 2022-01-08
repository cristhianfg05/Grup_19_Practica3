package Dades;

import java.io.Serializable;
import java.util.Arrays;

public class Arbre extends Planta implements Serializable{
	
	private float[] rangs; 
	private int edatactual;

	public Arbre(String nom, float[] rangs, int edatactual) {
		super(nom);
		this.rangs = rangs;
		this.edatactual = edatactual;
	}
	//NO HAY QUE REALIZAR CALCULO, VIENE TODO EN EL FICHERO

	public float[] getRangs() {
		return rangs;
	}

	public void setRangs(float[] rangs) {
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

	@Override
	public String toString() {
		return "Arbre [rangs=" + Arrays.toString(rangs) + ", edatactual=" + edatactual + "]";
	}

	public float getAbsorcioCO2() {
		return rangs[edatactual];
	}
	
	
	
}