package Aplicacio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Dades.*;

public class main extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
			graella[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = 0;
					boolean trobat = false;
					JButton boto = (JButton)e.getSource();
					while(i<l.getNumEstacions() && !trobat) {
						if(l.getLista()[i].getNom().equalsIgnoreCase(boto.getText())) {
							trobat = true;
						}else
							i++;
					}
					visualitzador.setText(l.getLista()[i].toString());
				}
			});
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
		
		LlistaPlantes listaEjemplo = new LlistaPlantes();
		listaEjemplo.afegirPlanta(new Arbust(12,200,"BAAAA", 234));
		listaEjemplo.afegirPlanta(new Arbust(12,200,"AAAAA", 234));
		listaEjemplo.afegirPlanta(new Arbust(12,200,"CAAAA", 234));
		listaEjemplo.afegirPlanta(new Arbust(12,200,"ZAAAA", 234));
		listaEjemplo.afegirPlanta(new Arbust(12,200,"DAAAA", 234));
		r[0] = new Rodal(new TipusTerreny(listaEjemplo, "Terrenos Pelele"), 12.3);
		r[1] = new Rodal(new TipusTerreny(listaEjemplo, "Terrenos Loli"),45.3);

		listaPlantacion.afegirPlantacions(new Plantacions("Plantacion 1", 2000, r));
		listaPlantacion.afegirPlantacions(new Plantacions("Plantacion 2", 2000, r));
		listaPlantacion.afegirPlantacions(new Plantacions("Plantacion 3", 2000, r));
		listaPlantacion.afegirPlantacions(new Plantacions("patata 3", 2000, r));
		System.out.print(listaEjemplo.getLista()[2].getNom());

		//DATOS PARA RECOGER PARA EL GRAFICO//
		
		dim = listaPlantacion.getNumEstacions();
		new main("Part gràfica Pràctica CO2",listaPlantacion);
	}

}
