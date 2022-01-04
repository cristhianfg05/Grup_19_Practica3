package Dades;

public class Arbust extends Planta {

	private int edatMaxima;
	private float absorcioCO2;

	public Arbust(int edatMaxima, String nom, float absCO2) {
		super(nom);
		this.edatMaxima = edatMaxima;
		this.absorcioCO2 = absCO2;
	}

	public int getEdatmaxima() {
		return edatMaxima;
	}

	public void setEdatmaxima(int edatmaxima) {
		this.edatMaxima = edatmaxima;
	}

	public float getAbsorcioCO2() {
		return absorcioCO2;
	}

	public void setAbsorcioCO2(float absorcioCO2) {
		this.absorcioCO2 = absorcioCO2;
	}
	
	public Planta copia() {
		return new Arbust(this.edatMaxima,this.getNom(),this.absorcioCO2);
	}
}