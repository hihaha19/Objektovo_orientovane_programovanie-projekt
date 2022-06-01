package zakaznik;

import majetok.BankovyUcet;

/**
 * Interface, ktory obsahuje default method implementation, cize kazda trieda, ktora pouziva tento interface, musi 
 * dokazat zaplatit dan z prijmu. Tento interface dedia iba zakaznici, teda subjekty, ktore podnikaju a musia platit dan
 * @author Miska
 *
 */

public interface ZakaznikInterface {
	
	default void zaplatDan(double suma, BankovyUcet bankovyUcet) {
		bankovyUcet.zaplat(suma);
		bankovyUcet.zobrazZostatok();
	}


}
