package Aplicacio;
import Dades.*;

public class main {

	public static void main(String[] args) {
		LlistaPlantes listaP = new LlistaPlantes();
		listaP.afegirPlanta(new Arbust(12,"BAAAA", 234));
		listaP.afegirPlanta(new Arbust(12,"CAAAA", 234));
		listaP.afegirPlanta(new Arbust(12,"DAAAA", 234));
		listaP.afegirPlanta(new Arbust(12,"ZAAAA", 234));
		listaP.afegirPlanta(new Arbust(12,"AAAAA", 234));
		System.out.print(listaP.getLista()[0].getNom()+"\n");
		System.out.print(listaP.getLista()[1].getNom()+"\n");
		System.out.print(listaP.getLista()[2].getNom()+"\n");
		System.out.print(listaP.getLista()[3].getNom()+"\n");
		System.out.print(listaP.getLista()[4].getNom()+"\n");

	}

}
