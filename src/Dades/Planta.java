package Dades;

public abstract class Planta { // es abstract porque no se pueden crear plantas directamente
	private String nom;
	private int numPlantes;

	public Planta(String nom, int numPlantes) {
		this.nom = nom;
		this.numPlantes = numPlantes;
	}

	public int getNumPlantes() {
		return numPlantes;
	}

	public void setNumPlantes(int numPlantes) {
		this.numPlantes = numPlantes;
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
		return "Planta [nom=" + nom + ", numPlantes=" + numPlantes + "]";
	}

	

}
