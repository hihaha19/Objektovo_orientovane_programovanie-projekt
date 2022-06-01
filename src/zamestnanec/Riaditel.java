package zamestnanec;

/**
 * Riaditel je vytvoreny prostrednictvom navrhoveho vzoru singleton - v celom programe moze byt vytvoreny iba jeden objekt riaditela
 * @author Miska
 *
 */

public class Riaditel {	//singleton
	private static Riaditel instance;
	public Riaditel() {};
	public static Riaditel getInstance() {
		if(instance == null) {
			instance = new Riaditel();
		}
		return instance;
	}

}
