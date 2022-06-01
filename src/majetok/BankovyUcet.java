package majetok;

import java.text.DecimalFormat;

/**
 * Bankovy ucet, s metodami prijem, to znamena, ze na bankovy ucet pribudli peniaze, zaplat znamena, ze sme z uctu nieco zaplatili.
 * Metoda zobraz zostatok vypise peniaze, ktore zostali na ucte 
 *
 */

public class BankovyUcet {
	private String nazov;
	private static double zostatok;

	private static DecimalFormat df2 = new DecimalFormat("#.##");
	
	public BankovyUcet(String nazov, double zostatok) {
		this.nazov = nazov;
		this.zostatok = zostatok;
	}
	
	public static double prijem(double suma) {
		return zostatok += suma;
	}
	
	public static void zobrazZostatok() {
		System.out.println("Zostatok je: " + df2.format(zostatok) + "€");
	}
	
	public static void zaplat(double suma) {
		zostatok -= suma;
	}
}