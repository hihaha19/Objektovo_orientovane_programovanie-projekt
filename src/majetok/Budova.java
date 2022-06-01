package majetok;

/**
 * Trieda budova obsahuje kompoziciu - ma 2 premenne - hornu a dolnu salu, ktore by bez budovy nemohli existovat.
 * Konstruktor budovy zaroven skonstruuje tieto dve saly, a urci maximalny pocet ludi, ktory sa do nich zmesti, a cenu za jedneho 
 * cloveka, ktoru firma zinkasuje, ak sa v tejto sale kona napriklad oslava narodenin alebo svadba
 */

//kompozicia
public class Budova {
	private HornaSala hornaSala;
	private DolnaSala dolnaSala;
	
	public Budova() {
		hornaSala = new HornaSala(140, 30.5);
		dolnaSala = new DolnaSala(30, 20.1);
		
	}

}
