package Dades;

import java.io.Serializable;

public class TipusTerreny implements Serializable{
	private String nom;
	private LlistaPlantes listaplantas;
	private int[] unitatsHra;
	
	// faltaria algo para poner las unidades plantadas por hectarea

	public TipusTerreny(LlistaPlantes listaplantas, String nom, int[] unitatsHra) {
		super();
		this.nom=nom;
		this.listaplantas = listaplantas;
		this.unitatsHra = unitatsHra;
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

	public int[] getUnitatsHra() {
		return unitatsHra;
	}

	public void setUnitatsHra(int[] unitatsHra) {
		this.unitatsHra = unitatsHra;
	}
	
	@Override
	public String toString() {
		return "TipusTerreny [nom=" + nom + ", listaplantas=" + listaplantas + "]";
	}		
}