package Dades;

public abstract class Planta { // es abstract porque no se pueden crear plantas directamente
	private String nom;

	public Planta(String nom) {
		this.nom = nom;
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
	

}
