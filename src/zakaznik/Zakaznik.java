package zakaznik;
import java.util.ArrayList;
import java.util.Observable;

import majetok.BankovyUcet;

/**
 * Abstraktna trieda, z ktorej dedia triedy zivnostnik, sro, akciova spolocnost
 * @author Miska
 *
 */


@SuppressWarnings("deprecation")
public abstract class Zakaznik extends Observable implements ZakaznikInterface {
	protected static String nazov;
	protected Adresa adresa;
	protected BankovyUcet platiaciUcet;

	
	//enkapsulacia
		public String getNazov() {
			return nazov;
		}
		
		public Adresa getAdresa() {
			return adresa;
		}
		
		public void setNazov(String newNazov) {
			nazov = newNazov;
		}
		
		public void setAdresa(Adresa newAdresa) {
			adresa = newAdresa;
		}
		
		public abstract void vypisNazov();			//abstraktna metoda
}