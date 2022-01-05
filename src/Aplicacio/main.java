package Aplicacio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.Iterator;

import javax.swing.*;

import Dades.*;

public class main extends JFrame{

	private JButton[] graella;
	private JPanel panelBotones, panelLista;
	private JLabel visualitzador;
	private static int dim; //DIMENSION DE TODAS LAS PLANTACIONES
	private JTextField texte;
	
	public main(String nom, ListaPlantacions l) {
		super(nom);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(2000,2000);
		panelBotones = new JPanel();
		graella = new JButton[dim];
		texte = new JTextField(4);
		this.setLayout(new BorderLayout());
		panelBotones.setLayout(new GridLayout(30,30));
		for (int i = 0; i < graella.length; i++) {
			graella[i] = new JButton(l.getLista()[i].getNom());
			graella[i].setBackground(Color.white);
			panelBotones.add(graella[i]);
		}
		this.add(panelBotones,BorderLayout.NORTH);
		panelLista = new JPanel();
		panelLista.setLayout(new FlowLayout());
		visualitzador = new JLabel("PULSA UN BOTON PARA VER LA INFORMACIÓN DE ESA PLANTACIÓN");
		panelLista.add(visualitzador);
		this.add(panelLista);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {

		//MAIN ADRI//
		
		//MAIN ADRI//
		
		
		//DATOS PARA RECOGER PARA EL GRAFICO//
		ListaPlantacions listaPlantacion = new ListaPlantacions();
		Rodal []r = new Rodal[2];
		listaPlantacion.afegirPlantacions(new Plantacions("Plantacion 1", 2000, r));
		listaPlantacion.afegirPlantacions(new Plantacions("Plantacion 2", 2000, r));
		listaPlantacion.afegirPlantacions(new Plantacions("Plantacion 3", 2000, r));
		//DATOS PARA RECOGER PARA EL GRAFICO//
		
		dim = listaPlantacion.getNumEstacions();
		new main("Part gràfica Pràctica CO2",listaPlantacion);
	}

}
