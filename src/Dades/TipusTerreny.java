package Dades;

public class TipusTerreny {
	private String nom;
	private LlistaPlantes listaplantas;
	// faltaria algo para poner las unidades plantadas por hectarea

	public TipusTerreny(LlistaPlantes listaplantas, String nom) {
		super();
		this.nom=nom;
		this.listaplantas = listaplantas;			// asi hacemos que solo haya 5 tipos de Plantas
	}

	public LlistaPlantes getListaplantas() {
		return listaplantas;
	}

	public void setListaplantas(LlistaPlantes listaplantas) {
		this.listaplantas = listaplantas;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "TipusTerreny [nom=" + nom + " listaplantas=" + listaplantas + "]";
	}
	
	
}
