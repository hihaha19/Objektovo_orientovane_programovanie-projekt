package nabytok;

import java.io.Serializable;

/**
 * Trieda stolicka, ktoru pouzivaju zamestnanci uctovnickej firmy v kancelarii
 * 
 *
 */

public class Stolicka implements Serializable {
	
	int cena;
	
	public void nazov() {
		System.out.println("Stolicka patriaca uctovnikovi");

	}

	public void setCena() {
		this.cena = 50;
	}
	
	public int getCenaStolicky() {
		return this.cena;
	}

}
