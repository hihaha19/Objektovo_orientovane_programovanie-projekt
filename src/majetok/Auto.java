package majetok;
import java.text.DecimalFormat;

/**
 * Trieda auto obsahuje vhniezdenu triedu motor. Jej metoda cestujem vypocita, ci ma auto dostatok paliva na to, aby sa s nim mohlo 
 * cestovat. Ak ma menej ako 20 litrov benzinu, musi sa s nim ist natankovat a zaplatit za palivo z bankoveho uctu.
 * Funkcia vypocitaj cenu za prenajom nam na zaklade typu auta a poctu dni, na ktore si ho chce zakaznik prenajat, vypocita
 * vyslednu cenu, ktoru musi zaplatit
 */

//vhniezdena trieda motor
public class Auto implements AutoInterface{
	private String nazov;
	private static double cenaZaJedenDen;
	private String farba;
	private static double vyslednaCena;
	private double benzin;
	private double cenaZaBenzin;
		
	private static DecimalFormat df2 = new DecimalFormat("#.##");	
	
	//pretazenie konstruktorov
	public Auto(String nazov, double cenaZaJedenDen, int benzin) {
		this.nazov = nazov;
		this.cenaZaJedenDen = cenaZaJedenDen;
		this.benzin = benzin;
	}
	
	public Auto (String nazov, double cenaZaJedenDen, String farba, int benzin)  {
		this.nazov = nazov;
		this.cenaZaJedenDen = cenaZaJedenDen;
		this.farba = farba;
		this.benzin = benzin;
	}
	
	public Auto(String nazov, String farba, int benzin) {
		this.nazov = nazov;		
		this.farba = farba;
		this.benzin = benzin;
	}

	
	public void cestujem(int pocetKilometrov, double spotreba) {
		if((pocetKilometrov/100)*spotreba > benzin) {
			System.out.println("Treba najprv natankovat!");
		}
		
		else {
			this.benzin = this.benzin - ((pocetKilometrov/100)*spotreba);
		System.out.println("Benzinu zostalo: " + df2.format(benzin));
		if(benzin < 20) {
			natankuj(100-benzin, 1.3);
		}	
		}	
	}

	public void natankuj(double pocetLitrov, double cenaZaLiter) {
		this.benzin += pocetLitrov;
		cenaZaBenzin = pocetLitrov*cenaZaLiter;
		BankovyUcet.zaplat(cenaZaBenzin);
		System.out.println("Tankujem " +pocetLitrov+ " litrov za celkovu cenu " + df2.format(cenaZaBenzin) + "€, ktore zaplatim z bankoveho uctu");
	}
	
	//vypocitaj cenu za prenajom
		public static void vypocitajCenu (String nazov, int pocetDni) {
			System.out.println(nazov + " odchadza na " + pocetDni + " dni");
				if (pocetDni > 3) {	
				System.out.println("Vysledna cena je: " + (vyslednaCena = pocetDni * cenaZaJedenDen) * 0.9); }
				
				else System.out.println("Vysledna cena je: " + (vyslednaCena = pocetDni * cenaZaJedenDen));
				 
				  BankovyUcet.prijem(vyslednaCena);
				 BankovyUcet.zobrazZostatok();
				  System.out.println();
			
		}
		
		public class Motor{
			int rokVyroby;
			boolean pokazeny;
			int vykonVKiloWatoch;
			
			public Motor(int rokVyroby, boolean pokazeny, int vykonVKiloWatoch) {
				this.rokVyroby = rokVyroby;
				this.pokazeny = pokazeny;
				this.vykonVKiloWatoch = vykonVKiloWatoch;
			}
		}
}	