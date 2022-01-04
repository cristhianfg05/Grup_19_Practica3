package Dades;

public class Rodal {
	private TipusTerreny tipus;
	private double superficie;
	
	
	
	public Rodal(TipusTerreny tipus, double superficie) {
		this.tipus = tipus;
		this.superficie = superficie;
	}
	
	public TipusTerreny getTipus() {
		return tipus;
	}
	public void setTipus(TipusTerreny tipus) {
		this.tipus = tipus;
	}
	public double getSuperficie() {
		return superficie;
	}
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	
	
}