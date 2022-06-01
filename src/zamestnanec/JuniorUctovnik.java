package zamestnanec;
import java.text.DecimalFormat;

import majetok.Pocitac;


/**
 * Junior uctovnik je brigadnik, ktory dostava plat 4.5€ na hodinu, pouziva firemny pocitac, mzdu dostava podla odpracovanych
 * hodin, ak jeho mzda presiahne 200€, zo sumy, ktora prekrocila 200€ sa mu rata poistne v hodnote 10% z jeho mzdy
 * Dokaze vypocitat zdravotne a socialne poistenie zivnostnika, aj zamestnancov v S.r.o. alebo v akciovej spolocnosti
 * Vie vypocitat aj naklady z hospodarskej cinnosti obchodnych spolocnosti (spocita dokopy socialne a zdravotnej poistenie 
 * vsetkych zamestnancov a ich mzdy.
 * Vie vypocitat naklady aj vynosy z financnej cinnosti, a to tak, ze v pripade nakladov spocita kurzovu stratu a zaplatene uroky.
 * V pripade vynosov spocita kurzovy zisk a prijate uroky. Vie aj vypocitat vysledok hospodarenia pred zdanenim, a to tak, ze
 * scita vynosy z hospodarskej a financnej cinnosti, a odpocita od nich naklady z hospodarskej a financnej cinnosti
 *
 * @author Miska
 *
 */
public class JuniorUctovnik extends Zamestnanec {
	private Pocitac pocitac;
	final static double hodinovaMzda  = 4.5;
	private double odpracovaneHodiny;
	private double mzda;
	private double vyplata;
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");

	
	public double getOdpracovaneHodiny() {
		return odpracovaneHodiny;
	}
	
	public double getMzda() {
		//System.out.println("Mzda juniora je "+ hodinovaMzda*odpracovaneHodiny);
		return hodinovaMzda*odpracovaneHodiny;
}
	public Pocitac getPocitac() {
		return pocitac;
	}
	
	public void setOdpracovaneHodiny (int newOdpracovaneHodiny) {
		this.odpracovaneHodiny = newOdpracovaneHodiny;
	}
	
	public void setVyplata(double newMzdaNaVyplatenie) {
		this.vyplata = newMzdaNaVyplatenie;
	}

	
	//public void setVyplata()
	
	public void setPocitac (Pocitac pocitac) {
		this.pocitac = pocitac;
	}
	
	public void setSvojePoistne(double mzda) {
		if (mzda > 200)  {
			//System.out.println("Poistne juniora: "+ (mzda-200)*0.1 );
			this.poistne = (mzda-200)*0.1;
		}
		else this.poistne = 0.0;
	}
	
	public double getPoistne() {
	//	System.out.println("get poistne juniora: " + poistne);
		return poistne;
	}

	public double getVyplata() {
		return vyplata;
	}

	public void povedzSvojeMeno() {
		System.out.println("Volam sa: " + getMeno());
	}

	
	public void menoZamestnanca() {
		System.out.println("Som brigadnik a volam sa: " + getMeno());
	}
	
	public double vypocitajZdravotnePoistenieZivnostnika(double rocnyPrijem) {
		System.out.println("ZP zivnostnika "+ df2.format(rocnyPrijem*0.14));
		return rocnyPrijem*0.14;
	}
	
	public double vypocitajSocialnePoistenieZivnostnika(double rocnyPrijem) {
		System.out.println("SP zivnostnika " + rocnyPrijem*0.3315);
		return rocnyPrijem*0.3315;
	}
	
	public double vypocitajZdravotnePoistenieZamestnancov(int pocetZamestnancov, double vydavkyNaMzdu) {
		poistne=vydavkyNaMzdu*0.1;
		return poistne;
	}
	
	public double vypocitajSocialnePoistenieZamestnancov(int pocetZamestnancov, double vydavkyNaMzdu) {
		poistne = vydavkyNaMzdu*0.252;
		return poistne;
	}
	
	public double vypocitajNakladyZHospodarskejCinnosti(double zdravotnePoistenie, double socialnePoistenie, double mzdy) {
		return zdravotnePoistenie+socialnePoistenie+mzdy;
	}
	
	public double vypocitajNakladyZFinancnejCinnosti(double kurzovaStrata, double zaplateneUroky) {
		return kurzovaStrata+zaplateneUroky;
	}
	
	public double vypocitajVynosyZFinancnejCinnosti(double kurzovyZisk, double prijateUroky) {
		return kurzovyZisk+prijateUroky;
	}
	
	public double vypocitajVHPredDanou(double nakladyZHospCinnosti, double nakladyZFinCinnosti, double vynosyZFinCinnosti, double vynosyZHospCinnosti) {
		double vysledok = (vynosyZFinCinnosti + vynosyZHospCinnosti) - (nakladyZHospCinnosti - nakladyZFinCinnosti);
		return vysledok;
	}
	
	public void zobrazUdaje() {
		System.out.println("Meno: " + getMeno());
		System.out.println("Vek: " + getVek());
		System.out.println("Odpracovane hodiny: " + getOdpracovaneHodiny());
		System.out.println("Vyplata: " + getVyplata());
		//System.out.println("Poistne: " + vypocitajSvojePoistne(getVyplata()));	
}


}
