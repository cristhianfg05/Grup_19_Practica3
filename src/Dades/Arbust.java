package Dades;

public class Arbust extends Planta {

	private int edatmaxima;
	private float absorcioCO2;

	public Arbust(String nom, float absCO2) {
		super(nom);
		this.absorcioCO2 = absCO2;
	}

	public int getEdatmaxima() {
		return edatmaxima;
	}

	public void setEdatmaxima(int edatmaxima) {
		this.edatmaxima = edatmaxima;
	}

	public float getAbsorcioCO2() {
		return absorcioCO2;
	}

	public void setAbsorcioCO2(float absorcioCO2) {
		this.absorcioCO2 = absorcioCO2;
	}
	
	
}
