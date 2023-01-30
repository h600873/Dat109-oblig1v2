package spillFiler;

import java.util.HashMap;

/**
 * Klasse som skal etterlikne et brett i stigespillet
 */
public class Brett {

	HashMap<Integer, Integer> brett = new HashMap<Integer, Integer>();

	/**
	 * Konstruktør for brett, kaller metoden genererRute() som oppretter et map av
	 * stiger/slanger.
	 */
	public Brett() {
		genererRuter();
	}

	/**
	 * Genererer rutene til brettet. Stiger og slanger er angitt av et HashMap der
	 * nøkkel er rutenummer der disse rutene er og verdi er hvor disse rutene leder
	 * til.
	 */
	private void genererRuter() {
		// Stiger og slanger (key = rutenummer, verdi = hvor de leder til)
		// Stiger:
		brett.put(2, 38);
		brett.put(4, 14);
		brett.put(8, 31);
		brett.put(21, 42);
		brett.put(28, 84);
		brett.put(36, 44);
		brett.put(51, 67);
		brett.put(71, 90);
		brett.put(80, 100);

		// Slanger:
		brett.put(16, 5);
		brett.put(47, 26);
		brett.put(48, 11);
		brett.put(56, 53);
		brett.put(62, 18);
		brett.put(64, 60);
		brett.put(87, 24);
		brett.put(92, 73);
		brett.put(95, 75);
		brett.put(98, 78);
	}

	/**
	 * Sjekker om spilleren står på en stige/slange rute.
	 *
	 * @param pos Posisjonen til spilleren
	 * @return posisjonen hvor stigen/slangen leder til. -1 hvis spilleren ikke står
	 *         på noe stige/slange.
	 */
	public int sjekkOmStigeSlange(int pos) {
		if (brett.containsKey(pos)) {
			return brett.get(pos);
		}
		return -1;
	}
}
