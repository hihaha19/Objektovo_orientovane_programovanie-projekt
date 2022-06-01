package majetok;

/**
 * Sala, s konstruktorom, ktory urcuje maximalny pocet ludi, ktory sa do saly zmesti a cenu, ktoru spolocnost zinkasuje, ak si
 * zakaznik v tejto sale urobi akciu, napriklad oslavu narodenin. Ak je pocet ludi, ktory sa ma zucastnit oslavy vacsi ako 
 * kapacita saly, vypise sa vypis, ze akcia sa konat nemoze. Ak sa akcia konat moze, na bankovy ucet vlastnikovi saly pribudnu peniaze
 */

public class DolnaSala {
	private static int maxPocetLudi;
	private static double cenaZaJednehoCloveka;
	
	DolnaSala(int maxPocetLudi, double cenaZaJednehoCloveka){
		this.maxPocetLudi = maxPocetLudi;
		this.cenaZaJednehoCloveka = cenaZaJednehoCloveka;
	}
	
	public static double spravAkciu(int pocetLudi, String nazov) {
		if(pocetLudi > maxPocetLudi) {
			System.out.println("Prilis vela ludi, nemozete mat u nas akciu s nazvom: " + nazov);

		}
		else
			System.out.println("Budete mat u nas akciu s nazvom: " + nazov + ". Cena bude: " + pocetLudi*cenaZaJednehoCloveka);
			return BankovyUcet.prijem(pocetLudi*cenaZaJednehoCloveka);
}}
