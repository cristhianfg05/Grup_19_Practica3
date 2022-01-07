package Dades;

public class Rodal {
	private TipusTerreny tipus;
	private double superficie;

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

	public float quantitatCO2() {
		float quantitat = 0;
		for (int i = 0; i < tipus.getListaplantas().getLista().length; i++) {
			//Por cada planta saber el co2
			quantitat += tipus.getListaplantas().getLista()[i].getAbsorcioCO2() * this.superficie * tipus.getListaplantas().getNumPlantes();
		}
		return quantitat;
	}

}
