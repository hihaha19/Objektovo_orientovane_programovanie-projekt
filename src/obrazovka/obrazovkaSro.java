package obrazovka;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import hlavna.ZapornyVstup;
import majetok.BankovyUcet;
import zakaznik.*;

/**
 * Obrazovka sro je urcena na zadanie udajov potrebnych na vypocitanie dane z prijmu s.r.o.
 * @author Miska
 *
 */

public class obrazovkaSro extends Frame implements ActionListener  {

	private static JFrame frameSro;
	
	private static JLabel nazovSro;
	private static JLabel pocetZamestnancov;
	private static JLabel kurzovyZisk;
	private static JLabel kurzovaStrata;
	private static JLabel zakladneI;
	private static JLabel hospodarskeVynosy;
	private static JLabel vydavkyNaMzdu;
	private static JLabel urokyPrijate;
	private static JLabel urokyZaplatene;
	
	private static JTextField prijateUroky;
	private static JTextField zaplateneUroky;
	private static JTextField sroNazov;
	private static JTextField zamestnanciPocet;
	private static JTextField iZakladne;
	private static JTextField vynosyHospodarske;
	private static JTextField mzdoveVydavky;
	private static JTextField strataKurzova;
	private static JTextField ziskKurzovy;

	private static JButton odoslat;
	
	
	public void vytvorObrazovkuSro() {
		JPanel panelSro = new JPanel();
		frameSro = new JFrame();
		frameSro.setSize(600,500);
		frameSro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSro.add(panelSro);
		panelSro.setLayout(null);
			
		nazovSro = new JLabel ("Nazov spolocnosti: ");
		pocetZamestnancov = new JLabel ("Pocet zamestnancov: ");
		zakladneI = new JLabel("Zakladne imanie: ");
		urokyPrijate = new JLabel ("Prijate uroky: ");
		urokyZaplatene = new JLabel ("Zaplatene uroky: ");
		kurzovyZisk = new JLabel ("Zadajte kurzovy zisk: ");
		kurzovaStrata = new JLabel ("Zadajte kurzovu stratu: ");
		hospodarskeVynosy = new JLabel("Zadajte hospodarske vynosy: ");
		vydavkyNaMzdu = new JLabel("Zadajte vydavky na mzdu: ");
		
		nazovSro.setBounds(10, 20, 200, 25);
		pocetZamestnancov.setBounds(10, 55, 200, 25);
		zakladneI.setBounds(10, 90, 200, 25);
		urokyPrijate.setBounds(10, 125, 200, 25);
		urokyZaplatene.setBounds(10, 160, 200, 25);
		kurzovyZisk.setBounds(10, 195, 200, 25);
		kurzovaStrata.setBounds(10, 230, 200, 25);
		hospodarskeVynosy.setBounds(10, 265, 200, 25);
		vydavkyNaMzdu.setBounds(10, 300, 200, 25);


			
		panelSro.add(nazovSro);
		panelSro.add(zakladneI);
		panelSro.add(hospodarskeVynosy);
		panelSro.add(vydavkyNaMzdu);
		panelSro.add(pocetZamestnancov);
		panelSro.add(kurzovyZisk);
		panelSro.add(kurzovaStrata);
		panelSro.add(urokyPrijate);
		panelSro.add(urokyZaplatene);

		
		sroNazov = new JTextField(20);
		sroNazov.setBounds(200, 20, 165, 25);
		
		zamestnanciPocet = new JTextField(20);
		zamestnanciPocet.setBounds(200, 55, 165, 25);
		
		iZakladne = new JTextField(20);
		iZakladne.setBounds(200, 90, 160, 25);
		
		prijateUroky = new JTextField(20);
		prijateUroky.setBounds(200, 125, 165, 25);

		zaplateneUroky = new JTextField(20);
		zaplateneUroky.setBounds(200, 160, 165, 25);
		
		ziskKurzovy = new JTextField(20);
		ziskKurzovy.setBounds(200, 195, 165, 25);
		
		strataKurzova = new JTextField(20);
		strataKurzova.setBounds(200, 230, 165, 25);
		
		vynosyHospodarske = new JTextField(20);
		vynosyHospodarske.setBounds(200, 265, 165, 25);
		
		mzdoveVydavky = new JTextField(20);
		mzdoveVydavky.setBounds(200, 300, 165, 25);
		


		panelSro.add(zaplateneUroky);
		panelSro.add(prijateUroky);
		panelSro.add(sroNazov);
		panelSro.add(zamestnanciPocet);
		panelSro.add(ziskKurzovy);
		panelSro.add(iZakladne);
		panelSro.add(vynosyHospodarske);
		panelSro.add(mzdoveVydavky);
		panelSro.add(strataKurzova);

	
		odoslat = new JButton("Odoslat");
		odoslat.setBounds(400, 400, 120, 25);
		odoslat.addActionListener(this);
		panelSro.add(odoslat);
			
		frameSro.setVisible(true);
					
	}
		@Override
		public void actionPerformed(ActionEvent arg) {
			
			String nazov = nazovSro.getText();
			double kurzovyZisk = Integer.parseInt(ziskKurzovy.getText());
			double kurzovaStrata = Integer.parseInt(strataKurzova.getText());
			int zamestnanci = Integer.parseInt(zamestnanciPocet.getText());
			double hospodarskeV = Integer.parseInt(vynosyHospodarske.getText());
			double zakladneI = Integer.parseInt(iZakladne.getText());
			double mzda = Integer.parseInt(mzdoveVydavky.getText());
			double prijateU = Integer.parseInt(prijateUroky.getText());
			double zaplateneU = Integer.parseInt(zaplateneUroky.getText());
			
			if(nazov != null) {
				Sro z = new Sro();
				BankovyUcet b = new BankovyUcet("platiaci", 500000);
				z.setNazov(nazov);
				z.setKurzovaStrata(kurzovaStrata);
				z.setKurzovyZisk(kurzovyZisk);
				z.setPocetZamestnancov(zamestnanci);
				z.setPlatiaciBankovyUcet(b);
				
				try {
					z.setZakladneImanie(zakladneI);
				} catch (ZapornyVstup e) {
					
					System.out.println(e.getMessage());
				}
				
				z.setHospodarskeVynosy(hospodarskeV);
				z.setVydavkyNaMzdu(mzda);
				z.setPrijateUroky(prijateU);
				z.setZaplateneUroky(zaplateneU);
				
			frameSro.setVisible(false);
			VypocetSro obrazovka = new VypocetSro();
			obrazovka.vypocitanaDanSro(z);
			}
			
		}
	
}