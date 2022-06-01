package hlavna;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import majetok.*;
import nabytok.*;
import zakaznik.*;
import zamestnanec.*;
import obrazovka.*;


public class Hlavna{

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		
		DecimalFormat df2 = new DecimalFormat("#.##");
		
		ArrayList<Zamestnanec> vsetciZamestnanci = new ArrayList<Zamestnanec>();
	
		//vytvorenie riaditela prostrednictvom navrhoveho vzoru singleton
		Riaditel riaditel = new Riaditel();
		
		//navrhovy vzor Factory na vytvorenie stolicky
		Stolicka stolicka = StolickaFactory.createStolicka();
	
		//pouzitie navrhoveho vzoru Builder
		Pocitac prvyPocitac = new PocitacBuilder().setKvalita("Vysoka").setNakupnaCena(1200.0).getPocitac();
		Pocitac druhyPocitac = new PocitacBuilder().setNakupnaCena(700).setOperacnySystem("Windows").getPocitac();
	
		
		
		//vytvorenie prveho uctovnika
		Adresa adresaPrvehoUctovnika = new Adresa();
		adresaPrvehoUctovnika.setMesto("Senec");
		adresaPrvehoUctovnika.setUlica("Kamenna");
			
		Uctovnik prvyUctovnik = new Uctovnik();
		prvyUctovnik.setMeno("Peter Rychly");
		prvyUctovnik.setVek(35);
		prvyUctovnik.setPocitac(prvyPocitac);
		prvyUctovnik.setOdpracovaneDni(23);
		prvyUctovnik.setPocetDniDovolenky(18);
		prvyUctovnik.setAdresa(adresaPrvehoUctovnika);
		prvyUctovnik.setStolicka(stolicka);
		
		//pridanie uctovnika do arrayListu zamestnancov
		vsetciZamestnanci.add(prvyUctovnik);
		
		
		//vytvorenie prveho Junior uctovnika
		JuniorUctovnik prvyJuniorUctovnik = new JuniorUctovnik();
		prvyJuniorUctovnik.setMeno("Alena Vysoka");
		prvyJuniorUctovnik.setOdpracovaneHodiny(100);
		prvyJuniorUctovnik.setVek(18);
		prvyJuniorUctovnik.setPocitac(druhyPocitac);
		
		//pridanie junior uctovnika do arrayListu zamestnancov
		vsetciZamestnanci.add(prvyJuniorUctovnik);
		
		
		//vytvorenie akciovej spolocnosti
		AkciovaSpolocnost potravinyAS = new AkciovaSpolocnost();
		Adresa adresaPotravinyAS = new Adresa();
		adresaPotravinyAS.setMesto("Pezinok");
		adresaPotravinyAS.setUlica("Hradna");
		
		BankovyUcet platobnyUcetAS = new BankovyUcet("platobny", 200000);
		BankovyUcet sporiaciUcetAS = new BankovyUcet("sporiaci", 100000);
		
		potravinyAS.setNazov("Potraviny, a. s.");
		potravinyAS.setAdresa(adresaPotravinyAS);
		potravinyAS.setPocetAkcionarov(5);
		potravinyAS.setPocetZamestnancov(50);
		potravinyAS.setPlatiaciBankovyUcet(platobnyUcetAS);
		potravinyAS.setSporiaciUcet(sporiaciUcetAS);
		potravinyAS.setKurzovaStrata(8000);
		potravinyAS.setKurzovyZisk(5000);
		potravinyAS.setZaplateneUroky(0);
		potravinyAS.setPrijateUroky(7000);
		potravinyAS.setHospodarskeVynosy(200000);
		potravinyAS.setVydavkyNaMzdu(35000);
		
		//vypocitanie poistenia zamestnancov
		potravinyAS.setZdravotne(prvyJuniorUctovnik.vypocitajZdravotnePoistenieZamestnancov(potravinyAS.getPocetZamestnancov(), potravinyAS.getVydavkyNaMzdu()));
		potravinyAS.setSocialne(prvyJuniorUctovnik.vypocitajSocialnePoistenieZamestnancov(potravinyAS.getPocetZamestnancov(), potravinyAS.getVydavkyNaMzdu()));
		
		
		//vypocitanie financnych a hospodarskych nakladov, financnych vynosov
		potravinyAS.setFinancneNaklady(prvyJuniorUctovnik.vypocitajNakladyZFinancnejCinnosti(potravinyAS.getKurzovaStrata(), potravinyAS.getZaplateneUroky()));
		potravinyAS.setFinancneVynosy(prvyJuniorUctovnik.vypocitajVynosyZFinancnejCinnosti(potravinyAS.getKurzovyZisk(), potravinyAS.getPrijateUroky()));
		potravinyAS.setHospodarskeNaklady(prvyJuniorUctovnik.vypocitajNakladyZHospodarskejCinnosti(potravinyAS.getZdravotne(),
		potravinyAS.getSocialne(), potravinyAS.getVydavkyNaMzdu()));

		
		//nastavenie vysledku hospodarenia 
		potravinyAS.setVysledokHospodarenia(prvyJuniorUctovnik.vypocitajVHPredDanou(potravinyAS.getHospodarskeNaklady(), potravinyAS.getFinancneNaklady(), 
				potravinyAS.getHospodarskeVynosy(), potravinyAS.getFinancneVynosy()));
		
