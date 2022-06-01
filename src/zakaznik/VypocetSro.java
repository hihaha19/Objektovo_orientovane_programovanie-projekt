package zakaznik;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import zamestnanec.*;

/**
 * Obrazovka, ktora zobrazuje na GUI vypocitane udaje o socialnom a zdravotnom poisteni zamestnancov sro,
 * vysku dane, ktoru ma firma zaplatit, jej zratane hospodarske naklady a vynosy, financne naklady a vynosy
 * 
 * @author Miska
 *
 */


public class VypocetSro extends Frame implements ActionListener {

	private static JFrame frameSro;
	
	private static JLabel nazovSro;
	private static JLabel zdravotnePoistenie;
	private static JLabel socialnePoistenie;
	private static JLabel pocetZamestnancov;
	private static JLabel financneNaklady;
	private static JLabel financneVynosy;
	private static JLabel hospodarskeVynosy;
	private static JLabel hospodarskeNaklady;
	private static JLabel dan;
	
	
	public void vypocitanaDanSro(Sro z) {
		
		Uctovnik uctovnik = new Uctovnik();
		JuniorUctovnik junior = new JuniorUctovnik();
		
		JPanel panelSro = new JPanel();
		frameSro = new JFrame();
		frameSro.setSize(600,500);
		frameSro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSro.add(panelSro);
		panelSro.setLayout(null);
		
		
		z.setZdravotne(junior.vypocitajZdravotnePoistenieZamestnancov(z.getPocetZamestnancov(), z.getVydavkyNaMzdu()));
		z.setSocialne(junior.vypocitajSocialnePoistenieZamestnancov(z.getPocetZamestnancov(), z.getVydavkyNaMzdu()));
		
		z.setFinancneNaklady(junior.vypocitajNakladyZFinancnejCinnosti(z.getKurzovaStrata(), z.getZaplateneUroky()));
		z.setFinancneVynosy(junior.vypocitajVynosyZFinancnejCinnosti(z.getKurzovyZisk(), z.getPrijateUroky()));
		z.setHospodarskeNaklady(junior.vypocitajNakladyZHospodarskejCinnosti(z.getZdravotne(),
		z.getSocialne(), z.getVydavkyNaMzdu()));
		
		
		z.setDanZPrijmu(uctovnik.vypocitajDanObchodnejSpolocnosti(z.getHospodarskeNaklady(), z.getFinancneNaklady(), 
				z.getFinancneVynosy(), z.getHospodarskeVynosy()));
		
		
		nazovSro = new JLabel ();
		pocetZamestnancov = new JLabel ("Pocet zamestnancov: " + z.getPocetZamestnancov());
		zdravotnePoistenie = new JLabel ("Zdravotne poistenie zamestnancov: " + z.getZdravotne());
		socialnePoistenie = new JLabel ("Socialne poistenie zamestnancov: " + z.getSocialne());
		financneNaklady = new JLabel ("Financne naklady: " + z.getFinancneNaklady());
		financneVynosy = new JLabel ("Financne vynosy: " + z.getFinancneVynosy());
		hospodarskeNaklady = new JLabel ("Hospodarske naklady: " + z.getHospodarskeNaklady());
		hospodarskeVynosy = new JLabel ("Hospodarske vynosy: " + z.getHospodarskeVynosy());
		dan = new JLabel ("Dan: " + z.getDanZPrijmu());
		
		nazovSro.setBounds(10, 20, 600, 25);
		pocetZamestnancov.setBounds(10, 55, 600, 25);
		zdravotnePoistenie.setBounds(10, 90, 600, 25);
		socialnePoistenie.setBounds(10, 125, 600, 25);
		financneNaklady.setBounds(10, 160, 600, 25);
		financneVynosy.setBounds(10, 195, 600, 25);
		hospodarskeNaklady.setBounds(10, 230, 600, 25);
		hospodarskeVynosy.setBounds(10, 265, 600, 25);
		dan.setBounds(10, 300, 600, 25);

			
		panelSro.add(nazovSro);
		panelSro.add(pocetZamestnancov);
		panelSro.add(zdravotnePoistenie);
		panelSro.add(socialnePoistenie);
		panelSro.add(financneNaklady);
		panelSro.add(financneVynosy);
		panelSro.add(hospodarskeNaklady);
		panelSro.add(hospodarskeVynosy);
		panelSro.add(dan);

		frameSro.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}