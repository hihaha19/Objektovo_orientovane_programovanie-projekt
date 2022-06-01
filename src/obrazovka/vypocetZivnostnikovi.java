package obrazovka;

import java.awt.Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import zamestnanec.*;
import zakaznik.*;
import java.text.DecimalFormat;


/**
 * Obrazovka, ktora zobrazuje na GUI vypocitane udaje o socialnom a zdravotnom poisteni zivnostnika a vysku dane, ktoru ma 
 * zaplatit
 * @author Miska
 *
 */


public class vypocetZivnostnikovi extends Frame implements ActionListener {

	private static JFrame frameZivnostnika;
	
	private static JLabel socialnePoistenie;
	private static JLabel prijem;
	private static JLabel zdravotnePoistenie;
	private static JLabel zivnostnikMeno;
	private static JLabel dan;
	DecimalFormat df2 = new DecimalFormat("#.##");


	public void obrazovkaVypocitanejDane(Zivnostnik z) {
		
	Uctovnik uctovnik = new Uctovnik();
	JuniorUctovnik junior = new JuniorUctovnik();
	
	
	JPanel panelZivnostnika = new JPanel();
	frameZivnostnika = new JFrame();
	frameZivnostnika.setSize(600,500);
	frameZivnostnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frameZivnostnika.add(panelZivnostnika);
	panelZivnostnika.setLayout(null);
	
	z.setRocnyPrijemBezPoistneho(uctovnik.vypocitajVHZivnostnika(z.getRocnyPrijem(), junior.vypocitajZdravotnePoistenieZivnostnika(z.getRocnyPrijem()),
			junior.vypocitajSocialnePoistenieZivnostnika(z.getRocnyPrijem())));
	zivnostnikMeno = new JLabel ("Meno: " + z.getNazov());
	prijem = new JLabel ("Rocny prijem: " + z.getRocnyPrijem());
	zdravotnePoistenie = new JLabel ("Zdravotne poistenie: " + df2.format(junior.vypocitajZdravotnePoistenieZivnostnika(z.getRocnyPrijem())));
	
	socialnePoistenie = new JLabel("Socialne poistenie: " + df2.format(junior.vypocitajSocialnePoistenieZivnostnika(z.getRocnyPrijem())));
	z.setRocnyPrijemBezPoistneho(uctovnik.vypocitajVHZivnostnika(z.getRocnyPrijem(),
			junior.vypocitajSocialnePoistenieZivnostnika(z.getRocnyPrijem()),junior.vypocitajSocialnePoistenieZivnostnika(z.getRocnyPrijem())));
	
    z.setDanZPrijmu(uctovnik.vypocitajDanZivnostnika(z.getRocnyPrijemBezPoistneho()));

	dan = new JLabel ("Dan z prijmu: " + df2.format(z.getDanZPrijmu()));
	
	zivnostnikMeno.setBounds(10, 10, 200, 25);
	prijem.setBounds(10, 45, 200, 25);
	zdravotnePoistenie.setBounds(10, 80, 200, 25);
	socialnePoistenie.setBounds(10, 115, 200, 25);
	dan.setBounds(10, 185, 200, 25);
	
	panelZivnostnika.add(zivnostnikMeno);
	panelZivnostnika.add(prijem);
	panelZivnostnika.add(zdravotnePoistenie);
	panelZivnostnika.add(socialnePoistenie);
	panelZivnostnika.add(dan);
	
	frameZivnostnika.setVisible(true);
}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}


}
