package Dades;

public class TipusTerreny {
	private String nom;
	private Planta[] listaplantas;
	// faltaria algo para poner las unidades plantadas por hectarea

	public TipusTerreny(Planta listaplantas, String nom) {
		super();
		this.nom=nom;
		this.listaplantas = new Planta[5];			// asi hacemos que solo haya 5 tipos de Plantas
		this.listaplantas[0] = listaplantas;		
	}

	public Planta[] getListaplantas() {
		return listaplantas;
	}

	public void setListaplantas(Planta[] listaplantas) {
		this.listaplantas = listaplantas;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
