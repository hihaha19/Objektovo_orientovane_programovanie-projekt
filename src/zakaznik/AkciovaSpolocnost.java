package zakaznik;
import majetok.BankovyUcet;

/**
 * Trieda akciova spolocnost prekonava svoju rodicovsku triedu Sro v metodach getVysledokHospodarenia, vypisNazov a getDanZPrijmu
 * Po vypocitani cisteho zisku (zisk, od ktoreho je odpocitana dan z prijmu) sa odvedie 60% zisku na bankovy ucet, a zvysnych
 * 40 % si rozdelia rovnomerne majitelia firmy
 * 
 * @author Miska
 *
 */


public class AkciovaSpolocnost extends Sro {
	
	private int pocetAkcionarov;
	private double dividenda; //podiel jedneho akcionara na cistom zisku
	private double cistyZisk;
	private double ziskNaRozdelenie;
	BankovyUcet sporiaciUcet;
	
	//settery
	public void setSporiaciUcet(BankovyUcet newBankovyUcet) {
		sporiaciUcet = newBankovyUcet;
	}
	
	public void setPocetAkcionarov(int newPocetAkcionarov) {
		pocetAkcionarov = newPocetAkcionarov;
	}
	
	public void setCistyZisk(double newCistyZisk) {
		cistyZisk = newCistyZisk;
	}
	
	//gettery
	
	public int getPocetAkcionarov() {
		return pocetAkcionarov;
	}
	
	public BankovyUcet getSporiaciUcet() {
		return sporiaciUcet;
	}
	
	public double getDanZPrijmu(){
		return danZPrijmu;
	}
	
	
	
	public double getCistyZisk() {
		System.out.println("Cisty zisk je " +cistyZisk);
		return cistyZisk;
	}
	
	public double getVysledokHospodarenia() {
		return vysledokHospodarenia;
	}
	
	//ostatne
	public void vypisNazov() {
		System.out.println("Nazov akciovej spolocnosti je " + AkciovaSpolocnost.nazov);
	}
	
	public void odvedCastZiskuNaUcet(BankovyUcet bankovyUcet) {
		double suma = cistyZisk*0.6;
		BankovyUcet.prijem(suma);
	}
	
	public double vypocitajDividendu(double ziskNaRozdelenie) {
		System.out.println("Zisk jedneho akcionara je: " + (cistyZisk*0.4)/pocetAkcionarov);
		return (cistyZisk*0.4)/pocetAkcionarov;
	}
}