		//vypocitanie dane z prijmu
		potravinyAS.setDanZPrijmu(prvyUctovnik.vypocitajDanObchodnejSpolocnosti(potravinyAS.getHospodarskeNaklady(), potravinyAS.getFinancneNaklady(), 
		potravinyAS.getFinancneVynosy(), potravinyAS.getHospodarskeVynosy()));
		
		//zaplatenie dane z prijmu 
		potravinyAS.zaplatDan(potravinyAS.getDanZPrijmu(), potravinyAS.getPlatiaciBankovyUcet());
		
		
		//odvedenie casti zisku na ucet
		potravinyAS.setCistyZisk(potravinyAS.getVysledokHospodarenia()-potravinyAS.getDanZPrijmu());
		potravinyAS.odvedCastZiskuNaUcet(sporiaciUcetAS);
		potravinyAS.vypocitajDividendu(potravinyAS.getCistyZisk());
		
		//zobrazenie zostatku na platiacom ucte
		System.out.println();
		potravinyAS.getPlatiaciBankovyUcet().zobrazZostatok();
		System.out.println();
		
		
		//SRO
		
		//vytvorenie bankoveho uctu pre s.r.o.
		BankovyUcet bankovyUcetSro = new BankovyUcet("platobny", 100000);
		
		
		System.out.println("S.r.o.: ");
		//vytvorenie prvej s.r.o.
		Sro predajnaBicyklov = new Sro();
		predajnaBicyklov.setNazov("Predajna bicyklov (sro)");
		
		Adresa adresaPredajneBicyklov = new Adresa();
		adresaPredajneBicyklov.setMesto("Bratislava");
		adresaPredajneBicyklov.setUlica("Hospodarska");
		predajnaBicyklov.setAdresa(adresaPredajneBicyklov);
		
		predajnaBicyklov.setPlatiaciBankovyUcet(bankovyUcetSro);
		
		
		//vlastna vynimka pri nastavovani zakladneho imanie sro
		try {
			predajnaBicyklov.setZakladneImanie(-10000);
		} catch (ZapornyVstup e){
			System.out.println(e.getMessage());
			
		}
		
		predajnaBicyklov.setPocetZamestnancov(10);
		predajnaBicyklov.setHospodarskeVynosy(80000);
		predajnaBicyklov.setVydavkyNaMzdu(7000);
		predajnaBicyklov.setKurzovaStrata(506.2);
		predajnaBicyklov.setKurzovyZisk(406.11);
		predajnaBicyklov.setPrijateUroky(102.64);
		predajnaBicyklov.setZaplateneUroky(1000);
		predajnaBicyklov.vypisNazov();
		
		//vypocitanie poistneho zamestnancov s.r.o.
		predajnaBicyklov.setZdravotne(prvyJuniorUctovnik.vypocitajZdravotnePoistenieZamestnancov(predajnaBicyklov.getPocetZamestnancov(), predajnaBicyklov.getVydavkyNaMzdu()));
		predajnaBicyklov.setSocialne(prvyJuniorUctovnik.vypocitajSocialnePoistenieZamestnancov(predajnaBicyklov.getPocetZamestnancov(), predajnaBicyklov.getVydavkyNaMzdu()));
		predajnaBicyklov.getZdravotne();
		predajnaBicyklov.getSocialne();
		
		predajnaBicyklov.setFinancneNaklady(prvyJuniorUctovnik.vypocitajNakladyZFinancnejCinnosti(predajnaBicyklov.getKurzovaStrata(), predajnaBicyklov.getZaplateneUroky()));
		predajnaBicyklov.setFinancneVynosy(prvyJuniorUctovnik.vypocitajVynosyZFinancnejCinnosti(predajnaBicyklov.getKurzovyZisk(), predajnaBicyklov.getPrijateUroky()));
		predajnaBicyklov.setHospodarskeNaklady(prvyJuniorUctovnik.vypocitajNakladyZHospodarskejCinnosti(predajnaBicyklov.getZdravotne(),
		predajnaBicyklov.getSocialne(), predajnaBicyklov.getVydavkyNaMzdu()));
				
		predajnaBicyklov.setDanZPrijmu(prvyUctovnik.vypocitajDanObchodnejSpolocnosti(predajnaBicyklov.getHospodarskeNaklady(), predajnaBicyklov.getFinancneNaklady(), 
		predajnaBicyklov.getFinancneVynosy(), predajnaBicyklov.getHospodarskeVynosy()));
		
