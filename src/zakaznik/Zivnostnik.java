package zakaznik;

import java.text.DecimalFormat;

import majetok.BankovyUcet;


/**
 * Metoda setPriemernyMesacnyPrijem je sledovana uctovnikom, aby bol informovany o zmene prijmu zivnostnika a pripadne mohol
 * zmenit vypocet jeho dane. Vypocet zakladu dane zivnostnika sa pocita ako pocet mesiacov, ktore odpracoval * priemerny
 * mesacny zarobok. Junior uctovnik z tohto zakladu dane vypocita socialne a zdravotne poistne, normalny uctovnik vypocita
 * dan z prijmu zivnostnika
 * @author Miska
 *
 */

public class Zivnostnik extends Zakaznik  {
	
	private double priemernyMesacnyPrijem;
	private double rocnyPrijem;
	private double rocnyPrijemBezPoistneho;
	private int pocetMesiacovPrevadzkovania;
	private double zdravotnePoistenie;
	private double socialnePoistenie;
	private double cistyZisk;
	private double danZPrijmu;
	
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	//setery
	public void setPriemernyMesacnyPrijem(double newPriemernyMesacnyPrijem) {
		priemernyMesacnyPrijem = newPriemernyMesacnyPrijem;
		setChanged();
		notifyObservers(newPriemernyMesacnyPrijem);
	}
	
	public void setPocetMesiacovPrevadzkovania(int newPocetMesiacovPrevadzkovania) {
		pocetMesiacovPrevadzkovania = newPocetMesiacovPrevadzkovania;
	}
	
	public void setVysledokHospodareniaPoZdaneni(double newVysledokHospodarenia) {
		cistyZisk = newVysledokHospodarenia;
	}
	
	public void setBankovyUcetZivnostnika(BankovyUcet newBankovyUcet) {
		platiaciUcet = newBankovyUcet;
	}
	
	public void setDanZPrijmu(double dan) {
		danZPrijmu = dan;
	}
	
	
	public void setRocnyPrijemBezPoistneho(double rocnyPrijemBezPoistneho) {
		this.rocnyPrijemBezPoistneho = rocnyPrijemBezPoistneho;

	}
	
	
	//getery
	public double getRocnyPrijem() {
//		System.out.println("Rocny prijem je: " + priemernyMesacnyPrijem*12);
		return rocnyPrijem = priemernyMesacnyPrijem * 12;
	}
	
	public double getRocnyPrijemBezPoistneho() {
		return (rocnyPrijem-zdravotnePoistenie-socialnePoistenie);
	}
		
	public double getCistyZisk() {
		return cistyZisk;
	}
	
	public double getDanZPrijmu() {
		return danZPrijmu;
	}
	
	public BankovyUcet getPlatiaciBankovyUcet() {
		return platiaciUcet;
	}
	
	public void vypisRocnyPrijem() {
		//System.out.printf("Rocny prijem  + vypisNazov() je: " + rocnyPrijem);
	}
	
	//ostatne metody
	public void zaplatDan(double suma, BankovyUcet bankovyUcet) {
		bankovyUcet.zaplat(suma);
	}
	
	public void vypisNazov() {
		System.out.println(nazov);
	}

}
