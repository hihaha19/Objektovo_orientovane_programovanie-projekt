package zamestnanec;

/**
 * Interface, ktory predpisuje, ako ma vyzerat metoda vypocitaj vyplatu - je to default method implementation.
 * Tiez predpisuje, ze vsetky triedy, ktore pouzivaju tento interface, musia mat metodu setSvojePoistne, cize kazdy zamestnanec
 * si musi vediet vypocitat vysku svojho poistneho zo svojej vyplaty
 * 
 * @author Miska
 *
 */

//pridana default method implementation
public interface MetodyZamestnancov {
	
	public void setSvojePoistne(double vyplata);

	
	default double vypocitajVyplatu(double vyplata, double poistne) {
		return vyplata-poistne;
	}
}
