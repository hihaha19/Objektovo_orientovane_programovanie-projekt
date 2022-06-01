package zakaznik;

import java.io.Serializable;

/**
 * Adresa zamestnancov, ktory pracuju v uctovnickej firme na plny uvazok.
 * Implementuje interface serializable, aby sa mohli do suboru ulozit udaje o adresach zamestnancov
 * 
 * @author Miska
 *
 */

public class Adresa implements Serializable{
	String ulica;
	String mesto;
	
	public String getMesto() {
		return mesto;
	}
	
	public void setMesto(String newMesto) {
		this.mesto = newMesto;
	}
	
	public String getUlica() {
		return ulica;
	}
	
	public void setUlica(String newUlica) {
		this.ulica = newUlica;
	}
}
