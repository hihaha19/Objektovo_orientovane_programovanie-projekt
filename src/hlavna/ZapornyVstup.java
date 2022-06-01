package hlavna;

/**
 * Vlastna vynimka, ktora kontroluje, ci zakladne imanie obchodnej spolocnosti sa neuvadza v minusovych cislach. Ak ano, vypise chybovu
 * hlasku.
 *
 */

public class ZapornyVstup extends Exception {
	
	public ZapornyVstup () {
		super();
	}
	
	public ZapornyVstup(String message) {
		super(message);
	}

}
