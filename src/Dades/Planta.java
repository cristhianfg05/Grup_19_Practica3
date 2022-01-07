package Dades;

public abstract class Planta { // es abstract porque no se pueden crear plantas directamente
	private String nom;
	private int numPlantesPlantades;
	
	public void setNumPlantesPlanades (int num) {
		this.numPlantesPlantades = num;
	}
	public int getNumPlantesPlantades () {
		return this.numPlantesPlantades;
	}
	public Planta(String nom, int num) {
		this.nom = nom;
		this.numPlantesPlantades = num;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	protected abstract Planta copia();

	@Override
	public String toString() {
		return "Planta [nom=" + nom + "]";
	}

	protected abstract float getAbsorcioCO2();
	

}