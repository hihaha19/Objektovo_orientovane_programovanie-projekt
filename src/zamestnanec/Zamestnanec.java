package zamestnanec;

import java.io.Serializable;

import nabytok.Stolicka;

/**
 * Abstraktna trieda zamestnanec implementuje interface MetodyZamestnancov a interface Serializable, ktory sluzi na serializaciu.
 * Tato trieda obsahuje aj abstraktnu metodu zobrazUdaje().
 * @author Miska
 *
 */

public abstract class Zamestnanec  implements MetodyZamestnancov, Serializable{	
	protected String meno;
	private int vek;
	double poistne;
	Stolicka stolicka;
	
	//enkapsulacia
		public String getMeno() {
			return meno;
		}
		
		
		public int getVek() {
			return vek;
		}
		
		public void setMeno(String newMeno) {
			meno = newMeno;
		}
		
		public void setVek(int newVek) {
			vek = newVek;
		}	
		
		public abstract void zobrazUdaje();			//abstraktna metoda
}