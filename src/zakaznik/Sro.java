package zakaznik;
import hlavna.ZapornyVstup;
import majetok.BankovyUcet;


/**
 * Trieda Sro obsahuje gettery a settery, pri zakladnom imani sa nachadza vlastna vynimka, ktora kontroluje, ci vstup nie je mensi
 * ako 0, ak je, vypise do konzoly chybovy vypis. Ak je vstup vacsi ako 0, program pokracuje dalej bez problemov. Zaplat dan je funkcia,
 * prostrednictvom ktorej moze Sro zaplatit uctovnikmi vypocitanu dan z prijmu
 */

public class Sro extends Zakaznik {
	
	int pocetZamestnancov;
	double vydavkyNaMzdu;
	double zdravotneZamestnancov;
	double socialneZamestnancov;
 	double financneNaklady;
	double financneVynosy;
	double kurzovyZisk;
	double kurzovaStrata;
	double prijateUroky;
	double zaplateneUroky;
	double trzbyZPredajaTovaru;
	double nakladyNaMzdy;
	double hospodarskeNaklady;
	double hospodarskeVynosy;
	double zakladneImanie;
	double vysledokHospodarenia;
	double danZPrijmu;		//15% ak ma zisk mensi ako 100 000, inak 21%

	//gettery
	public int getPocetZamestnancov() {
		return pocetZamestnancov;
	}
	
	public double getVysledokHospodarenia() {
		return vysledokHospodarenia;
	}
	
	public double getVydavkyNaMzdu(){
		return vydavkyNaMzdu;
	}
	
	public double getDanZPrijmu(){
		return danZPrijmu;
	}
	
	public double getKurzovyZisk() {
		return kurzovyZisk;
	}
	
	public double getKurzovaStrata() {
		return kurzovaStrata;
	}
	
	public double getPrijateUroky() {
		return prijateUroky;
	}
	
	public double getZaplateneUroky() {
		return zaplateneUroky;
	}
	
	public double getFinancneNaklady() {
		return financneNaklady;
	}
	
	public double getFinancneVynosy() {
		return financneVynosy;
	}
	
	public double getHospodarskeNaklady() {
		return hospodarskeNaklady;
	}
	
	public double getHospodarskeVynosy() {
		return hospodarskeVynosy;
	}
	
	public double getZdravotne(){
		return zdravotneZamestnancov;
	}
	
	public double getSocialne(){
		return socialneZamestnancov;
	}
	
	
	public BankovyUcet getPlatiaciBankovyUcet() {
		return platiaciUcet;
	}
	
	public double getZakladneImanie(){
		return zakladneImanie;
	}
	
	//settery
	public void setPocetZamestnancov (int newPocetZamestnancov) {
		pocetZamestnancov = newPocetZamestnancov;
	}	
	
	public void setFinancneNaklady(double newFinancneNaklady) {
		financneNaklady = newFinancneNaklady;
	}	
	
	public void setFinancneVynosy(double newFinancneVynosy) {
		financneVynosy = newFinancneVynosy;
	}	
	
	public void setHospodarskeNaklady(double newHospodarskeNaklady) {
		hospodarskeNaklady = newHospodarskeNaklady;
	}	
	
	public void setHospodarskeVynosy (double newHospodarskeVynosy) {
		hospodarskeVynosy = newHospodarskeVynosy;
	}		
	
	public void setVydavkyNaMzdu(double newVydavky) {
		vydavkyNaMzdu = newVydavky;
	}	
	
	
	public void setPrijateUroky(double newPrijateUroky) {
		 prijateUroky = newPrijateUroky;
	}
	
	public void setZaplateneUroky(double newZaplateneUroky) {
		 zaplateneUroky = newZaplateneUroky;
	}
	
	public void setVysledokHospodarenia(double newVysledokHospodarenia) {
		 vysledokHospodarenia = newVysledokHospodarenia;
	}
	
	public void setZdravotne(double newZdravotne){
		zdravotneZamestnancov = newZdravotne;
	}
	
	public void setSocialne(double newSocialne){
		socialneZamestnancov = newSocialne;
	}
	
	public void setKurzovyZisk(double newKurzovyZisk) {
		kurzovyZisk = newKurzovyZisk;
	}
	
	public void setKurzovaStrata(double newKurzovaStrata) {
		kurzovaStrata = newKurzovaStrata;
	}
	
	public void setPlatiaciBankovyUcet(BankovyUcet newBankovyUcet) {
		platiaciUcet = newBankovyUcet;
	}


	public void setZakladneImanie(double newZakladneImanie)  throws ZapornyVstup  {
		if(newZakladneImanie < 0) {
			throw new ZapornyVstup("Zakladne imanie nemoze byt mensie ako 0, v tomto pripade by to bolo "+newZakladneImanie);
		}
		else
			zakladneImanie = newZakladneImanie;
	}
	
	public void setDanZPrijmu(double newDanZPrijmu) {
		 danZPrijmu = newDanZPrijmu;
	}
	
	//ostatne
	public void vypisNazov() {
		System.out.println("Nazov s.r.o.: " + Sro.nazov);
	}
	
	public void zaplatDan(double suma, BankovyUcet bankovyUcet) {
		bankovyUcet.zaplat(suma);
		bankovyUcet.zobrazZostatok();
	}

	
}