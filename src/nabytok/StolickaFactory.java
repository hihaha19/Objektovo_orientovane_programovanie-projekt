package nabytok;

/**
 * Navrhovy vzor, ktory sa pouziva na vytvorenie stolicky bez toho, aby sme v hlavnej triede museli zadavat jej cenu, pretoze
 *  objekt stolicky sa vytvori uz v tejto metode a aj sa tu zadefinuje jej nakupna cena
 *
 */
public class StolickaFactory {

		public static Stolicka createStolicka() {
			Stolicka stolicka = new Stolicka();
			stolicka.setCena();
			return stolicka;
		}
	
}