		predajnaBicyklov.getDanZPrijmu();
		predajnaBicyklov.zaplatDan(predajnaBicyklov.getDanZPrijmu(), predajnaBicyklov.getPlatiaciBankovyUcet());
		
		
		
		//zivnostnik
		System.out.println();
		System.out.println("Zivnostnik: ");
		
		//vytvorenie bankoveho uctu pre zivnostnika
		BankovyUcet bankovyUcetZivnostnika = new BankovyUcet("Bezny", 10000);
		
		
		//vytvorenie prveho zivnostnika
		Zivnostnik prvyZivnostnik = new Zivnostnik();
		Adresa adresaPrvehoZivnostnika = new Adresa();
		adresaPrvehoZivnostnika.setMesto("Bratislava");
		adresaPrvehoZivnostnika.setUlica("Horna");
		prvyZivnostnik.setNazov("Jozef Sikovny-Zamocnik");
		prvyZivnostnik.setBankovyUcetZivnostnika(bankovyUcetZivnostnika);
		prvyZivnostnik.setPriemernyMesacnyPrijem(1000);
		prvyZivnostnik.setPocetMesiacovPrevadzkovania(12);
		prvyZivnostnik.setAdresa(adresaPrvehoZivnostnika);
		
		//nastavenie uctovnika ako sledovatela zivnostnika
		prvyZivnostnik.addObserver(prvyUctovnik);
		
		
		
		//vypocitanie vysledku hospodarenia zivnostnika
		double rocnyPrijemPrvehoZivnostnika = prvyZivnostnik.getRocnyPrijem();
		double zdravotnePrvehoZivnostnika = prvyJuniorUctovnik.vypocitajZdravotnePoistenieZivnostnika(rocnyPrijemPrvehoZivnostnika);
		double socialnePrvehoZivnostnika = prvyJuniorUctovnik.vypocitajSocialnePoistenieZivnostnika(rocnyPrijemPrvehoZivnostnika);
		double prijemPrvehoZivnostnikaBezPoistneho;
		

		prijemPrvehoZivnostnikaBezPoistneho = prvyUctovnik.vypocitajVHZivnostnika(rocnyPrijemPrvehoZivnostnika, zdravotnePrvehoZivnostnika, socialnePrvehoZivnostnika);
		prvyZivnostnik.setRocnyPrijemBezPoistneho(prijemPrvehoZivnostnikaBezPoistneho);
		
		prvyZivnostnik.setDanZPrijmu(prvyUctovnik.vypocitajDanZivnostnika(prijemPrvehoZivnostnikaBezPoistneho));
		prvyZivnostnik.setVysledokHospodareniaPoZdaneni(prijemPrvehoZivnostnikaBezPoistneho-prvyZivnostnik.getDanZPrijmu());
		
		prvyZivnostnik.zaplatDan(prvyZivnostnik.getDanZPrijmu(), prvyZivnostnik.getPlatiaciBankovyUcet());
		bankovyUcetZivnostnika.zobrazZostatok();
		prvyZivnostnik.setPriemernyMesacnyPrijem(800);
		
		
		
		

		//RTTI zistenie pomocou instanceof celkovy pocet normalnych zamestnancov (uctovnici) a pocet brigadnikov (junior uctovnici)
		int pocetUctovnikov = 0;
		int pocetJuniorUctovnikov = 0;
		
		for (Zamestnanec z : vsetciZamestnanci) {
		    if (z instanceof Uctovnik) {
		       pocetUctovnikov++;
		    }
		    else if (z instanceof JuniorUctovnik) {
		        pocetJuniorUctovnikov++;
		    }
		}
		
		//junior uctovnik si rata svoje poistne a svoju vyplatu
		prvyJuniorUctovnik.setSvojePoistne(prvyJuniorUctovnik.getMzda());
		prvyJuniorUctovnik.setVyplata(prvyJuniorUctovnik.vypocitajVyplatu(prvyJuniorUctovnik.getMzda(),
				prvyJuniorUctovnik.getPoistne()));
		
		
		//motor je vhniezdena trieda
		Auto volvo = new Auto("Volvo", 40, "Cierne", 70);
		Auto.Motor motorVolvo = volvo.new Motor(2018, false, 80); 
		
		
		// serializacia - ulozenie udajov o zamestnancoch do suboru  
		File f = new File ("udajeZamestnancov.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(vsetciZamestnanci);
		oos.close();
		fos.close();
		
		// deserializacia - nacitanie udajov o zamestnancoch zo suboru do noveho ArrayList
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList <Zamestnanec> novyList = new ArrayList<Zamestnanec>();
		novyList = (ArrayList) ois.readObject();
        
		
		
		//vytvorenie GUI
	    PrvaObrazovka prva = new PrvaObrazovka();
		prva.vytvorPrvuObrazovku();
	
	}
	

}