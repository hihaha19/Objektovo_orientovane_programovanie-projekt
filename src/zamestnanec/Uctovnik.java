package zamestnanec;

import java.util.Observable;
import java.util.Observer;

import majetok.Pocitac;
import nabytok.Stolicka;
import zakaznik.Adresa;
//prekonava rodicovsku triedu v metodach getVyplata, getOdpracovaneHodiny, menoZamestnanca
// pouziva observer na sledovanie zmien zivnostnika

/**
 * Uctovnik ma nastavenu dennu mzdu na 30€, pouziva firemny pocitac (agregacia) a taktiez ma uvedenu svoju adresu (agregacia).
 * Jeho hruba mesacna mzda sa vypocita ako 30€ * pocet dni, ktore odpracoval. Vie si vypocitat svoje poistne, a to vo vyske 
 * 13.4 percenta zo svojej mzdy. Vie vypocitat zivnostnikov vysledok hospodarenia pred zdanenim, a to tak, ze od jeho rocneho
 * zisku odpocita zdravotne a socialne poistenie. Dokaze vypocitat dan obchodnej spolocnosti. Ak su vynosy spolocnosti
 * vyssie ako naklady, a vynosy su vacsie ako 100 000€, zaplati dan vo vyske 21% zo zisku. Ak su jeho vynosy vyssie ako naklady, 
 * ale mensie ako 100 000, zaplati dan vo vyske 15% zo zisku. Ak su jeho naklady vyssie ako vynosy, nema ziadnu dan.
 * 
 * Implementuje interface Observer. Uctovnik sleduje zivnostnika a dostane upozornenie, ak si zivnostnik zmeni vysku svojho
 * mesacneho prijmu.
 * 
 * @author Miska
 *
 */


@SuppressWarnings("deprecation")
public class Uctovnik extends JuniorUctovnik implements Observer{


	final static double dennaMzda = 30;
	private double hrubaMzda;
	private double vyplata;
	private double poistne;
	private int odpracovaneDni;
	private Adresa adresa;				//agregacia
	private int pocetDniDovolenky;
	private Pocitac pocitac;			//agregacia
	double vysledokHospodarenia;
	
	public int getOdpracovaneDni() {
		return odpracovaneDni;
	}
	
	public double getHrubaMzda() {
		System.out.println("Hruba mzda uctovnika je: " + dennaMzda*odpracovaneDni);
		return hrubaMzda = dennaMzda*odpracovaneDni;
	}
	
	public double vypocitajPoistne() {
		return poistne = hrubaMzda*0.134;
	}
		
	public double getVyplata() {
		System.out.println("Vyplata uctovnika je: " + (hrubaMzda-vypocitajPoistne()));
		return vyplata = hrubaMzda-vypocitajPoistne();
	}
	
	public Stolicka getStolicka() {
		return stolicka;
	}
	
	public double getPocetDniDovolenky() {
		return pocetDniDovolenky;
	}
	
	public void setPocetDniDovolenky(int pocetDniDovolenky) {
		this.pocetDniDovolenky = pocetDniDovolenky;
	}
	
	public void setStolicka(Stolicka newStolicka) {
		this.stolicka = newStolicka;
	}
	
	public Adresa getAdresa(){
		return adresa;
	}
	
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	
	public void setOdpracovaneDni(int newOdpracovaneDni) {
		this.odpracovaneDni = newOdpracovaneDni;
	}
	
	public double getOdpracovaneHodiny() {
		return odpracovaneDni*7.5;
	}
	
	public static double vypocitajVHZivnostnika(double rocnyZisk, double ZP, double SP) {
		if(rocnyZisk-ZP-SP >= 0) {
			System.out.println("Zivnostnik ma zisk v hodnote: " + (rocnyZisk-ZP-SP));
		}
		else System.out.println("Zivnostik ma stratu v hodnote: " +  (rocnyZisk-ZP-SP));
		return rocnyZisk-SP-ZP;
	}
	
	public double vypocitajDanObchodnejSpolocnosti(double nakladyZHospCinnosti, double nakladyZFinCinnosti, double vynosyZFinCinnosti, double vynosyZHospCinnosti) {
		double vysledok;
		if((vynosyZFinCinnosti+vynosyZHospCinnosti) > (nakladyZHospCinnosti+nakladyZFinCinnosti) && vynosyZFinCinnosti+vynosyZHospCinnosti >100000) {
			vysledok = (vynosyZFinCinnosti+vynosyZHospCinnosti)*0.21;
					return vysledok;
		}
		else if((vynosyZFinCinnosti+vynosyZHospCinnosti) > (nakladyZHospCinnosti+nakladyZFinCinnosti)) {
			vysledok = (vynosyZFinCinnosti+vynosyZHospCinnosti)*0.15;
			return vysledok;
		}
		else return 0;
	}
	
	
	public static double vypocitajDanZivnostnika(double ziskBezPoistneho) {
		System.out.println("Ratam s novym ziskom: " +ziskBezPoistneho);

		if((ziskBezPoistneho - 4414.2) > 0) {
			return (ziskBezPoistneho - 4414.2)*0.19;
		}
		else return 0;
	}
	
	public void menoZamestnanca() {
		System.out.println("Som uctovnik na plny uvazok a volam sa: " + getMeno());
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Zivnostnik ma zmeneny priemerny mesacny prijem, novy prijem: " +arg);	
	}
}
