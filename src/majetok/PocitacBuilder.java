package majetok;

/**
 * Navrhovy vzor Builder sa pouziva na to, aby mohol vzniknut pocitac aj bez urcenia vsetkych premennych (kvalita, nakupna cena,
 * znacka, operacny system). Napriklad, ak chcem vytvorit pocitac s uvedenou len nakupnou cenou a operacnym systemom, zavolam navrhovy 
 * vzor takto:
 * Pocitac druhyPocitac = new PocitacBuilder().setNakupnaCena(700).setOperacnySystem("Windows").getPocitac();
 */

public class PocitacBuilder {
	private String kvalita;
	private double nakupnaCena;
	private String znacka;
	private String operacnySystem;
	
	public PocitacBuilder setKvalita(String kvalita) {
		this.kvalita = kvalita;
		return this;
	}
	
	public PocitacBuilder setNakupnaCena(double nakupnaCena) {
		this.nakupnaCena = nakupnaCena;
		return this;
	}
	
	public PocitacBuilder setZnacka(String znacka) {
		this.znacka = znacka;
		return this;
	}
	
	public PocitacBuilder setOperacnySystem(String operacnySystem) {
		this.operacnySystem = operacnySystem;
		return this;
	}
	
	public Pocitac getPocitac() {
		return new Pocitac(kvalita, nakupnaCena, znacka, operacnySystem); 
			
		
	}
}