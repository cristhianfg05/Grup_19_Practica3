package Dades;

public class Plantacions {
	private String nom;
	private int any;
	private Rodal rodals;

	public Plantacions(String nom, int any, Rodal rodals) {
		super();
		this.nom = nom;
		this.any = any;
		this.rodals = rodals;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAny() {
		return any;
	}
	public void setAny(int any) {
		this.any = any;
	}
	public Rodal getRodals() {
		return rodals;
	}
	public void setRodals(Rodal rodals) {
		this.rodals = rodals;
	}

	
}
