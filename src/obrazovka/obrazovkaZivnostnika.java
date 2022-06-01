package obrazovka;

import java.awt.Frame;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;

import majetok.BankovyUcet;
import zakaznik.*;

/**
 * Obrazovka zivnostnika je urcena na zadanie udajov potrebnych na vypocitanie dane z prijmu zivnostnika
 * @author Miska
 *
 */


public class obrazovkaZivnostnika extends Frame implements ActionListener {

	private static JFrame frameZivnostnika;
	private static JLabel zivnostnikPriemernyPrijem;
	private static JLabel zivnostnikMesiacePrevadzkovania;
	private static JLabel zivnostnikMeno;
	private static JTextField zivnostnikPrijem;
	private static JTextField menoZivnostnika;
	private static JTextField zivnostnikPrevadzkovanie;
	private static JButton odoslat;
	DecimalFormat df2 = new DecimalFormat("#.##");
	

	public void vytvorObrazovkuZivnostnika() {
		JPanel panelZivnostnika = new JPanel();
		frameZivnostnika = new JFrame();
		frameZivnostnika.setSize(600,500);
		frameZivnostnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameZivnostnika.add(panelZivnostnika);
		panelZivnostnika.setLayout(null);
		
		zivnostnikMeno = new JLabel ("Vase meno: ");
		zivnostnikPriemernyPrijem = new JLabel ("Mesacny prijem: ");
		zivnostnikMesiacePrevadzkovania = new JLabel ("Mesiace prevadzkovania: ");
		zivnostnikMeno.setBounds(10, 20, 150, 25);
		zivnostnikPriemernyPrijem.setBounds(10, 55, 150, 25);
		zivnostnikMesiacePrevadzkovania.setBounds(10, 90, 150, 25);
		
		panelZivnostnika.add(zivnostnikMeno);
		panelZivnostnika.add(zivnostnikMesiacePrevadzkovania);
		panelZivnostnika.add(zivnostnikPriemernyPrijem);
		
		menoZivnostnika = new JTextField(20);
		menoZivnostnika.setBounds(160, 20, 165, 25);
		zivnostnikPrijem = new JTextField(20);
		zivnostnikPrijem.setBounds(160, 55, 165, 25);
		zivnostnikPrevadzkovanie = new JTextField(20);
		zivnostnikPrevadzkovanie.setBounds(160, 90, 165, 25);

		panelZivnostnika.add(menoZivnostnika);
		panelZivnostnika.add(zivnostnikPrijem);
		panelZivnostnika.add(zivnostnikPrevadzkovanie);
		
		odoslat = new JButton("Odoslat");
		odoslat.setBounds(100, 200, 165, 25);
		odoslat.addActionListener(this);
		panelZivnostnika.add(odoslat);
		
		frameZivnostnika.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String menoZ = menoZivnostnika.getText();
		int prijemZ = Integer.parseInt(zivnostnikPrijem.getText());
		int prevadzkovanieZ = Integer.parseInt(zivnostnikPrevadzkovanie.getText());
		if(menoZ != null) {
			Zivnostnik z = new Zivnostnik();
			BankovyUcet b = new BankovyUcet("platobby" , 200000);
			z.setNazov(menoZ);
			z.setPocetMesiacovPrevadzkovania(prevadzkovanieZ);
			z.setPriemernyMesacnyPrijem(prijemZ);
			z.setBankovyUcetZivnostnika(b);
		
		frameZivnostnika.setVisible(false);
		vypocetZivnostnikovi obrazovka = new vypocetZivnostnikovi();
		obrazovka.obrazovkaVypocitanejDane(z);
		}
	}
	
}
