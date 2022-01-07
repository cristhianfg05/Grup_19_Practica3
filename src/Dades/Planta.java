package Dades;

public abstract class Planta { // es abstract porque no se pueden crear plantas directamente
	private String nom;
	private int PlantesPerHra;

	public Planta(String nom, int PlantesPerHra) {
		this.nom = nom;
		this.PlantesPerHra = PlantesPerHra;
	}

	public int getNumPlantes() {
		return PlantesPerHra;
	}

	public void setNumPlantes(int numPlantes) {
		this.PlantesPerHra = numPlantes;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	protected abstract float getAbsorcioCO2();
	protected abstract Planta copia();

	@Override
	public String toString() {
		return "Planta [nom=" + nom + ", numPlantes=" + PlantesPerHra + "]";
	}
}