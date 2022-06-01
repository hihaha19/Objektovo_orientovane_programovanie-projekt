package majetok;

import java.io.Serializable;

/**
 * Triedu pocitac pouzivaju zamestnanci uctovnickej firmy na uctovanie
 * 
 *
 */

public class Pocitac implements Serializable{
	private String kvalita;
	private double nakupnaCena;
	private String znacka;
	private String operacnySystem;
	
	 public Pocitac(String kvalita, double nakupnaCena, String znacka, String operacnySystem){
		this.kvalita = kvalita;
		this.nakupnaCena = nakupnaCena;
		this.znacka = znacka;
		this.operacnySystem = operacnySystem;
	}
	 
	 public String toString() {
		 return kvalita;
	 }
}